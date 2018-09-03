package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.RealTimeMessage;
import com.simba.model.form.RealTimeMessageSearchForm;
import com.simba.service.RealTimeMessageService;
import com.simba.util.OnlineUserUtil;

/**
 * 设备功能表控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/realTimeMessage")
public class RealTimeMessageController {

	@Autowired
	private RealTimeMessageService realTimeMessageService;

	@Autowired
	private OnlineUserUtil onlineUserUtil;

	@RequestMapping("/list")
	public String list() {
		return "realTimeMessage/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, RealTimeMessageSearchForm searchForm, ModelMap model) {
		List<RealTimeMessage> list = realTimeMessageService.page(pager, searchForm);
		model.put("list", list);
		return "realTimeMessage/table";
	}

	@RequestMapping("/monitoring")
	public String monitoring(ModelMap model) {
		model.put("onlineCount", onlineUserUtil.countOnlineUser());
		model.put("appOnlineCount", onlineUserUtil.countOnlineUserByApp().toString());
		return "realTimeMessage/monitoring";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(RealTimeMessageSearchForm searchForm) {
		Long count = realTimeMessageService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "realTimeMessage/add";
	}

	@RequestMapping("/add")
	public String add(RealTimeMessage realTimeMessage) {
		realTimeMessageService.add(realTimeMessage);
		return "redirect:/realTimeMessage/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		RealTimeMessage realTimeMessage = realTimeMessageService.get(id);
		model.put("realTimeMessage", realTimeMessage);
		return "realTimeMessage/update";
	}

	@RequestMapping("/update")
	public String update(RealTimeMessage realTimeMessage) {
		realTimeMessageService.update(realTimeMessage);
		return "redirect:/realTimeMessage/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		realTimeMessageService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		realTimeMessageService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
