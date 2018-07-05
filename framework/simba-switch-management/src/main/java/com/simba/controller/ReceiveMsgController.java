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
import com.simba.model.ReceiveMsg;
import com.simba.model.form.ReceiveMsgSearchForm;
import com.simba.service.ReceiveMsgService;

/**
 * 接收消息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/receiveMsg")
public class ReceiveMsgController {

	@Autowired
	private ReceiveMsgService receiveMsgService;

	@RequestMapping("/showContent")
	public String showContent(Long id, ModelMap model) {
		ReceiveMsg receiveMsg = receiveMsgService.get(id);
		model.put("msg", receiveMsg);
		return "receiveMsg/showContent";
	}

	@RequestMapping("/list")
	public String list() {
		return "receiveMsg/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ReceiveMsgSearchForm searchForm, ModelMap model) {
		List<ReceiveMsg> list = receiveMsgService.page(pager, searchForm);
		model.put("list", list);
		return "receiveMsg/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(ReceiveMsgSearchForm searchForm) {
		Long count = receiveMsgService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "receiveMsg/add";
	}

	@RequestMapping("/add")
	public String add(ReceiveMsg receiveMsg) {
		receiveMsgService.add(receiveMsg);
		return "redirect:/receiveMsg/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		ReceiveMsg receiveMsg = receiveMsgService.get(id);
		model.put("receiveMsg", receiveMsg);
		return "receiveMsg/update";
	}

	@RequestMapping("/update")
	public String update(ReceiveMsg receiveMsg) {
		receiveMsgService.update(receiveMsg);
		return "redirect:/receiveMsg/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		receiveMsgService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		receiveMsgService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
