package com.simba.model;

/**
 * Created by linshuo on 2017/12/20.
 */
public class TotalDayAmountBean {
    private int total;
    private String dayDate;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    @Override
    public String toString() {
        return "TotalDayAmountBean{" +
                "total=" + total +
                ", dayDate='" + dayDate + '\'' +
                '}';
    }
}
