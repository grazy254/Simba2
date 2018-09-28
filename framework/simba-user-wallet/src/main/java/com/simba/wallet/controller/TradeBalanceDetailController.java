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
import com.simba.wallet.model.TradeBalanceDetail;
import com.simba.wallet.service.TradeBalanceDetailService;

/**
 * 控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeBalanceDetail")
public class TradeBalanceDetailController {

	@Autowired
	private TradeBalanceDetailService tradeBalanceDetailService;

	@RequestMapping("/list")
	public String list() {
		return "tradeBalanceDetail/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<TradeBalanceDetail> list = tradeBalanceDetailService.page(pager);
		model.put("list", list);
		return "tradeBalanceDetail/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = tradeBalanceDetailService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "tradeBalanceDetail/add";
	}

	@RequestMapping("/add")
	public String add(TradeBalanceDetail tradeBalanceDetail) {
		tradeBalanceDetailService.add(tradeBalanceDetail);
		return "redirect:/tradeBalanceDetail/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		TradeBalanceDetail tradeBalanceDetail = tradeBalanceDetailService.get(id);
		model.put("tradeBalanceDetail", tradeBalanceDetail);
		return "tradeBalanceDetail/update";
	}

	@RequestMapping("/update")
	public String update(TradeBalanceDetail tradeBalanceDetail) {
		tradeBalanceDetailService.update(tradeBalanceDetail);
		return "redirect:/tradeBalanceDetail/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeBalanceDetailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeBalanceDetailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
