package com.simba.wallet.model;
/***********************************************************************
 * Module:  TradeBalanceDetail.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeBalanceDetail
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import java.util.*;

/** */
@DescAnnotation(desc = "")
public class TradeBalanceDetail {
	/** */
	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 交易订单流水号
	 */
	@DescAnnotation(desc = "交易订单流水号")
	private long tradeNo;

	/**
	 * 余额类型 1：真实充值余额 2：虚拟余额
	 */
	@DescAnnotation(desc = "余额类型 1：真实充值余额 2：虚拟余额")
	private int balanceType;

	private long balanceAmount;

	/** */
	@DescAnnotation(desc = "")
	private Date createTime;

	/** */
	@DescAnnotation(desc = "")
	private Date updateTime;

	public long getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(long tradeNo) {
		this.tradeNo = tradeNo;
	}

	public int getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(int balanceType) {
		this.balanceType = balanceType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TradeBalanceDetail{" + "id=" + id + ", tradeNo=" + tradeNo + ", balanceType=" + balanceType + ", createTime=" + createTime + ", updateTime=" + updateTime + '}';
	}

}