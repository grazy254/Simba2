package com.simba.model;
/***********************************************************************
 * Module:  NotifyUser.java
 * Author:  linshuo
 * Purpose: Defines the Class NotifyUser
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;

import java.util.Date;

/**
 * 通知表和用户表的关联
 */
@DescAnnotation(desc = "通知表和用户表的关联")
public class NotifyUser {
    private long id;

    /** */
    @DescAnnotation(desc = "通知Id")
    private long notifyId;

    /**
     * 用户id
     */
    @DescAnnotation(desc = "用户Id")
    private long smartUserId;

    /**
     * 0: 未读 1:已读
     */
    @DescAnnotation(desc = "0: 未读 1:已读")
    private int status;

    /**
     * 阅读时间
     */
    @DescAnnotation(desc = "阅读时间")
    private Date readTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(long notifyId) {
        this.notifyId = notifyId;
    }

    public long getSmartUserId() {
        return smartUserId;
    }

    public void setSmartUserId(long smartUserId) {
        this.smartUserId = smartUserId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    @Override
    public String toString() {
        return "NotifyUser{" +
                "id=" + id +
                ", notifyId=" + notifyId +
                ", smartUserId=" + smartUserId +
                ", status=" + status +
                ", readTime=" + readTime +
                '}';
    }

}