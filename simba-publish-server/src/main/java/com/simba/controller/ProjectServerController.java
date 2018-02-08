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
import com.simba.model.ProjectServer;
import com.simba.service.ProjectServerService;

/**
 * 服务器控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/projectServer")
public class ProjectServerController {

	@Autowired
	private ProjectServerService projectServerService;

	@RequestMapping("/list")
	public String list() {
		return "projectServer/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<ProjectServer> list = projectServerService.page(pager);
		model.put("list", list);
		return "projectServer/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = projectServerService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "projectServer/add";
	}

	@RequestMapping("/add")
	public String add(ProjectServer projectServer) {
		projectServerService.add(projectServer);
		return "redirect:/projectServer/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		ProjectServer projectServer = projectServerService.get(id);
		model.put("projectServer", projectServer);
		return "projectServer/update";
	}

	@RequestMapping("/update")
	public String update(ProjectServer projectServer) {
		projectServerService.update(projectServer);
		return "redirect:/projectServer/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		projectServerService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		projectServerService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
