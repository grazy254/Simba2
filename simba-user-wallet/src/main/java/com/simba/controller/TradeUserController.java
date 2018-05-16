package com.simba.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.exception.BussException;
import com.simba.framework.util.code.DesUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.model.TradeUser;
import com.simba.service.SmartUserService;
import com.simba.service.TradeUserService;
import com.simba.service.UserProjectService;

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

	@Autowired
	private SmartUserService smartUserService;
	


	@ResponseBody
	@RequestMapping("/toConfirmTradeUserInfo") 
	public JsonResult toConfirmTradeUserInfo(Long userID) {	
		if (userID == null) {
			return new JsonResult("", "参数错误", 400);
		}
		SmartUser smartUser = smartUserService.get(userID);
		if (smartUser != null) {
			return new JsonResult(smartUser, "success", 200);
		}
		return new JsonResult("", "未知错误", 400);
	}
	
	
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
