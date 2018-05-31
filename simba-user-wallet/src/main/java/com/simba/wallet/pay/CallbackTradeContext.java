package com.simba.wallet.pay;

import com.simba.framework.util.json.JsonResult;

public class CallbackTradeContext {
    private CallbackTradeInterface callbackTrade;

    public CallbackTradeContext(CallbackTradeInterface callbackTrade) {
        this.callbackTrade = callbackTrade;
    }

    public JsonResult startTrade() {
        return callbackTrade.startTrade();
    }

    public JsonResult finishTrade() {
        return callbackTrade.finishTrade();
    }
}
