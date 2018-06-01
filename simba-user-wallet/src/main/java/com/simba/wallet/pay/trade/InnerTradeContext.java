package com.simba.wallet.pay.trade;

import java.util.Date;
import com.simba.framework.util.json.JsonResult;

public class InnerTradeContext {
    private InnerTradeInterface trade;


    public InnerTradeContext(InnerTradeInterface trade) {
        this.trade = trade;
    }

    public JsonResult trade(String userID, String orderNO, long paymentAmount,
            Date tradeCreateTime) {
        return trade.trade(userID, orderNO, paymentAmount, tradeCreateTime);
    }
}
