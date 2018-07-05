package com.simba.controller.form;

/**
 * Created by linshuo on 2017/12/13.
 */
public class JpushTemplateForm {
    private String name;
    private String content;
    private String selfId;

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

    @Override
    public String toString() {
        return "JpushTemplateForm{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", selfId='" + selfId + '\'' +
                '}';
    }
}
