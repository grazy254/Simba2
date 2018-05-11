package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.TradeParty;
import com.simba.service.TradePartyService;

/**
 * 交易主体控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeParty")
public class TradePartyController {

	@Autowired
	private TradePartyService tradePartyService;

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeParty> list() {
		List<TradeParty> list = tradePartyService.listAll();
		return list;
	}

	/**
	 * 新增交易主体
	 * 
	 * @param tradeParty
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeParty tradeParty) {
		tradePartyService.add(tradeParty);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeParty tradeParty) {
		tradePartyService.update(tradeParty);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradePartyService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradePartyService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
