package com.simba.model;
/***********************************************************************
 * Module:  AliPayEnterpriseBill.java
 * Author:  caozhejun
 * Purpose: Defines the Class AliPayEnterpriseBill
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import java.util.*;

/**
 * 支付宝企业支付账单
 * */
@DescAnnotation(desc = "支付宝企业支付账单")
public class AliPayEnterpriseBill {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 商户订单号
    * */
   @DescAnnotation(desc = "商户订单号")
	private String outBizNo;

   /**
    * 账户类型
    * */
   @DescAnnotation(desc = "账户类型")
	private String payType;

   /**
    * 收款方账户
    * */
   @DescAnnotation(desc = "收款方账户")
	private String account;

   /**
    * 转账金额
    * */
   @DescAnnotation(desc = "转账金额")
	private String amount;

   /**
    * 付款方姓名
    * */
   @DescAnnotation(desc = "付款方姓名")
	private String payerName;

   /**
    * 收款方真实姓名
    * */
   @DescAnnotation(desc = "收款方真实姓名")
	private String peyeeName;

   /**
    * 备注
    * */
   @DescAnnotation(desc = "备注")
	private String remark;

   /**
    * 支付宝转账单据号
    * */
   @DescAnnotation(desc = "支付宝转账单据号")
	private String orderId;

   /**
    * 支付时间
    * */
   @DescAnnotation(desc = "支付时间")
	private String payDate;

   /**
    * 时间
    * */
   @DescAnnotation(desc = "时间")
	private Date createTime;

   /**
    * 创建者
    * */
   @DescAnnotation(desc = "创建者")
	private String createUser;

   /**
    * 状态
    * */
   @DescAnnotation(desc = "状态")
	private String status;

   /**
    * 理由
    * */
   @DescAnnotation(desc = "理由")
	private String reason;

   /**
    * 预计收费金额
    * */
   @DescAnnotation(desc = "预计收费金额")
	private String orderFee;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPeyeeName() {
        return peyeeName;
    }

    public void setPeyeeName(String peyeeName) {
        this.peyeeName = peyeeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(String orderFee) {
        this.orderFee = orderFee;
    }

    @Override
    public String toString() {
        return "AliPayEnterpriseBill{" +
		"id=" + id +
		", outBizNo='" + outBizNo + '\'' + 
		", payType='" + payType + '\'' + 
		", account='" + account + '\'' + 
		", amount='" + amount + '\'' + 
		", payerName='" + payerName + '\'' + 
		", peyeeName='" + peyeeName + '\'' + 
		", remark='" + remark + '\'' + 
		", orderId='" + orderId + '\'' + 
		", payDate='" + payDate + '\'' + 
		", createTime=" + createTime + 
		", createUser='" + createUser + '\'' + 
		", status='" + status + '\'' + 
		", reason='" + reason + '\'' + 
		", orderFee='" + orderFee + '\'' + 
		'}';
    }

}