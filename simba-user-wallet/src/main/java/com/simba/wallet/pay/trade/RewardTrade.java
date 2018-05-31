package com.simba.wallet.pay.trade;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.simba.framework.util.json.JsonResult;
import com.simba.registry.util.RegistryUtil;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.pay.BaseInnerTrade;

@Component
public class RewardTrade extends BaseInnerTrade {

    @Autowired
    private TradeAccountDao tradeAccountDao;

    @Override
    public JsonResult trade(String userID, String orderNO, long paymentAmount,
            Date tradeCreateTime) {
        return trade(userID, "", "", orderNO, "", "", "", paymentAmount, paymentAmount,
                tradeCreateTime, RegistryUtil.get("tradeAccount.department.reward"));
    }

    @Override
    public void postTrade(String smartUserAccountID, String departmentAccountID,
            long paymentAmount) {
        TradeAccount smartUserTradeAccount = tradeAccountDao.getBy("accountID", smartUserAccountID);

        TradeAccount departmentTradeAccount =
                tradeAccountDao.getBy("accountID", departmentAccountID);

        smartUserTradeAccount
                .setAccountBalance(smartUserTradeAccount.getAccountBalance() + paymentAmount);
        smartUserTradeAccount
                .setAvailableBalance(smartUserTradeAccount.getAvailableBalance() + paymentAmount);

        departmentTradeAccount
                .setAccountBalance(departmentTradeAccount.getAccountBalance() + paymentAmount);
        departmentTradeAccount
                .setAvailableBalance(departmentTradeAccount.getAvailableBalance() + paymentAmount);

        tradeAccountDao.update(smartUserTradeAccount);
        tradeAccountDao.update(departmentTradeAccount);
    }
}
