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
import com.simba.model.ReceiveDealType;
import com.simba.model.form.DealTypeSearchForm;
import com.simba.service.ReceiveDealTypeService;

/**
 * 处理接收消息类型控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/receiveDealType")
public class ReceiveDealTypeController {

	@Autowired
	private ReceiveDealTypeService receiveDealTypeService;

	@RequestMapping("/list")
	public String list() {
		return "receiveDealType/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, DealTypeSearchForm searchForm, ModelMap model) {
		List<ReceiveDealType> list = receiveDealTypeService.page(pager, searchForm);
		model.put("list", list);
		return "receiveDealType/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(DealTypeSearchForm searchForm) {
		Integer count = receiveDealTypeService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "receiveDealType/add";
	}

	@RequestMapping("/add")
	public String add(ReceiveDealType receiveDealType) {
		receiveDealTypeService.add(receiveDealType);
		return "redirect:/receiveDealType/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		ReceiveDealType receiveDealType = receiveDealTypeService.get(id);
		model.put("receiveDealType", receiveDealType);
		return "receiveDealType/update";
	}

	@RequestMapping("/update")
	public String update(ReceiveDealType receiveDealType) {
		receiveDealTypeService.update(receiveDealType);
		return "redirect:/receiveDealType/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		receiveDealTypeService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		receiveDealTypeService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
