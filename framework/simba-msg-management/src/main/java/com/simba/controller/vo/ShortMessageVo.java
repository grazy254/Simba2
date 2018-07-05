package com.simba.controller.vo;

import java.util.Date;

/**
 * Created by linshuo on 2017/12/15.
 */
public class ShortMessageVo {
    private long id;
    private String templateId;
    private String value;
    private String mobile;
    private Date sendDate;
    private String projectName;
    private String status;
    private String platform;
    private String messageId;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "ShortMessageVo{" +
                "id=" + id +
                ", templateId='" + templateId + '\'' +
                ", value='" + value + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sendDate=" + sendDate +
                ", projectName='" + projectName + '\'' +
                ", status='" + status + '\'' +
                ", platform='" + platform + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}
