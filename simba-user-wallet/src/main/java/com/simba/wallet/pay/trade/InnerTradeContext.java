package com.simba.wallet.pay.trade;

import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.util.FmtUtil;

/**
 * 支付调用接口
 * 
 * @author zhangfenghua
 *
 */
public class InnerTradeContext {

    private InnerTradeInterface trade;


    public InnerTradeContext(InnerTradeInterface trade) {
        this.trade = trade;
    }

    /**
     * 执行交易
     * 
     * @param userID smart用户的account
     * @param orderNO 订单号
     * @param paymentAmount 金额
     * @return
     */
    public JsonResult trade(String userID, String orderNO, long paymentAmount) {
        return trade.trade(userID, orderNO, paymentAmount);
    }

    /**
     * 执行交易 自动生成orderNO
     * 
     * @param userID
     * @param paymentAmount
     * @return
     */
    public JsonResult trade(String userID, long paymentAmount) {
        return trade.trade(userID, FmtUtil.generateOrderNO(), paymentAmount);

    }
}
