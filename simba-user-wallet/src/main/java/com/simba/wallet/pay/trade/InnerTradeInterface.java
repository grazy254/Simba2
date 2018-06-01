package com.simba.wallet.pay.trade;

import com.simba.framework.util.json.JsonResult;

public interface InnerTradeInterface {
    public JsonResult trade(String userID, String orderNO, long paymentAmount);
}
