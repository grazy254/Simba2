package com.simba.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.OpinionFeedback;
import com.simba.service.OpinionFeedbackService;

/**
 * 意见反馈管理控制器
 * 
 * @author caozj
 * 
 */
@RestController
@RequestMapping("/api/opinionFeedback")
public class OpinionFeedbackApiController {

	@Autowired
	private OpinionFeedbackService opinionFeedbackService;

	@RequestMapping("/save")
	public JsonResult save(OpinionFeedback opinionFeedback) {
		opinionFeedbackService.insertOpinionFeedback(opinionFeedback);
		return new JsonResult();
	}

}
