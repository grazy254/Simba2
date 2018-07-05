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
import com.simba.model.MsgBlacklist;
import com.simba.service.MsgBlacklistService;

/**
 * 黑名单控制器
 *
 * @author caozj
 */
@Controller
@RequestMapping("/msgBlacklist")
public class MsgBlackListController {

	@Autowired
	private MsgBlacklistService blacklistService;

	@RequestMapping("/list")
	public String list() {
		return "msgBlacklist/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<MsgBlacklist> list = blacklistService.page(pager);
		model.put("list", list);
		return "msgBlacklist/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Integer count = blacklistService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "msgBlacklist/add";
	}

	@RequestMapping("/add")
	public String add(MsgBlacklist blacklist) {
		if (!blacklistService.isDuplicated(blacklist.getMobile())) {
			blacklistService.add(blacklist);
		}
		return "redirect:/msgBlacklist/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		MsgBlacklist blacklist = blacklistService.get(id);
		model.put("blacklist", blacklist);
		return "msgBlacklist/update";
	}

	@RequestMapping("/update")
	public String update(MsgBlacklist blacklist) {
		blacklistService.update(blacklist);
		return "redirect:/msgBlacklist/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		blacklistService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		blacklistService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
