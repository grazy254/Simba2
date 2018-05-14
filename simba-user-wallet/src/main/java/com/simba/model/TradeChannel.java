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
    * TradeAccount的逻辑外键
    * */
   @DescAnnotation(desc = "TradeAccount的逻辑外键")
	private long tradeAccountID;

   /**
    * 渠道名称：微信/支付宝
    * */
   @DescAnnotation(desc = "渠道名称：微信/支付宝")
	private String channelName;

   /**
    * 渠道类型：WX/ALIPAY
    * */
   @DescAnnotation(desc = "渠道类型：WX/ALIPAY")
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
   @DescAnnotation(desc = "错误信息")
	private String errorMsg;

   /**
    * 错误代号
    * */
   @DescAnnotation(desc = "错误代号")
	private String errorCode;

   /**
    * 创建时间
    * */
   @DescAnnotation(desc = "创建时间")
	private Date createTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTradeAccountID() {
        return tradeAccountID;
    }

    public void setTradeAccountID(long tradeAccountID) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TradeChannel{" +
		"id=" + id +
		", tradeAccountID=" + tradeAccountID + 
		", channelName='" + channelName + '\'' + 
		", channelType='" + channelType + '\'' + 
		", orderCreateTime=" + orderCreateTime + 
		", paymentTime=" + paymentTime + 
		", orderNO='" + orderNO + '\'' + 
		", openID='" + openID + '\'' + 
		", errorMsg='" + errorMsg + '\'' + 
		", errorCode='" + errorCode + '\'' + 
		", createTime=" + createTime + 
		'}';
    }

}