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
import com.simba.model.OpinionFeedback;
import com.simba.model.form.OpinionFeedbackSearchForm;
import com.simba.service.OpinionFeedbackService;

/**
 * 意见反馈管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/opinionFeedback")
public class OpinionFeedbackController {

	@Autowired
	private OpinionFeedbackService opinionFeedbackService;

	@RequestMapping("/list")
	public String list() {
		return "opinionFeedback/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, OpinionFeedbackSearchForm searchForm, ModelMap model) {
		List<OpinionFeedback> list = opinionFeedbackService.page(pager, searchForm);
		model.put("list", list);
		return "opinionFeedback/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = opinionFeedbackService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "opinionFeedback/add";
	}

	@RequestMapping("/add")
	public String add(OpinionFeedback opinionFeedback) {
		opinionFeedbackService.add(opinionFeedback);
		return "redirect:/opinionFeedback/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		OpinionFeedback opinionFeedback = opinionFeedbackService.get(id);
		model.put("opinionFeedback", opinionFeedback);
		return "opinionFeedback/update";
	}

	@RequestMapping("/update")
	public String update(OpinionFeedback opinionFeedback) {
		opinionFeedbackService.update(opinionFeedback);
		return "redirect:/opinionFeedback/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		opinionFeedbackService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		opinionFeedbackService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
