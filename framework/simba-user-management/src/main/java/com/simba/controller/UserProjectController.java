package com.simba.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.UserProject;
import com.simba.model.form.ProjectSearchForm;
import com.simba.service.UserProjectService;

/**
 * 项目控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/userProject")
public class UserProjectController {

	@Autowired
	private UserProjectService projectService;

	@RequestMapping("/list")
	public String list() {
		return "userProject/list";
	}

	@RequestMapping("/getList")
	public String getList(String sessAccount, Pager pager, ProjectSearchForm searchForm, ModelMap model) {
		List<UserProject> list = projectService.page(pager, searchForm);
		list.forEach((project) -> {
			project.setCanOper(sessAccount.equals(project.getCreateUserAccount()));
		});
		model.put("list", list);
		return "userProject/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(ProjectSearchForm searchForm) {
		int count = projectService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "userProject/add";
	}

	@RequestMapping("/add")
	public String add(String sessAccount, UserProject project) {
		project.setCreateTime(new Date());
		project.setCreateUserAccount(sessAccount);
		projectService.add(project);
		return "redirect:/userProject/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		UserProject project = projectService.get(id);
		model.put("project", project);
		return "userProject/update";
	}

	@RequestMapping("/update")
	public String update(String sessAccount, UserProject project) {
		project.setCreateTime(new Date());
		project.setCreateUserAccount(sessAccount);
		projectService.update(project);
		return "redirect:/userProject/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		projectService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		projectService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
