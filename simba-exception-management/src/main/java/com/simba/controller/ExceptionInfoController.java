package com.simba.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.common.ServerUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.ip.util.IpUtil;
import com.simba.model.ExceptionInfo;
import com.simba.model.form.ExceptionInfoSearchForm;
import com.simba.service.ExceptionInfoService;

/**
 * 异常信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/exceptionInfo")
public class ExceptionInfoController {

	@Autowired
	private ExceptionInfoService exceptionInfoService;

	@Autowired
	private IpUtil ipUtil;

	@RequestMapping("/list")
	public String list() {
		return "exceptionInfo/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ExceptionInfoSearchForm searchForm, ModelMap model) {
		List<ExceptionInfo> list = exceptionInfoService.page(pager, searchForm);
		model.put("list", list);
		return "exceptionInfo/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(ExceptionInfoSearchForm searchForm) {
		Long count = exceptionInfoService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(ExceptionInfo exceptionInfo, HttpServletRequest request) {
		String ip = ServerUtil.getProxyIp(request);
		String address = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(ip)) {
			address = ipUtil.getAdress(ip).toString();
		} else {
			ip = StringUtils.EMPTY;
		}
		exceptionInfo.setCreateTime(new Date());
		exceptionInfo.setIp(ip);
		exceptionInfo.setIpInfo(address);
		exceptionInfoService.add(exceptionInfo);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		exceptionInfoService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		exceptionInfoService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@RequestMapping("/show")
	public String show(long id, ModelMap model) {
		ExceptionInfo exceptionInfo = exceptionInfoService.get(id);
		model.put("exceptionInfo", exceptionInfo);
		return "exceptionInfo/show";
	}

}
