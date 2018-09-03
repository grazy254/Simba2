package com.simba.wallet.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.wallet.dao.TradeDetailDao;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.util.Constants.TradeUserType;

/**
 * 交易详情信息 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class TradeDetailDaoImpl implements TradeDetailDao {

    @Autowired
    private Jdbc jdbc;

    private static final String table = "tradeDetail";

    @Override
    public Long add(TradeDetail tradeDetail) {
        String sql = "insert into " + table
                + "( tradeNO, tradeType, tradeStatus, orderNO, orderName, orderDesc, orderAddress, feeType, "
                + "originalAmount, paymentAmount, partyTradeUserID, counterpartyTradeUserID, channelTradeUserID, "
                + "tradePartyID, tradeCounterpartyID, tradeChannelID, tradeCreateTime, tradePaymentTime,tradePaymentDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Number id = jdbc.updateForGeneratedKey(sql, tradeDetail.getTradeNO(),
                tradeDetail.getTradeType(), tradeDetail.getTradeStatus(), tradeDetail.getOrderNO(),
                tradeDetail.getOrderName(), tradeDetail.getOrderDesc(),
                tradeDetail.getOrderAddress(), tradeDetail.getFeeType(),
                tradeDetail.getOriginalAmount(), tradeDetail.getPaymentAmount(),
                tradeDetail.getPartyTradeUserID(), tradeDetail.getCounterpartyTradeUserID(),
                tradeDetail.getChannelTradeUserID(), tradeDetail.getTradePartyID(),
                tradeDetail.getTradeCounterpartyID(), tradeDetail.getTradeChannelID(),
                tradeDetail.getTradeCreateTime(), tradeDetail.getTradePaymentTime(),
                tradeDetail.getTradePaymentDate());
        return id.longValue();
    }

    @Override
    public void update(TradeDetail tradeDetail) {
        String sql = "update " + table
                + " set  tradeNO = ? , tradeType = ? , tradeStatus = ? , orderNO = ? , orderName = ? , orderDesc = ? , orderAddress = ? , feeType = ? , originalAmount = ? , paymentAmount = ? , partyTradeUserID = ? , counterpartyTradeUserID = ?, channelTradeUserID = ?, tradePartyID = ? , tradeCounterpartyID = ? , tradeChannelID = ? , tradeCreateTime = ? , tradePaymentTime = ? , createTime = ? , lastUpdateTime = ?  where id = ?  ";
        jdbc.updateForBoolean(sql, tradeDetail.getTradeNO(), tradeDetail.getTradeType(),
                tradeDetail.getTradeStatus(), tradeDetail.getOrderNO(), tradeDetail.getOrderName(),
                tradeDetail.getOrderDesc(), tradeDetail.getOrderAddress(), tradeDetail.getFeeType(),
                tradeDetail.getOriginalAmount(), tradeDetail.getPaymentAmount(),
                tradeDetail.getPartyTradeUserID(), tradeDetail.getCounterpartyTradeUserID(),
                tradeDetail.getChannelTradeUserID(), tradeDetail.getTradePartyID(),
                tradeDetail.getTradeCounterpartyID(), tradeDetail.getTradeChannelID(),
                tradeDetail.getTradeCreateTime(), tradeDetail.getTradePaymentTime(),
                tradeDetail.getCreateTime(), tradeDetail.getLastUpdateTime(), tradeDetail.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from " + table + " where id = ? ";
        jdbc.updateForBoolean(sql, id);
    }

    @Override
    public List<TradeDetail> page(Pager page) {
        String sql = "select * from " + table;
        return jdbc.queryForPage(sql, TradeDetail.class, page);
    }

    @Override
    public List<TradeDetail> page(Pager page, TradeDetailSearchForm tradeDetailSearchForm) {
        String sql = "select * from " + table;
        StatementParameter param = new StatementParameter();
        return jdbc.queryForPage(buildCondition(sql, tradeDetailSearchForm, param),
                TradeDetail.class, page, param);
    }

    @Override
    public List<TradeDetail> listAll() {
        String sql = "select * from " + table;
        return jdbc.queryForList(sql, TradeDetail.class);
    }

    @Override
    public Long count() {
        String sql = "select count(*) from " + table;
        return jdbc.queryForLong(sql);
    }

    @Override
    public Long count(TradeDetailSearchForm tradeDetailSearchForm) {
        String sql = "select count(*) from " + table;
        StatementParameter param = new StatementParameter();
        return jdbc.queryForLong(buildCondition(sql, tradeDetailSearchForm, param), param);
    }

    @Override
    public TradeDetail get(Long id) {
        String sql = "select * from " + table + " where id = ? ";
        return jdbc.query(sql, TradeDetail.class, id);
    }

    @Override
    public TradeDetail getBy(String field, Object value) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        return jdbc.query(sql, TradeDetail.class, value);
    }

    @Override
    public TradeDetail getByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        return jdbc.query(sql, TradeDetail.class, value1, value2);
    }

    @Override
    public TradeDetail getByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        return jdbc.query(sql, TradeDetail.class, value1, value2);
    }

    @Override
    public List<TradeDetail> listBy(String field, Object value) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        return jdbc.queryForList(sql, TradeDetail.class, value);
    }

    @Override
    public List<TradeDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        return jdbc.queryForList(sql, TradeDetail.class, value1, value2);
    }

    @Override
    public List<TradeDetail> listByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        return jdbc.queryForList(sql, TradeDetail.class, value1, value2);
    }

    @Override
    public List<TradeDetail> pageBy(String field, Object value, Pager page) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value);
        return jdbc.queryForPage(sql, TradeDetail.class, page, param);
    }

    @Override
    public List<TradeDetail> pageByAnd(String field1, Object value1, String field2, Object value2,
            Pager page) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value1);
        param.set(value2);
        return jdbc.queryForPage(sql, TradeDetail.class, page, param);
    }

    @Override
    public List<TradeDetail> pageByOr(String field1, Object value1, String field2, Object value2,
            Pager page) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value1);
        param.set(value2);
        return jdbc.queryForPage(sql, TradeDetail.class, page, param);
    }

    @Override
    public Long countBy(String field, Object value) {
        String sql = "select count(*) from " + table + " where " + field + " = ? ";
        return jdbc.queryForLong(sql, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        String sql = "delete from " + table + " where " + field + " = ? ";
        jdbc.updateForBoolean(sql, value);
    }

    @Override
    public Long countByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2
                + " = ? ";
        return jdbc.queryForLong(sql, value1, value2);
    }

    @Override
    public Long countByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2
                + " = ? ";
        return jdbc.queryForLong(sql, value1, value2);
    }

    @Override
    public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "delete from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        jdbc.updateForBoolean(sql, value1, value2);
    }

    @Override
    public void deleteByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "delete from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        jdbc.updateForBoolean(sql, value1, value2);
    }

    private String buildCondition(String sql, TradeDetailSearchForm tradeDetailSearchForm,
            StatementParameter param) {
        sql += " where 1 = 1";

        if (tradeDetailSearchForm.getTradeUserID() != null
                && StringUtils.isNotEmpty(tradeDetailSearchForm.getTradeUserID() + "")) {
            TradeUserType tradeUserType =
                    TradeUserType.getTradeUserType(tradeDetailSearchForm.getTradeUserType());
            switch (tradeUserType) {
                case CHANNEL:
                    sql += " and channelTradeUserID  = ?";
                    break;
                case DEPARTMENT:
                    sql += " and counterpartyTradeUserID  = ?";
                    break;
                case PERSION:
                    sql += " and partyTradeUserID  = ?";
                    break;
            }
            param.set(tradeDetailSearchForm.getTradeUserID());
        }

        if (tradeDetailSearchForm.getStartTime() != null
                && StringUtils.isNotEmpty(tradeDetailSearchForm.getStartTime() + "")) {
            sql += " and tradePaymentTime  >= ?";
            param.set(tradeDetailSearchForm.getStartTime());
        }
        if (tradeDetailSearchForm.getEndTime() != null
                && StringUtils.isNotEmpty(tradeDetailSearchForm.getEndTime() + "")) {
            sql += " and tradePaymentTime  <= ?";
            param.set(tradeDetailSearchForm.getEndTime());
        }
        if (tradeDetailSearchForm.getTradeNO() != null
                && StringUtils.isNotEmpty(tradeDetailSearchForm.getTradeNO() + "")) {
            sql += " and tradeNO  = ?";
            param.set(tradeDetailSearchForm.getTradeNO());
        }
        if (tradeDetailSearchForm.getTradeType() != null
                && StringUtils.isNotEmpty(tradeDetailSearchForm.getTradeType() + "")) {
            sql += " and tradeType  = ?";
            param.set(tradeDetailSearchForm.getTradeType());
        }
        if (tradeDetailSearchForm.getTradeStatus() != null
                && StringUtils.isNotEmpty(tradeDetailSearchForm.getTradeStatus() + "")) {
            sql += " and tradeStatus  = ?";
            param.set(tradeDetailSearchForm.getTradeStatus());
        }
        return sql;
    }
}
