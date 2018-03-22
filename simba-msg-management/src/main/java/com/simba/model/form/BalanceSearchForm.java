package com.simba.model.form;

/**
 * Created by linshuo on 2017/12/15.
 */
public class BalanceSearchForm {
    private String projectName;
    private String interval;
    private String startTime;
    private String endTime;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
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
        return "BalanceSearchForm{" +
                "projectName='" + projectName + '\'' +
                ", interval='" + interval + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
