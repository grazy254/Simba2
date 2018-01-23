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
import com.simba.model.OperLog;
import com.simba.model.form.OperLogSearchForm;
import com.simba.service.OperLogService;

/**
 * 操作日志控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/operLog")
public class OperLogController {

	@Autowired
	private OperLogService operLogService;

	@RequestMapping("/list")
	public String list() {
		return "operLog/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, OperLogSearchForm searchForm, ModelMap model) {
		List<OperLog> list = operLogService.page(pager, searchForm);
		model.put("list", list);
		return "operLog/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(OperLogSearchForm searchForm) {
		Long count = operLogService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "operLog/add";
	}

	@RequestMapping("/add")
	public String add(OperLog operLog) {
		operLogService.add(operLog);
		return "redirect:/operLog/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		OperLog operLog = operLogService.get(id);
		model.put("operLog", operLog);
		return "operLog/update";
	}

	@RequestMapping("/update")
	public String update(OperLog operLog) {
		operLogService.update(operLog);
		return "redirect:/operLog/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		operLogService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		operLogService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
