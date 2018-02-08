package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Project;
import com.simba.model.ProjectUser;
import com.simba.service.ProjectService;
import com.simba.service.ProjectUserService;

/**
 * 控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectUserService projectUserService;

	@RequestMapping("/list")
	public String list() {
		return "project/list";
	}

	@RequestMapping("/getList")
	public String getList(String sessAccount, Pager pager, ModelMap model) {
		List<Project> projectList = new ArrayList<>();
		List<ProjectUser> projectUserObj = projectUserService.pageBy("account", sessAccount, pager);
		for (ProjectUser projectUser : projectUserObj) {
			projectList.add(projectService.get(projectUser.getProjectId()));
		}
		model.put("list", projectList);
		return "project/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(String sessAccount) {
		int count = projectService.countBy("account", sessAccount);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(HttpSession session) {
		return "project/add";
	}

	@RequestMapping("/add")
	public String add(String sessAccount, Project project) {
		projectService.add(sessAccount, project);
		return "redirect:/project/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		Project project = projectService.get(id);
		model.put("project", project);
		return "project/update";
	}

	@RequestMapping("/update")
	public String update(Project project) {
		projectService.update(project);
		return "redirect:/project/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		projectService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		projectService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/getProjectName")
	public JsonResult getProjectName(Integer projectId, ModelMap model) {
		JsonResult jsonResult = new JsonResult();
		String projectName = projectService.getBy("id", projectId).getName();
		if (projectName == null) {
			jsonResult.setCode(JsonResult.failCode);
			jsonResult.setMsg("没有对应项目");
		} else {
			jsonResult.setData(projectName);
		}
		return jsonResult;
	}

}
