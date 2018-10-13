package com.simba.controller.form;

/**
 * Created by linshuo on 2017/12/15.
 */
public class ShortMsgSearchForm {
    private String mobile;
    private String projectId;
    private String templateId;
    private String platform;
    private String status;
    private String startTime;
    private String endTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ShortMsgSearchForm{" +
                "mobile='" + mobile + '\'' +
                ", projectId='" + projectId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", platform='" + platform + '\'' +
                ", status=" + status +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
