package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.enums.ChannelType;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeDepartmentService;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.SessionUtil;

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
	private TradeDepartmentService tradeDepartmentService;
	
	@Autowired
	private TradeAccountService tradeAccountService;
	
	@Autowired
	private TradeUserService tradeUserService;
	
	@Autowired
	private TradeDetailService tradeDetailService;
	
	@Autowired
	private SessionUtil sessionUtil;

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeDetail> list() {
		List<TradeDetail> list = tradeDetailService.listAll();
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/recharge")
	public JsonResult recharge(TradePartyDetail tradePartyDetail, String orderNO, String orderName, String orderDesc, Long originalAmount,
			Long paymentAmount, Date tradeCreateTime, HttpSession session) {
		SmartUser smartUser = sessionUtil.getSmartUser(session);
		JsonResult rs = tradeDetailService.recharge(smartUser, "SK001", ChannelType.WXPAY,
		 tradePartyDetail, orderNO, orderName, orderDesc, originalAmount,
		 paymentAmount, tradeCreateTime);
		return rs;
	}
	
	@ResponseBody
	@RequestMapping("getTradeList")
	public JsonResult getTradeList() {
		return null;
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
