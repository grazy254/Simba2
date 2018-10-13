package com.simba.controller.vo;

/**
 * Created by linshuo on 2017/12/11.
 */
public class BalanceVo {
    private String platform;
    private int balance;

    public BalanceVo(String platform, int balance) {
        this.platform = platform;
        this.balance = balance;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BalanceVo{" +
                "platform='" + platform + '\'' +
                ", balance=" + balance +
                '}';
    }

}
