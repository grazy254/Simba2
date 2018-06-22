package com.simba.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefNotAdvertisedException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tmatesoft.svn.core.SVNException;

import com.simba.dao.DeployLogDao;
import com.simba.dao.DevProjectDao;
import com.simba.dao.ProjectPackageResultDao;
import com.simba.dao.ProjectServerDao;
import com.simba.dao.ProjectServerRelDao;
import com.simba.exception.BussException;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.common.ExecuteUtil;
import com.simba.framework.util.common.StringUtil;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.common.ThreadUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.git.GitUtil;
import com.simba.model.DeployLog;
import com.simba.model.DevProject;
import com.simba.model.ProjectPackageResult;
import com.simba.model.ProjectServer;
import com.simba.model.ProjectServerRel;
import com.simba.model.enums.VersionType;
import com.simba.registry.model.RegistryTableData;
import com.simba.service.DevProjectService;
import com.simba.util.EmailUtil;
import com.simba.util.svn.SvnUtil;

/**
 * 项目 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DevProjectServiceImpl implements DevProjectService {

	private static final Log logger = LogFactory.getLog(DevProjectServiceImpl.class);

	private static final String deployUrl = "/deploy/receive";

	private static final String rollbackUrl = "/deploy/rollback";

	@Value("${auto.deploy.local.reps}")
	private String repsDir;

	@Autowired
	private DevProjectDao devProjectDao;

	@Autowired
	private ProjectPackageResultDao projectPackageResultDao;

	@Autowired
	private ProjectServerRelDao projectServerRelDao;

	@Autowired
	private ProjectServerDao projectServerDao;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private DeployLogDao deployLogDao;

	@Resource
	private TaskExecutor taskExecutor;

	@Override
	public void add(DevProject devProject) {
		devProjectDao.add(devProject);
	}

	@Override
	public void delete(Integer id) {
		DevProject devProject = this.get(id);
		devProjectDao.delete(id);
		projectServerRelDao.deleteBy("projectId", id);
		projectPackageResultDao.deleteBy("projectId", id);
		String repsPath = repsDir + "/" + devProject.getCode();
		FileUtils.deleteQuietly(new File(repsPath));
	}

	@Override
	@Transactional(readOnly = true)
	public DevProject get(Integer id) {
		return devProjectDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> page(Pager page) {
		return devProjectDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return devProjectDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return devProjectDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		devProjectDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> listAll() {
		return devProjectDao.listAll();
	}

	@Override
	public void update(DevProject devProject) {
		devProjectDao.update(devProject);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DevProject getBy(String field, Object value) {
		return devProjectDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public DevProject getByAnd(String field1, Object value1, String field2, Object value2) {
		return devProjectDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public DevProject getByOr(String field1, Object value1, String field2, Object value2) {
		return devProjectDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> listBy(String field, Object value) {
		return devProjectDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> listByAnd(String field1, Object value1, String field2, Object value2) {
		return devProjectDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> listByOr(String field1, Object value1, String field2, Object value2) {
		return devProjectDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> pageBy(String field, Object value, Pager page) {
		return devProjectDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return devProjectDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DevProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return devProjectDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		devProjectDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		devProjectDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countByAnd(String field1, Object value1, String field2, Object value2) {
		return devProjectDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countByOr(String field1, Object value1, String field2, Object value2) {
		return devProjectDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public void add(DevProject devProject, String[] targetFile) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		int projectId = devProjectDao.add(devProject);
		List<ProjectPackageResult> ps = new ArrayList<>();
		if (targetFile != null && targetFile.length > 0) {
			for (String file : targetFile) {
				if (StringUtils.isBlank(file)) {
					continue;
				}
				ProjectPackageResult pp = new ProjectPackageResult();
				pp.setFilePath(file);
				pp.setProjectId(projectId);
				ps.add(pp);
			}
		}
		ps.forEach((ProjectPackageResult pp) -> {
			projectPackageResultDao.add(pp);
		});
		getCodeFormVersionServer(devProject);
	}

	/**
	 * 从版本服务器拉代码
	 * 
	 * @param devProject
	 * @throws GitAPIException
	 * @throws TransportException
	 * @throws InvalidRemoteException
	 * @throws SVNException
	 */
	private void getCodeFormVersionServer(DevProject devProject) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		String repsPath = repsDir + "/" + devProject.getCode();
		new File(repsPath).mkdirs();
		if (StringUtils.isBlank(devProject.getVersionUrl())) {
			return;
		}
		// 从版本服务器拉取最新的代码
		checkoutCode(devProject);
	}

	/**
	 * 从代码库拉代码
	 * 
	 * @param devProject
	 * @throws GitAPIException
	 * @throws TransportException
	 * @throws InvalidRemoteException
	 * @throws SVNException
	 */
	private void checkoutCode(DevProject devProject) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		logger.info(devProject.toString() + "开发初始化代码:" + devProject.getVersionUrl());
		if (devProject.getVersionType().equals(VersionType.SVN.getName())) {
			// svn拉取代码
			checkoutSvn(devProject);
		} else {
			// git拉取代码
			cloneGit(devProject);
		}
		logger.info(devProject.toString() + "结束初始化代码:" + devProject.getVersionUrl());
	}

	/**
	 * 从git上clone代码
	 * 
	 * @param devProject
	 * @throws GitAPIException
	 * @throws TransportException
	 * @throws InvalidRemoteException
	 */
	private void cloneGit(DevProject devProject) throws InvalidRemoteException, TransportException, GitAPIException {
		String repsPath = repsDir + "/" + devProject.getCode();
		GitUtil.clone(devProject.getVersionUrl(), repsPath, devProject.getAccount(), devProject.getPwd());
	}

	/**
	 * 从svn上checkout代码
	 * 
	 * @param devProject
	 * @throws SVNException
	 */
	private void checkoutSvn(DevProject devProject) throws SVNException {
		String repsPath = repsDir + "/" + devProject.getCode();
		SvnUtil.getInstance().checkout(devProject.getVersionUrl(), repsPath, devProject.getAccount(), devProject.getPwd());
	}

	@Override
	public void update(DevProject devProject, String[] targetFile) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		DevProject oldDevProject = this.get(devProject.getId());
		projectPackageResultDao.deleteBy("projectId", devProject.getId());
		List<ProjectPackageResult> ps = new ArrayList<>();
		if (targetFile != null && targetFile.length > 0) {
			for (String file : targetFile) {
				if (StringUtils.isBlank(file)) {
					continue;
				}
				ProjectPackageResult pp = new ProjectPackageResult();
				pp.setFilePath(file);
				pp.setProjectId(devProject.getId());
				ps.add(pp);
			}
		}
		ps.forEach((ProjectPackageResult pp) -> {
			projectPackageResultDao.add(pp);
		});
		this.update(devProject);
		boolean changed = false;
		if (!devProject.getVersionUrl().equals(oldDevProject.getVersionUrl())) {
			changed = true;
		}
		if (!devProject.getCode().equals(oldDevProject.getCode())) {
			changed = true;
			String repsPath = repsDir + "/" + oldDevProject.getCode();
			FileUtils.deleteQuietly(new File(repsPath));
		}
		if (changed) {
			reGetCodeFormVersionServer(devProject);
		}
	}

	/**
	 * 从版本服务器重新拉代码
	 * 
	 * @param devProject
	 * @throws GitAPIException
	 * @throws TransportException
	 * @throws InvalidRemoteException
	 * @throws SVNException
	 */
	private void reGetCodeFormVersionServer(DevProject devProject) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		String repsPath = repsDir + "/" + devProject.getCode();
		FileUtils.deleteQuietly(new File(repsPath));
		getCodeFormVersionServer(devProject);
	}

	@Override
	public void publishAll(int id) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException, RefNotFoundException,
			RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException {
		List<ProjectServerRel> rels = projectServerRelDao.listBy("projectId", id);
		List<ProjectServer> servers = new ArrayList<>(rels.size());
		rels.forEach((ProjectServerRel rel) -> {
			ProjectServer server = projectServerDao.get(rel.getServerId());
			servers.add(server);
		});
		publishServers(this.get(id), servers);
	}

	/**
	 * 打包发布到服务器
	 * 
	 * @param devProject
	 * @param servers
	 * @throws IOException
	 * @throws GitAPIException
	 * @throws TransportException
	 * @throws NoHeadException
	 * @throws RefNotAdvertisedException
	 * @throws RefNotFoundException
	 * @throws CanceledException
	 * @throws InvalidRemoteException
	 * @throws InvalidConfigurationException
	 * @throws WrongRepositoryStateException
	 * @throws SVNException
	 */
	private void publishServers(DevProject devProject, List<ProjectServer> servers) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException,
			CanceledException, RefNotFoundException, RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException {
		checkServers(servers);
		projectPackage(devProject);
		publishPackageServers(devProject, servers);
		addLog(devProject);
		taskExecutor.execute(() -> {
			sendNotifyEmail(devProject);
		});
	}

	/**
	 * 增加日志
	 * 
	 * @param devProject
	 */
	private void addLog(DevProject devProject) {
		DeployLog log = new DeployLog();
		log.setName(devProject.getName());
		log.setProjectId(devProject.getId());
		deployLogDao.add(log);
	}

	private void checkServers(List<ProjectServer> servers) {
		if (servers == null || servers.size() == 0) {
			throw new BussException("没有绑定服务器");
		}
	}

	/**
	 * 将打包结果发布到服务器
	 * 
	 * @param devProject
	 * @param servers
	 */
	private void publishPackageServers(DevProject devProject, List<ProjectServer> servers) {
		List<ProjectPackageResult> res = projectPackageResultDao.listBy("projectId", devProject.getId());
		if (res.isEmpty()) {
			throw new BussException("没有需要发布的文件");
		}
		res.forEach((ProjectPackageResult r) -> {
			publishServer(r, devProject, servers);
		});
	}

	/**
	 * 将打包结果发布到服务器
	 * 
	 * @param r
	 * @param devProject
	 * @param servers
	 */
	private void publishServer(ProjectPackageResult r, DevProject devProject, List<ProjectServer> servers) {
		String repsPath = repsDir + "/" + devProject.getCode();
		String targetFile = repsPath + "/" + r.getFilePath();
		String key = RegistryTableData.getInstance().get("autoDeployKey");
		long time = System.currentTimeMillis();
		String sign = EncryptUtil.md5(time + key);
		String startParams = devProject.getStartParams();
		Map<String, String> params = new HashMap<>();
		params.put("sign", sign);
		params.put("startParams", startParams);
		params.put("time", time + "");
		int count = servers.size();
		int num = 0;
		for (ProjectServer server : servers) {
			String url = "http://" + server.getIp() + ":" + server.getPort() + deployUrl;
			logger.info("开始发布文件[" + targetFile + "]到" + url);
			String response = HttpClientUtil.fileUpload(url, targetFile, params);
			logger.info("结束发布文件[" + targetFile + "]到" + url + ",返回结果:" + response);
			num++;
			if (num != count) {
				ThreadUtil.sleep(30000);
			}
		}
	}

	/**
	 * 项目打包
	 * 
	 * @param devProject
	 * @throws IOException
	 * @throws GitAPIException
	 * @throws TransportException
	 * @throws NoHeadException
	 * @throws RefNotAdvertisedException
	 * @throws RefNotFoundException
	 * @throws CanceledException
	 * @throws InvalidRemoteException
	 * @throws InvalidConfigurationException
	 * @throws WrongRepositoryStateException
	 * @throws SVNException
	 */
	private void projectPackage(DevProject devProject) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException,
			RefNotFoundException, RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException {
		String repsPath = repsDir + "/" + devProject.getCode();
		if (!new File(repsPath).exists()) {
			reGetCodeFormVersionServer(devProject);
		}
		updateCode(devProject);
		packageServer(devProject);
	}

	/**
	 * 项目执行打包命令
	 * 
	 * @param devProject
	 * @throws IOException
	 */
	private void packageServer(DevProject devProject) throws IOException {
		String repsPath = repsDir + "/" + devProject.getCode();
		String packageCommandFile = repsPath + "/" + devProject.getPackageCommandFile();
		logger.info(devProject.toString() + "开始打包");
		File cf = new File(packageCommandFile);
		String cfDir = cf.getParent();
		String command = "";
		boolean isWindows = SystemUtil.isWindowsOs();
		if (isWindows) {
			command += "cmd.exe /c  ";
			command += com.simba.framework.util.file.FileUtils.getWindowsPanFu(cfDir) + ": && ";
		} else {
			command += "/bin/sh -c  ";
		}
		command += " cd " + cfDir + " && ";
		if (isWindows) {
			command += cf.getName();
		} else {
			command += " ./" + cf.getName();
		}
		logger.info("执行打包命令:" + command);
		ExecuteUtil.execute(command);
		logger.info(devProject.toString() + "结束打包");
	}

	/**
	 * 从版本服务器更新代码
	 * 
	 * @param devProject
	 * @throws GitAPIException
	 * @throws IOException
	 * @throws TransportException
	 * @throws NoHeadException
	 * @throws RefNotAdvertisedException
	 * @throws RefNotFoundException
	 * @throws CanceledException
	 * @throws InvalidRemoteException
	 * @throws InvalidConfigurationException
	 * @throws WrongRepositoryStateException
	 * @throws SVNException
	 */
	private void updateCode(DevProject devProject) throws WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException, RefNotFoundException,
			RefNotAdvertisedException, NoHeadException, TransportException, IOException, GitAPIException, SVNException {
		logger.info(devProject.toString() + "开发更新代码:" + devProject.getVersionUrl());
		if (devProject.getVersionType().equals(VersionType.SVN.getName())) {
			// svn更新代码
			updateSvn(devProject);
		} else {
			// git更新代码
			pullGit(devProject);
		}
		logger.info(devProject.toString() + "结束更新代码:" + devProject.getVersionUrl());
	}

	/**
	 * 从git来pull代码
	 * 
	 * @param devProject
	 * @throws GitAPIException
	 * @throws IOException
	 * @throws TransportException
	 * @throws NoHeadException
	 * @throws RefNotAdvertisedException
	 * @throws RefNotFoundException
	 * @throws CanceledException
	 * @throws InvalidRemoteException
	 * @throws InvalidConfigurationException
	 * @throws WrongRepositoryStateException
	 */
	private void pullGit(DevProject devProject) throws WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException, RefNotFoundException,
			RefNotAdvertisedException, NoHeadException, TransportException, IOException, GitAPIException {
		String repsPath = repsDir + "/" + devProject.getCode();
		GitUtil.pull(repsPath, devProject.getAccount(), devProject.getPwd());
	}

	/**
	 * 从svn上update代码
	 * 
	 * @param devProject
	 * @throws SVNException
	 */
	private void updateSvn(DevProject devProject) throws SVNException {
		String repsPath = repsDir + "/" + devProject.getCode();
		SvnUtil.getInstance().update(repsPath, devProject.getAccount(), devProject.getPwd());
	}

	/**
	 * 发送打包成功通知邮件
	 * 
	 * @param devProject
	 */
	private void sendNotifyEmail(DevProject devProject) {
		String emails = devProject.getNotifyEmails();
		if (StringUtils.isBlank(emails)) {
			return;
		}
		String title = devProject.getName() + "发布完成[" + DateUtil.now() + "]";
		String[] emailList = emails.split(",");
		for (String email : emailList) {
			if (StringUtils.isBlank(email)) {
				continue;
			}
			emailUtil.send(email, title, title);
		}
	}

	@Override
	public void publish(int projectId, String[] serverIds) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException,
			RefNotFoundException, RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException {
		List<ProjectServer> servers = new ArrayList<>();
		for (String serverId : serverIds) {
			ProjectServer server = projectServerDao.get(NumberUtils.toInt(serverId));
			servers.add(server);
		}
		publishServers(this.get(projectId), servers);
	}

	@Override
	public void refreshCode(int id) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		reGetCodeFormVersionServer(this.get(id));
	}

	@Override
	public void copy(Integer id) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		DevProject devProject = this.get(id);
		List<ProjectPackageResult> ps = projectPackageResultDao.listBy("projectId", id);
		String num = System.currentTimeMillis() + "";
		devProject.setCode(devProject.getCode() + num);
		devProject.setName(devProject.getName() + num);
		int length = ps.size();
		String[] targetFile = new String[length];
		for (int i = 0; i < length; i++) {
			targetFile[i] = ps.get(i).getFilePath();
		}
		this.add(devProject, targetFile);
	}

	@Override
	public void rollback(int projectId, String[] serverIds) {
		List<ProjectServer> servers = new ArrayList<>();
		for (String serverId : serverIds) {
			ProjectServer server = projectServerDao.get(NumberUtils.toInt(serverId));
			servers.add(server);
		}
		rollbackServers(this.get(projectId), servers);
	}

	@Override
	public void rollbackAll(int projectId) {
		List<ProjectServerRel> rels = projectServerRelDao.listBy("projectId", projectId);
		List<ProjectServer> servers = new ArrayList<>(rels.size());
		rels.forEach((ProjectServerRel rel) -> {
			ProjectServer server = projectServerDao.get(rel.getServerId());
			servers.add(server);
		});
		rollbackServers(this.get(projectId), servers);
	}

	/**
	 * 回滚服务器
	 * 
	 * @param devProject
	 * @param servers
	 */
	private void rollbackServers(DevProject devProject, List<ProjectServer> servers) {
		checkServers(servers);
		List<ProjectPackageResult> res = projectPackageResultDao.listBy("projectId", devProject.getId());
		if (res.isEmpty()) {
			throw new BussException("没有需要发布的文件");
		}
		List<String> fileNames = new ArrayList<>(res.size());
		res.forEach((ProjectPackageResult result) -> {
			String fileName = result.getFilePath();
			int index = fileName.lastIndexOf("/");
			if (index > -1) {
				fileName = fileName.substring(index + 1);
			}
			fileNames.add(fileName);
		});
		String names = StringUtil.join(fileNames, ",");
		Map<String, String> params = new HashMap<>(1);
		params.put("fileNames", names);
		for (ProjectServer server : servers) {
			rollbackServer(params, server);
		}
		addLog(devProject);
		taskExecutor.execute(() -> {
			sendNotifyEmail(devProject);
		});
	}

	private void rollbackServer(Map<String, String> params, ProjectServer server) {
		String url = "http://" + server.getIp() + ":" + server.getPort() + rollbackUrl;
		logger.info("开始回滚文件" + params.toString() + "到" + url);
		String response = HttpClientUtil.post(url, params);
		logger.info("结束回滚文件" + params.toString() + "到" + url + ",返回结果:" + response);
	}

}
