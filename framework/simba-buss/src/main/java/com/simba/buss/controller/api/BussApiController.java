package com.simba.buss.controller.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.buss.service.BussService;
import com.simba.framework.util.json.JsonResult;

/**
 * 业务Controller对外api
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/api/buss")
public class BussApiController {

	@Autowired
	private BussService bussService;

	/**
	 * 执行业务脚本
	 * 
	 * @param request
	 * @param scriptName
	 *            脚本名称
	 * @return
	 */
	@RequestMapping("/execute")
	public JsonResult execute(HttpServletRequest request, String scriptName) {
		Map<String, String[]> params = request.getParameterMap();
		Object object = bussService.execute(params, scriptName);
		return new JsonResult(object != null ? object.toString() : StringUtils.EMPTY);
	}

}
