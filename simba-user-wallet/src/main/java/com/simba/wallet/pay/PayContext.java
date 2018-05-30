package com.simba.wallet.pay;

import com.simba.framework.util.json.JsonResult;

public class PayContext {
    private RechargeInterface recharge;
    private RefundInterface refund;


    public PayContext(RechargeInterface recharge, RefundInterface refund) {
        this.recharge = recharge;
        this.refund = refund;
    }

    public JsonResult recharge() {
        return recharge.recharge();
    }

    public JsonResult refund() {
        return refund.refund();
    }
}
