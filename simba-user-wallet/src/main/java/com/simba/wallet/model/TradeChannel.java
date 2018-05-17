package com.simba.wallet.model;
/***********************************************************************
 * Module:  TradeChannel.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeChannel
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import java.util.*;

/**
 * 渠道信息
 * */
@DescAnnotation(desc = "渠道信息")
public class TradeChannel {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 渠道名称：微信支付/支付宝支付
    * */
   @DescAnnotation(desc = "渠道名称：微信支付/支付宝支付")
	private String name;

   /**
    * 渠道类型：WXPAY/ALIPAY
    * */
   @DescAnnotation(desc = "渠道类型：WXPAY/ALIPAY")
	private String type;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "TradeChannel{" +
		"id=" + id +
		", name='" + name + '\'' + 
		", type='" + type + '\'' + 
		", createTime=" + createTime + 
		", lastUpdateTime=" + lastUpdateTime + 
		'}';
    }

}