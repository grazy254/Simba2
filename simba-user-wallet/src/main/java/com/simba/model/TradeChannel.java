package com.simba.model;
/***********************************************************************
 * Module:  TradeChannel.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeChannel
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import java.util.*;

/**
 * 交易的渠道信息
 * */
@DescAnnotation(desc = "交易的渠道信息")
public class TradeChannel {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 帐号ID
    * */
   @DescAnnotation(desc = "帐号ID")
	private String tradeAccountID;

   /**
    * 渠道名称：微信支付/支付宝支付
    * */
   @DescAnnotation(desc = "渠道名称：微信支付/支付宝支付")
	private String channelName;

   /**
    * 渠道类型：WXPAY/ALIPAY
    * */
   @DescAnnotation(desc = "渠道类型：WXPAY/ALIPAY")
	private String channelType;

   /**
    * 渠道提交时间
    * */
   @DescAnnotation(desc = "渠道提交时间")
	private Date orderCreateTime;

   /**
    * 渠道支付时间
    * */
   @DescAnnotation(desc = "渠道支付时间")
	private Date paymentTime;

   /**
    * 渠道订单号
    * */
   @DescAnnotation(desc = "渠道订单号")
	private String orderNO;

   /**
    * 用户的openID
    * */
   @DescAnnotation(desc = "用户的openID")
	private String openID;

   /**
    * 错误信息
    * */
   private String errorMsg = "";
   /**
    * 错误代号
    * */
   private String errorCode = "";
   /**
    * 创建时间
    * */
   @DescAnnotation(desc = "错误信息")
	private Date createTime;

   /**
    * 最后更新时间
    * */
   @DescAnnotation(desc = "错误代号")
	private Date lastUpdateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTradeAccountID() {
        return tradeAccountID;
    }

    public void setTradeAccountID(String tradeAccountID) {
        this.tradeAccountID = tradeAccountID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
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
    

    public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
    public String toString() {
        return "TradeChannel{" +
		"id=" + id +
		", tradeAccountID='" + tradeAccountID + '\'' + 
		", channelName='" + channelName + '\'' + 
		", channelType='" + channelType + '\'' + 
		", orderCreateTime=" + orderCreateTime + 
		", paymentTime=" + paymentTime + 
		", orderNO='" + orderNO + '\'' + 
		", openID='" + openID + '\'' + 
		", createTime=" + createTime + 
		", lastUpdateTime=" + lastUpdateTime + 
		'}';
    }

}