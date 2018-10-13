package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.FAQ;
import com.simba.model.FAQType;
import com.simba.model.form.FAQSearchForm;
import com.simba.service.FAQService;
import com.simba.service.FAQTypeService;

/**
 * 常见问题管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/fAQ")
public class FAQController {

	@Autowired
	private FAQService fAQService;

	@Autowired
	private FAQTypeService fAQTypeService;

	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		return "fAQ/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, FAQSearchForm searchForm, ModelMap model) {
		List<FAQ> list = fAQService.page(pager, searchForm);
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		list.forEach((FAQ faq) -> {
			String type = fAQTypeService.get(faq.getType()).getType();
			Map<String, Object> map = new HashMap<>();
			map.put("id", String.valueOf(faq.getId()));
			map.put("title", faq.getTitle());
			map.put("text", faq.getText());
			map.put("createTime", String.valueOf(faq.getCreateTime()));
			map.put("type", type);
			lists.add(map);
		});
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		model.put("list", lists);
		return "fAQ/table";
	}

	@RequestMapping("/count")
	public JsonResult count(FAQSearchForm searchForm) {
		Integer count = fAQService.count(searchForm);
		return new JsonResult(count);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		return "fAQ/add";
	}

	@RequestMapping("/add")
	public String add(FAQ fAQ, ModelMap model) {
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		fAQService.add(fAQ);
		return "redirect:/fAQ/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		FAQ fAQ = fAQService.get(id);
		model.put("fAQ", fAQ);
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		return "fAQ/update";
	}

	@RequestMapping("/update")
	public String update(FAQ fAQ, ModelMap model) {
		List<FAQType> typeList = fAQTypeService.listAll();
		model.put("typeList", typeList);
		fAQService.update(fAQ);
		return "redirect:/fAQ/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		fAQService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		fAQService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
