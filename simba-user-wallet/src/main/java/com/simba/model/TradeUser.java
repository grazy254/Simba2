package com.simba.model;
/***********************************************************************
 * Module:  TradeUser.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeUser
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import java.util.*;

/**
 * 钱包用户信息
 * */
@DescAnnotation(desc = "钱包用户信息")
public class TradeUser {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 用户的ID/系统用户的ID
    * */
   @DescAnnotation(desc = "用户的ID/系统用户的ID")
	private String userID;

   /**
    * 用户名称
    * */
   @DescAnnotation(desc = "用户名称")
	private String name;

   /**
    * 是否允许支付：0不允许，1允许
    * */
   @DescAnnotation(desc = "是否允许支付：0不允许，1允许")
	private byte isAllowPay;

   /**
    * 支付密码 
    * */
   @DescAnnotation(desc = "支付密码")
	private String payPassword;

   /**
    * 支付手机
    * */
   @DescAnnotation(desc = "支付手机")
	private String payPhone;

   /**
    * 支付邮箱
    * */
   @DescAnnotation(desc = "支付邮箱")
	private String payEmail;

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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getIsAllowPay() {
        return isAllowPay;
    }

    public void setIsAllowPay(byte isAllowPay) {
        this.isAllowPay = isAllowPay;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getPayPhone() {
        return payPhone;
    }

    public void setPayPhone(String payPhone) {
        this.payPhone = payPhone;
    }

    public String getPayEmail() {
        return payEmail;
    }

    public void setPayEmail(String payEmail) {
        this.payEmail = payEmail;
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
        return "TradeUser{" +
		"id=" + id +
		", userID='" + userID + '\'' + 
		", name='" + name + '\'' + 
		", isAllowPay=" + isAllowPay + 
		", payPassword='" + payPassword + '\'' + 
		", payPhone='" + payPhone + '\'' + 
		", payEmail='" + payEmail + '\'' + 
		", createTime=" + createTime + 
		", lastUpdateTime=" + lastUpdateTime + 
		'}';
    }

}