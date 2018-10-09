package com.simba.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.constant.ConstantData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * sessionController
 * 
 * @author caozhejun
 *
 */
@Api(value = "Session Controller", tags = "Session Controller")
@RestController
@RequestMapping("/session")
public class SessionController {

	/**
	 * 获取会话session的sid
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "获取会话session的sid", notes = "获取会话session的sid")
	@RequestMapping(value = "/getSid", method = RequestMethod.GET)
	public JsonResult getSid(HttpServletRequest request) {
		return new JsonResult(request.getAttribute(ConstantData.SESSIONID_COOKIE_NAME));
	}
}
