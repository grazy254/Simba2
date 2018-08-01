package com.simba.registry.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.registry.model.RegistryTableData;

/**
 * 读取注册表数据的对外Api的Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/api/registry")
public class RegistryApiController {

	/**
	 * 获取key对应的值
	 * 
	 * @param key
	 * @return
	 */
	@RequestMapping("/get")
	public JsonResult get(String key) {
		String value = RegistryTableData.getInstance().get(key);
		return new JsonResult(value);
	}

}
