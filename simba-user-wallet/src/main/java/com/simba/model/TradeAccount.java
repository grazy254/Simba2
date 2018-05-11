package com.simba.model;
/***********************************************************************
 * Module:  TradeAccount.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeAccount
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import java.util.*;

/**
 * 支付账号
 * */
@DescAnnotation(desc = "支付账号")
public class TradeAccount {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * TradeUser的逻辑外键
    * */
   @DescAnnotation(desc = "TradeUser的逻辑外键")
	private long tradeUserID;

   /**
    * 账号ID
    * */
   @DescAnnotation(desc = "账号ID")
	private String accountID;

   /**
    * 账户类型 部门资产账户/个人账户/渠道账号
    * */
   @DescAnnotation(desc = "账户类型 部门资产账户/个人账户/渠道账号")
	private String accountType;

   /**
    * 货币类型：人民币为CNY
    * */
   @DescAnnotation(desc = "货币类型：人民币为CNY")
	private String feeType;

   /**
    * 是否允许充值：0不允许，1允许
    * */
   @DescAnnotation(desc = "是否允许充值：0不允许，1允许")
	private byte isAllowRecharge;

   /**
    * 是否允许支付：0不允许，1允许
    * */
   @DescAnnotation(desc = "是否允许支付：0不允许，1允许")
	private byte isAllowPay;

   /**
    * 是否激活：0不允许，1允许
    * */
   @DescAnnotation(desc = "是否激活：0不允许，1允许")
	private byte isActive;

   /**
    * 是否冻结：0不允许，1允许
    * */
   @DescAnnotation(desc = "是否冻结：0不允许，1允许")
	private byte isFrozen;

   /**
    * 账户当前余额
    * */
   @DescAnnotation(desc = "账户当前余额")
	private long accountBalance;

   /**
    * 账户当前可用余额
    * */
   @DescAnnotation(desc = "账户当前可用余额")
	private long availableBalance;

   /**
    * 账户当前冻结余额
    * */
   @DescAnnotation(desc = "账户当前冻结余额")
	private long frozenBalance;

   /**
    * 创建时间
    * */
   @DescAnnotation(desc = "创建时间")
	private Date createTime;

   /**
    * 最后修改时间
    * */
   @DescAnnotation(desc = "最后修改时间")
	private Date lastUpdateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTradeUserID() {
        return tradeUserID;
    }

    public void setTradeUserID(long tradeUserID) {
        this.tradeUserID = tradeUserID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public byte getIsAllowRecharge() {
        return isAllowRecharge;
    }

    public void setIsAllowRecharge(byte isAllowRecharge) {
        this.isAllowRecharge = isAllowRecharge;
    }

    public byte getIsAllowPay() {
        return isAllowPay;
    }

    public void setIsAllowPay(byte isAllowPay) {
        this.isAllowPay = isAllowPay;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    public byte getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(byte isFrozen) {
        this.isFrozen = isFrozen;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public long getFrozenBalance() {
        return frozenBalance;
    }

    public void setFrozenBalance(long frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "TradeAccount{" +
		"id=" + id +
		", tradeUserID=" + tradeUserID + 
		", accountID='" + accountID + '\'' + 
		", accountType='" + accountType + '\'' + 
		", feeType='" + feeType + '\'' + 
		", isAllowRecharge=" + isAllowRecharge + 
		", isAllowPay=" + isAllowPay + 
		", isActive=" + isActive + 
		", isFrozen=" + isFrozen + 
		", accountBalance=" + accountBalance + 
		", availableBalance=" + availableBalance + 
		", frozenBalance=" + frozenBalance + 
		", createTime=" + createTime + 
		", lastUpdateTime=" + lastUpdateTime + 
		'}';
    }

}