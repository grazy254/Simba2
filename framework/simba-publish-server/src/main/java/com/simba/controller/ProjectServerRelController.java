package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.ProjectServerRel;
import com.simba.service.ProjectServerRelService;

/**
 * 项目绑定部署的服务器控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/projectServerRel")
public class ProjectServerRelController {

	@Autowired
	private ProjectServerRelService projectServerRelService;

	@RequestMapping("/list")
	public String list() {
		return "projectServerRel/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<ProjectServerRel> list = projectServerRelService.page(pager);
		model.put("list", list);
		return "projectServerRel/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = projectServerRelService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "projectServerRel/add";
	}

	@RequestMapping("/add")
	public String add(ProjectServerRel projectServerRel) {
		projectServerRelService.add(projectServerRel);
		return "redirect:/projectServerRel/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		ProjectServerRel projectServerRel = projectServerRelService.get(id);
		model.put("projectServerRel", projectServerRel);
		return "projectServerRel/update";
	}

	@RequestMapping("/update")
	public String update(ProjectServerRel projectServerRel) {
		projectServerRelService.update(projectServerRel);
		return "redirect:/projectServerRel/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		projectServerRelService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		projectServerRelService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
