package com.simba.model;
/***********************************************************************
 * Module:  Blacklist.java
 * Author:  linshuo
 * Purpose: Defines the Class Blacklist
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 异常名单，暂时用于拉黑反复发短信的沙雕
 */
@DescAnnotation(desc = "黑名单")
public class MsgBlacklist {
    private int id;
    /**
     * 手机号
     */
    @DescAnnotation(desc = "手机号")
    private String mobile;

    @DescAnnotation(desc = "拉黑时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Blacklist{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}