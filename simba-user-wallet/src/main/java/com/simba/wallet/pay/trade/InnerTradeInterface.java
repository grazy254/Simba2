package com.simba.wallet.pay.trade;

import com.simba.framework.util.json.JsonResult;

public interface InnerTradeInterface {
    /**
     * 交易
     * 
     * @param userID
     * @param orderNO
     * @param paymentAmount
     * @return
     */
    public JsonResult trade(String userID, String ip, String location, String orderNO,
            String orderName, String orderDesc, String orderAddress, long originalAmount,
            long paymentAmount);
}
