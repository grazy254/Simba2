package com.simba.wallet.pay.callbacktrade.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.json.JsonResult;
import com.simba.registry.util.RegistryUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.pay.callbacktrade.BaseCallbackTrade;
import com.simba.wallet.util.Constants.ChannelType;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;

/**
 * 微信充值交易
 * 
 * @author zhangfenghua
 *
 */
@Service
@Transactional
public class AliRechargeTrade extends BaseCallbackTrade {

	@Override
	public void updateBalance(TradeAccount smartUserTradeAccount, TradeAccount departmentTradeAccount, TradeAccount channelTradeAccount, long paymentAmount) {
		smartUserTradeAccount.setAccountBalance(smartUserTradeAccount.getAccountBalance() + paymentAmount);
		smartUserTradeAccount.setAvailableBalance(smartUserTradeAccount.getAvailableBalance() + paymentAmount);
		departmentTradeAccount.setAccountBalance(departmentTradeAccount.getAccountBalance() + paymentAmount);
		departmentTradeAccount.setAvailableBalance(departmentTradeAccount.getAvailableBalance() + paymentAmount);
		channelTradeAccount.setAccountBalance(channelTradeAccount.getAccountBalance() + paymentAmount);
		channelTradeAccount.setAvailableBalance(channelTradeAccount.getAvailableBalance() + paymentAmount);
	}

	@Override
	public JsonResult finishTrade(String userID, String orderNO, String channelOrderNO, String openID, Date channelStartTime, Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
			long paymentAmount, TradeStatus tradeStatus) {
		return finishTrade(userID, ChannelType.getChannelType(RegistryUtil.get("trade.channel.alipay")), orderNO, channelOrderNO, openID, channelStartTime, channelPaymentTime, channelErrorMsg,
				channelErrorCode, paymentAmount, tradeStatus, RegistryUtil.get("trade.department.recharge"), TradeType.RECHARGE);
	}

	@Override
	public JsonResult startTrade(String userID, String ip, String location, String orderNO, String orderName, String orderDesc, String orderAddress, long originalAmount, long paymentAmount,
			Date channelStartTime) {
		return startTrade(userID, ip, location, orderNO, orderName, orderDesc, orderAddress, originalAmount, paymentAmount, new Date(), channelStartTime, RegistryUtil.get("trade.department.recharge"),
				ChannelType.getChannelType(RegistryUtil.get("trade.channel.alipay")), TradeType.RECHARGE);
	}

}
