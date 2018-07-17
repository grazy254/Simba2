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
import com.simba.model.Dictionary;
import com.simba.service.DictionaryService;
/**
 * 字典控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	@RequestMapping("/list")
	public String list() {
		return "dictionary/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<Dictionary> list = dictionaryService.page(pager);
		model.put("list", list);
		return "dictionary/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = dictionaryService.count();
		return new JsonResult(count, "", 200);
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "dictionary/add";
	}

	@RequestMapping("/add")
	public String add(Dictionary dictionary) {
		dictionaryService.add(dictionary);
		return "redirect:/dictionary/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		Dictionary dictionary = dictionaryService.get(id);
		model.put("dictionary", dictionary);
		return "dictionary/update";
	}

	@RequestMapping("/update")
	public String update(Dictionary dictionary) {
		dictionaryService.update(dictionary);
		return "redirect:/dictionary/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		dictionaryService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		dictionaryService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
