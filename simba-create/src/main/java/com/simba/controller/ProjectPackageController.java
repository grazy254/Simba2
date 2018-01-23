package com.simba.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.common.UUIDUtil;
import com.simba.framework.util.zip.ZipUtil;
import com.simba.model.ProjectPackage;
import com.simba.model.ProjectVersion;
import com.simba.model.constant.ConstantData;
import com.simba.service.ProjectVersionService;

import net.lingala.zip4j.exception.ZipException;

/**
 * 项目版本打包控制器Controller
 * 
 * @author caozhejun
 *
 */
@Controller
@RequestMapping("/projectPackage")
public class ProjectPackageController {

	private static final Log logger = LogFactory.getLog(ProjectPackageController.class);

	private static final String defaultProjectCode = "simba";

	private static final String defaultPackageName = "com.simba";

	@Autowired
	private ProjectVersionService projectVersionService;

	/**
	 * 进入打包页面
	 * 
	 * @return
	 */
	@RequestMapping("/create")
	public String create(ModelMap model) {
		model.put("versions", projectVersionService.listAll());
		return "projectPackage/create";
	}

	/**
	 * 执行打包
	 * 
	 * @param projectPackage
	 * @param response
	 * @throws ZipException
	 * @throws IOException
	 */
	@RequestMapping("/projectPackage")
	public void projectPackage(ProjectPackage projectPackage, HttpServletResponse response) throws ZipException, IOException {
		String fileName = projectPackage.getProjectCode() + ".zip";
		String tempDir = SystemUtil.getUserDir() + "/" + UUIDUtil.get();
		String packageZipDir = SystemUtil.getUserDir() + "/" + UUIDUtil.get();
		String packageZipFile = packageZipDir + "/" + fileName;
		new File(tempDir).mkdirs();
		new File(packageZipDir).mkdirs();
		ProjectVersion version = projectVersionService.getBy("versionNo", projectPackage.getVersionNo());
		String filePath = version.getFilePath();
		// 将文件解压
		ZipUtil.unzip(filePath, tempDir, "GBK");
		logger.info("解压" + filePath + "到" + tempDir);
		// 处理文件
		deal(projectPackage, tempDir);
		// 将处理后的文件目录打包
		ZipUtil.zip(tempDir, packageZipFile, false);
		// 删除临时目录
		FileUtils.deleteQuietly(new File(tempDir));
		// 下载打包后的zip文件
		OutputStream out = null;
		InputStream in = null;
		try {
			logger.info("下载文件:" + packageZipFile);
			out = response.getOutputStream();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			in = new FileInputStream(packageZipFile);
			IOUtils.copy(in, out);
		} catch (Exception e) {
			logger.error("下载文件:[" + packageZipFile + "]出现异常", e);
		} finally {
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
	}

	/**
	 * 处理需要替换的文件及目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void deal(ProjectPackage projectPackage, String dir) throws IOException {
		dealSimbaRoot(projectPackage, dir);
		dealSimbaAdmin(projectPackage, dir);
		dealSimbaUser(projectPackage, dir);
		dealSimbaService(projectPackage, dir);
		dealSimbaDao(projectPackage, dir);
		dealSimbaUtil(projectPackage, dir);
		dealSimbaModel(projectPackage, dir);
	}

	/**
	 * 处理service目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void dealSimbaService(ProjectPackage projectPackage, String dir) throws IOException {
		dealModule(projectPackage, dir, "service");
	}

	private void dealModule(ProjectPackage projectPackage, String dir, String module) throws IOException {
		String code = projectPackage.getProjectCode();
		String oldDir = getRootDir(code, dir) + "/" + "simba-" + module;
		String newDir = getRootDir(code, dir) + "/" + code + "-" + module;
		if (!defaultProjectCode.equals(code)) {
			FileUtils.moveDirectory(new File(oldDir), new File(newDir));
		}
		String packageDir = newDir + "/src/main/java/com/simba";
		String newPackageDir = newDir + "/src/main/java/" + getPackagePath(projectPackage.getPackageName());
		if (!defaultPackageName.equals(projectPackage.getPackageName())) {
			FileUtils.moveDirectory(new File(packageDir), new File(newPackageDir));
		}
		if (!projectPackage.getPackageName().startsWith("com")) {
			FileUtils.deleteQuietly(new File(newDir + "/src/main/java/com"));
		}
		if (!defaultProjectCode.equals(code)) {
			String pomFile = newDir + "/" + "pom.xml";
			replacePomFile(code, pomFile);
		}
	}

	/**
	 * 处理model目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void dealSimbaModel(ProjectPackage projectPackage, String dir) throws IOException {
		dealModule(projectPackage, dir, "model");
	}

	/**
	 * 处理util目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void dealSimbaUtil(ProjectPackage projectPackage, String dir) throws IOException {
		dealModule(projectPackage, dir, "util");
	}

	/**
	 * 处理dao目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void dealSimbaDao(ProjectPackage projectPackage, String dir) throws IOException {
		dealModule(projectPackage, dir, "dao");
	}

	/**
	 * 处理user目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void dealSimbaUser(ProjectPackage projectPackage, String dir) throws IOException {
		dealModule(projectPackage, dir, "user");
		dealJavaFiles(projectPackage, dir, "user");
		dealPropertiesFiles(projectPackage, dir, "user");
	}

	/**
	 * 处理properties文件
	 * 
	 * @param projectPackage
	 * @param dir
	 * @param module
	 * @throws IOException
	 */
	private void dealPropertiesFiles(ProjectPackage projectPackage, String dir, String module) throws IOException {
		String code = projectPackage.getProjectCode();
		String propertiesDir = getRootDir(code, dir) + "/" + code + "-" + module + "/src/main/resources/";
		String totalFile = propertiesDir + "application.properties";
		String devFile = propertiesDir + "application-dev.properties";
		replacePropertiesFile(totalFile, projectPackage);
		replacePropertiesFile(devFile, projectPackage);
	}

	/**
	 * 替换properties文件
	 * 
	 * @param file
	 * @param projectPackage
	 * @throws IOException
	 */
	private void replacePropertiesFile(String file, ProjectPackage projectPackage) throws IOException {
		String content = FileUtils.readFileToString(new File(file), ConstantData.DEFAULT_CHARSET);
		content = replacePropertiesContent(content, projectPackage);
		FileUtils.write(new File(file), content, ConstantData.DEFAULT_CHARSET);
	}

	/**
	 * 根据用户设置替换properties文件的内容
	 * 
	 * @param content
	 * @param projectPackage
	 * @return
	 */
	private String replacePropertiesContent(String content, ProjectPackage projectPackage) {
		String projectCode = projectPackage.getProjectCode();
		String packageName = projectPackage.getPackageName();
		String account = projectPackage.getAccount();
		String pwd = projectPackage.getPwd();
		String defaultPwd = projectPackage.getDefaultPwd();
		String encryptKey = projectPackage.getEncryptKey();
		String encryptAccount = EncryptUtil.md5(account + encryptKey);
		String encryptPwd = EncryptUtil.md5(pwd + encryptKey);
		String encryptDefaultPwd = EncryptUtil.md5(defaultPwd + encryptKey);
		content = content.replaceAll("spring.application.name=simbauser", "spring.application.name=" + projectCode + "user");
		content = content.replaceAll("spring.application.name=simbaadmin", "spring.application.name=" + projectCode + "admin");
		content = content.replaceAll("administrator.username=66d4aaa5ea177ac32c69946de3731ec0", "administrator.username=" + encryptAccount);
		content = content.replaceAll("administrator.password=91d4b760bf3bf963b775955e12d0a3c2", "administrator.password=" + encryptPwd);
		content = content.replaceAll("key=test", "key=" + encryptKey);
		content = content.replaceAll("default.pwd=5a2e54ee57e5b7273b9a8fed78c1ebd8", "default.pwd=" + encryptDefaultPwd);
		content = content.replaceAll("code.generate.package=com.simba", "code.generate.package=" + packageName);
		content = content.replaceAll("project.name=simba", "project.name=" + projectCode);
		content = content.replaceAll("server.port=8888", "server.port=" + projectPackage.getAdminPort());
		content = content.replaceAll("server.port=8889", "server.port=" + projectPackage.getUserPort());
		return content;
	}

	/**
	 * 处理java类
	 * 
	 * @param projectPackage
	 * @param dir
	 * @param module
	 * @throws IOException
	 */
	private void dealJavaFiles(ProjectPackage projectPackage, String dir, String module) throws IOException {
		if (defaultPackageName.equals(projectPackage.getPackageName())) {
			return;
		}
		String code = projectPackage.getProjectCode();
		String javaFileDir = getRootDir(code, dir) + "/" + code + "-" + module + "/src/main/java/" + getPackagePath(projectPackage.getPackageName());
		String applicationStartFile = javaFileDir + "/" + "ApplicationStart.java";
		String servletInitializerFile = javaFileDir + "/" + "ServletInitializer.java";
		replacePackageName(applicationStartFile, projectPackage.getPackageName());
		replacePackageName(servletInitializerFile, projectPackage.getPackageName());
		String testPackageDir = getRootDir(code, dir) + "/" + code + "-" + module + "/src/test/java/com/simba";
		String testFileDir = getRootDir(code, dir) + "/" + code + "-" + module + "/src/test/java/" + getPackagePath(projectPackage.getPackageName());
		FileUtils.moveDirectory(new File(testPackageDir), new File(testFileDir));
		String codeGenerateFile = testFileDir + "/" + "CodeGenerate.java";
		replacePackageName(codeGenerateFile, projectPackage.getPackageName());
		if (!projectPackage.getPackageName().startsWith("com")) {
			FileUtils.deleteQuietly(new File(getRootDir(code, dir) + "/" + code + "-" + module + "/src/test/java/com"));
		}
	}

	/**
	 * 更新包名
	 * 
	 * @param file
	 * @param packageName
	 * @throws IOException
	 */
	private void replacePackageName(String file, String packageName) throws IOException {
		String content = FileUtils.readFileToString(new File(file), ConstantData.DEFAULT_CHARSET);
		content = content.replaceFirst(defaultPackageName, packageName);
		FileUtils.write(new File(file), content, ConstantData.DEFAULT_CHARSET);
	}

	/**
	 * 处理admin目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void dealSimbaAdmin(ProjectPackage projectPackage, String dir) throws IOException {
		dealModule(projectPackage, dir, "admin");
		dealJavaFiles(projectPackage, dir, "admin");
		dealPropertiesFiles(projectPackage, dir, "admin");
	}

	/**
	 * 处理simbaRoot目录
	 * 
	 * @param projectPackage
	 * @param dir
	 * @throws IOException
	 */
	private void dealSimbaRoot(ProjectPackage projectPackage, String dir) throws IOException {
		if (defaultProjectCode.equals(projectPackage.getProjectCode())) {
			return;
		}
		String simbaRoot = dir + "/" + "simbaRoot";
		String code = projectPackage.getProjectCode();
		String newDir = getRootDir(code, dir);
		FileUtils.moveDirectory(new File(simbaRoot), new File(newDir));
		String pomFile = newDir + "/" + "pom.xml";
		replacePomFile(code, pomFile);
	}

	private void replacePomFile(String code, String pomFile) throws IOException {
		String pomContent = FileUtils.readFileToString(new File(pomFile), ConstantData.DEFAULT_CHARSET);
		pomContent = pomContent.replaceAll("simbaRoot", code + "Root");
		pomContent = pomContent.replaceAll("simba-model", code + "-model");
		pomContent = pomContent.replaceAll("simba-util", code + "-util");
		pomContent = pomContent.replaceAll("simba-dao", code + "-dao");
		pomContent = pomContent.replaceAll("simba-service", code + "-service");
		pomContent = pomContent.replaceAll("simba-admin", code + "-admin");
		pomContent = pomContent.replaceAll("simba-user", code + "-user");
		pomContent = pomContent.replaceAll("simbaadmin", code + "admin");
		pomContent = pomContent.replaceAll("simbauser", code + "user");
		FileUtils.write(new File(pomFile), pomContent, ConstantData.DEFAULT_CHARSET);
	}

	private String getRootDir(String projectCode, String dir) {
		return dir + "/" + projectCode + "Root";
	}

	private String getPackagePath(String packageName) {
		return packageName.replaceAll("\\.", "/");
	}
}
