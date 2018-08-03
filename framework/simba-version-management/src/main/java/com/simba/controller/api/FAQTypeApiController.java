package com.simba.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.service.FAQTypeService;

/**
 * 常见问题类型管理控制器
 * 
 * @author caozj
 * 
 */
@RestController
@RequestMapping("/api/fAQType")
public class FAQTypeApiController {

	@Autowired
	private FAQTypeService fAQTypeService;

	@RequestMapping("/list")
	public JsonResult list() {
		return new JsonResult(fAQTypeService.listAll());
	}

}
