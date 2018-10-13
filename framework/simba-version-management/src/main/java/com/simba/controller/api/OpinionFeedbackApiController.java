package com.simba.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

	private final static Log logger = LogFactory.getLog(OpinionFeedbackApiController.class);

	@RequestMapping("/save")
	public JsonResult save(OpinionFeedback opinionFeedback, HttpServletRequest request) {
		logger.info("opinionFeedback:" + opinionFeedback.toString());
		if (opinionFeedback.getUserId() == null) {
			opinionFeedback.setUserId(Integer.parseInt(request.getSession().getAttribute("userId").toString()));
		}
		logger.info("opinionFeedback:" + opinionFeedback.toString());
		opinionFeedbackService.add(opinionFeedback);
		return new JsonResult();
	}

}
