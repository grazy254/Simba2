package com.simba.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simba.model.constant.ConstantData;

/**
 * sessionController
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/session")
public class SessionController {

	/**
	 * 获取会话session的sid
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getSid", method = RequestMethod.GET)
	public String getSid(HttpServletRequest request) {
		return (String) request.getAttribute(ConstantData.SESSIONID_COOKIE_NAME);
	}
}
