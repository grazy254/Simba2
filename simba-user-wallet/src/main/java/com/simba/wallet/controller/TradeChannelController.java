package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.service.TradeChannelService;

/**
 * 渠道信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeChannel")
public class TradeChannelController {

	@Autowired
	private TradeChannelService tradeChannelService;

	@RequestMapping("/list")
	public String list() {
		return "tradeChannel/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<TradeChannel> list = tradeChannelService.page(pager);
		model.put("list", list);
		return "tradeChannel/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = tradeChannelService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "tradeChannel/add";
	}

	@RequestMapping("/add")
	public String add(TradeChannel tradeChannel) {
		tradeChannelService.add(tradeChannel);
		return "redirect:/tradeChannel/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		TradeChannel tradeChannel = tradeChannelService.get(id);
		model.put("tradeChannel", tradeChannel);
		return "tradeChannel/update";
	}

	@RequestMapping("/update")
	public String update(TradeChannel tradeChannel) {
		tradeChannelService.update(tradeChannel);
		return "redirect:/tradeChannel/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeChannelService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeChannelService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
