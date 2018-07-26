package com.simba.arg;

import java.util.Map;

public class ShortMsgArg {
    private String selfTemplateId;
    private Map<String, String> params;

    public String getSelfTemplateId() {
        return selfTemplateId;
    }

    public void setSelfTemplateId(String selfTemplateId) {
        this.selfTemplateId = selfTemplateId;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}