package com.simba.wallet.pay.callbacktrade.impl;

import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.simba.framework.util.json.JsonResult;
import com.simba.registry.util.RegistryUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.enums.TradeStatus;
import com.simba.wallet.model.enums.TradeType;
import com.simba.wallet.pay.callbacktrade.BaseCallbackTrade;
import com.simba.wallet.util.FmtUtil;

@Service
@Transactional
public class WXRechargeTrade extends BaseCallbackTrade {

    @Override
    public void postTrade(TradeAccount smartUserTradeAccount, TradeAccount departmentTradeAccount,
            TradeAccount channelTradeAccount, long paymentAmount) {
        smartUserTradeAccount
                .setAccountBalance(smartUserTradeAccount.getAccountBalance() + paymentAmount);
        smartUserTradeAccount
                .setAvailableBalance(smartUserTradeAccount.getAvailableBalance() + paymentAmount);

        departmentTradeAccount
                .setAccountBalance(departmentTradeAccount.getAccountBalance() + paymentAmount);
        departmentTradeAccount
                .setAvailableBalance(departmentTradeAccount.getAvailableBalance() + paymentAmount);

        channelTradeAccount
                .setAccountBalance(channelTradeAccount.getAccountBalance() + paymentAmount);
        channelTradeAccount
                .setAvailableBalance(channelTradeAccount.getAvailableBalance() + paymentAmount);
    }

    @Override
    public JsonResult finishTrade(String userID, String orderNO, String channelOrderNO,
            String openID, Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
            long paymentAmount, TradeStatus tradeStatus) {

        return finishTrade(userID, FmtUtil.fmtChannel(RegistryUtil.get("trade.channel.weixin")),
                orderNO, channelOrderNO, openID, channelPaymentTime, channelErrorMsg,
                channelErrorCode, paymentAmount, tradeStatus,
                RegistryUtil.get("trade.department.recharge"));
    }

    @Override
    public JsonResult startTrade(String userID, String ip, String orderNO, long paymentAmount,
            Date tradeCreateTime, Date channelStartTime) {
        return startTrade(userID, ip, "", orderNO, "", "", "", paymentAmount, paymentAmount,
                tradeCreateTime, channelStartTime, RegistryUtil.get("trade.department.recharge"),
                FmtUtil.fmtChannel(RegistryUtil.get("trade.channel.weixin")), TradeType.RECHARGE);
    }

}
