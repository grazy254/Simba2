package com.simba.wallet.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;
import com.simba.wallet.util.SessionUtil;

/**
 * 支付账号控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/api/tradeAccount")
public class TradeAccountApi {

	@Autowired
	private TradeAccountService tradeAccountService;

	@Autowired
	private TradeUserService tradeUserService;

	@Autowired
	private SessionUtil sessionUtil;

	/**
	 * 展示余额
	 * 
	 * @param sessSmartUserAccount
	 * 			@param session @return @throws
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/showBalance")
	public JsonResult showBalance(HttpSession session) throws Exception {
		SmartUser smartUser = sessionUtil.getSmartUser(session);

		TradeUser tradeUser = tradeUserService.get(smartUser.getAccount(), TradeUserType.PERSION);
		if (tradeUser == null) {
			tradeAccountService.openAccount(smartUser.getAccount(), smartUser.getName(), smartUser.getPassword(), smartUser.getTelNo(), smartUser.getEmail(), TradeUserType.PERSION, 1, 1,
					Constants.AccountActiveStatus.ACTIVE.getValue());
		}
		TradeAccount smartUserTradeAccount = tradeAccountService.get(smartUser.getAccount(), TradeUserType.PERSION);
		if (smartUserTradeAccount == null) {
			throw ErrConfig.INVALID_WALLET_USER;
		}
		return new JsonResult(CommonUtil.transToCNYType(smartUserTradeAccount.getAccountBalance()));

	}
}
