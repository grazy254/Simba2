package com.simba.wallet.pay.trade.impl;

import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.simba.exception.BussException;
import com.simba.framework.util.json.JsonResult;
import com.simba.registry.util.RegistryUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.enums.TradeType;
import com.simba.wallet.pay.trade.BaseInnerTrade;

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
            throw new BussException("有一笔异常支付");
        }
        if (tradeAccount.getAvailableBalance() < amount) {
            throw new BussException("金额不足");
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
    public JsonResult trade(String userID, String orderNO, long paymentAmount) {
        return trade(userID, "", "", orderNO, "", "", "", paymentAmount, paymentAmount, new Date(),
                RegistryUtil.get("trade.department.consume"), TradeType.CONSUME);
    }

}
