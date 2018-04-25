package com.simba.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tmatesoft.svn.core.SVNException;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.DevProject;
import com.simba.model.ProjectPackageResult;
import com.simba.model.ProjectServer;
import com.simba.model.ProjectServerRel;
import com.simba.model.enums.VersionType;
import com.simba.service.DevProjectService;
import com.simba.service.ProjectPackageResultService;
import com.simba.service.ProjectServerRelService;
import com.simba.service.ProjectServerService;

/**
 * 项目控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/devProject")
public class DevProjectController {

	@Autowired
	private DevProjectService devProjectService;

	@Autowired
	private ProjectPackageResultService projectPackageResultService;

	@Autowired
	private ProjectServerRelService projectServerRelService;

	@Autowired
	private ProjectServerService projectServerService;

	@ResponseBody
	@RequestMapping("/copy")
	public JsonResult copy(Integer id) {
		DevProject devProject = devProjectService.get(id);
		devProjectService.add(devProject);
		return new JsonResult();
	}

	@RequestMapping("/list")
	public String list() {
		return "devProject/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<DevProject> list = devProjectService.page(pager);
		list.forEach((DevProject p) -> {
			List<String> targetFiles = new ArrayList<>();
			List<ProjectPackageResult> ps = projectPackageResultService.listBy("projectId", p.getId());
			ps.forEach((pp) -> {
				targetFiles.add(pp.getFilePath());
			});
			p.setTargetFiles(targetFiles.toString());
			List<String> targetServers = new ArrayList<>();
			List<ProjectServerRel> rels = projectServerRelService.listBy("projectId", p.getId());
			rels.forEach((ProjectServerRel rel) -> {
				int serverId = rel.getServerId();
				ProjectServer projectServer = projectServerService.get(serverId);
				targetServers.add(projectServer.getName() + "(" + projectServer.getIp() + ")");
			});
			p.setTargetServers(targetServers.toString());
		});
		model.put("list", list);
		return "devProject/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = devProjectService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", VersionType.values());
		return "devProject/add";
	}

	@RequestMapping("/add")
	public String add(DevProject devProject, String[] targetFile) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		devProjectService.add(devProject, targetFile);
		return "redirect:/devProject/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		List<String> targetFiles = new ArrayList<>();
		List<ProjectPackageResult> ps = projectPackageResultService.listBy("projectId", id);
		ps.forEach((pp) -> {
			targetFiles.add(pp.getFilePath());
		});
		DevProject devProject = devProjectService.get(id);
		model.put("devProject", devProject);
		model.put("targetFiles", FastJsonUtil.toJson(targetFiles));
		model.put("targetFileSize", targetFiles.size());
		model.put("types", VersionType.values());
		return "devProject/update";
	}

	@RequestMapping("/update")
	public String update(DevProject devProject, String[] targetFile) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		devProjectService.update(devProject, targetFile);
		return "redirect:/devProject/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		devProjectService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		devProjectService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@RequestMapping("/showBindServers")
	public String showBindServers(int id, ModelMap model) {
		List<ProjectServerRel> rels = projectServerRelService.listBy("projectId", id);
		List<Integer> bindServers = new ArrayList<>(rels.size());
		rels.forEach((ProjectServerRel rel) -> {
			bindServers.add(rel.getServerId());
		});
		model.put("bindServers", bindServers);
		model.put("servers", projectServerService.listAll());
		model.put("id", id);
		return "devProject/bindServers";
	}

	@ResponseBody
	@RequestMapping("/bindServers")
	public JsonResult bindServers(int projectId, String[] serverIds) {
		List<ProjectServerRel> rels = new ArrayList<>();
		if (serverIds != null && serverIds.length > 0) {
			for (String serverId : serverIds) {
				ProjectServerRel rel = new ProjectServerRel();
				rel.setProjectId(projectId);
				rel.setServerId(NumberUtils.toInt(serverId));
				rels.add(rel);
			}
		}
		projectServerRelService.bindServers(projectId, rels);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/publishAll")
	public JsonResult publishAll(int id) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException, RefNotFoundException,
			RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException {
		devProjectService.publishAll(id);
		return new JsonResult();
	}

	@RequestMapping("/showPublishSome")
	public String showPublishSome(int id, ModelMap model) {
		List<ProjectServerRel> rels = projectServerRelService.listBy("projectId", id);
		List<ProjectServer> servers = new ArrayList<>(rels.size());
		rels.forEach((ProjectServerRel rel) -> {
			ProjectServer server = projectServerService.get(rel.getServerId());
			servers.add(server);
		});
		model.put("servers", servers);
		model.put("id", id);
		return "devProject/publishSome";
	}

	@ResponseBody
	@RequestMapping("/publishSomeServers")
	public JsonResult publishSomeServers(int projectId, String[] serverIds) throws IOException, WrongRepositoryStateException, InvalidConfigurationException, InvalidRemoteException, CanceledException,
			RefNotFoundException, RefNotAdvertisedException, NoHeadException, TransportException, GitAPIException, SVNException {
		devProjectService.publish(projectId, serverIds);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/refreshCode")
	public JsonResult refreshCode(int id) throws InvalidRemoteException, TransportException, GitAPIException, SVNException {
		devProjectService.refreshCode(id);
		return new JsonResult();
	}
}
