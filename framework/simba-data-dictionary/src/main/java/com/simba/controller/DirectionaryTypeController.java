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
import com.simba.model.DirectionaryType;
import com.simba.service.DirectionaryTypeService;
import com.simba.model.form.SearchDirectionaryTypeForm;
/**
 * 字典类型控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/directionaryType")
public class DirectionaryTypeController {

	@Autowired
	private DirectionaryTypeService directionaryTypeService;

	@RequestMapping("/list")
	public String list() {
		return "directionaryType/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<DirectionaryType> list = directionaryTypeService.page(pager);
		model.put("list", list);
		return "directionaryType/table";
	}
	
	@RequestMapping("/doSearch")
	public String getList(Pager pager, SearchDirectionaryTypeForm searchDirectionaryTypeForm, ModelMap model){
		List<DirectionaryType> list = directionaryTypeService.page(pager, searchDirectionaryTypeForm);
		model.put("list", list);
		return "directionaryType/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(SearchDirectionaryTypeForm searchDirectionaryTypeForm) {
		Long count = directionaryTypeService.count(searchDirectionaryTypeForm);
		return new JsonResult(count, "", 200);
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "directionaryType/add";
	}

	@RequestMapping("/add")
	public String add(DirectionaryType directionaryType) {
		directionaryTypeService.add(directionaryType);
		return "redirect:/directionaryType/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		DirectionaryType directionaryType = directionaryTypeService.get(id);
		model.put("directionaryType", directionaryType);
		return "directionaryType/update";
	}

	@RequestMapping("/update")
	public String update(DirectionaryType directionaryType) {
		directionaryTypeService.update(directionaryType);
		return "redirect:/directionaryType/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		directionaryTypeService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		directionaryTypeService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
