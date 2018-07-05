package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SendMessage;
import com.simba.model.enums.SendMessageType;
import com.simba.model.form.SendMessageSearchForm;
import com.simba.service.SendMessageService;

/**
 * 发消息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/sendMessage")
public class SendMessageController {

	@Autowired
	private SendMessageService sendMessageService;

	@RequestMapping("/toAddNews")
	public String toAddNews() {
		return "sendMessage/addNews";
	}

	@RequestMapping("/showJson")
	public String showJson(long id, ModelMap model) {
		SendMessage sendMessage = sendMessageService.get(id);
		model.put("sendMessage", sendMessage);
		return "sendMessage/showJson";
	}

	@RequestMapping("/showNews")
	public String showNews(long id, ModelMap model) {
		SendMessage sendMessage = sendMessageService.get(id);
		String news = sendMessage.getNews();
		String[] cs = news.split("@~@");
		List<Map<String, String>> list = new ArrayList<>(cs.length);
		for (String content : cs) {
			if (StringUtils.isEmpty(content)) {
				continue;
			}
			String[] a = content.split("&~&");
			Map<String, String> map = new HashMap<>(4);
			map.put("title", a[0]);
			map.put("description", a[1]);
			map.put("url", a[2]);
			map.put("picurl", a[3]);
			list.add(map);
		}
		model.put("list", list);
		return "sendMessage/showNews";
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("types", SendMessageType.values());
		return "sendMessage/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, SendMessageSearchForm searchForm, ModelMap model) {
		List<SendMessage> list = sendMessageService.page(pager, searchForm);
		model.put("list", list);
		return "sendMessage/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(SendMessageSearchForm searchForm) {
		int count = sendMessageService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", SendMessageType.values());
		return "sendMessage/add";
	}

	@RequestMapping("/add")
	public String add(String sessAccount, SendMessage sendMessage) {
		sendMessage.setAccount(sessAccount);
		sendMessageService.add(sendMessage);
		return "redirect:/sendMessage/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		SendMessage sendMessage = sendMessageService.get(id);
		model.put("types", SendMessageType.values());
		model.put("sendMessage", sendMessage);
		return "sendMessage/update";
	}

	@RequestMapping("/update")
	public String update(SendMessage sendMessage) {
		sendMessageService.update(sendMessage);
		return "redirect:/sendMessage/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		sendMessageService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		sendMessageService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
