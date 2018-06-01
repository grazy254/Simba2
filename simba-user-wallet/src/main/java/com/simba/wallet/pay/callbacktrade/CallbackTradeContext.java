package com.simba.wallet.pay.callbacktrade;

import java.util.Date;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.enums.TradeStatus;

public class CallbackTradeContext {
    private CallbackTradeInterface callbackTrade;

    public CallbackTradeContext(CallbackTradeInterface callbackTrade) {
        this.callbackTrade = callbackTrade;
    }

    public JsonResult startTrade(String userID, String ip, String orderNO, long paymentAmount,
            Date tradeCreateTime, Date channelStartTime) {
        return callbackTrade.startTrade(userID, ip, orderNO, paymentAmount, tradeCreateTime,
                channelStartTime);
    }

    public JsonResult finishTrade(String userID, String orderNO, String channelOrderNO,
            String openID, Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
            long paymentAmount, TradeStatus tradeStatus) {

        return callbackTrade.finishTrade(userID, orderNO, channelOrderNO, openID,
                channelPaymentTime, channelErrorMsg, channelErrorCode, paymentAmount, tradeStatus);
    }
}
