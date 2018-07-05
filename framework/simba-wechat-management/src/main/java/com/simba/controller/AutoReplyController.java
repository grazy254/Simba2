package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.AutoReply;
import com.simba.model.enums.AutoReplyType;
import com.simba.service.AutoReplyService;

/**
 * 自动回复设置控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/autoReply")
public class AutoReplyController {

	@Autowired
	private AutoReplyService autoReplyService;

	@RequestMapping("/list")
	public String list() {
		return "autoReply/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<AutoReply> list = autoReplyService.page(pager);
		model.put("list", list);
		return "autoReply/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		int count = autoReplyService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", AutoReplyType.values());
		return "autoReply/add";
	}

	@RequestMapping("/add")
	public String add(AutoReply autoReply) {
		checkAdd(autoReply);
		autoReplyService.add(autoReply);
		return "redirect:/autoReply/list";
	}

	private void checkAdd(AutoReply autoReply) {
		AutoReply typeReply = autoReplyService.getBy("type", autoReply.getType());
		if (typeReply != null) {
			throw new RuntimeException("此类型已经设置了自动回复，不能重复设置");
		}
		if (StringUtils.isEmpty(autoReply.getContent())) {
			throw new RuntimeException("回复内容不能为空");
		}
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		AutoReply autoReply = autoReplyService.get(id);
		model.put("autoReply", autoReply);
		model.put("types", AutoReplyType.values());
		return "autoReply/update";
	}

	@RequestMapping("/update")
	public String update(AutoReply autoReply) {
		checkUpdate(autoReply);
		autoReplyService.update(autoReply);
		return "redirect:/autoReply/list";
	}

	private void checkUpdate(AutoReply autoReply) {
		AutoReply oldAutoReply = autoReplyService.get(autoReply.getId());
		if (oldAutoReply.getType() != autoReply.getType()) {
			AutoReply typeReply = autoReplyService.getBy("type", autoReply.getType());
			if (typeReply != null) {
				throw new RuntimeException("此类型已经设置了自动回复，不能重复设置");
			}
		}
		if (StringUtils.isEmpty(autoReply.getContent())) {
			throw new RuntimeException("回复内容不能为空");
		}
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		autoReplyService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		autoReplyService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
