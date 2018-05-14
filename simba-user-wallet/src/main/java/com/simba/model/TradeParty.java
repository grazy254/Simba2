package com.simba.model;
/***********************************************************************
 * Module:  TradeParty.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeParty
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import java.util.*;

/**
 * 交易主体
 * */
@DescAnnotation(desc = "交易主体")
public class TradeParty {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * TradeUser的逻辑外键
    * */
   @DescAnnotation(desc = "TradeUser的逻辑外键")
	private long tradeUserID;

   /**
    * 主体名称：买家姓名/部门名称
    * */
   @DescAnnotation(desc = "主体名称：买家姓名/部门名称")
	private String partyName;

   /**
    * 主体类型：个人/公司部门
    * */
   @DescAnnotation(desc = "主体类型：个人/公司部门")
	private String partyType;

   /**
    * TradeAccount表的逻辑外键
    * */
   @DescAnnotation(desc = "TradeAccount表的逻辑外键")
	private long tradeAccountID;

   /**
    * 交易的设备IP信息（对手主体可选填）
    * */
   @DescAnnotation(desc = "交易的设备IP信息（对手主体可选填）")
	private String ip;

   /**
    * 用户的电话信息（对手主体可选填）
    * */
   @DescAnnotation(desc = "用户的电话信息（对手主体可选填）")
	private String mobileNumber;

   /**
    * 手机的平台： IOS/Android（ 对手主体可选填）
    * */
   @DescAnnotation(desc = "手机的平台： IOS/Android（ 对手主体可选填）")
	private String device;

   /**
    * 通知的邮箱
    * */
   @DescAnnotation(desc = "通知的邮箱")
	private String noticeMail;

   /**
    * 当时的位置信息（对手主体可选填）
    * */
   @DescAnnotation(desc = "当时的位置信息（对手主体可选填）")
	private String location;

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

    public long getTradeUserID() {
        return tradeUserID;
    }

    public void setTradeUserID(long tradeUserID) {
        this.tradeUserID = tradeUserID;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public long getTradeAccountID() {
        return tradeAccountID;
    }

    public void setTradeAccountID(long tradeAccountID) {
        this.tradeAccountID = tradeAccountID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getNoticeMail() {
        return noticeMail;
    }

    public void setNoticeMail(String noticeMail) {
        this.noticeMail = noticeMail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TradeParty{" +
		"id=" + id +
		", tradeUserID=" + tradeUserID + 
		", partyName='" + partyName + '\'' + 
		", partyType='" + partyType + '\'' + 
		", tradeAccountID=" + tradeAccountID + 
		", ip='" + ip + '\'' + 
		", mobileNumber='" + mobileNumber + '\'' + 
		", device='" + device + '\'' + 
		", noticeMail='" + noticeMail + '\'' + 
		", location='" + location + '\'' + 
		", createTime=" + createTime + 
		'}';
    }

}