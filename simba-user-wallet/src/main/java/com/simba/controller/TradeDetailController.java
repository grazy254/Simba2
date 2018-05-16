package com.simba.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.exception.BussException;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.model.TradeAccount;
import com.simba.model.TradeChannel;
import com.simba.model.TradeDepartment;
import com.simba.model.TradeDetail;
import com.simba.model.TradeParty;
import com.simba.model.TradeUser;
import com.simba.model.enums.ChannelType;
import com.simba.model.enums.FeeType;
import com.simba.model.enums.TradeType;
import com.simba.model.enums.TradeUserType;
import com.simba.service.SmartUserService;
import com.simba.service.TradeAccountService;
import com.simba.service.TradeDepartmentService;
import com.simba.service.TradeDetailService;
import com.simba.service.TradeUserService;
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
	
	@Value("${recharge.department}")
	private String rechargeDeptNO;
	
	@Autowired
	private TradeDetailService tradeDetailService;
	
	@Autowired
	private SmartUserService smartUserService;
	
	@Autowired
	private SessionUtil sessionUtil;
	
	@Autowired
	private TradeDepartmentService tradeDepartmentService;
	
	@Autowired
	private TradeAccountService tradeAccountService;
	
	@Autowired
	private TradeUserService tradeUserService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<TradeDetail> list() {
		List<TradeDetail> list = tradeDetailService.listAll();
		return list;
	}
	
	private String getChannelNameByType(String channelType) {
		String channelName = "";
		
		if (channelType == ChannelType.ALIPAY.getType()) {
			channelName = ChannelType.ALIPAY.getName(); 
		}else if (channelType == ChannelType.WXPAY.getType()) {
			channelName = ChannelType.WXPAY.getName();
		}else {
			throw new BussException("错误的渠道类型");
		}
		return channelName;
	}

	private TradeAccount forzenAccountBalance(long amount) {
		
		return null;
	}
	private TradeDepartment getTradeDepartment(String deptNO) {
		TradeDepartment tradeDepartment = tradeDepartmentService.getBy("deptNO", deptNO);
		if (tradeDepartment == null) {
			throw new BussException("交易部门不存在");
		}
		return tradeDepartment;
	}
	private TradeAccount getTradeAccount(String userID) {
		TradeAccount tradeAccount = tradeAccountService.getBy("userID", userID);
		if (tradeAccount == null) {
			throw new BussException("用户账号不存在");
		}
		return tradeAccount;
	}
	private TradeUser getTradeUser(String userID) {
		TradeUser tradeUser = tradeUserService.getBy("userID", userID);
		if (tradeUser == null) {
			throw new BussException("交易用户不存在");
		}
		return tradeUser;
	}
	@ResponseBody
	@RequestMapping("recharge") 
	public JsonResult recharge(TradeParty tradeParty, String channelType, 
			Long originalAmount, Long paymentAmount, String orderName, HttpSession session){
		
		String tradeAccountID =  sessionUtil.getTradeAccount(session).getAccountID();
		SmartUser smartUser = sessionUtil.getSmartUser(session);
		TradeUser tradeUser = sessionUtil.getTradeUser(session);
		
		TradeChannel tradeChannel = new TradeChannel();
		tradeChannel.setChannelName(getChannelNameByType(channelType));
		tradeChannel.setChannelType(channelType);
		tradeChannel.setCreateTime(new Date());
		tradeChannel.setTradeAccountID(tradeAccountID);
		tradeChannel.setLastUpdateTime(new Date()); //渠道返回后更新
//		tradeChannel.setErrorCode(""); //渠道返回后更新
//		tradeChannel.setErrorMsg(""); //渠道返回后更新
//		tradeChannel.setOpenID(); //渠道返回后更新
//		tradeChannel.setOrderCreateTime(orderCreateTime);  //渠道返回后更新
//		tradeChannel.setOrderNO(orderNO);  //渠道返回后更新
//		tradeChannel.setPaymentTime(paymentTime);  //渠道返回后更新
		
//		TradeParty tradeParty = new TradeParty();
		tradeParty.setCreateTime(new Date());
		tradeParty.setPartyName(smartUser.getName());
		tradeParty.setPartyType(TradeUserType.PERSION.getType());
		tradeParty.setTradeAccountID(tradeAccountID);
		tradeParty.setTradeUserID(tradeUser.getId());
		
		TradeParty counterParty = new TradeParty();
		counterParty.setCreateTime(new Date());
		counterParty.setPartyName(getTradeDepartment(rechargeDeptNO).getDeptName());
		counterParty.setPartyType(TradeUserType.COMPANY.getType());
		counterParty.setTradeAccountID(getTradeAccount(rechargeDeptNO).getAccountID());
		counterParty.setTradeUserID(getTradeUser(rechargeDeptNO).getId());
		
		TradeDetail tradeDetail = new TradeDetail();
		tradeDetail.setCreateTime(new Date());
		tradeDetail.setFeeType(FeeType.CNY.getName());
		tradeDetail.setLastUpdateTime(new Date());
		tradeDetail.setOrderAddress("");
		tradeDetail.setOrderDesc("");
		tradeDetail.setOrderName(orderName);
		tradeDetail.setOrderNO("");
		tradeDetail.setOriginalAmount(originalAmount);
		tradeDetail.setPaymentAmount(paymentAmount);
//		tradeDetail.setTradeChannelID(tradeChannelID);
//		tradeDetail.setTradeCounterpartyID(tradeCounterpartyID);
//		tradeDetail.setTradeStatus(tradeStatus);
//		tradeDetail.setTradeCreateTime(tradeCreateTime);
		tradeDetail.setTradeType(TradeType.RECHARGE.getName());
		Long tradeDetailID = tradeDetailService.add(tradeDetail);
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("getTradeList")
	public JsonResult getTradeList() {
		return null;
	}
	
	@ResponseBody
	@RequestMapping("trade")
	public JsonResult trade() {
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
