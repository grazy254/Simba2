package com.simba.wallet.util;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.simba.exception.BussException;
import com.simba.model.SmartUser;
import com.simba.service.SmartUserService;
import com.simba.wallet.service.TradeAccountService;
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
		Long userID = (Long) session.getAttribute("userId");
		SmartUser smartUser = smartUserService.get(userID);
		if (smartUser == null) {
			throw new BussException("用户未登陆");
		}
		return smartUser;
	}

}
