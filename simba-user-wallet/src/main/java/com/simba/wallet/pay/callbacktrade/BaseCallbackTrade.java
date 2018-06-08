package com.simba.wallet.pay.callbacktrade;

import java.util.Date;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import com.simba.dao.SmartUserDao;
import com.simba.exception.BussException;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.dao.TradeChannelDao;
import com.simba.wallet.dao.TradeChannelDetailDao;
import com.simba.wallet.dao.TradeDepartmentDao;
import com.simba.wallet.dao.TradeDetailDao;
import com.simba.wallet.dao.TradePartyDetailDao;
import com.simba.wallet.dao.TradeUserDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.model.TradeChannelDetail;
import com.simba.wallet.model.TradeDepartment;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.ChannelType;
import com.simba.wallet.util.Constants.FeeType;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;

/**
 * 回调交易基类
 * 
 * 实现了接口的{@code startTrade}和{@code finishTrade}方法，
 * 子类可以根据自己的需要实现模板方法{@code checkUserAccount}和{@code postTrade}
 * 
 * @author zhangfenghua
 *
 */
public abstract class BaseCallbackTrade implements CallbackTradeInterface {

    @Autowired
    protected TradeDetailDao tradeDetailDao;

    @Autowired
    protected TradePartyDetailDao tradePartyDetailDao;

    @Autowired
    protected TradeDepartmentDao tradeDepartmentDao;

    @Autowired
    protected TradeUserDao tradeUserDao;

    @Autowired
    protected SmartUserDao smartUserDao;

    @Autowired
    protected TradeAccountDao tradeAccountDao;

    @Autowired
    protected TradeChannelDao tradeChannelDao;

    @Autowired
    protected TradeChannelDetailDao tradeChannelDetailDao;

    /**
     * 检查用户状态
     * 
     * @param userID smart用户account
     */
    protected void checkUserAccount(String userID) {

    }

    /**
     * 需要自己实现的后续交易操作
     * 
     * @param smartUserTradeAccount smart用户账户
     * @param departmentAccount 部门账户
     * @param channelTradeAccount 渠道账户
     * @param paymentAmount 金额 单位是分
     */
    protected void updateBalance(TradeAccount smartUserTradeAccount, TradeAccount departmentAccount,
            TradeAccount channelTradeAccount, long paymentAmount) {

    }

    /**
     * 开始交易
     * 
     * 一般在回调之前调用
     * 
     * @param userID smart用户的account
     * @param ip 交易时的ip信息
     * @param location 交易时的地理位置
     * @param orderNO 订单号
     * @param orderName 订单名称
     * @param orderDesc 订单描述
     * @param orderAddress 订单地址
     * @param originalAmount 原始金额
     * @param paymentAmount 实际金额
     * @param tradeCreateTime 订单时间
     * @param channelStartTime 渠道开始时间
     * @param tradeDeptNO 部门编号
     * @param channelType 渠道类型
     * @param tradeType 交易类型
     * 
     * @exception BussException 如果{@code paymentAmount <=0} 或者 {@code originalAmount<=0}会抛出非法金额异常
     * @exception BussException 如果 {@code userID}没有开通钱包功能会抛
     * @return
     */
    protected JsonResult startTrade(String userID, String ip, String location, String orderNO,
            String orderName, String orderDesc, String orderAddress, long originalAmount,
            long paymentAmount, Date tradeCreateTime, Date channelStartTime, String tradeDeptNO,
            ChannelType channelType, TradeType tradeType) {

        if (paymentAmount <= 0 || originalAmount <= 0) {
            throw ErrConfig.INVALID_PAYMENT_ACCOUNT;
        }

        checkUserAccount(userID);

        SmartUser smartUser = smartUserDao.getBy("account", userID);
        if (Objects.isNull(smartUser)) {
            throw ErrConfig.USER_NOT_EXIST_ERR;
        }
        TradeUser smartTradeUser = tradeUserDao.get(smartUser.getAccount(), TradeUserType.PERSION);
        TradeAccount smartUserTradeAccount =
                tradeAccountDao.get(smartTradeUser.getId(), TradeUserType.PERSION);
        CommonUtil.checkWalletAutority(smartTradeUser, smartUserTradeAccount,
                TradeUserType.PERSION);

        Date now = new Date();
        TradePartyDetail tradePartyDetail = new TradePartyDetail();
        tradePartyDetail.setCreateDate(DateUtil.getOnlyDate(now));
        tradePartyDetail.setPartyName(smartUser.getName());
        tradePartyDetail.setPartyType(TradeUserType.PERSION.getName());
        tradePartyDetail.setNoticeMail(smartUser.getEmail());
        tradePartyDetail.setIp(ip);
        tradePartyDetail.setLocation(location);
        tradePartyDetail.setMobileNumber(smartUser.getTelNo());
        tradePartyDetail.setTradeAccountID(smartUserTradeAccount.getAccountID());
        tradePartyDetail.setTradeUserID(smartTradeUser.getId());

        Long tradePartyID = tradePartyDetailDao.add(tradePartyDetail);

        tradePartyDetail.setId(tradePartyID);

        TradeDepartment tradeDepartment = tradeDepartmentDao.get(tradeDeptNO);
        TradeUser departmentTradeUser =
                tradeUserDao.get(tradeDepartment.getDeptNO(), TradeUserType.DEPARTMENT);
        TradeAccount departmentTradeAccount =
                tradeAccountDao.get(departmentTradeUser.getId(), TradeUserType.DEPARTMENT);
        CommonUtil.checkWalletAutority(departmentTradeUser, departmentTradeAccount,
                TradeUserType.DEPARTMENT);

        TradePartyDetail counterPartyDetail = new TradePartyDetail();
        counterPartyDetail.setCreateDate(DateUtil.getOnlyDate(now));
        counterPartyDetail.setPartyName(tradeDepartment.getDeptName());
        counterPartyDetail.setPartyType(TradeUserType.DEPARTMENT.getName());
        counterPartyDetail.setTradeAccountID(departmentTradeAccount.getAccountID());
        counterPartyDetail.setTradeUserID(departmentTradeUser.getId());
        // 对手实体默认不填
        counterPartyDetail.setIp("");
        counterPartyDetail.setLocation("");
        counterPartyDetail.setMobileNumber("");
        counterPartyDetail.setNoticeMail("");

        Long counterPartyID = tradePartyDetailDao.add(counterPartyDetail);
        counterPartyDetail.setId(counterPartyID);

        TradeChannel tradeChannel = tradeChannelDao.get(channelType.getName());
        TradeUser channelTradeUser = tradeUserDao.get(channelType.getName(), TradeUserType.CHANNEL);
        TradeAccount channelTradeAccount =
                tradeAccountDao.get(channelTradeUser.getId(), TradeUserType.CHANNEL);
        CommonUtil.checkWalletAutority(channelTradeUser, channelTradeAccount,
                TradeUserType.CHANNEL);

        TradeChannelDetail tradeChannelDetail = new TradeChannelDetail();
        tradeChannelDetail.setChannelID(tradeChannel.getId());
        tradeChannelDetail.setTradeAccountID(channelTradeAccount.getAccountID());
        tradeChannelDetail.setOrderCreateTime(channelStartTime);

        Long tradeChannelDetailID = tradeChannelDetailDao.add(tradeChannelDetail);
        tradeChannelDetail.setId(tradeChannelDetailID);

        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setFeeType(FeeType.CNY.name());
        tradeDetail.setOrderAddress(orderAddress);
        tradeDetail.setOrderDesc(orderDesc);
        tradeDetail.setOrderName(orderName);
        tradeDetail.setOrderNO(orderNO);
        tradeDetail.setOriginalAmount(originalAmount);
        tradeDetail.setPaymentAmount(paymentAmount);
        tradeDetail.setTradeChannelID(tradeChannelDetailID);
        tradeDetail.setTradeCounterpartyID(counterPartyID);
        tradeDetail.setTradeCreateTime(tradeCreateTime);
        tradeDetail.setTradeNO(CommonUtil.generateTradeNO());
        tradeDetail.setTradePartyID(tradePartyID);
        tradeDetail.setTradePaymentTime(new Date());
        tradeDetail.setTradeStatus(TradeStatus.SUCCESS.getName());
        tradeDetail.setTradeType(tradeType.getName());
        tradeDetail.setTradePaymentTime(new Date());

        Long tradeDetailID = tradeDetailDao.add(tradeDetail);

        if (tradeDetailID <= 0) {
            throw ErrConfig.TRADE_FAILED;
        }

        return new JsonResult("订单创建成功");
    }

