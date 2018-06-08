package com.simba.wallet.model.form;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.simba.annotation.DBFieldAnnotation;

public class TradeDetailSearchForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DBFieldAnnotation(desc = "开始日期", field = "tradePaymentDate", oper = ">=")
    private Date startDate;

    @DBFieldAnnotation(desc = "结束日期", field = "tradePaymentDate", oper = "<")
    private Date endDate;

    @DBFieldAnnotation(desc = "订单号")
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

    public Long getTradeUserID() {
        return tradeUserID;
    }

    public void setTradeUserID(Long tradeUserID) {
        this.tradeUserID = tradeUserID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
