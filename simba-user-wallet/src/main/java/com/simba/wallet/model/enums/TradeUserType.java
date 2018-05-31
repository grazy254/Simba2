package com.simba.wallet.model.enums;

public enum TradeUserType {

    PERSION("PERSON", "PE"), CHANNEL("CHANNEL", "CH"), DEPARTMENT("DEPARTMENT", "DEPT");

    private String name;
    private String shortName;


    private TradeUserType(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }
}
