package com.simba.wallet.pay.recharge.service;

import java.util.Date;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.pay.RechargeInterface;

public class ConsumeRecharge implements RechargeInterface {

    private String userID;
    private String ip;
    private String location;
    private String orderNO;
    private String orderName;
    private String orderDesc;
    private String orderAddress;
    private long originalAmount;
    private long paymentAmount;
    private Date tradeCreateTime;


    public ConsumeRecharge() {

    }

    public ConsumeRecharge(String userID, String orderNO, long paymentAmount) {
        this.userID = userID;
        this.paymentAmount = paymentAmount;
        this.originalAmount = paymentAmount;
        this.orderNO = orderNO;

        this.ip = "";
        this.location = "";
        this.orderName = "";
        this.orderDesc = "";
        this.orderAddress = "";
        this.tradeCreateTime = new Date();
    }

    public ConsumeRecharge(String userID, String ip, String location, String orderNO,
            String orderName, String orderDesc, String orderAddress, long originalAmount,
            long paymentAmount, Date tradeCreateTime) {
        super();
        this.userID = userID;
        this.ip = ip;
        this.location = location;
        this.orderNO = orderNO;
        this.orderName = orderName;
        this.orderDesc = orderDesc;
        this.orderAddress = orderAddress;
        this.originalAmount = originalAmount;
        this.paymentAmount = paymentAmount;
        this.tradeCreateTime = tradeCreateTime;
    }



    @Override
    public JsonResult recharge() {

        return null;
    }

}
