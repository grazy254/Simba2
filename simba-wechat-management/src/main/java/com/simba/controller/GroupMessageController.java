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
import com.simba.model.GroupMessage;
import com.simba.model.enums.GroupMessageType;
import com.simba.model.enums.SendStatus;
import com.simba.model.form.GroupMessageSearchForm;
import com.simba.service.GroupMessageService;

/**
 * 群发消息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/groupMessage")
public class GroupMessageController {

	@Autowired
	private GroupMessageService groupMessageService;

	@RequestMapping("/showJson")
	public String showJson(long id, ModelMap model) {
		GroupMessage groupMessage = groupMessageService.get(id);
		model.put("groupMessage", groupMessage);
		return "groupMessage/showJson";
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("types", GroupMessageType.values());
		model.put("statuses", SendStatus.values());
		return "groupMessage/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, GroupMessageSearchForm searchForm, ModelMap model) {
		List<GroupMessage> list = groupMessageService.page(pager, searchForm);
		model.put("list", list);
		return "groupMessage/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(GroupMessageSearchForm searchForm) {
		int count = groupMessageService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", GroupMessageType.values());
		return "groupMessage/add";
	}

	@ResponseBody
	@RequestMapping("/preview")
	public JsonResult preview(GroupMessage groupMessage, String previewOpenid) {
		groupMessageService.preview(groupMessage, previewOpenid);
		return new JsonResult();
	}

	@RequestMapping("/add")
	public String add(String sessAccount, GroupMessage groupMessage) {
		groupMessage.setAccount(sessAccount);
		groupMessageService.add(groupMessage);
		return "redirect:/groupMessage/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		GroupMessage groupMessage = groupMessageService.get(id);
		model.put("groupMessage", groupMessage);
		return "groupMessage/update";
	}

	@RequestMapping("/update")
	public String update(GroupMessage groupMessage) {
		groupMessageService.update(groupMessage);
		return "redirect:/groupMessage/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		groupMessageService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		groupMessageService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
