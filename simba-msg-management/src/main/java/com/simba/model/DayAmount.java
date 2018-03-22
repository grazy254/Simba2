package com.simba.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by linshuo on 2017/12/18.
 *
 * 记录每个项目每天发送的短信数量
 */
public class DayAmount {
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayDate;

    /**
     * 发送数量
     */
    private int amount;

    private int projectId;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DayAmount{" +
                "id=" + id +
                ", dayDate=" + dayDate +
                ", amount=" + amount +
                ", projectId=" + projectId +
                '}';
    }
}
