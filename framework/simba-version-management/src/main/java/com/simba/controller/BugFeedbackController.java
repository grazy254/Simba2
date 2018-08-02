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
import com.simba.model.BugFeedback;
import com.simba.model.form.BugFeedbackSearchForm;
import com.simba.service.BugFeedbackService;

/**
 * bug反馈管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/bugFeedback")
public class BugFeedbackController {

	@Autowired
	private BugFeedbackService bugFeedbackService;

	@RequestMapping("/list")
	public String list() {
		return "bugFeedback/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, BugFeedbackSearchForm searchForm, ModelMap model) {
		List<BugFeedback> list = bugFeedbackService.page(pager, searchForm);
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", String.valueOf(list.get(i).getId()));
			map.put("userId", list.get(i).getUserId());
			map.put("title", list.get(i).getTitle());
			map.put("text", list.get(i).getText());
			map.put("createTime", String.valueOf(list.get(i).getCreateTime()));
			map.put("img", list.get(i).getImg().split(","));
			lists.add(map);
		}
		model.put("list", lists);
		return "bugFeedback/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(BugFeedbackSearchForm searchForm) {
		Integer count = bugFeedbackService.count(searchForm);
		return new JsonResult(count);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "bugFeedback/add";
	}

	@RequestMapping("/add")
	public String add(BugFeedback bugFeedback) {
		bugFeedbackService.add(bugFeedback);
		return "redirect:/bugFeedback/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		BugFeedback bugFeedback = bugFeedbackService.get(id);
		model.put("bugFeedback", bugFeedback);
		return "bugFeedback/update";
	}

	@RequestMapping("/update")
	public String update(BugFeedback bugFeedback) {
		bugFeedbackService.update(bugFeedback);
		return "redirect:/bugFeedback/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		bugFeedbackService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		bugFeedbackService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
