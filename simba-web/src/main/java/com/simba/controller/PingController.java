package com.simba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ping controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/ping")
public class PingController {

	@RequestMapping
	public String ping() {
		return "ok";
	}
}
