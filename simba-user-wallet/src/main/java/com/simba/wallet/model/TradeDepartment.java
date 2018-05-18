package com.simba.wallet.model;
/***********************************************************************
 * Module:  TradeDepartment.java
 * Author:  zhangfenghua
 * Purpose: Defines the Class TradeDepartment
 ***********************************************************************/

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
    * 收款部门
 * */
@DescAnnotation(desc = "收款部门")
public class TradeDepartment {
   /**
    * 
    * */
   @DescAnnotation(desc = "收款部门")
	private long id;

   /**
    * 部门编号
    * */
   @DescAnnotation(desc = "部门编号")
	private String deptNO;

   /**
    * 部门名称
    * */
   @DescAnnotation(desc = "部门名称")
	private String deptName;

   /** */
   @DescAnnotation(desc = "")
	private Date createTime;

   /** */
   @DescAnnotation(desc = "")
	private Date lastUpdateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeptNO() {
        return deptNO;
    }

    public void setDeptNO(String deptNO) {
        this.deptNO = deptNO;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
        return "TradeDepartment{" +
		"id=" + id +
		", deptNO='" + deptNO + '\'' + 
		", deptName='" + deptName + '\'' + 
		", createTime=" + createTime + 
		", lastUpdateTime=" + lastUpdateTime + 
		'}';
    }

}