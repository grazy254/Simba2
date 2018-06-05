package com.simba.wallet.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.simba.exception.BussException;
import com.simba.framework.util.common.UUIDUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.enums.AccountStatus;
import com.simba.wallet.model.enums.AccountType;
import com.simba.wallet.model.enums.ChannelType;
import com.simba.wallet.model.enums.TradeStatus;
import com.simba.wallet.model.enums.TradeType;
import com.simba.wallet.model.enums.TradeUserType;

public class FmtUtil {
    public static String transToCNYType(Long amount) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        return fmt.format(amount * 1.0 / 100) + "元";
    }

    public static String fmtTradeType(String tradeType) {
        if (TradeType.CONSUME.getName().equals(tradeType)) {
            return TradeType.CONSUME.getDesc();
        } else if (TradeType.RECHARGE.getName().equals(tradeType)) {
            return TradeType.RECHARGE.getDesc();
        } else if (TradeType.REWARD.getName().equals(tradeType)) {
            return TradeType.REWARD.getDesc();
        } else {
            throw new BussException("不支持的交易类型");
        }
    }

    public static ChannelType fmtChannel(String channel) {
        if (ChannelType.ALIPAY.getName().equals(channel)) {
            return ChannelType.ALIPAY;
        } else if (ChannelType.WXPAY.getName().equals(channel)) {
            return ChannelType.WXPAY;
        } else {
            throw new BussException("不支持的交易类型");
        }
    }

    public static String fmtTradeStatus(String tradeStatus) {
        if (TradeStatus.FAILED.getName().equals(tradeStatus)) {
            return TradeStatus.FAILED.getDesc();
        } else if (TradeStatus.SUCCESS.getName().equals(tradeStatus)) {
            return TradeStatus.SUCCESS.getDesc();
        } else if (TradeStatus.OVERTIME.getName().equals(tradeStatus)) {
            return TradeStatus.OVERTIME.getDesc();
        } else if (TradeStatus.INPROCESS.getName().equals(tradeStatus)) {
            return TradeStatus.INPROCESS.getDesc();
        } else {
            throw new BussException("不支持的交易状态");
        }
    }

    public static AccountStatus getAccountStatus(TradeAccount tradeAccount) {
        AccountStatus accountStatus = AccountStatus.NOTEXIST;
        if (tradeAccount != null) {
            if (tradeAccount.getIsActive() == 0) {
                accountStatus = AccountStatus.NOTACTIVE;
            } else if (tradeAccount.getIsActive() == 1) {
                if (tradeAccount.getIsFrozen() == 0) {
                    accountStatus = AccountStatus.ACTIVE;
                } else {
                    accountStatus = AccountStatus.FRONZEN;
                }
            } else if (tradeAccount.getIsActive() == -1) {
                accountStatus = AccountStatus.CLOSED;
            }
        }
        return accountStatus;
    }

    public static AccountStatus getUserStatus(TradeUser tradeUser) {
        AccountStatus accountStatus = AccountStatus.NOTEXIST;
        if (tradeUser != null) {
            if (tradeUser.getIsActive() == 0) {
                accountStatus = AccountStatus.NOTACTIVE;
            } else if (tradeUser.getIsActive() == 1) {
                accountStatus = AccountStatus.ACTIVE;
            } else if (tradeUser.getIsActive() == -1) {
                accountStatus = AccountStatus.CLOSED;
            }
        }
        return accountStatus;

    }

    public static AccountType getAccountType(TradeUserType tradeUserType) {

        AccountType accountType = null;
        if (tradeUserType.equals(TradeUserType.PERSION)) {
            accountType = AccountType.PERSIONAL_ACCOUNT;
        } else if (tradeUserType.equals(TradeUserType.DEPARTMENT)) {
            accountType = AccountType.COMPANY_ACCOUNT;
        } else if (tradeUserType.equals(TradeUserType.CHANNEL)) {
            accountType = AccountType.CHANNEL_ACCOUNT;
        } else {
            throw new BussException("错误的用户类型");
        }
        return accountType;
    }

    public static ChannelType getChannelType(String chanelType) {
        if (ChannelType.ALIPAY.getName().equals(chanelType)) {
            return ChannelType.ALIPAY;
        } else if (ChannelType.WXPAY.getName().equals(chanelType)) {
            return ChannelType.WXPAY;
        } else {
            throw new BussException("不支持的渠道类型");
        }
    }

    public static Map<String, String> fmtBalance(Map<String, Object> balanceMap) {
        Map<String, String> map = new HashMap<String, String>();
        if (balanceMap.get("accountBalance") != null) {
            map.put("accountBalance", FmtUtil
                    .transToCNYType(Long.parseLong(balanceMap.get("accountBalance").toString())));
        }
        if (balanceMap.get("availableBalance") != null) {
            map.put("availableBalance", FmtUtil
                    .transToCNYType(Long.parseLong(balanceMap.get("availableBalance").toString())));
        }
        if (balanceMap.get("frozenBalance") != null) {
            map.put("frozenBalance", FmtUtil
                    .transToCNYType(Long.parseLong(balanceMap.get("frozenBalance").toString())));
        }
        return map;
    }

    public static String generateTradeNO() {
        return UUID.randomUUID().toString();
    }

    public static String generateOrderNO() {
        return "R" + UUIDUtil.get();
    }
}
