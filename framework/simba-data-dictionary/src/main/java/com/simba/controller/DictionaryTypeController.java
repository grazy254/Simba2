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
import com.simba.model.DictionaryType;
import com.simba.service.DictionaryTypeService;
import com.simba.model.form.SearchDictionaryTypeForm;
/**
 * 字典类型控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/dictionaryType")
public class DictionaryTypeController {

	@Autowired
	private DictionaryTypeService dictionaryTypeService;

	@RequestMapping("/list")
	public String list() {
		return "dictionaryType/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<DictionaryType> list = dictionaryTypeService.page(pager);
		model.put("list", list);
		return "dictionaryType/table";
	}
	
	@RequestMapping("/doSearch")
	public String getList(Pager pager, SearchDictionaryTypeForm searchDictionaryTypeForm, ModelMap model){
		List<DictionaryType> list = dictionaryTypeService.page(pager, searchDictionaryTypeForm);
		model.put("list", list);
		return "dictionaryType/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(SearchDictionaryTypeForm searchDictionaryTypeForm) {
		Long count = dictionaryTypeService.count(searchDictionaryTypeForm);
		return new JsonResult(count, "", 200);
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "dictionaryType/add";
	}

	@RequestMapping("/add")
	public String add(DictionaryType dictionaryType) {
		dictionaryTypeService.add(dictionaryType);
		return "redirect:/dictionaryType/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		DictionaryType dictionaryType = dictionaryTypeService.get(id);
		model.put("dictionaryType", dictionaryType);
		return "dictionaryType/update";
	}

	@RequestMapping("/update")
	public String update(DictionaryType dictionaryType) {
		dictionaryTypeService.update(dictionaryType);
		return "redirect:/dictionaryType/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		dictionaryTypeService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		dictionaryTypeService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
