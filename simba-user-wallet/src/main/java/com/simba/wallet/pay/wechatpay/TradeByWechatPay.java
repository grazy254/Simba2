package com.simba.wallet.pay.wechatpay;

import org.springframework.beans.factory.annotation.Autowired;
import com.simba.framework.util.data.ThreadDataUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.interfaces.PayInterface;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.wallet.model.enums.TradeStatus;
import com.simba.wallet.pay.callbacktrade.CallbackTradeContext;
import com.simba.wallet.pay.callbacktrade.impl.WXRechargeTrade;

public class TradeByWechatPay implements PayInterface {

    @Autowired
    private WXRechargeTrade rechargeTrade;

    private CallbackTradeContext context = new CallbackTradeContext(rechargeTrade);
    private String userID = (String) ThreadDataUtil.get("account");

    @Override
    public void dealResult(PayResult payResult) {
        TradeStatus status = null;
        if ("FAIL".equals(payResult.getReturn_code())
                || "FAIL".equals(payResult.getResult_code())) {
            status = TradeStatus.FAILED;
        }
        context.finishTrade(userID, payResult.getOut_trade_no(), payResult.getTransaction_id(),
                payResult.getOpenid(), DateUtil.str2Date(payResult.getTime_end(), "yyyyMMddHHmmss"),
                payResult.getErr_code_des(), payResult.getErr_code(), payResult.getTotal_fee(),
                status);
    }



    @Override
    public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {
        context.startTrade(userID, req.getSpbill_create_ip(), req.getOut_trade_no(),
                req.getTotal_fee(), DateUtil.str2Date(req.getTime_start(), "yyyyMMddHHmmss"));
    }

    @Override
    public void close(String outTradeNo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refund(RefundReq refundReq) {


    }

    @Override
    public void dealRefundCallback(RefundResult refundResult, RefundCallbackInfo callbackInfo) {
        // TODO Auto-generated method stub

    }

}
