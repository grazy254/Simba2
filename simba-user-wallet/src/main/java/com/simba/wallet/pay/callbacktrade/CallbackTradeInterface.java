package com.simba.wallet.pay.callbacktrade;

import java.util.Date;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.enums.TradeStatus;

public interface CallbackTradeInterface {

    /**
     * 回调接口开始交易
     * 
     * @param userID
     * @param ip
     * @param orderNO
     * @param paymentAmount
     * @param tradeCreateTime
     * @param channelStartTime
     * @return
     */
    JsonResult startTrade(String userID, String ip, String orderNO, long paymentAmount,
            Date tradeCreateTime, Date channelStartTime);

    /**
     * 回调接口结束交易
     * 
     * @param userID
     * @param orderNO
     * @param channelOrderNO
     * @param openID
     * @param channelPaymentTime
     * @param channelErrorMsg
     * @param channelErrorCode
     * @param paymentAmount
     * @param tradeStatus
     * @return
     */
    JsonResult finishTrade(String userID, String orderNO, String channelOrderNO, String openID,
            Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
            long paymentAmount, TradeStatus tradeStatus);
}
