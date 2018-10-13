package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import com.simba.framework.util.json.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.MsgProject;
import com.simba.service.MsgProjectService;

/**
 * 项目控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/msgProject")
public class MsgProjectController {

	@Autowired
	private MsgProjectService projectService;

	@RequestMapping("/list")
	public String list() {
		return "msgProject/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<MsgProject> list = projectService.page(pager);
		model.put("list", list);
		return "msgProject/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = projectService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "msgProject/add";
	}

	@RequestMapping("/add")
	public String add(MsgProject project) {
		projectService.add(project);
		return "redirect:/msgProject/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		MsgProject project = projectService.get(id);
		model.put("project", project);
		return "msgProject/update";
	}

	@RequestMapping("/update")
	public String update(MsgProject project) {
		projectService.update(project);
		return "redirect:/msgProject/list";
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

	@ResponseBody
	@RequestMapping("/listJson")
	public JsonResult listJson() {
		List<MsgProject> listProject = projectService.listAll();
		return new JsonResult(FastJsonUtil.toJson(listProject));
	}
}
