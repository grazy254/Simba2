package com.simba.wallet.model.vo;

public class TradeDetailVO {
    private String tradeType;
    private String tradePaymentTime;
    private String tradeCreateTime;
    private String tradeStatus;
    private String tradeNO;
    private String orderNO;
    private String feeType;
    private String originalAmount;
    private String paymentAmount;
    private String tradePartyName;
    private String tradeCounterpartyName;
    private String channelName;
    private String createTime;
    private String lastUpdateTime;


    public String getTradeCreateTime() {
        return tradeCreateTime;
    }

    public void setTradeCreateTime(String tradeCreateTime) {
        this.tradeCreateTime = tradeCreateTime;
    }

    public String getTradeNO() {
        return tradeNO;
    }

    public void setTradeNO(String tradeNO) {
        this.tradeNO = tradeNO;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getTradePartyName() {
        return tradePartyName;
    }

    public void setTradePartyName(String tradePartyName) {
        this.tradePartyName = tradePartyName;
    }

    public String getTradeCounterpartyName() {
        return tradeCounterpartyName;
    }

    public void setTradeCounterpartyName(String tradeCounterpartyName) {
        this.tradeCounterpartyName = tradeCounterpartyName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradePaymentTime() {
        return tradePaymentTime;
    }

    public void setTradePaymentTime(String tradePaymentTime) {
        this.tradePaymentTime = tradePaymentTime;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }


}
