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
import com.simba.model.SmartGroup;
import com.simba.service.SmartGroupService;

/**
 * 分组表控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/smartGroup")
public class SmartGroupController {

	@Autowired
	private SmartGroupService smartGroupService;

	@RequestMapping("/list")
	public String list() {
		return "smartGroup/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<SmartGroup> list = smartGroupService.page(pager);
		model.put("list", list);
		return "smartGroup/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = smartGroupService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "smartGroup/add";
	}

	@RequestMapping("/add")
	public String add(SmartGroup smartGroup) {
		smartGroupService.add(smartGroup);
		return "redirect:/smartGroup/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		SmartGroup smartGroup = smartGroupService.get(id);
		model.put("smartGroup", smartGroup);
		return "smartGroup/update";
	}

	@RequestMapping("/update")
	public String update(SmartGroup smartGroup) {
		smartGroupService.update(smartGroup);
		return "redirect:/smartGroup/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		smartGroupService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		smartGroupService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
