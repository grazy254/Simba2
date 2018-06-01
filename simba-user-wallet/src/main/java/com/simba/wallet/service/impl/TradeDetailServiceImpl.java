package com.simba.wallet.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.dao.TradeChannelDao;
import com.simba.wallet.dao.TradeChannelDetailDao;
import com.simba.wallet.dao.TradeDepartmentDao;
import com.simba.wallet.dao.TradeDetailDao;
import com.simba.wallet.dao.TradePartyDetailDao;
import com.simba.wallet.dao.TradeUserDao;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.enums.ChannelType;
import com.simba.wallet.model.enums.TradeStatus;
import com.simba.wallet.model.enums.TradeType;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.service.TradeDetailService;

/**
 * 交易详情信息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeDetailServiceImpl implements TradeDetailService {

    @Autowired
    private TradeDetailDao tradeDetailDao;

    @Autowired
    private TradePartyDetailDao tradePartyDetailDao;

    @Autowired
    private TradeChannelDetailDao tradeChannelDetailDao;

    @Autowired
    private TradeDepartmentDao tradeDepartmentDao;

    @Autowired
    private TradeUserDao tradeUserDao;

    @Autowired
    private TradeAccountDao tradeAccountDao;

    @Autowired
    private TradeChannelDao tradeChannelDao;

    @Override
    public Long add(TradeDetail tradeDetail) {
        return tradeDetailDao.add(tradeDetail);
    }

    @Override
    public void delete(Long id) {
        tradeDetailDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDetail get(Long id) {
        return tradeDetailDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> page(Pager page) {
        return tradeDetailDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> page(Pager page, TradeDetailSearchForm tradeDetailSearchForm) {
        return tradeDetailDao.page(page, tradeDetailSearchForm);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return tradeDetailDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Long count(TradeDetailSearchForm tradeDetailSearchForm) {
        return tradeDetailDao.count(tradeDetailSearchForm);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countBy(String field, Object value) {
        return tradeDetailDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        tradeDetailDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> listAll() {
        return tradeDetailDao.listAll();
    }

    @Override
    public void update(TradeDetail tradeDetail) {
        tradeDetailDao.update(tradeDetail);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        for (Long id : idList) {
            this.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDetail getBy(String field, Object value) {
        return tradeDetailDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDetail getByAnd(String field1, Object value1, String field2, Object value2) {
        return tradeDetailDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDetail getByOr(String field1, Object value1, String field2, Object value2) {
        return tradeDetailDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> listBy(String field, Object value) {
        return tradeDetailDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
        return tradeDetailDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> listByOr(String field1, Object value1, String field2, Object value2) {
        return tradeDetailDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> pageBy(String field, Object value, Pager page) {
        return tradeDetailDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> pageByAnd(String field1, Object value1, String field2, Object value2,
            Pager page) {
        return tradeDetailDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDetail> pageByOr(String field1, Object value1, String field2, Object value2,
            Pager page) {
        return tradeDetailDao.pageByOr(field1, value1, field2, value2, page);
    }

    @Override
    public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
        tradeDetailDao.deleteByAnd(field1, value1, field2, value2);
    }

    @Override
    public void deleteByOr(String field1, Object value1, String field2, Object value2) {
        tradeDetailDao.deleteByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByAnd(String field1, Object value1, String field2, Object value2) {
        return tradeDetailDao.countByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByOr(String field1, Object value1, String field2, Object value2) {
        return tradeDetailDao.countByOr(field1, value1, field2, value2);
    }

    // private String generateTradeNO() {
    // return UUID.randomUUID().toString();
    // }
    //
    // private boolean checkUserBalance(Long tradeUserID, TradeUserType userType, long amount) {
    // TradeAccount tradeAccount = tradeAccountDao.get(tradeUserID, userType);
    // Long availableBalacne = tradeAccount.getAvailableBalance();
    // if (availableBalacne >= amount) {
    // return true;
    // }
    // return false;
    // }


    public JsonResult finishTrade(SmartUser smartUser, String tradeDeptNO, ChannelType channelType,
            String orderNO, String channelOrderNO, String openID, Date channelOrderCreateTime,
            Date channelPaymentTime, String channelErrorMsg, String channelErrorCode,
            long channelPaymentAmount, TradeStatus tradeStatus, TradeType tradeType) {

        // TradeDetail tradeDetail = tradeDetailDao.getBy("orderNO", orderNO);
        // if (tradeDetail == null) {
        // throw new BussException("订单异常");
        // }
        // TradeChannelDetail tradeChannelDetail =
        // tradeChannelDetailDao.get(tradeDetail.getTradeChannelID());
        // TradeAccount smartUserTradeAccount =
        // tradeAccountDao.get(smartUser.getAccount(), TradeUserType.PERSION);
        // TradeAccount channelTradeAccount =
        // tradeAccountDao.get(tradeDeptNO, TradeUserType.DEPARTMENT);
        // TradeAccount departmentTradeAccount =
        // tradeAccountDao.get(channelType.getName(), TradeUserType.CHANNEL);
        //
        // tradeDetail.setTradeStatus(tradeStatus.getName());
        // tradeDetailDao.update(tradeDetail);
        //
        // if (tradeType == TradeType.RECHARGE || tradeType == TradeType.REFUND) {
        // tradeChannelDetail.setOrderCreateTime(channelOrderCreateTime);
        // tradeChannelDetail.setOrderNO(channelOrderNO);
        // tradeChannelDetail.setPaymentTime(channelPaymentTime);
        // tradeChannelDetail.setOpenID(openID);
        // tradeChannelDetail.setOrderNO(channelOrderNO);
        // tradeChannelDetail.setErrorCode(channelErrorCode);
        // tradeChannelDetail.setErrorMsg(channelErrorMsg);
        // tradeChannelDetailDao.update(tradeChannelDetail);
        // }
        // if (tradeStatus == TradeStatus.SUCCESS) {
        // if (tradeType == TradeType.CONSUME) {
        // // 如果是消费 则需要把可用余额赋值给余额 并且冻结金额清零
        // // 单个人的两笔消费不能同时进行
        // // TODO: 检查是否还有冻结金额 , 检查账号是否冻结，检查个人是否allowpay，检查账号是否是allowpay
        // smartUserTradeAccount
        // .setAccountBalance(smartUserTradeAccount.getAvailableBalance());
        //
        // departmentTradeAccount.setAccountBalance(departmentTradeAccount.getAccountBalance()
        // + smartUserTradeAccount.getFrozenBalance());
        // departmentTradeAccount
        // .setAvailableBalance(departmentTradeAccount.getAvailableBalance()
        // + smartUserTradeAccount.getFrozenBalance());
        // smartUserTradeAccount.setFrozenBalance(0);
        //
        // } else if (tradeType == TradeType.RECHARGE) {
        // // 如果是充值 则需要在余额和可用余额上增加
        // smartUserTradeAccount.setAccountBalance(
        // smartUserTradeAccount.getAccountBalance() + channelPaymentAmount);
        // smartUserTradeAccount.setAvailableBalance(
        // smartUserTradeAccount.getAvailableBalance() + channelPaymentAmount);
        //
        // departmentTradeAccount.setAccountBalance(
        // departmentTradeAccount.getAccountBalance() + channelPaymentAmount);
        // departmentTradeAccount.setAvailableBalance(
        // departmentTradeAccount.getAvailableBalance() + channelPaymentAmount);
        //
        // channelTradeAccount.setAccountBalance(
        // channelTradeAccount.getAccountBalance() + channelPaymentAmount);
        // channelTradeAccount.setAvailableBalance(
        // channelTradeAccount.getAvailableBalance() + channelPaymentAmount);
        // } else if (tradeType == TradeType.REFUND) {
        // smartUserTradeAccount.setAccountBalance(
        // smartUserTradeAccount.getAccountBalance() - channelPaymentAmount);
        // smartUserTradeAccount.setAvailableBalance(
        // smartUserTradeAccount.getAvailableBalance() - channelPaymentAmount);
        //
        // departmentTradeAccount.setAccountBalance(
        // departmentTradeAccount.getAccountBalance() - channelPaymentAmount);
        // departmentTradeAccount.setAvailableBalance(
        // departmentTradeAccount.getAvailableBalance() - channelPaymentAmount);
        //
        // channelTradeAccount.setAccountBalance(
        // channelTradeAccount.getAccountBalance() - channelPaymentAmount);
        // channelTradeAccount.setAvailableBalance(
        // channelTradeAccount.getAvailableBalance() - channelPaymentAmount);
        //
        // } else if (tradeType == TradeType.REWARD) {
        // smartUserTradeAccount.setAccountBalance(
        // smartUserTradeAccount.getAccountBalance() + channelPaymentAmount);
        // smartUserTradeAccount.setAvailableBalance(
        // smartUserTradeAccount.getAvailableBalance() + channelPaymentAmount);
        //
        // departmentTradeAccount.setAccountBalance(
        // departmentTradeAccount.getAccountBalance() + channelPaymentAmount);
        // departmentTradeAccount.setAvailableBalance(
        // departmentTradeAccount.getAvailableBalance() + channelPaymentAmount);
        //
        // }
        //// tradeAccountDao.update(smartUserTradeAccount);
        //// tradeAccountDao.update(departmentTradeAccount);
        //// tradeAccountDao.update(channelTradeAccount);
        // }


        return new JsonResult();

    }



}
