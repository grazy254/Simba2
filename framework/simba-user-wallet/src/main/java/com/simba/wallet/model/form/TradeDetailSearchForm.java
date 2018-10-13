package com.simba.wallet.model.form;

import com.simba.annotation.DBFieldAnnotation;

public class TradeDetailSearchForm {

    @DBFieldAnnotation(desc = "开始日期", field = "tradePaymentTime", oper = ">=")
    private String startTime;

    @DBFieldAnnotation(desc = "结束日期", field = "tradePaymentTime", oper = "<")
    private String endTime;

    @DBFieldAnnotation(desc = "交易流水号")
    private String tradeNO;

    @DBFieldAnnotation(desc = "交易类型")
    private String tradeType;

    @DBFieldAnnotation(desc = "交易状态")
    private String tradeStatus;

    @DBFieldAnnotation(desc = "用户账号")
    private String userID;

    private Long tradeUserID;
    private String tradeUserType;


    public String getTradeUserType() {
        return tradeUserType;
    }

    public void setTradeUserType(String tradeUserType) {
        this.tradeUserType = tradeUserType;
    }


    public void setTradeUserID(Long tradeUserID) {
        this.tradeUserID = tradeUserID;
    }

    public Long getTradeUserID() {
        return tradeUserID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getTradeNO() {
        return tradeNO;
    }

    public void setTradeNO(String tradeNO) {
        this.tradeNO = tradeNO;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }


}
