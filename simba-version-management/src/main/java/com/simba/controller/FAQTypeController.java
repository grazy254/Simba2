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
import com.simba.model.FAQType;
import com.simba.service.FAQTypeService;

/**
 * 常见问题类型管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/fAQType")
public class FAQTypeController {

	@Autowired
	private FAQTypeService fAQTypeService;

	@RequestMapping("/list")
	public String list() {
		return "fAQType/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<FAQType> list = fAQTypeService.page(pager);
		model.put("list", list);
		return "fAQType/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = fAQTypeService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "fAQType/add";
	}

	@RequestMapping("/add")
	public String add(FAQType fAQType) {
		fAQTypeService.add(fAQType);
		return "redirect:/fAQType/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		FAQType fAQType = fAQTypeService.get(id);
		model.put("fAQType", fAQType);
		return "fAQType/update";
	}

	@RequestMapping("/update")
	public String update(FAQType fAQType) {
		fAQTypeService.update(fAQType);
		return "redirect:/fAQType/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		fAQTypeService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		fAQTypeService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
