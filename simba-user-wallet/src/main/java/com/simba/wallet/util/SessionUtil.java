package com.simba.wallet.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.exception.BussException;
import com.simba.model.SmartUser;
import com.simba.service.SmartUserService;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.model.TradeDepartment;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.enums.ChannelType;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeChannelService;
import com.simba.wallet.service.TradeDepartmentService;
import com.simba.wallet.service.TradeUserService;

/**
 * Session工具类
 * 
 * @author fzhang
 * 
 */
@Repository
public class SessionUtil {
	
	@Autowired
	public SmartUserService smartUserService;
	
	@Autowired
	public TradeAccountService tradeAccountService;
	
	@Autowired
	public TradeUserService tradeUserService;
	
	
	@Autowired
	private TradeDepartmentService tradeDepartmentService;

	@Autowired
	private TradeChannelService tradeChannelService;

	// 存在session里的TradeAccount对象的key
	public static final String tradeAccountKey = "sessTradeAccount";
	
	// 存在session里的SmartUser对象的key
	public static final String smartUserKey = "sessSmartUser";
	
	public static final String tradeUserKey = "sessTradeUser";

	public TradeDepartment getTradeDepartment(String deptNO) {
		TradeDepartment tradeDepartment = tradeDepartmentService.getBy("deptNO", deptNO);
		if (tradeDepartment == null) {
			throw new BussException("交易部门不存在");
		}
		return tradeDepartment;
	}

	public TradeAccount getTradeAccount(String userID) {
		TradeAccount tradeAccount = tradeAccountService.getBy("tradeUserID", getTradeUser(userID).getId());
		if (tradeAccount == null) {
			throw new BussException("用户账号不存在");
		}
		return tradeAccount;
	}

	public TradeUser getTradeUser(String userID) {
		TradeUser tradeUser = tradeUserService.getBy("userID", userID);
		if (tradeUser == null) {
			throw new BussException("交易用户不存在");
		}
		return tradeUser;
	}

	public TradeChannel getTradeChannel(ChannelType channelType) {
		TradeChannel tradeChannel = tradeChannelService.getBy("type", channelType.getName());
		if (tradeChannel == null) {
			throw new BussException("未找到交易渠道");
		}
		return tradeChannel;
	}
	/**
	 * @param session
	 * @return
	 */
	public SmartUser getSmartUser(HttpSession session) {
		Long userID = (Long)session.getAttribute("userId");
		SmartUser smartUser = smartUserService.get(userID);
		if (smartUser == null) {
			throw new BussException("用户未登陆");
		}
		return smartUser;
	}
		
}
