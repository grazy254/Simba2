package com.simba.wallet.model;
/***********************************************************************
 * Module:  TradeDetail.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeDetail
 ***********************************************************************/

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 交易详情信息
 * */
@DescAnnotation(desc = "交易详情信息")
public class TradeDetail {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 交易流水号
    * */
   @DescAnnotation(desc = "交易流水号")
	private String tradeNO;

   /**
    * 记录交易类型：充值/消费
    * */
   @DescAnnotation(desc = "记录交易类型：充值/消费")
	private String tradeType;

   /**
    * 记录支付状态 SUCCESS/FAILED/FROZON
    * */
   @DescAnnotation(desc = "记录支付状态 SUCCESS/FAILED/FROZON")
	private String tradeStatus;

   /**
    * 订单号
    * */
   @DescAnnotation(desc = "订单号")
	private String orderNO;

   /**
    * 订单名称
    * */
   @DescAnnotation(desc = "订单名称")
	private String orderName;

   /**
    * 订单描述
    * */
	@DescAnnotation(desc = "订单描述")
   private String orderDesc = "";
   /**
    * 订单地址
    * */
	@DescAnnotation(desc = "订单地址")
   private String orderAddress = "";
   /**
    * 货币类型
    * */
	@DescAnnotation(desc = "货币类型")
   private String feeType = "CNY";
   /**
    * 原始费用
    * */
	@DescAnnotation(desc = "原始费用")
   private long originalAmount = 0;
   /**
    * 实际费用
    * */
	@DescAnnotation(desc = "实际费用")
   private long paymentAmount = 0;
   /**
    * 交易主体ID
    * */
	@DescAnnotation(desc = "主交易方")
	private long tradePartyID;

   /**
    * 交易对手ID
    * */
	@DescAnnotation(desc = "对手交易方")
	private long tradeCounterpartyID;

   /**
    * 交易渠道ID
    * */
	@DescAnnotation(desc = "交易渠道")
	private long tradeChannelID;

   /**
    * 请求支付时间
    * */
	@DescAnnotation(desc = "请求支付时间")
	private Date tradeCreateTime;

   /**
    * 支付创建时间
    * */
	@DescAnnotation(desc = "支付创建时间")
	private Date tradePaymentTime;

   /**
    * 创建时间
    * */
	@DescAnnotation(desc = "创建时间")
	private Date createTime;

   /**
    * 最后更新时间
    * */
	@DescAnnotation(desc = "最后更新时间")
	private Date lastUpdateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTradeNO() {
        return tradeNO;
    }

    public void setTradeNO(String tradeNO) {
        this.tradeNO = tradeNO;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public long getTradePartyID() {
        return tradePartyID;
    }

    public void setTradePartyID(long tradePartyID) {
        this.tradePartyID = tradePartyID;
    }

    public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public long getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(long originalAmount) {
		this.originalAmount = originalAmount;
	}

	public long getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public long getTradeCounterpartyID() {
        return tradeCounterpartyID;
    }

    public void setTradeCounterpartyID(long tradeCounterpartyID) {
        this.tradeCounterpartyID = tradeCounterpartyID;
    }

    public long getTradeChannelID() {
        return tradeChannelID;
    }

    public void setTradeChannelID(long tradeChannelID) {
        this.tradeChannelID = tradeChannelID;
    }

    public Date getTradeCreateTime() {
        return tradeCreateTime;
    }

    public void setTradeCreateTime(Date tradeCreateTime) {
        this.tradeCreateTime = tradeCreateTime;
    }

    public Date getTradePaymentTime() {
        return tradePaymentTime;
    }

    public void setTradePaymentTime(Date tradePaymentTime) {
        this.tradePaymentTime = tradePaymentTime;
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
        return "TradeDetail{" +
		"id=" + id +
		", tradeNO='" + tradeNO + '\'' + 
		", tradeType='" + tradeType + '\'' + 
		", tradeStatus='" + tradeStatus + '\'' + 
		", orderNO='" + orderNO + '\'' + 
		", orderName='" + orderName + '\'' + 
		", tradePartyID=" + tradePartyID + 
		", tradeCounterpartyID=" + tradeCounterpartyID + 
		", tradeChannelID=" + tradeChannelID + 
		", tradeCreateTime=" + tradeCreateTime + 
		", tradePaymentTime=" + tradePaymentTime + 
		", createTime=" + createTime + 
		", lastUpdateTime=" + lastUpdateTime + 
		'}';
    }

}