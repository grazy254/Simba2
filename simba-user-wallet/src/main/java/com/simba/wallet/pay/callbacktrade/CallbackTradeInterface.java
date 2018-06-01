package com.simba.wallet.pay.callbacktrade;

import java.util.Date;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.enums.TradeStatus;

public interface CallbackTradeInterface {

    JsonResult startTrade(String userID, String ip, String orderNO, long paymentAmount,
            Date tradeCreateTime, Date channelStartTime);

    JsonResult finishTrade(String userID, String orderNO, String channelOrderNO, String openID,
            Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
            long paymentAmount, TradeStatus tradeStatus);
}
