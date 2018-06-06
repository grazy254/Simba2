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
import com.simba.wallet.util.CommonUtil;


/**
 * 微信提现交易
 * 
 * @author zhangfenghua
 *
 */
@Service
@Transactional
public class WXRefundTrade extends BaseCallbackTrade {

    @Override
    public void updateBalance(TradeAccount smartUserTradeAccount,
            TradeAccount departmentTradeAccount, TradeAccount channelTradeAccount,
            long paymentAmount) {
        smartUserTradeAccount
                .setAccountBalance(smartUserTradeAccount.getAccountBalance() - paymentAmount);
        smartUserTradeAccount
                .setAvailableBalance(smartUserTradeAccount.getAvailableBalance() - paymentAmount);

        departmentTradeAccount
                .setAccountBalance(departmentTradeAccount.getAccountBalance() - paymentAmount);
        departmentTradeAccount
                .setAvailableBalance(departmentTradeAccount.getAvailableBalance() - paymentAmount);

        channelTradeAccount
                .setAccountBalance(channelTradeAccount.getAccountBalance() - paymentAmount);
        channelTradeAccount
                .setAvailableBalance(channelTradeAccount.getAvailableBalance() - paymentAmount);
    }

    @Override
    public JsonResult finishTrade(String userID, String orderNO, String channelOrderNO,
            String openID, Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
            long paymentAmount, TradeStatus tradeStatus) {

        return finishTrade(userID, CommonUtil.fmtChannel(RegistryUtil.get("trade.channel.weixin")),
                orderNO, channelOrderNO, openID, channelPaymentTime, channelErrorMsg,
                channelErrorCode, paymentAmount, tradeStatus,
                RegistryUtil.get("trade.department.refund"));
    }

    @Override
    public JsonResult startTrade(String userID, String ip, String orderNO, long paymentAmount,
            Date channelStartTime) {
        return startTrade(userID, ip, "", orderNO, "", "", "", paymentAmount, paymentAmount,
                new Date(), channelStartTime, RegistryUtil.get("trade.department.refund"),
                CommonUtil.fmtChannel(RegistryUtil.get("trade.channel.weixin")), TradeType.REFUND);
    }

}
