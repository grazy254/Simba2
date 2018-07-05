package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.vo.BlackListVo;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Blacklist;
import com.simba.model.Fans;
import com.simba.service.BlacklistService;
import com.simba.service.FansService;

/**
 * 黑名单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/blacklist")
public class BlacklistController {

	@Autowired
	private BlacklistService blacklistService;

	@Autowired
	private FansService fansService;

	@RequestMapping("/list")
	public String list() {
		return "blacklist/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<Blacklist> list = blacklistService.page(pager);
		List<BlackListVo> voList = new ArrayList<>(list.size());
		list.forEach((Blacklist blacklist) -> {
			BlackListVo vo = new BlackListVo();
			vo.setBlacklist(blacklist);
			int fansId = blacklist.getFansId();
			Fans fans = fansService.get(fansId);
			vo.setFans(fans);
			voList.add(vo);
		});
		model.put("list", voList);
		return "blacklist/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		int count = blacklistService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "blacklist/add";
	}

	@RequestMapping("/add")
	public String add(Blacklist blacklist) {
		blacklistService.add(blacklist);
		return "redirect:/blacklist/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		Blacklist blacklist = blacklistService.get(id);
		model.put("blacklist", blacklist);
		return "blacklist/update";
	}

	@RequestMapping("/update")
	public String update(Blacklist blacklist) {
		blacklistService.update(blacklist);
		return "redirect:/blacklist/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
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