    /**
     * 回调方法用来结束交易
     * 
     * @param userID smart用户account
     * @param channelType 渠道类型
     * @param orderNO 订单号
     * @param channelOrderNO 渠道订单号
     * @param openID
     * @param channelPaymentTime 渠道支付时间
     * @param channelErrorMsg 渠道返回的错误信息
     * @param channelErrorCode 渠道返回的错误码
     * @param paymentAmount 交易金额 单位是分
     * @param tradeStatus 交易状态
     * @param tradeDeptNO 部门编号
     * @return
     */
    protected JsonResult finishTrade(String userID, ChannelType channelType, String orderNO,
            String channelOrderNO, String openID, Date channelPaymentTime, String channelErrorMsg,
            String channelErrorCode, long paymentAmount, TradeStatus tradeStatus,
            String tradeDeptNO) {

        if (channelType == null) {
            throw ErrConfig.INVALID_CHANNEL;
        }

        TradeDetail tradeDetail = tradeDetailDao.getBy("orderNO", orderNO);
        if (tradeDetail == null) {
            throw ErrConfig.INVALID_ORDER;
        }
        TradeChannelDetail tradeChannelDetail =
                tradeChannelDetailDao.get(tradeDetail.getTradeChannelID());
        TradeAccount smartUserTradeAccount = tradeAccountDao.get(userID, TradeUserType.PERSION);
        TradeAccount departmentTradeAccount =
                tradeAccountDao.get(tradeDeptNO, TradeUserType.DEPARTMENT);
        TradeAccount channelTradeAccount =
                tradeAccountDao.get(channelType.getName(), TradeUserType.CHANNEL);

        tradeDetail.setTradeStatus(tradeStatus.getName());
        tradeDetailDao.update(tradeDetail);

        tradeChannelDetail.setOrderNO(channelOrderNO);
        tradeChannelDetail.setPaymentTime(channelPaymentTime);
        tradeChannelDetail.setOpenID(openID);
        tradeChannelDetail.setOrderNO(channelOrderNO);
        tradeChannelDetail.setErrorCode(channelErrorCode);
        tradeChannelDetail.setErrorMsg(channelErrorMsg);
        tradeChannelDetailDao.update(tradeChannelDetail);

        if (tradeStatus == TradeStatus.SUCCESS) {
            updateBalance(smartUserTradeAccount, departmentTradeAccount, channelTradeAccount,
                    paymentAmount);
            tradeAccountDao.update(smartUserTradeAccount);
            tradeAccountDao.update(departmentTradeAccount);
            tradeAccountDao.update(channelTradeAccount);

            return new JsonResult("订单完成");
        } else if (tradeStatus == TradeStatus.FAILED) {
            return new JsonResult("订单失败");
        } else if (tradeStatus == TradeStatus.OVERTIME) {
            return new JsonResult("订单超时");
        }
        return new JsonResult("未知订单完成状态");
    }

}