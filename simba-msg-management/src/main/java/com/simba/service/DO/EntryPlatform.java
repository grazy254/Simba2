package com.simba.service.DO;

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
    private MsgType plaformType;

    public EntryPlatform(String templateId, MsgType plaformType) {
        this.templateId = templateId;
        this.plaformType = plaformType;
    }

    public EntryPlatform() {
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public MsgType getPlaformType() {
        return plaformType;
    }

    public void setPlaformType(MsgType plaformType) {
        this.plaformType = plaformType;
    }

    @Override
    public String toString() {
        return "EntryPlatform{" +
                "templateId='" + templateId + '\'' +
                ", plaformType=" + plaformType +
                '}';
    }
}
