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
import com.simba.model.DayAmount;
import com.simba.service.DayAmountService;

/**
 * 控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/dayAmount")
public class DayAmountController {

	@Autowired
	private DayAmountService dayAmountService;

	@RequestMapping("/list")
	public String list() {
		return "dayAmount/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<DayAmount> list = dayAmountService.page(pager);
		model.put("list", list);
		return "dayAmount/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = dayAmountService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "dayAmount/add";
	}

	@RequestMapping("/add")
	public String add(DayAmount dayAmount) {
		dayAmountService.add(dayAmount);
		return "redirect:/dayAmount/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		DayAmount dayAmount = dayAmountService.get(id);
		model.put("dayAmount", dayAmount);
		return "dayAmount/update";
	}

	@RequestMapping("/update")
	public String update(DayAmount dayAmount) {
		dayAmountService.update(dayAmount);
		return "redirect:/dayAmount/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		dayAmountService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		dayAmountService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
