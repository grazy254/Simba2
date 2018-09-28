package com.simba.wallet.pay.callbacktrade;

import java.util.Date;

import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.util.Constants.TradeStatus;

/**
 * 回调交易调用接口
 * 
 * @author zhangfenghua
 *
 */
public class CallbackTradeContext {
	private CallbackTradeInterface callbackTrade;

	public CallbackTradeContext(CallbackTradeInterface callbackTrade) {
		this.callbackTrade = callbackTrade;
	}

	public JsonResult startTrade(String userID, String ip, String orderNO, long paymentAmount, Date channelStartTime) {
		return callbackTrade.startTrade(userID, ip, "", orderNO, "", "", "", paymentAmount, paymentAmount, channelStartTime);
	}

	public JsonResult startTrade(String userID, String ip, String orderNO, long paymentAmount) {
		return callbackTrade.startTrade(userID, ip, "", orderNO, "", "", "", paymentAmount, paymentAmount, new Date());
	}

	public JsonResult finishTrade(String userID, String orderNO, String channelOrderNO, String openID, Date channelPaymentTime, String channelErrorMsg, String channelErrorCode, long paymentAmount,
			TradeStatus tradeStatus) {
		return callbackTrade.finishTrade(userID, orderNO, channelOrderNO, openID, null, channelPaymentTime, channelErrorMsg, channelErrorCode, paymentAmount, tradeStatus);
	}

	public JsonResult finishTrade(String userID, String orderNO, String channelOrderNO, String openID, Date channelStartTime, Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
			long paymentAmount, TradeStatus tradeStatus) {
		return callbackTrade.finishTrade(userID, orderNO, channelOrderNO, openID, channelStartTime, channelPaymentTime, channelErrorMsg, channelErrorCode, paymentAmount, tradeStatus);
	}
}
