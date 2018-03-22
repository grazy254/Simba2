package com.simba.controller.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.OpinionFeedback;
import com.simba.service.OpinionFeedbackService;

/**
 * 意见反馈管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/user/opinionFeedback")
public class UserOpinionFeedbackController {

	@Autowired
	private OpinionFeedbackService opinionFeedbackService;

	// new add interface
	@ResponseBody
	@RequestMapping("/insertOpinionFeedback")
	public JsonResult insertOpinionFeedback(OpinionFeedback opinionFeedback) {

		opinionFeedback.setUserId(1);
		opinionFeedbackService.insertOpinionFeedback(opinionFeedback);

		return new JsonResult("", "", 200);
	}
	// new add interface end!!!

	@ResponseBody
	@RequestMapping("/list")
	public List<OpinionFeedback> list() {
		List<OpinionFeedback> list = opinionFeedbackService.listAll();
		return list;
	}

	/**
	 * 新增意见反馈管理
	 * 
	 * @param opinionFeedback
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(OpinionFeedback opinionFeedback) {
		opinionFeedbackService.add(opinionFeedback);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(OpinionFeedback opinionFeedback) {
		opinionFeedbackService.update(opinionFeedback);
		return new JsonResult();
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
