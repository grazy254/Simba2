package com.simba.controller;

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

	@ApiOperation(value = "ping", notes = "成功返回ok")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ping() {
		return "ok";
	}
}
