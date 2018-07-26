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
import com.simba.model.PushMessage;
import com.simba.service.PushMessageService;
/**
 * 消息记录控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/pushMessage")
public class PushMessageController {

	@Autowired
	private PushMessageService pushMessageService;

	@RequestMapping("/list")
	public String list() {
		return "pushMessage/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<PushMessage> list = pushMessageService.page(pager);
		model.put("list", list);
		return "pushMessage/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = pushMessageService.count();
		return new JsonResult(count, "", 200);
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "pushMessage/add";
	}

	@RequestMapping("/add")
	public String add(PushMessage pushMessage) {
		pushMessageService.add(pushMessage);
		return "redirect:/pushMessage/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		PushMessage pushMessage = pushMessageService.get(id);
		model.put("pushMessage", pushMessage);
		return "pushMessage/update";
	}

	@RequestMapping("/update")
	public String update(PushMessage pushMessage) {
		pushMessageService.update(pushMessage);
		return "redirect:/pushMessage/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		pushMessageService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		pushMessageService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
