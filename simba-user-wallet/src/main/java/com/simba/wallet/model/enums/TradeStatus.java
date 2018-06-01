package com.simba.wallet.model.enums;

public enum TradeStatus {

    INPROCESS("INPROCESS", "正在处理"), FAILED("FAILED", "失败"), SUCCESS("SUCCESS",
            "成功"), OVERTIME("OVERTIME", "超时"), UNKNOWNSTATUS("UNKNOWNSTATUS", "未知");

    private String name;
    private String desc;

    private TradeStatus(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
