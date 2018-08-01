package com.simba.model;
/***********************************************************************
 * Module:  Template.java
 * Author:  linshuo
 * Purpose: Defines the Class Template
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 模板
 */
@DescAnnotation(desc = "短信模板")
public class MsgTemplate {
    @DescAnnotation(desc = "ID")
    private int id;
    /**
     * 模板名称
     */
    @DescAnnotation(desc = "模板名称")
    private String name;
    /**
     * 模板内容
     */
    @DescAnnotation(desc = "模板内容")
    private String content;
    /**
     * 模板创建时间
     */
    @DescAnnotation(desc = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 审核状态: 0未通过 1通过 2审核中 3无
     */
    @DescAnnotation(desc = "阿里审核状态")
    private int statusAli;

    @DescAnnotation(desc = "极光审核状态")
    private int statusJpush;

    @DescAnnotation(desc = "阿里模板ID")
    private String aliTemplateId;

    @DescAnnotation(desc = "极光模板ID")
    private String jpushTemplateId;

    @DescAnnotation(desc = "自定ID")
    private String selfId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatusAli() {
        return statusAli;
    }

    public void setStatusAli(int statusAli) {
        this.statusAli = statusAli;
    }

    public int getStatusJpush() {
        return statusJpush;
    }

    public void setStatusJpush(int statusJpush) {
        this.statusJpush = statusJpush;
    }

    public String getAliTemplateId() {
        return aliTemplateId;
    }

    public void setAliTemplateId(String aliTemplateId) {
        this.aliTemplateId = aliTemplateId;
    }

    public String getJpushTemplateId() {
        return jpushTemplateId;
    }

    public void setJpushTemplateId(String jpushTemplateId) {
        this.jpushTemplateId = jpushTemplateId;
    }

    public String getSelfId() {
        return selfId;
    }

    public void setSelfId(String selfId) {
        this.selfId = selfId;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", statusAli=" + statusAli +
                ", statusJpush=" + statusJpush +
                ", aliTemplateId='" + aliTemplateId + '\'' +
                ", jpushTemplateId='" + jpushTemplateId + '\'' +
                ", selfId='" + selfId + '\'' +
                '}';
    }
}