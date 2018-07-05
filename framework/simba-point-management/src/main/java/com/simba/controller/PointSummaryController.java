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
import com.simba.model.PointSummary;
import com.simba.service.PointSummaryService;

/**
 * null控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/pointSummary")
public class PointSummaryController {

	@Autowired
	private PointSummaryService pointSummaryService;

	@RequestMapping("/list")
	public String list() {
		return "pointSummary/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<PointSummary> list = pointSummaryService.page(pager);
		model.put("list", list);
		return "pointSummary/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = pointSummaryService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "pointSummary/add";
	}

	@RequestMapping("/add")
	public String add(PointSummary pointSummary) {
		pointSummaryService.add(pointSummary);
		return "redirect:/pointSummary/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		PointSummary pointSummary = pointSummaryService.get(id);
		model.put("pointSummary", pointSummary);
		return "pointSummary/update";
	}

	@RequestMapping("/update")
	public String update(PointSummary pointSummary) {
		pointSummaryService.update(pointSummary);
		return "redirect:/pointSummary/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		pointSummaryService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		pointSummaryService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
