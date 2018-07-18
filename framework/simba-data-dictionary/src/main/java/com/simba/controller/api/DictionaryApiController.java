package com.simba.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.Dictionary;
import com.simba.service.DictionaryTypeService;

/**
 * 数据字典对外api的Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/api/dictionary")
public class DictionaryApiController {

	@Autowired
	private DictionaryTypeService dictionaryTypeService;

	/**
	 * 根据数据字典的编码获取所有的选择列表
	 * 
	 * @param code
	 * @return
	 */
	@GetMapping("/list")
	public JsonResult list(String code) {
		List<Dictionary> list = dictionaryTypeService.listByCode(code);
		return new JsonResult(list);
	}
}
