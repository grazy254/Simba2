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
import com.simba.model.DeployLog;
import com.simba.service.DeployLogService;

/**
 * 部署日志控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/deployLog")
public class DeployLogController {

	@Autowired
	private DeployLogService deployLogService;

	@RequestMapping("/list")
	public String list() {
		return "deployLog/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<DeployLog> list = deployLogService.page(pager);
		model.put("list", list);
		return "deployLog/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = deployLogService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "deployLog/add";
	}

	@RequestMapping("/add")
	public String add(DeployLog deployLog) {
		deployLogService.add(deployLog);
		return "redirect:/deployLog/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		DeployLog deployLog = deployLogService.get(id);
		model.put("deployLog", deployLog);
		return "deployLog/update";
	}

	@RequestMapping("/update")
	public String update(DeployLog deployLog) {
		deployLogService.update(deployLog);
		return "redirect:/deployLog/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		deployLogService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		deployLogService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
