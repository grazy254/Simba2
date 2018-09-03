package com.simba.wallet.model;
/***********************************************************************
 * Module: TradeAccount.java Author: zhangfenghua Purpose: Defines the Class TradeAccount
 ***********************************************************************/

import java.util.Date;
import com.simba.annotation.DescAnnotation;

/**
 * 支付账号
 */
@DescAnnotation(desc = "支付账号")
public class TradeAccount {
    /** */
    @DescAnnotation(desc = "")
    private long id;

    /**
     * 支付用户ID
     */
    @DescAnnotation(desc = "支付用户ID")
    private long tradeUserID;

    /**
     * 账号ID
     */
    @DescAnnotation(desc = "账号ID")
    private String accountID;

    /**
     * 账户类型：部门资产账户/个人账户/渠道账号
     */
    @DescAnnotation(desc = "账户类型：部门资产账户/个人账户/渠道账号")
    private String accountType;

    /**
     * 货币类型：人民币为CNY
     */
    private String feeType = "CNY";
    /**
     * 是否允许充值：0不允许，1允许
     */
    private int isAllowRecharge = 0;
    /**
     * 是否允许支付：0不允许，1允许
     */
    private int isAllowPay = 0;
    /**
     * 是否激活：0未激活，1激活
     */
    private int isActive = 0;
    /**
     * 是否冻结：0冻结，1未冻结
     */
    private int isFrozen = 1;
    /**
     * 账户当前余额
     */
    private long accountBalance = 0;
    /**
     * 账户当前可用余额
     */
    private long availableBalance = 0;
    /**
     * 账户当前冻结余额
     */
    private long frozenBalance = 0;
    
    /**
     * 奖励的虚拟金额
     */
    private long virtualBalance = 0;
    
    /**
     * 创建时间
     */
    @DescAnnotation(desc = "货币类型：人民币为CNY")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @DescAnnotation(desc = "是否允许充值：0不允许，1允许")
    private Date lastUpdateTime;


    
    public long getVirtualBalance() {
		return virtualBalance;
	}

	public void setVirtualBalance(long virtualBalance) {
		this.virtualBalance = virtualBalance;
	}

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


    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getIsAllowRecharge() {
        return isAllowRecharge;
    }

    public void setIsAllowRecharge(int isAllowRecharge) {
        this.isAllowRecharge = isAllowRecharge;
    }

    public int getIsAllowPay() {
        return isAllowPay;
    }

    public void setIsAllowPay(int isAllowPay) {
        this.isAllowPay = isAllowPay;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(int isFrozen) {
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

	@Override
	public String toString() {
		return "TradeAccount [id=" + id + ", tradeUserID=" + tradeUserID + ", accountID=" + accountID + ", accountType=" + accountType + ", feeType=" + feeType + ", isAllowRecharge=" + isAllowRecharge
				+ ", isAllowPay=" + isAllowPay + ", isActive=" + isActive + ", isFrozen=" + isFrozen + ", accountBalance=" + accountBalance + ", availableBalance=" + availableBalance
				+ ", frozenBalance=" + frozenBalance + ", virtualBalance=" + virtualBalance + ", createTime=" + createTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}





}
