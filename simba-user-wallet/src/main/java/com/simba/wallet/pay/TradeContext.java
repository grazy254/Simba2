package com.simba.wallet.pay;

import java.util.Date;
import com.simba.framework.util.json.JsonResult;

public class TradeContext {
    private InnerTradeInterface trade;


    public TradeContext(InnerTradeInterface trade) {
        this.trade = trade;
    }

    public JsonResult trade(String userID, String orderNO, long paymentAmount,
            Date tradeCreateTime) {
        return trade.trade(userID, orderNO, paymentAmount, tradeCreateTime);
    }
}
