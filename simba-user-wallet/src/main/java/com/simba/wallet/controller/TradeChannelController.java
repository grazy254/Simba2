package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeChannel> list() {
		List<TradeChannel> list = tradeChannelService.listAll();
		return list;
	}

	/**
	 * 新增渠道信息
	 * 
	 * @param tradeChannel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeChannel tradeChannel) {
		tradeChannelService.add(tradeChannel);
		return new JsonResult("添加成功");
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeChannel tradeChannel) {
		tradeChannelService.update(tradeChannel);
		return new JsonResult();
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
