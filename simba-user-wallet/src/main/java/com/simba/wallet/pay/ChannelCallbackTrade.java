package com.simba.wallet.pay;

import java.util.Date;
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
import com.simba.wallet.model.enums.ChannelType;
import com.simba.wallet.model.enums.FeeType;
import com.simba.wallet.model.enums.TradeStatus;
import com.simba.wallet.model.enums.TradeType;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.util.FmtUtil;

public abstract class ChannelCallbackTrade implements CallbackTradeInterface {

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


    public void checkUserAccount(String userID) {

    }

    public void postTrade(String smartUserAccountID, String departmentAccountID,
            long paymentAmount) {

    }

    public JsonResult startTrade(String userID, String ip, String location, String orderNO,
            String orderName, String orderDesc, String orderAddress, long originalAmount,
            long paymentAmount, Date tradeCreateTime, String tradeDeptNO, ChannelType channelType) {

        if (paymentAmount <= 0 || originalAmount <= 0) {
            throw new BussException("非法金额");
        }

        checkUserAccount(userID);

        SmartUser smartUser = smartUserDao.getBy("account", userID);
        TradeUser tradeUser =
                tradeUserDao.get(smartUser.getAccount(), TradeUserType.PERSION.getName());

        Date now = new Date();
        TradePartyDetail tradePartyDetail = new TradePartyDetail();
        tradePartyDetail.setCreateDate(DateUtil.getOnlyDate(now));
        tradePartyDetail.setPartyName(smartUser.getName());
        tradePartyDetail.setPartyType(TradeUserType.PERSION.getName());
        tradePartyDetail.setNoticeMail(smartUser.getEmail());
        tradePartyDetail.setIp(ip);
        tradePartyDetail.setLocation(location);
        tradePartyDetail.setMobileNumber(smartUser.getTelNo());
        tradePartyDetail.setTradeAccountID(
                tradeAccountDao.get(tradeUser.getId(), TradeUserType.PERSION).getAccountID());
        tradePartyDetail.setTradeUserID(tradeUser.getId());
        Long tradePartyID = tradePartyDetailDao.add(tradePartyDetail);
        tradePartyDetail.setId(tradePartyID);

        TradeDepartment tradeDepartment = tradeDepartmentDao.get(tradeDeptNO);

        TradeUser departmentTradeUser =
                tradeUserDao.get(tradeDepartment.getDeptNO(), TradeUserType.DEPARTMENT.getName());

        TradePartyDetail counterPartyDetail = new TradePartyDetail();
        counterPartyDetail.setCreateDate(DateUtil.getOnlyDate(now));
        counterPartyDetail.setPartyName(tradeDepartment.getDeptName());
        counterPartyDetail.setPartyType(TradeUserType.DEPARTMENT.getName());
        counterPartyDetail.setTradeAccountID(tradeAccountDao
                .get(departmentTradeUser.getId(), TradeUserType.DEPARTMENT).getAccountID());
        counterPartyDetail.setTradeUserID(departmentTradeUser.getId());

        // 对手实体默认不填
        counterPartyDetail.setIp("");
        counterPartyDetail.setLocation("");
        counterPartyDetail.setMobileNumber("");
        counterPartyDetail.setNoticeMail("");

        Long counterPartyID = tradePartyDetailDao.add(counterPartyDetail);
        counterPartyDetail.setId(counterPartyID);

        TradeChannel tradeChannel = tradeChannelDao.get(channelType.getName());

        TradeChannelDetail tradeChannelDetail = new TradeChannelDetail();
        tradeChannelDetail.setChannelID(tradeChannel.getId());
        tradeChannelDetail.setTradeAccountID(
                tradeAccountDao.get(tradeChannel.getType(), TradeUserType.CHANNEL).getAccountID());

        Long tradeChannelDetailID = tradeChannelDetailDao.add(tradeChannelDetail);

        tradeChannelDetail.setId(tradeChannelDetailID);

        TradeDetail tradeDetail = new TradeDetail();
        tradeDetail.setFeeType(FeeType.CNY.getName());
        tradeDetail.setOrderAddress(orderAddress);
        tradeDetail.setOrderDesc(orderDesc);
        tradeDetail.setOrderName(orderName);
        tradeDetail.setOrderNO(orderNO);
        tradeDetail.setOriginalAmount(originalAmount);
        tradeDetail.setPaymentAmount(paymentAmount);
        tradeDetail.setTradeChannelID(tradeChannelDetailID);
        tradeDetail.setTradeCounterpartyID(counterPartyID);
        tradeDetail.setTradeCreateTime(tradeCreateTime);
        tradeDetail.setTradeNO(FmtUtil.generateTradeNO());
        tradeDetail.setTradePartyID(tradePartyID);
        tradeDetail.setTradePaymentTime(new Date());
        tradeDetail.setTradeStatus(TradeStatus.SUCCESS.getName());
        tradeDetail.setTradeType(TradeType.CONSUME.getName());
        tradeDetail.setTradePaymentTime(new Date());

        Long tradeDetailID = tradeDetailDao.add(tradeDetail);

        if (tradeDetailID <= 0) {
            throw new BussException("创建支付订单失败");
        }

        return new JsonResult("订单创建成功");
    }

    public JsonResult finishTrade(String userID, ChannelType channelType, String orderNO,
            String channelOrderNO, String openID, Date channelOrderCreateTime,
            Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
            long channelPaymentAmount, TradeStatus tradeStatus, String tradeDeptNO,
            TradeType tradeType) {

        SmartUser smartUser = smartUserDao.getBy("account", userID);
        TradeDetail tradeDetail = tradeDetailDao.getBy("orderNO", orderNO);
        if (tradeDetail == null) {
            throw new BussException("订单异常");
        }
        TradeChannelDetail tradeChannelDetail =
                tradeChannelDetailDao.get(tradeDetail.getTradeChannelID());
        TradeAccount smartUserTradeAccount =
                tradeAccountDao.get(smartUser.getAccount(), TradeUserType.PERSION);
        TradeAccount channelTradeAccount =
                tradeAccountDao.get(tradeDeptNO, TradeUserType.DEPARTMENT);
        TradeAccount departmentTradeAccount =
                tradeAccountDao.get(channelType.getName(), TradeUserType.CHANNEL);

        tradeDetail.setTradeStatus(tradeStatus.getName());
        tradeDetailDao.update(tradeDetail);

        if (channelType != null) {
            tradeChannelDetail.setOrderCreateTime(channelOrderCreateTime);
            tradeChannelDetail.setOrderNO(channelOrderNO);
            tradeChannelDetail.setPaymentTime(channelPaymentTime);
            tradeChannelDetail.setOpenID(openID);
            tradeChannelDetail.setOrderNO(channelOrderNO);
            tradeChannelDetail.setErrorCode(channelErrorCode);
            tradeChannelDetail.setErrorMsg(channelErrorMsg);
            tradeChannelDetailDao.update(tradeChannelDetail);
        }
        return null;
    }

}
