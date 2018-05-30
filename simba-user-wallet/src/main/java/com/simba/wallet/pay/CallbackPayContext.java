package com.simba.wallet.pay;

import com.simba.framework.util.json.JsonResult;

public class CallbackPayContext {
    private CallbackRechargeInterface recharge;
    private CallbackRefundInterface refund;

    public CallbackPayContext(CallbackRechargeInterface recharge, CallbackRefundInterface refund) {
        this.recharge = recharge;
        this.refund = refund;
    }

    public JsonResult startRecharge() {
        return recharge.startRecharge();
    }

    public JsonResult finishRecharge() {
        return recharge.finishRecharge();
    }

    public JsonResult startRefund() {
        return refund.startRefund();
    }

    public JsonResult finishRefund() {
        return refund.finishRefund();
    }
}
