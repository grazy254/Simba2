package com.simba.wallet.util;

import com.simba.exception.BussException;

public class ErrConfig {
    public final static BussException ACCOUNT_EXIST_ERR = new BussException("钱包账户已存在");

    public final static BussException DEPARTMENT_NOT_EXIST_ERR = new BussException("钱包交易部门不存在");
    public final static BussException CHANNEL_NOT_EXIST_ERR = new BussException("钱包交易渠道不存在");

    public final static BussException INVALID_WALLET_USER = new BussException("钱包功能未开通");

    public final static BussException WALLET_UNAVAILABLE = new BussException("钱包功能暂不可用");
    public final static BussException WALLET_FROZEN = new BussException("钱包已冻结");
    public final static BussException WALLET_NOT_ALLOWPAY = new BussException("钱包不允许支付");
    public final static BussException WALLET_NOT_ALLOWRECHARGE = new BussException("钱包不允许充值");

    public final static BussException OPEN_WALLET_ACCOUNT_FAILED = new BussException("钱包功能开通失败");


}
