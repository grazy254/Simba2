package com.simba.controller.user;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.BugFeedback;
import com.simba.service.BugFeedbackService;

/**
 * bug反馈管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/user/bugFeedback")
public class UserBugFeedbackController {

	@Autowired
	private BugFeedbackService bugFeedbackService;
	
	private static final Log logger = LogFactory.getLog(UserBugFeedbackController.class);

	// new add interface
	@ResponseBody
	@RequestMapping("/insertBugFeedback")
	public JsonResult insertBugFeedback(BugFeedback bugFeedback) {
		bugFeedback.setUserId(1);
		bugFeedbackService.insertBugFeedback(bugFeedback);

		return new JsonResult("", "", 200);
	}
	// new add interface end!!!

	@ResponseBody
	@RequestMapping("/list")
	public List<BugFeedback> list() {
		logger.info("===============-----------------");
		List<BugFeedback> list = bugFeedbackService.listAll();
		return list;
	}

	/**
	 * 新增bug反馈管理
	 * 
	 * @param bugFeedback
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(BugFeedback bugFeedback) {
		bugFeedbackService.add(bugFeedback);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(BugFeedback bugFeedback) {
		bugFeedbackService.update(bugFeedback);
		return new JsonResult();
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
