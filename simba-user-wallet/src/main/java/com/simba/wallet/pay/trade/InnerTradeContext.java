package com.simba.wallet.pay.trade;

import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.util.FmtUtil;

public class InnerTradeContext {
    private InnerTradeInterface trade;


    public InnerTradeContext(InnerTradeInterface trade) {
        this.trade = trade;
    }

    public JsonResult trade(String userID, String orderNO, long paymentAmount) {
        return trade.trade(userID, orderNO, paymentAmount);
    }

    public JsonResult trade(String userID, long paymentAmount) {
        return trade.trade(userID, FmtUtil.generateOrderNO(), paymentAmount);

    }
}
