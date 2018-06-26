package com.simba.wallet.pay.alipay;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.interfaces.AliPayInterface;
import com.simba.framework.util.data.ThreadDataUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.wallet.pay.callbacktrade.CallbackTradeContext;
import com.simba.wallet.pay.callbacktrade.impl.AliRechargeTrade;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.ErrConfig;

public class TradeByAliPay implements AliPayInterface {

    @Autowired
    private AliRechargeTrade rechargeTrade;

    private CallbackTradeContext context = new CallbackTradeContext(rechargeTrade);
    private String userID = (String) ThreadDataUtil.get("account");


    @Override
    public void dealCallback(AliPayCallbackForm callbackForm) {
        try {
            TradeStatus status = TradeStatus.FAILED;

            if ("TRADE_SUCCESS".equals(callbackForm.getTrade_status())
                    || "TRADE_FINISHED".equals(callbackForm.getTrade_status())) {
                status = TradeStatus.SUCCESS;
            }

            context.finishTrade(userID, callbackForm.getOut_trade_no(), callbackForm.getTrade_no(),
                    callbackForm.getBuyer_id(),
                    DateUtil.str2Date(callbackForm.getGmt_create(), "yyyyMMddHHmmss"),
                    DateUtil.str2Date(callbackForm.getGmt_payment(), "yyyyMMddHHmmss"), "", "",
                    CommonUtil.CNYToLong(callbackForm.getTotal_amount()), status);
        } catch (ParseException e) {
            throw ErrConfig.CNY_PARSE_ERR;
        }
    }



    @Override
    public void appPay(AppPayForm payForm) {
        try {
            context.startTrade(userID, "", payForm.getOutTradeNo(),
                    CommonUtil.CNYToLong(payForm.getTotalAmount()));
        } catch (ParseException e) {
            throw ErrConfig.CNY_PARSE_ERR;
        }
    }



    @Override
    public void close(AliPayCloseForm closeForm) {
        // TODO Auto-generated method stub

    }



    @Override
    public void cancel(AliPayCancelForm cancelForm) {
        // TODO Auto-generated method stub

    }



    @Override
    public void refund(AliPayRefundForm refundForm) {
        // TODO Auto-generated method stub

    }

}
