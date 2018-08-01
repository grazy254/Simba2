package com.simba.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.BugFeedback;
import com.simba.service.BugFeedbackService;

/**
 * Bug反馈管理控制器
 * 
 * @author caozj
 * 
 */
@RestController
@RequestMapping("/api/bugFeedback")
public class BugFeedbackApiController {

	@Autowired
	private BugFeedbackService bugFeedbackService;

	/**
	 * 保存bug反馈
	 * 
	 * @param bugFeedback
	 * @return
	 */
	@RequestMapping("/save")
	public JsonResult save(BugFeedback bugFeedback) {
		bugFeedbackService.insertBugFeedback(bugFeedback);
		return new JsonResult();
	}

}
