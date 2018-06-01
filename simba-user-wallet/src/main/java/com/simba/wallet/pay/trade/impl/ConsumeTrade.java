package com.simba.wallet.pay.trade.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.simba.dao.SmartUserDao;
import com.simba.exception.BussException;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.registry.util.RegistryUtil;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.dao.TradeUserDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.enums.TradeType;
import com.simba.wallet.model.enums.TradeUserType;
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

    @Autowired
    private TradeUserDao tradeUserDao;

    @Autowired
    private SmartUserDao smartUserDao;

    @Autowired
    private TradeAccountDao tradeAccountDao;

    public ConsumeTrade() {}


    private boolean checkSmartUserAccountStatus(Long tradeUserID) {
        TradeAccount tradeAccount = tradeAccountDao.get(tradeUserID, TradeUserType.PERSION);
        if (tradeAccount.getFrozenBalance() != 0) {
            return false;
        }
        return true;
    }

    @Override
    public void checkUserAccount(String userID) {
        SmartUser smartUser = smartUserDao.getBy("account", userID);
        TradeUser tradeUser =
                tradeUserDao.get(smartUser.getAccount(), TradeUserType.PERSION.getName());

        if (!checkSmartUserAccountStatus(tradeUser.getId())) {
            throw new BussException("有一笔异常支付");
        }
    }


    @Override
    public void postTrade(String smartUserAccountID, String departmentAccountID,
            long paymentAmount) {

        TradeAccount smartUserTradeAccount = tradeAccountDao.getBy("accountID", smartUserAccountID);
        TradeAccount departmentTradeAccount =
                tradeAccountDao.getBy("accountID", departmentAccountID);
        smartUserTradeAccount
                .setAccountBalance(smartUserTradeAccount.getAccountBalance() - paymentAmount);
        smartUserTradeAccount
                .setAvailableBalance(smartUserTradeAccount.getAvailableBalance() - paymentAmount);

        departmentTradeAccount
                .setAccountBalance(departmentTradeAccount.getAccountBalance() + paymentAmount);
        departmentTradeAccount
                .setAvailableBalance(departmentTradeAccount.getAvailableBalance() + paymentAmount);

        tradeAccountDao.update(smartUserTradeAccount);
        tradeAccountDao.update(departmentTradeAccount);
    }


    @Override
    public JsonResult trade(String userID, String orderNO, long paymentAmount) {
        return trade(userID, "", "", orderNO, "", "", "", paymentAmount, paymentAmount, new Date(),
                RegistryUtil.get("trade.department.consume"), TradeType.CONSUME);
    }

}
