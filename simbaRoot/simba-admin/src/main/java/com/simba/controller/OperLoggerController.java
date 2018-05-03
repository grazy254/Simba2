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
import com.simba.model.OperLogger;
import com.simba.service.OperLoggerService;
import com.simba.model.form.OperLoggerSearchForm;

/**
 * 操作日志控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/operLogger")
public class OperLoggerController {

	@Autowired
	private OperLoggerService operLoggerService;

	@RequestMapping("/list")
	public String list() {
		return "operLogger/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<OperLogger> list = operLoggerService.page(pager);
		model.put("list", list);
		return "operLogger/table";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "operLogger/search";
	}
	
	
	@RequestMapping("/doSearch")
	public String getList(Pager pager, OperLoggerSearchForm operLoggerSearchForm, ModelMap model){
		List<OperLogger> list = operLoggerService.page(pager, operLoggerSearchForm);
		model.put("list", list);
		return "operLogger/searchtable";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(OperLoggerSearchForm operLoggerSearchForm) {
		Long count = operLoggerService.count(operLoggerSearchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "operLogger/add";
	}

	@RequestMapping("/add")
	public String add(OperLogger operLogger) {
		operLoggerService.add(operLogger);
		return "redirect:/operLogger/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		OperLogger operLogger = operLoggerService.get(id);
		model.put("operLogger", operLogger);
		return "operLogger/update";
	}

	@RequestMapping("/update")
	public String update(OperLogger operLogger) {
		operLoggerService.update(operLogger);
		return "redirect:/operLogger/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		operLoggerService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		operLoggerService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
