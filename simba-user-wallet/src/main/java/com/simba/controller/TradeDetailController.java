package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.TradeDetail;
import com.simba.service.TradeDetailService;

/**
 * 交易详情信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeDetail")
public class TradeDetailController {

	@Autowired
	private TradeDetailService tradeDetailService;

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeDetail> list() {
		List<TradeDetail> list = tradeDetailService.listAll();
		return list;
	}

	/**
	 * 新增交易详情信息
	 * 
	 * @param tradeDetail
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeDetail tradeDetail) {
		tradeDetailService.add(tradeDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeDetail tradeDetail) {
		tradeDetailService.update(tradeDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeDetailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeDetailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
