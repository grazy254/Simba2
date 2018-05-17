package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeChannelDetail;
import com.simba.wallet.service.TradeChannelDetailService;

/**
 * 交易的渠道信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeChannelDetail")
public class TradeChannelDetailController {

	@Autowired
	private TradeChannelDetailService tradeChannelDetailService;

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeChannelDetail> list() {
		List<TradeChannelDetail> list = tradeChannelDetailService.listAll();
		return list;
	}

	/**
	 * 新增交易的渠道信息
	 * 
	 * @param tradeChannelDetail
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeChannelDetail tradeChannelDetail) {
		tradeChannelDetailService.add(tradeChannelDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeChannelDetail tradeChannelDetail) {
		tradeChannelDetailService.update(tradeChannelDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeChannelDetailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeChannelDetailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
