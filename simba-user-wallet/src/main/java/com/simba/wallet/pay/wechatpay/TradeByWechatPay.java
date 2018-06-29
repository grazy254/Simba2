package com.simba.wallet.pay.wechatpay;

import java.util.Date;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.simba.framework.util.data.ThreadDataUtil;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.interfaces.PayInterface;
import com.simba.model.SmartUser;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.pay.callbacktrade.CallbackTradeContext;
import com.simba.wallet.pay.callbacktrade.impl.WXRechargeTrade;
import com.simba.wallet.pay.callbacktrade.impl.WXRefundTrade;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;

@Component
public class TradeByWechatPay implements PayInterface {

    private static final Log logger = LogFactory.getLog(TradeByWechatPay.class);

    @Autowired
    private WXRechargeTrade rechargeTrade;
    @Autowired
    private WXRefundTrade refundTrade;

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
    public void dealResult(PayResult payResult) {
        logger.info(String.format("wechat recharge callbacke trade payResult: %s",
                payResult.toString()));
        TradeStatus status = TradeStatus.FAILED;
        if (payResult.getTotal_fee() > 0) {
            status = TradeStatus.SUCCESS;
        }
        TradeUser tradeUser =
                tradeUserService.getByOrderNO(payResult.getOut_trade_no(), TradeType.RECHARGE);
        logger.info("wechat recharge callback trade user account: " + tradeUser.getUserID());

        JsonResult rs = rechargeContext.finishTrade(tradeUser.getUserID(),
                payResult.getOut_trade_no(), payResult.getTransaction_id(), payResult.getOpenid(),
                DateUtil.str2Date(payResult.getTime_end(), "yyyyMMddHHmmss"),
                payResult.getErr_code_des(), payResult.getErr_code(), payResult.getTotal_fee(),
                status);
        logger.info("wechat recharge callback trade result: " + rs.toJson());
    }



    @Override
    public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {
        logger.info(String.format(
                "wechat recharge start trade UnifiedOrderReq %s, prePayId %s, codeUrl %s, mwebUrl %s",
                req.toString(), prePayId, codeUrl, mwebUrl));
        SmartUser user = (SmartUser) ThreadDataUtil.get("account");
        JsonResult rs = rechargeContext.startTrade(user.getAccount(), req.getSpbill_create_ip(),
                req.getOut_trade_no(), req.getTotal_fee(),
                DateUtil.str2Date(req.getTime_start(), "yyyyMMddHHmmss"));
        logger.info("wechat recharge start trade result: " + rs.toJson());
    }

    @Override
    public void close(String outTradeNo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refund(RefundReq refundReq) {
        logger.info(String.format("wechat refund start trade RefundReq: %s", refundReq.toString()));
        TradeUser tradeUser =
                tradeUserService.getByOrderNO(refundReq.getOut_trade_no(), TradeType.RECHARGE);
        logger.info("wechat refund start trade user account: " + tradeUser.getUserID());

        JsonResult rs = refundContext.startTrade(tradeUser.getUserID(), "",
                refundReq.getOut_trade_no(), refundReq.getRefund_fee());
        logger.info("wechat refund start trade result: " + rs.toJson());

    }

    @Override
    public void dealRefundCallback(RefundResult refundResult, RefundCallbackInfo callbackInfo) {
        logger.info(String.format(
                "wechat refund callback trade RefundResult %s, RefundCallbackInfo %s: ",
                refundResult.toString(), callbackInfo.toString()));
        TradeUser tradeUser =
                tradeUserService.getByOrderNO(callbackInfo.getOut_trade_no(), TradeType.REFUND);
        logger.info("wechat refund callback trade user account: " + tradeUser.getUserID());

        TradeStatus status = TradeStatus.FAILED;
        if ("SUCCESS".equals(callbackInfo.getRefund_status())) {
            status = TradeStatus.SUCCESS;
        }
        JsonResult rs = refundContext.finishTrade(tradeUser.getUserID(),
                callbackInfo.getOut_trade_no(), callbackInfo.getTransaction_id(), "", new Date(),
                DateUtil.str2Date(callbackInfo.getSuccess_time(), "yyyy-MM-dd HH:mm:ss"), "", "",
                callbackInfo.getRefund_fee(), status);
        logger.info("wechat refund callback trade result: " + rs.toJson());


    }

}
