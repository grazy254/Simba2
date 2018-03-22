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
import com.simba.model.DeviceBind;
import com.simba.model.form.DeviceBindSearchForm;
import com.simba.service.DeviceBindService;

/**
 * 设备绑定控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/deviceBind")
public class DeviceBindController {

	@Autowired
	private DeviceBindService deviceBindService;

	@RequestMapping("/list")
	public String list() {
		return "deviceBind/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, DeviceBindSearchForm searchForm, ModelMap model) {
		List<DeviceBind> list = deviceBindService.page(pager, searchForm);
		model.put("list", list);
		return "deviceBind/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(DeviceBindSearchForm searchForm) {
		int count = deviceBindService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "deviceBind/add";
	}

	@RequestMapping("/add")
	public String add(DeviceBind deviceBind) {
		deviceBindService.add(deviceBind);
		return "redirect:/deviceBind/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		DeviceBind deviceBind = deviceBindService.get(id);
		model.put("deviceBind", deviceBind);
		return "deviceBind/update";
	}

	@RequestMapping("/update")
	public String update(DeviceBind deviceBind) {
		deviceBindService.update(deviceBind);
		return "redirect:/deviceBind/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		deviceBindService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		deviceBindService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
