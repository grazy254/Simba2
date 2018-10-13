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
import com.simba.model.ReceiveMessage;
import com.simba.model.form.ReceiveMessageSearchForm;
import com.simba.service.ReceiveMessageService;

/**
 * 收到消息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/receiveMessage")
public class ReceiveMessageController {

	@Autowired
	private ReceiveMessageService receiveMessageService;

	/**
	 * 查看完整的XML内容
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showXML")
	public String showXML(long id, ModelMap model) {
		ReceiveMessage message = receiveMessageService.get(id);
		model.put("message", message);
		return "receiveMessage/showXML";
	}

	@RequestMapping("/list")
	public String list() {
		return "receiveMessage/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ReceiveMessageSearchForm searchForm, ModelMap model) {
		List<ReceiveMessage> list = receiveMessageService.page(pager, searchForm);
		model.put("list", list);
		return "receiveMessage/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(ReceiveMessageSearchForm searchForm) {
		long count = receiveMessageService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "receiveMessage/add";
	}

	@RequestMapping("/add")
	public String add(ReceiveMessage receiveMessage) {
		receiveMessageService.add(receiveMessage);
		return "redirect:/receiveMessage/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		ReceiveMessage receiveMessage = receiveMessageService.get(id);
		model.put("receiveMessage", receiveMessage);
		return "receiveMessage/update";
	}

	@RequestMapping("/update")
	public String update(ReceiveMessage receiveMessage) {
		receiveMessageService.update(receiveMessage);
		return "redirect:/receiveMessage/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		receiveMessageService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		receiveMessageService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
