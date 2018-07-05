package com.simba.dao.impl.PO;

import java.util.Date;

/**
 * Created by linshuo on 2017/12/8.
 */
public class DayCount {
    private int countmsg;

    private Date date;

    public int getCountmsg() {
        return countmsg;
    }

    public void setCountmsg(int countmsg) {
        this.countmsg = countmsg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DayCount{" +
                "countmsg=" + countmsg +
                ", date=" + date +
                '}';
    }
}
