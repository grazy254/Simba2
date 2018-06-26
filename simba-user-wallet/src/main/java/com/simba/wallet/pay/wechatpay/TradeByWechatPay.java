package com.simba.wallet.pay.wechatpay;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.simba.framework.util.data.ThreadDataUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.interfaces.PayInterface;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.wallet.pay.callbacktrade.CallbackTradeContext;
import com.simba.wallet.pay.callbacktrade.impl.WXRechargeTrade;
import com.simba.wallet.pay.callbacktrade.impl.WXRefundTrade;
import com.simba.wallet.util.Constants.TradeStatus;

@Component
public class TradeByWechatPay implements PayInterface {

    @Autowired
    private WXRechargeTrade rechargeTrade;
    @Autowired
    private WXRefundTrade refundTrade;

    private CallbackTradeContext rechargeContext = new CallbackTradeContext(rechargeTrade);
    private CallbackTradeContext refundContext = new CallbackTradeContext(refundTrade);
    private String userID = (String) ThreadDataUtil.get("account");

    @Override
    public void dealResult(PayResult payResult) {
        TradeStatus status = TradeStatus.FAILED;
        if (payResult.getTotal_fee() > 0) {
            status = TradeStatus.SUCCESS;
        }
        rechargeContext.finishTrade(userID, payResult.getOut_trade_no(),
                payResult.getTransaction_id(), payResult.getOpenid(),
                DateUtil.str2Date(payResult.getTime_end(), "yyyyMMddHHmmss"),
                payResult.getErr_code_des(), payResult.getErr_code(), payResult.getTotal_fee(),
                status);
    }



    @Override
    public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {
        rechargeContext.startTrade(userID, req.getSpbill_create_ip(), req.getOut_trade_no(),
                req.getTotal_fee(), DateUtil.str2Date(req.getTime_start(), "yyyyMMddHHmmss"));
    }

    @Override
    public void close(String outTradeNo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refund(RefundReq refundReq) {
        refundContext.startTrade(userID, "", refundReq.getOut_trade_no(),
                refundReq.getRefund_fee());

    }

    @Override
    public void dealRefundCallback(RefundResult refundResult, RefundCallbackInfo callbackInfo) {
        TradeStatus status = TradeStatus.FAILED;
        if ("SUCCESS".equals(callbackInfo.getRefund_status())) {
            status = TradeStatus.SUCCESS;
        }
        refundContext.finishTrade(userID, callbackInfo.getOut_trade_no(),
                callbackInfo.getTransaction_id(), "", new Date(),
                DateUtil.str2Date(callbackInfo.getSuccess_time(), "yyyy-MM-dd HH:mm:ss"), "", "",
                callbackInfo.getRefund_fee(), status);

    }

}
