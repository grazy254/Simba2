package com.simba.wallet.pay.trade;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.simba.dao.SmartUserDao;
import com.simba.exception.BussException;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.dao.TradeDepartmentDao;
import com.simba.wallet.dao.TradeDetailDao;
import com.simba.wallet.dao.TradePartyDetailDao;
import com.simba.wallet.dao.TradeUserDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeDepartment;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.FeeType;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;

/**
 * 内部交易抽象类
 * 
 * @author zhangfenghua
 *
 */
public abstract class BaseInnerTrade implements InnerTradeInterface {

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

    @Value("${node.id}")
    private int nodeId;

    /**
     * 检查用户账户状态
     * 
     * @param tradeAccount smart用户account
     */
    protected void checkUserAccount(TradeAccount tradeAccount, Long amount) {

    }


    /**
     * 交易后要执行的后续操作
     * 
     * @param smartUserAccount smart用户账户
     * @param departmentAccount 部门账户
     * @param paymentAmount 金额 单位是分
     */
    protected void updateBalance(TradeAccount smartUserAccount, TradeAccount departmentAccount,
            long paymentAmount) {

    }

    /**
     * 交易
     * 
     * @param userID smart用户account
     * @param ip 交易时候的ip信息
     * @param location 交易时候的地理位置信息
     * @param orderNO 订单号
     * @param orderName 订单名称
     * @param orderDesc 订单描述
     * @param orderAddress 订单地址
     * @param originalAmount 原始金额
     * @param paymentAmount 实际金额
     * @param tradeCreateTime 交易时间
     * @param tradeDeptNO 部门编号
     * @param tradeType 交易类型
     * @return
     */
    protected JsonResult trade(String userID, String ip, String location, String orderNO,
            String orderName, String orderDesc, String orderAddress, long originalAmount,
            long paymentAmount, Date tradeCreateTime, String tradeDeptNO, TradeType tradeType) {

        if (paymentAmount <= 0 || originalAmount <= 0) {
            throw ErrConfig.INVALID_PAYMENT_ACCOUNT;
        }

        SmartUser smartUser = smartUserDao.getBy("account", userID);
        TradeUser smartTradeUser = tradeUserDao.get(smartUser.getAccount(), TradeUserType.PERSION);

        TradeAccount smartUserTradeAccount =
                tradeAccountDao.get(smartTradeUser.getId(), TradeUserType.PERSION);
        CommonUtil.checkWalletAutority(smartTradeUser, smartUserTradeAccount,
                TradeUserType.PERSION);

        checkUserAccount(smartUserTradeAccount, paymentAmount);

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

        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setFeeType(FeeType.CNY.name());
        tradeDetail.setOrderAddress(orderAddress);
        tradeDetail.setOrderDesc(orderDesc);
        tradeDetail.setOrderName(orderName);
        tradeDetail.setOrderNO(orderNO);
        tradeDetail.setOriginalAmount(originalAmount);
        tradeDetail.setPaymentAmount(paymentAmount);
        tradeDetail.setTradeChannelID(-1);
        tradeDetail.setTradeCounterpartyID(counterPartyID);
        tradeDetail.setTradeCreateTime(tradeCreateTime);
        tradeDetail.setTradeNO(CommonUtil.TradeNoGenerator.gen(nodeId));
        tradeDetail.setTradePartyID(tradePartyID);
        tradeDetail.setTradeStatus(TradeStatus.SUCCESS.getName());
        tradeDetail.setTradeType(tradeType.getName());
        tradeDetail.setTradePaymentTime(now);
        tradeDetail.setTradePaymentDate(DateUtil.getOnlyDate(now));
        tradeDetail.setChannelTradeUserID(-1);
        tradeDetail.setCounterpartyTradeUserID(departmentTradeUser.getId());
        tradeDetail.setPartyTradeUserID(smartTradeUser.getId());

        Long tradeDetailID = tradeDetailDao.add(tradeDetail);

        if (tradeDetailID <= 0) {
            throw new BussException("创建支付订单失败");
        }

        updateBalance(smartUserTradeAccount, departmentTradeAccount, paymentAmount);

        tradeAccountDao.update(smartUserTradeAccount);
        tradeAccountDao.update(departmentTradeAccount);

        return new JsonResult("订单创建成功");
    }

}
