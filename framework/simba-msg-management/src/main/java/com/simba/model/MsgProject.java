package com.simba.model;
/***********************************************************************
 * Module:  Project.java
 * Author:  linshuo
 * Purpose: Defines the Class Project
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;

/**
 * 项目
 */
@DescAnnotation(desc = "项目")
public class MsgProject {
    public int id;
    /**
     * 项目名称
     */
    @DescAnnotation(desc = "项目名称")
    private String name;

    @DescAnnotation(desc = "ProjectKey")
    private String projectKey;

    @DescAnnotation(desc = "IP地址")
    private String ip;
    /**
     * 报警阈值
     */
    @DescAnnotation(desc = "报警阈值")
    private float threshold;
    /**
     * 每天短信数量限制
     */
    @DescAnnotation(desc = "短信上限")
    private int limitNum;
    /**
     * 邮箱提醒
     */
    @DescAnnotation(desc = "邮箱")
    private String email;
    /**
     * 短信提醒
     */
    @DescAnnotation(desc = "手机号")
    private String mobile;

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

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public float getThreshold() {
        return threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectKey='" + projectKey + '\'' +
                ", ip='" + ip + '\'' +
                ", threshold=" + threshold +
                ", limitNum=" + limitNum +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}