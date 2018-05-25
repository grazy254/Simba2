package com.simba.wallet.pay.wechatpay;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.simba.framework.util.date.DateUtil;
import com.simba.interfaces.PayInterface;
import com.simba.model.SmartUser;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.registry.util.RegistryUtil;
import com.simba.service.SmartUserService;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.util.FmtUtil;

public class TradeByWechatPay implements PayInterface {

    @Autowired
    private TradeDetailService tradeDetailService;

    @Autowired
    private SmartUserService smartUserService;

    @Override
    public void dealResult(PayResult payResult) {
        // ======修改的数据(针对充值操作)======
        // 普通用户的TradeAccount
        // AccountBalance = AccountBalance
        // FrozonBalance = ${changedAmount}
        // AvaliableBalance = AvaliableBalance

        // 收费部门的TradeAccount
        // AccountBalance = AccountBalance
        // FrozonBalance = ${changedAmount}
        // AvaliableBalance = AvaliableBalance
        // 渠道的TradeAccount
    }



    @Override
    public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {

        SmartUser smartUser = smartUserService.getBy("account", "18676459182");

        String tradeDeptNO = RegistryUtil.get("tradeAccount.department.recharge");
        String chanelType = RegistryUtil.get("tradeChannel.wxpay");

        tradeDetailService.startTrade(smartUser, tradeDeptNO, FmtUtil.getChannelType(chanelType),
                req.getSpbill_create_ip(), "", req.getOut_trade_no(), "", "", "", 0, 0,
                DateUtil.str2Date(req.getTime_start(), "yyyyMMddHHmmss", new Date()));
    }

    @Override
    public void close(String outTradeNo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refund(RefundReq refundReq) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dealRefundCallback(RefundResult refundResult, RefundCallbackInfo callbackInfo) {
        // TODO Auto-generated method stub

    }

}
