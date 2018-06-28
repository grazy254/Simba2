package com.simba.wallet.pay.alipay;

import javax.annotation.PostConstruct;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.pay.callbacktrade.CallbackTradeContext;
import com.simba.wallet.pay.callbacktrade.impl.AliRechargeTrade;
import com.simba.wallet.pay.callbacktrade.impl.AliRefundTrade;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;

@Component
public class TradeByAliPay implements AliPayInterface {

    private static final Log logger = LogFactory.getLog(TradeByAliPay.class);

    @Autowired
    private AliRechargeTrade rechargeTrade;

    @Autowired
    private AliRefundTrade refundTrade;

    @Autowired
    private TradeUserService tradeUserService;

    private CallbackTradeContext rechargeContext = null;
    private CallbackTradeContext refundContext = null;

    @PostConstruct
    public void init() {
        rechargeContext = new CallbackTradeContext(rechargeTrade);
        refundContext = new CallbackTradeContext(refundTrade);

    }

    @Override
    public void dealCallback(AliPayCallbackForm callbackForm) {

        if (com.simba.alipay.enums.TradeStatus.SUCCESS.name()
                .equals(callbackForm.getTrade_status())) {

            TradeUser tradeUser = tradeUserService.getByOrderNO(callbackForm.getOut_trade_no(),
                    TradeType.RECHARGE);

            JsonResult rs = rechargeContext.finishTrade(tradeUser.getUserID(),
                    callbackForm.getOut_trade_no(), callbackForm.getTrade_no(),
                    callbackForm.getBuyer_id(),
                    DateUtil.str2Date(callbackForm.getGmt_create(), "yyyyMMddHHmmss"),
                    DateUtil.str2Date(callbackForm.getGmt_payment(), "yyyyMMddHHmmss"), "", "",
                    NumberUtils.toInt(callbackForm.getTotal_amount()), TradeStatus.SUCCESS);
            logger.info("alipay recharge callback trade result: " + rs.toJson());

        } else if (com.simba.alipay.enums.TradeStatus.REFUNDSUCCESS.getName()
                .equals(callbackForm.getTrade_status())) {

            TradeUser tradeUser =
                    tradeUserService.getByOrderNO(callbackForm.getOut_trade_no(), TradeType.REFUND);

            JsonResult rs = refundContext.finishTrade(tradeUser.getUserID(),
                    callbackForm.getOut_trade_no(), callbackForm.getTrade_no(),
                    callbackForm.getBuyer_id(),
                    DateUtil.str2Date(callbackForm.getGmt_create(), "yyyyMMddHHmmss"),
                    DateUtil.str2Date(callbackForm.getGmt_payment(), "yyyyMMddHHmmss"), "", "",
                    NumberUtils.toLong(callbackForm.getTotal_amount()), TradeStatus.SUCCESS);
            logger.info("alipay refund callback trade result: " + rs.toJson());

        }

    }


    @Override
    public void appPay(AppPayForm payForm) {
        SmartUser user = (SmartUser) ThreadDataUtil.get("account");
        JsonResult rs = rechargeContext.startTrade(user.getAccount(), "", payForm.getOutTradeNo(),
                NumberUtils.toLong(payForm.getTotalAmount()));
        logger.info("alipay recharge start trade result: " + rs.toJson());


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

        TradeUser tradeUser =
                tradeUserService.getByOrderNO(refundForm.getOutTradeNo(), TradeType.RECHARGE);

        JsonResult rs = refundContext.startTrade(tradeUser.getUserID(), "",
                refundForm.getOutTradeNo(), NumberUtils.toLong(refundForm.getRefundAmount()));
        logger.info("alipay refund start trade result: " + rs.toJson());

    }

}
