package com.simba.wallet.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.exception.BussException;
import com.simba.model.SmartUser;
import com.simba.model.TradeAccount;
import com.simba.model.TradeUser;
import com.simba.service.SmartUserService;
import com.simba.service.TradeAccountService;
import com.simba.service.TradeUserService;

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
	
	
	// 存在session里的TradeAccount对象的key
	public static final String tradeAccountKey = "sessTradeAccount";
	
	// 存在session里的SmartUser对象的key
	public static final String smartUserKey = "sessSmartUser";
	
	public static final String tradeUserKey = "sessTradeUser";

	
	/**
	 * @param session
	 * @return
	 */
	public SmartUser getSmartUser(HttpSession session) {
		SmartUser smartUserSess =  (SmartUser)session.getAttribute(smartUserKey);
		if (smartUserSess == null) {
			Long userID = (Long)session.getAttribute("userId");
			SmartUser smartUser = smartUserService.get(userID);
			//拦截器确保能获取到smartUser
			setSmartUser(session, smartUser);
			return smartUser;
		}
		return smartUserSess;
	}

	public void setSmartUser(HttpSession session, SmartUser smartUser) {
		session.setAttribute(smartUserKey, smartUser);
	}

	/**
	 * @param session
	 * @return
	 */
	public TradeAccount getTradeAccount(HttpSession session) {
		TradeAccount tradeAccountSess =  (TradeAccount)session.getAttribute(tradeAccountKey);
		if (tradeAccountSess == null) {
			SmartUser smartUser = getSmartUser(session);
			TradeAccount tradeAccount = tradeAccountService.getBy("userID", smartUser.getAccount());
			if (tradeAccount == null) {
				throw new BussException("用户尚未开通钱包功能");
			}
			setTradeAccount(session, tradeAccount);
			return tradeAccount;
		}
		return tradeAccountSess;
	}

	public void setTradeAccount(HttpSession session, TradeAccount tradeAccount) {
		session.setAttribute(tradeAccountKey, tradeAccount);
	}
	
	public TradeUser getTradeUser(HttpSession session) {
		TradeUser tradeUserSess =  (TradeUser)session.getAttribute(tradeUserKey);
		if (tradeUserSess == null) {
			SmartUser smartUser = getSmartUser(session);
			TradeUser tradeUser = tradeUserService.getBy("userID", smartUser.getAccount());
			if (tradeUser == null) {
				throw new BussException("用户尚未开通钱包功能");
			}
			setTradeUser(session, tradeUser);
			return tradeUser;
		}
		return tradeUserSess;

	}
	
	public void setTradeUser(HttpSession session, TradeUser tradeUser) {
		session.setAttribute(tradeUserKey, tradeUser);
	}
		
}
