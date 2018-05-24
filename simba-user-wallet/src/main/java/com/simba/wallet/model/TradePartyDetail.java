package com.simba.wallet.model;
/***********************************************************************
 * Module:  TradePartyDetail.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradePartyDetail
 ***********************************************************************/

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 交易主体
 * */
@DescAnnotation(desc = "交易主体")
public class TradePartyDetail {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 支付用户ID
    * */
   @DescAnnotation(desc = "支付用户ID")
	private long tradeUserID;

   /**
    * 主体名称：买家姓名/部门名称
    * */
	@DescAnnotation(desc = "主体名称")
	private String partyName;

   /**
    * 主体类型：个人/公司部门
    * */
	@DescAnnotation(desc = "主体类型")
	private String partyType;

   /**
    * 账户ID
    * */
   @DescAnnotation(desc = "账户ID")
	private String tradeAccountID;

   /**
    * 交易的设备IP信息（对手主体可选填）
    * */
	@DescAnnotation(desc = "交易的设备IP信息")
   private String ip = "";
   /**
    * 用户的电话信息（对手主体可选填）
    * */
	@DescAnnotation(desc = "用户的电话信息")
   private String mobileNumber = "";
   /**
    * 手机的平台： IOS/Android（ 对手主体可选填）
    * */
   private String device = "";
   /**
    * 通知的邮箱
    * */
	private String noticeMail;

   /**
    * 当时的位置信息（对手主体可选填）
    * */
   private String location = "";
   /**
    * 创建时间
    * */
	@DescAnnotation(desc = "创建时间")
	private Date createTime;

	@DescAnnotation(desc = "创建日期")
	private Date createDate;

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

    public String getTradeAccountID() {
        return tradeAccountID;
    }

    public void setTradeAccountID(String tradeAccountID) {
        this.tradeAccountID = tradeAccountID;
    }

    public String getNoticeMail() {
        return noticeMail;
    }

    public void setNoticeMail(String noticeMail) {
        this.noticeMail = noticeMail;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
    public String toString() {
        return "TradePartyDetail{" +
		"id=" + id +
		", tradeUserID=" + tradeUserID + 
		", partyName='" + partyName + '\'' + 
		", partyType='" + partyType + '\'' + 
		", tradeAccountID='" + tradeAccountID + '\'' + 
		", noticeMail='" + noticeMail + '\'' + 
		", createTime=" + createTime + 
		'}';
    }

}