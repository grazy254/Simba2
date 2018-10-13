package com.simba.service.bean;

import com.simba.mobile.message.model.MsgType;

/**
 * Created by linshuo on 2017/12/6.
 */
public class EntryPlatform {
    /**
     * 对应平台真实的模板Id
     */
    private String templateId;
    /**
     * 短信平台
     */
    private MsgType platformType;

    public EntryPlatform(String templateId, MsgType platformType) {
        this.templateId = templateId;
        this.platformType = platformType;
    }

    public EntryPlatform() {
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public MsgType getPlatformType() {
        return platformType;
    }

    public void setPlatformType(MsgType platformType) {
        this.platformType = platformType;
    }

    @Override
    public String toString() {
        return "EntryPlatform{" +
                "templateId='" + templateId + '\'' +
                ", platformType=" + platformType +
                '}';
    }
}
