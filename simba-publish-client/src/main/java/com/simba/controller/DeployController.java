package com.simba.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.simba.exception.SimbaException;
import com.simba.form.DeployForm;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.common.ExecuteUtil;
import com.simba.framework.util.common.ServerUtil;
import com.simba.framework.util.common.StringUtil;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.registry.model.RegistryTableData;

/**
 * 用于接收发布系统文件的Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/deploy")
public class DeployController {

	private static final Log logger = LogFactory.getLog(DeployController.class);

	@RequestMapping("/receive")
	public JsonResult receive(MultipartHttpServletRequest request, MultipartFile file, DeployForm deployForm) throws IllegalStateException, IOException {
		checkIp(request);
		checkSign(deployForm);
		dealFile(file, deployForm);
		return new JsonResult();
	}

	private void dealFile(MultipartFile file, DeployForm deployForm) throws IllegalStateException, IOException {
		if (SystemUtil.isWindowsOs()) {
			dealFileWindows(file, deployForm);
		} else {
			dealFileLinux(file, deployForm);
		}
	}

	private void dealFileWindows(MultipartFile file, DeployForm deployForm) throws IllegalStateException, IOException {
		String serverDir = RegistryTableData.getInstance().get("autoDeployServerDir");
		new File(serverDir).mkdirs();
		String fileName = file.getOriginalFilename();
		int lastIndex = fileName.lastIndexOf(".");
		String name = fileName.substring(0, lastIndex);
		String jarFile = serverDir + "/" + fileName;
		String scriptFile = serverDir + "/" + name + ".bat";
		file.transferTo(new File(jarFile));
		logger.info("文件写入成功" + jarFile);
		String scriptContent = "java " + deployForm.getStartParams() + " -jar " + jarFile;
		FileUtils.writeStringToFile(new File(scriptFile), scriptContent);
		logger.info("脚本写入成功" + scriptFile);
		// 关闭运行的进程
		killJarProcessWindows(fileName);
		// 启动服务
		ExecuteUtil.executeBat(scriptFile);
	}

	/**
	 * 删掉windows里的进程
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	private void killJarProcessWindows(String fileName) throws IOException {
		Process proc = Runtime.getRuntime().exec("wmic process list");
		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String info = br.readLine();
		while (info != null) {
			info = br.readLine();
			if (StringUtils.isNotBlank(info) && info.contains(fileName)) {
				logger.info("找到需要删除的进程:" + info);
				String pid = StringUtil.getFirstNumber(info);
				logger.info("找到需要删除的进程pid:" + pid);
				SystemUtil.killByPid(NumberUtils.toInt(pid));
				logger.info("杀掉进程:" + pid);
			}
		}
	}

	private void dealFileLinux(MultipartFile file, DeployForm deployForm) throws IllegalStateException, IOException {
		String serverDir = RegistryTableData.getInstance().get("autoDeployServerDir");
		new File(serverDir).mkdirs();
		String fileName = file.getOriginalFilename();
		// 覆盖服务文件及脚本文件
		String scriptFile = dealFileLinux(file, deployForm, serverDir, fileName);
		// 关注运行的进程
		killJarProcessLinux(fileName);
		// 启动服务
		logger.info("启动服务:" + scriptFile);
		ExecuteUtil.execute(scriptFile);
	}

	private String dealFileLinux(MultipartFile file, DeployForm deployForm, String serverDir, String fileName) throws IOException {
		int lastIndex = fileName.lastIndexOf(".");
		String name = fileName.substring(0, lastIndex);
		String jarFile = serverDir + "/" + fileName;
		String scriptFile = serverDir + "/" + name + ".sh";
		file.transferTo(new File(jarFile));
		logger.info("文件写入成功" + jarFile);
		String scriptContent = "nohup java " + deployForm.getStartParams() + " -jar " + jarFile + " &";
		FileUtils.writeStringToFile(new File(scriptFile), scriptContent);
		logger.info("脚本写入成功" + scriptFile);
		ExecuteUtil.execute("chmod 777 " + scriptFile);
		logger.info("脚本设置权限成功" + scriptFile);
		return scriptFile;
	}

	private void killJarProcessLinux(String fileName) throws IOException {
		String process = ExecuteUtil.execute("ps -ef");
		logger.info("进程:" + process);
		List<String> lines = IOUtils.readLines(IOUtils.toInputStream(process));
		for (String line : lines) {
			if (line.endsWith(fileName)) {
				logger.info("找到需要kill调的进程:" + line);
				killProcessLinux(line);
			}
		}
	}

	/**
	 * 杀掉进程
	 * 
	 * @param line
	 * @throws IOException
	 */
	private void killProcessLinux(String line) throws IOException {
		String pid = getPidLinux(line);
		// 杀掉进程
		ExecuteUtil.execute("kill -9 " + pid);
		logger.info("杀掉进程:" + pid);
	}

	/**
	 * 获取进程的pid
	 * 
	 * @param line
	 * @return
	 */
	private String getPidLinux(String line) {
		return StringUtil.getFirstNumber(line);
	}

	private void checkIp(MultipartHttpServletRequest request) {
		HttpServletRequest r = (HttpServletRequest) request;
		String ip = ServerUtil.getProxyIp(r);
		logger.info("接收到" + ip + "发来的发布请求");
		String ips = RegistryTableData.getInstance().get("autoDeployIps");
		if (StringUtils.isBlank(ips)) {
			return;
		}
		if (ips.indexOf(ip) == -1) {
			throw new SimbaException("不在白名单中，不能发布系统");
		}
	}

	private void checkSign(DeployForm deployForm) {
		String key = RegistryTableData.getInstance().get("autoDeployKey");
		String sign = EncryptUtil.md5(deployForm.getTime() + key);
		if (!sign.equals(deployForm.getSign())) {
			throw new SimbaException("签名错误");
		}
	}

}