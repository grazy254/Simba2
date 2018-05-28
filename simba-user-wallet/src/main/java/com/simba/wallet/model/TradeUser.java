package com.simba.wallet.model;
/***********************************************************************
 * Module: TradeUser.java Author: zhangfenghua Purpose: Defines the Class TradeUser
 ***********************************************************************/

import java.io.Serializable;
import java.util.Date;
import com.simba.annotation.DescAnnotation;

/**
 * 钱包用户信息
 */
@DescAnnotation(desc = "钱包用户信息")
public class TradeUser implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** */
    @DescAnnotation(desc = "")
    private long id;

    /**
     * 用户ID/部门ID
     */
    @DescAnnotation(desc = "用户ID/部门ID")
    private String userID;

    /**
     * 用户/部门名称
     */
    @DescAnnotation(desc = "用户/部门名称")
    private String name;

    /**
     * 用户类型 PERSON/CHANNEL/DEPARTMENT
     */
    private String type;
    /**
     * 是否允许支付：0不允许，1允许
     */
    @DescAnnotation(desc = "是否允许支付：0不允许，1允许")
    private int isAllowPay;

    private int isActive;

    /**
     * 支付密码
     */
    @DescAnnotation(desc = "支付密码")
    private String payPassword;

    /**
     * 支付手机
     */
    @DescAnnotation(desc = "支付手机")
    private String payPhone;

    /**
     * 支付邮箱
     */
    @DescAnnotation(desc = "支付邮箱")
    private String payEmail;

    /**
     * 创建时间
     */
    @DescAnnotation(desc = "创建时间")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @DescAnnotation(desc = "最后更新时间")
    private Date lastUpdateTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsAllowPay() {
        return isAllowPay;
    }

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

    public int activate() {
        return isAllowPay;
    }

    public void setIsAllowPay(int isAllowPay) {
        this.isAllowPay = isAllowPay;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
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
        return "TradeUser{" + "id=" + id + ", userID='" + userID + '\'' + ", name='" + name + '\''
                + ", isAllowPay=" + isAllowPay + ", payPassword='" + payPassword + '\''
                + ", payPhone='" + payPhone + '\'' + ", payEmail='" + payEmail + '\''
                + ", createTime=" + createTime + ", lastUpdateTime=" + lastUpdateTime + '}';
    }

}
