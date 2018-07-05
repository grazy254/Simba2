package com.simba.model;
/***********************************************************************
 * Module:  Notify.java
 * Author:  linshuo
 * Purpose: Defines the Class Notify
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;

import java.util.Date;

/**
 * 通知表
 */
@DescAnnotation(desc = "通知表")
public class Notify {
    private long id;

    /**
     * 通知标题
     */
    @DescAnnotation(desc = "通知标题")
    private String title;

    /**
     * 通知内容
     */
    @DescAnnotation(desc = "通知内容")
    private String content;

    /**
     * 0: 紧急通知 1:普通通知
     */
    @DescAnnotation(desc = "0: 紧急通知 1:普通通知")
    private int type;

    /**
     * 创建时间
     */
    @DescAnnotation(desc = "创建时间")
    private Date createTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }

}