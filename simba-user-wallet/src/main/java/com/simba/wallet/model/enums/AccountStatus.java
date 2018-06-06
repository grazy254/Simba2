package com.simba.wallet.model.enums;

public enum AccountStatus {

    ACTIVE("已激活", 1),

    NOTACTIVE("未激活", 0),

    CLOSED("已注销", -1),

    FRONZEN("已冻结", 1),

    NOTFROZEN("未冻结", 0),

    NOTEXIST("未开通", -100);

    private String name;
    private int value;

    private AccountStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
