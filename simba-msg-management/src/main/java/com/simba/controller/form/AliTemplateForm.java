package com.simba.controller.form;

/**
 * Created by linshuo on 2017/12/13.
 */
public class AliTemplateForm {
    private String name;
    private String content;
    private String selfId;
    private int statusAli;
    private String aliTemplateId;

    public String getAliTemplateId() {
        return aliTemplateId;
    }

    public void setAliTemplateId(String aliTemplateId) {
        this.aliTemplateId = aliTemplateId;
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

    public String getSelfId() {
        return selfId;
    }

    public void setSelfId(String selfId) {
        this.selfId = selfId;
    }

    public int getStatusAli() {
        return statusAli;
    }

    public void setStatusAli(int statusAli) {
        this.statusAli = statusAli;
    }

    @Override
    public String toString() {
        return "AliTemplateForm{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", selfId='" + selfId + '\'' +
                ", statusAli=" + statusAli +
                ", aliTemplateId='" + aliTemplateId + '\'' +
                '}';
    }
}
