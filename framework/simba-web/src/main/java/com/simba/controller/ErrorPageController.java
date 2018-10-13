package com.simba.controller;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 错误处理Controller
 * 
 * @author caozhejun
 *
 */
@Api(value = "错误处理的Controller", tags = "错误处理的Controller")
@Controller
public class ErrorPageController {

	@Value("${page.error}")
	private String errorPage;

	@Value("${page.forbid}")
	private String forbidPage;

	@Value("${page.no}")
	private String noPage;

	@PostConstruct
	private void init() {
		noPage = StringUtils.defaultIfEmpty(noPage, "error/nopage");
		errorPage = StringUtils.defaultIfEmpty(errorPage, "error/error");
		forbidPage = StringUtils.defaultIfEmpty(forbidPage, "error/forbid");
	}

	@ApiOperation(value = "错误页面")
	@RequestMapping("/myerror")
	public String error() {
		return errorPage;
	}

	@ApiOperation(value = "禁止页面")
	@RequestMapping("/myforbid")
	public String forbid() {
		return forbidPage;
	}

	@ApiOperation(value = "404页面")
	@RequestMapping("/mynopage")
	public String nopage() {
		return noPage;
	}

}
