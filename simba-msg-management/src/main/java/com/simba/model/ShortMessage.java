package com.simba.model;
/***********************************************************************
 * Module:  ShortMessage.java
 * Author:  linshuo
 * Purpose: Defines the Class ShortMessage
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 短信
 */
@DescAnnotation(desc = "短信")
public class ShortMessage {
    /**
     * ID
     */
    @DescAnnotation(desc = "ID")
    private long id;
    /**
     * 模板Id
     */
    @DescAnnotation(desc = "模板ID")
    private String templateId;
    /**
     * 模板中的值
     */
    @DescAnnotation(desc = "插值")
    private String value;
    /**
     * 手机号码
     */
    @DescAnnotation(desc = "手机号")
    private String mobile;
    /**
     * 发送时间
     */
    @DescAnnotation(desc = "发送时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate;
    /**
     * 来自项目
     */
    @DescAnnotation(desc = "来自项目")
    private int projectId;
    /**
     * 发送状态
     */
    @DescAnnotation(desc = "发送状态")
    private int status;
    /**
     * 发送的平台
     */
    @DescAnnotation(desc = "短信平台")
    private String platform;
    /**
     * 调用SMS发送接口返回的短信ID
     */
    @DescAnnotation(desc = "SMS短信ID")
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "ShortMessage{" +
                "id=" + id +
                ", templateId='" + templateId + '\'' +
                ", value='" + value + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sendDate=" + sendDate +
                ", projectId=" + projectId +
                ", status=" + status +
                ", platform='" + platform + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}