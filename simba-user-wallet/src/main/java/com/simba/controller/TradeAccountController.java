package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.TradeAccount;
import com.simba.service.TradeAccountService;

/**
 * 支付账号控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeAccount")
public class TradeAccountController {

	@Autowired
	private TradeAccountService tradeAccountService;

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeAccount> list() {
		List<TradeAccount> list = tradeAccountService.listAll();
		return list;
	}

	/**
	 * 新增支付账号
	 * 
	 * @param tradeAccount
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeAccount tradeAccount) {
		tradeAccountService.add(tradeAccount);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeAccount tradeAccount) {
		tradeAccountService.update(tradeAccount);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeAccountService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeAccountService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
