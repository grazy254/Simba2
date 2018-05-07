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
import com.simba.model.AutoId;
import com.simba.service.AutoIdService;

/**
 * 自增id控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/autoId")
public class AutoIdController {

	@Autowired
	private AutoIdService autoIdService;

	@RequestMapping("/list")
	public String list() {
		return "autoId/list";
	}

	@RequestMapping("/getList")
	public String getList(String key, Pager pager, ModelMap model) {
		List<AutoId> list = autoIdService.listAll(key);
		model.put("list", list);
		return "autoId/table";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "autoId/add";
	}

	@RequestMapping("/add")
	public String add(AutoId autoId) {
		autoIdService.add(autoId);
		return "redirect:/autoId/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap model) {
		AutoId autoId = autoIdService.get(id);
		model.put("autoId", autoId);
		return "autoId/update";
	}

	@RequestMapping("/update")
	public String update(AutoId autoId) {
		autoIdService.update(autoId);
		return "redirect:/autoId/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(String id, ModelMap model) {
		autoIdService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(String[] id, ModelMap model) {
		autoIdService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/getAutoId")
	public JsonResult getAutoId(String id) {
		long num = autoIdService.getAutoId(id);
		return new JsonResult(num);
	}

}
