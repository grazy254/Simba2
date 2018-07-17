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
import com.simba.model.Directionary;
import com.simba.service.DirectionaryService;
/**
 * 字典控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/directionary")
public class DirectionaryController {

	@Autowired
	private DirectionaryService directionaryService;

	@RequestMapping("/list")
	public String list() {
		return "directionary/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<Directionary> list = directionaryService.page(pager);
		model.put("list", list);
		return "directionary/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = directionaryService.count();
		return new JsonResult(count, "", 200);
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "directionary/add";
	}

	@RequestMapping("/add")
	public String add(Directionary directionary) {
		directionaryService.add(directionary);
		return "redirect:/directionary/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		Directionary directionary = directionaryService.get(id);
		model.put("directionary", directionary);
		return "directionary/update";
	}

	@RequestMapping("/update")
	public String update(Directionary directionary) {
		directionaryService.update(directionary);
		return "redirect:/directionary/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		directionaryService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		directionaryService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
