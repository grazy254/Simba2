package com.simba.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.PropertyTemplate;
import com.simba.service.TemplateService;

/**
 * 配置模板表控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

	@Autowired
	private TemplateService templateService;

	@RequestMapping("/list")
	public String list() {
		return "template/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<PropertyTemplate> list = templateService.page(pager);
		model.put("list", list);
		return "template/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = templateService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "template/add";
	}

	@RequestMapping("/add")
	public String add(PropertyTemplate template) {
		template.setCreateTime(new Date());
		templateService.add(template);
		return "redirect:/template/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		PropertyTemplate template = templateService.get(id);
		model.put("template", template);
		return "template/update";
	}

	@RequestMapping("/update")
	public String update(PropertyTemplate template) {
		template.setCreateTime(new Date());
		templateService.update(template);
		return "redirect:/template/list";
	}
	
	@RequestMapping("/showTemplate")
	public String showTemplate(Long id, ModelMap model) {
		PropertyTemplate template = templateService.get(id);
		model.put("template", template);
		return "template/showTemplate";
	}
	@ResponseBody
	@RequestMapping("/getTemplate")
	public JsonResult getTemplate(Long id, ModelMap model) {
		PropertyTemplate template = templateService.get(id);
		return new JsonResult(template,"",200);
	}

	
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		templateService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		templateService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
