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
import com.simba.model.ProjectPackageResult;
import com.simba.service.ProjectPackageResultService;

/**
 * 项目打包结果控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/projectPackageResult")
public class ProjectPackageResultController {

	@Autowired
	private ProjectPackageResultService projectPackageResultService;

	@RequestMapping("/list")
	public String list() {
		return "projectPackageResult/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<ProjectPackageResult> list = projectPackageResultService.page(pager);
		model.put("list", list);
		return "projectPackageResult/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = projectPackageResultService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "projectPackageResult/add";
	}

	@RequestMapping("/add")
	public String add(ProjectPackageResult projectPackageResult) {
		projectPackageResultService.add(projectPackageResult);
		return "redirect:/projectPackageResult/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		ProjectPackageResult projectPackageResult = projectPackageResultService.get(id);
		model.put("projectPackageResult", projectPackageResult);
		return "projectPackageResult/update";
	}

	@RequestMapping("/update")
	public String update(ProjectPackageResult projectPackageResult) {
		projectPackageResultService.update(projectPackageResult);
		return "redirect:/projectPackageResult/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		projectPackageResultService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		projectPackageResultService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
