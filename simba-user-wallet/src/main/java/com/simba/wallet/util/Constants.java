package com.simba.wallet.util;

public class Constants {
    public static enum AccountActiveStatus {

        ACTIVE("已激活", 1), NOTACTIVE("未激活", 0), CLOSED("已注销", -1);

        private String name;
        private int value;

        private AccountActiveStatus(String name, int value) {
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
    public static enum AccountFrozenStatus {
        FROZEN("已冻结", 1), NOTFROZEN("未冻结", 0);

        private String name;
        private int value;

        private AccountFrozenStatus(String name, int value) {
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

    public static enum TradePayment {
        ALLOWPAY("可支付", 1), NOTALLOWPAY("不可支付", 0);
        private String name;
        private int value;

        private TradePayment(String name, int value) {
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
    public static enum TradeRechargement {
        ALLOWRECHARGE("可充值", 1), NOTALLOWRECHARGE("不可充值", 0);
        private String name;
        private int value;

        private TradeRechargement(String name, int value) {
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

    public static enum AccountType {

        PERSIONAL_ACCOUNT("PE", "个人账号"),

        COMPANY_ACCOUNT("CO", "公司账号"),

        CHANNEL_ACCOUNT("CH", "渠道账号");

        private String shortName;
        private String value;

        private AccountType(String shortName, String value) {
            this.shortName = shortName;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public String getShortName() {
            return shortName;
        }

    }


    public static enum ChannelType {

        WXPAY("WXPAY", "01"),

        ALIPAY("ALIPAY", "02");

        private String name;
        private String value;

        private ChannelType(String name, String value) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    public static enum FeeType {
        CNY;
    }

    public static enum TradeStatus {

        INPROCESS("INPROCESS", "正在处理"),

        FAILED("FAILED", "失败"),

        SUCCESS("SUCCESS", "成功"),

        OVERTIME("OVERTIME", "超时"),

        UNKNOWNSTATUS("UNKNOWNSTATUS", "未知");

        private String name;
        private String value;

        private TradeStatus(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

    }

    public static enum TradeType {

        RECHARGE("RECHARGE", "充值"), CONSUME("CONSUME", "消费"), REFUND("REFUND",
                "退款"), REWARD("REWARD", "奖励");

        private String name;
        private String value;

        private TradeType(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

    }


    public static enum TradeUserType {

        PERSION("PERSON", "PE", "大众用户"), CHANNEL("CHANNEL", "CH", "渠道用户"), DEPARTMENT("DEPARTMENT",
                "DEPT", "部门用户");

        private String name;
        private String shortName;
        private String value;


        private TradeUserType(String name, String shortName, String value) {
            this.name = name;
            this.shortName = shortName;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getShortName() {
            return shortName;
        }

        public String getValue() {
            return value;
        }
    }

}
