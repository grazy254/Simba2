package com.simba.controller;

import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ping controller
 * 
 * @author caozhejun
 *
 */
@Api(value = "用来测试服务器是否运行的Controller", tags = "用来测试服务器是否运行的Controller")
@RestController
@RequestMapping("/ping")
public class PingController {

	private static final Log logger = LogFactory.getLog(PingController.class);

	@ApiOperation(value = "ping", notes = "成功返回ok")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ping() {
		return "ok";
	}

	@ApiOperation(value = "ping", notes = "成功返回ok")
	@RequestMapping(value = "/async", method = RequestMethod.GET)
	public Callable<String> asyncPing() {
		logger.info("begin ping");
		Callable<String> callable = () -> {
			logger.info("ping...");
			return "ok";
		};
		logger.info("end ping");
		return callable;
	}
}
