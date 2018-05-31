package com.simba.wallet.pay;

import java.util.Date;
import com.simba.framework.util.json.JsonResult;

public interface InnerTradeInterface {
    public JsonResult trade(String userID, String orderNO, long paymentAmount,
            Date tradeCreateTime)
}
