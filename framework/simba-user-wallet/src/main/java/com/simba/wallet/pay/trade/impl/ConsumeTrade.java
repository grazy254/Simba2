package com.simba.wallet.pay.trade.impl;

import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.simba.framework.util.json.JsonResult;
import com.simba.registry.util.RegistryUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.pay.trade.BaseInnerTrade;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.ErrConfig;

/**
 * 购买交易
 * 
 * @author zhangfenghua
 *
 */
@Service
@Transactional
public class ConsumeTrade extends BaseInnerTrade {

    public ConsumeTrade() {}

    @Override
    public void checkUserAccount(TradeAccount tradeAccount, Long amount) {
        if (tradeAccount.getFrozenBalance() != 0) {
            throw ErrConfig.EXISTING_INVALID_PAYMENT;
        }
        if (tradeAccount.getAvailableBalance() < amount) {
            throw ErrConfig.NO_ENOUGH_BALANCE;
        }
    }

    @Override
    public void updateBalance(TradeAccount smartUserTradeAccount,
            TradeAccount departmentTradeAccount, long paymentAmount) {

        smartUserTradeAccount
                .setAccountBalance(smartUserTradeAccount.getAccountBalance() - paymentAmount);
        smartUserTradeAccount
                .setAvailableBalance(smartUserTradeAccount.getAvailableBalance() - paymentAmount);

        departmentTradeAccount
                .setAccountBalance(departmentTradeAccount.getAccountBalance() + paymentAmount);
        departmentTradeAccount
                .setAvailableBalance(departmentTradeAccount.getAvailableBalance() + paymentAmount);
    }


    @Override
    public JsonResult trade(String userID, String ip, String location, String orderNO,
            String orderName, String orderDesc, String orderAddress, long originalAmount,
            long paymentAmount) {
        return trade(userID, ip, location, orderNO, orderName, orderDesc, orderAddress,
                paymentAmount, paymentAmount, new Date(),
                RegistryUtil.get("trade.department.consume"), TradeType.CONSUME);
    }

}
