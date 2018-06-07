package com.simba.wallet.model.vo;

import com.simba.framework.util.date.DateUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.util.CommonUtil;

public class TradeAccountVO {
    private String userID;
    private String accountID;
    private String isAllowPay;
    private String accountStatus;
    private String accountBalance;
    private String availableBalance;
    private String frozenBalance;
    private String createTime;
    private String lastUpdateTime;

    public TradeAccountVO(TradeAccount tradeAccount, TradeUser tradeUser) {
        this.setAccountID(tradeAccount.getAccountID());
        this.setCreateTime(DateUtil.date2String(tradeAccount.getCreateTime()));
        this.setLastUpdateTime(DateUtil.date2String(tradeAccount.getLastUpdateTime()));
        this.setAccountBalance(CommonUtil.transToCNYType(tradeAccount.getAccountBalance()));
        this.setAvailableBalance(CommonUtil.transToCNYType(tradeAccount.getAvailableBalance()));
        this.setFrozenBalance(CommonUtil.transToCNYType(tradeAccount.getFrozenBalance()));
        this.setAccountStatus(CommonUtil.getAccountStatus(tradeAccount));
        this.setUserID(tradeUser.getUserID());
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getIsAllowPay() {
        return isAllowPay;
    }

    public void setIsAllowPay(String isAllowPay) {
        this.isAllowPay = isAllowPay;
    }


    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }


    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(String frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

}
