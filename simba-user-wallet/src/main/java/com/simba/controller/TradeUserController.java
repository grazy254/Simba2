package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.TradeUser;
import com.simba.service.TradeUserService;

/**
 * 钱包用户信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeUser")
public class TradeUserController {

	@Autowired
	private TradeUserService tradeUserService;

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeUser> list() {
		List<TradeUser> list = tradeUserService.listAll();
		return list;
	}

	/**
	 * 新增钱包用户信息
	 * 
	 * @param tradeUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeUser tradeUser) {
		tradeUserService.add(tradeUser);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeUser tradeUser) {
		tradeUserService.update(tradeUser);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeUserService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeUserService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
