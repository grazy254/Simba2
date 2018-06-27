package com.simba.wallet.pay.alipay;

import javax.annotation.PostConstruct;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.interfaces.AliPayInterface;
import com.simba.framework.util.data.ThreadDataUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.model.SmartUser;
import com.simba.wallet.pay.callbacktrade.CallbackTradeContext;
import com.simba.wallet.pay.callbacktrade.impl.AliRechargeTrade;
import com.simba.wallet.pay.callbacktrade.impl.AliRefundTrade;
import com.simba.wallet.util.Constants.TradeStatus;

@Component
public class TradeByAliPay implements AliPayInterface {

    @Autowired
    private AliRechargeTrade rechargeTrade;

    @Autowired
    private AliRefundTrade refundTrade;

    private CallbackTradeContext rechargeContext = null;
    private CallbackTradeContext refundContext = null;

    @PostConstruct
    public void init() {
        rechargeContext = new CallbackTradeContext(rechargeTrade);
        refundContext = new CallbackTradeContext(refundTrade);

    }


    @Override
    public void dealCallback(AliPayCallbackForm callbackForm) {
        SmartUser user = (SmartUser) ThreadDataUtil.get("account");

        if (com.simba.alipay.enums.TradeStatus.SUCCESS.name()
                .equals(callbackForm.getTrade_status())) {
            rechargeContext.finishTrade(user.getAccount(), callbackForm.getOut_trade_no(),
                    callbackForm.getTrade_no(), callbackForm.getBuyer_id(),
                    DateUtil.str2Date(callbackForm.getGmt_create(), "yyyyMMddHHmmss"),
                    DateUtil.str2Date(callbackForm.getGmt_payment(), "yyyyMMddHHmmss"), "", "",
                    NumberUtils.toInt(callbackForm.getTotal_amount()), TradeStatus.SUCCESS);
        } else if (com.simba.alipay.enums.TradeStatus.REFUNDSUCCESS.getName()
                .equals(callbackForm.getTrade_status())) {
            refundContext.finishTrade(user.getAccount(), callbackForm.getOut_trade_no(),
                    callbackForm.getTrade_no(), callbackForm.getBuyer_id(),
                    DateUtil.str2Date(callbackForm.getGmt_create(), "yyyyMMddHHmmss"),
                    DateUtil.str2Date(callbackForm.getGmt_payment(), "yyyyMMddHHmmss"), "", "",
                    NumberUtils.toLong(callbackForm.getTotal_amount()), TradeStatus.SUCCESS);
        }

    }


    @Override
    public void appPay(AppPayForm payForm) {
        SmartUser user = (SmartUser) ThreadDataUtil.get("account");
        rechargeContext.startTrade(user.getAccount(), "", payForm.getOutTradeNo(),
                NumberUtils.toLong(payForm.getTotalAmount()));

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
        SmartUser user = (SmartUser) ThreadDataUtil.get("account");

        refundContext.startTrade(user.getAccount(), "", refundForm.getOutTradeNo(),
                NumberUtils.toLong(refundForm.getRefundAmount()));
    }

}
