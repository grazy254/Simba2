package com.simba.wallet.util;

import com.simba.exception.BussException;

public class ErrConfig {

    public final static BussException USER_NOT_EXIST_ERR = new BussException("用户不存在");

    public final static BussException ACCOUNT_EXIST_ERR = new BussException("钱包账户已存在");

    public final static BussException DEPARTMENT_NOT_EXIST_ERR = new BussException("钱包交易部门不存在");
    public final static BussException CHANNEL_NOT_EXIST_ERR = new BussException("钱包交易渠道不存在");

    public final static BussException INVALID_WALLET_USER = new BussException("钱包功能未开通");

    public final static BussException WALLET_UNAVAILABLE = new BussException("钱包功能暂不可用");
    public final static BussException WALLET_FROZEN = new BussException("钱包已被冻结");
    public final static BussException WALLET_NOT_ALLOWPAY = new BussException("钱包未开通支付功能");
    public final static BussException WALLET_NOT_ALLOWRECHARGE = new BussException("钱包未开通充值功能");

    public final static BussException OPEN_WALLET_ACCOUNT_FAILED = new BussException("钱包功能开通失败");
    public final static BussException TRADE_FAILED = new BussException("交易失败");

    public final static BussException INVALID_CHANNEL = new BussException("渠道信息不正确");
    public final static BussException INVALID_ORDER = new BussException("订单异常");
    public final static BussException INVALID_PAYMENT_AMOUNT = new BussException("非法金额");

    public final static BussException INVALID_ACCOUNT_ACTIVE_TYPE = new BussException("账户激活状态码错误");
    public final static BussException INVALID_ACCOUNT_FROZEN_TYPE = new BussException("账户冻结状态码错误");

    public final static BussException INVALID_TRADEUSER_ACTIVE_TYPE =
            new BussException("用户激活状态码错误");
    public final static BussException INVALID_TRADE_PAYMENT_TYPE = new BussException("用户可支付状态码错误");
    public final static BussException INVALID_TRADE_RECHARGEMENT_TYPE =
            new BussException("用户可充值状态码错误");

    public final static BussException INVALID_CHANNEL_TYPE = new BussException("不支持的渠道类型");
    public final static BussException INVALID_TRADE_TYPE = new BussException("不支持的交易类型");
    public final static BussException INVALID_TRADE_STATUS = new BussException("不支持的交易状态");
    public final static BussException INVALID_ACCOUNT_TYPE = new BussException("错误的账户类型");
    public final static BussException INVALID_TRADEUSER_TYPE = new BussException("错误的用户类型");
    public final static BussException INVALID_TRADBALANCE_TYPE = new BussException("错误的交易余额类型");
    
    public final static BussException INVALID_PARAMETER = new BussException("参数错误");

    public final static BussException EXISTING_INVALID_PAYMENT = new BussException("有一笔异常支付");
    public final static BussException NO_ENOUGH_BALANCE = new BussException("余额不足");

    public final static BussException CNY_PARSE_ERR = new BussException("元转换成分异常 ");



}
