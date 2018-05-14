package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TradeDetailDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.TradeDetail;
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
	public void add(TradeDetail tradeDetail) {
		String sql = "insert into " + table + "( tradeNO, tradeType, tradeStatus, orderNO, orderName, orderDesc, orderAddress, feeType, originalAmount, paymentAmount, tradePartyID, tradeCounterpartyID, tradeChannelID, tradeCreateTime, tradePaymentTime, createTime, lastUpdateTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, tradeDetail.getTradeNO(),tradeDetail.getTradeType(),tradeDetail.getTradeStatus(),tradeDetail.getOrderNO(),tradeDetail.getOrderName(),tradeDetail.getOrderDesc(),tradeDetail.getOrderAddress(),tradeDetail.getFeeType(),tradeDetail.getOriginalAmount(),tradeDetail.getPaymentAmount(),tradeDetail.getTradePartyID(),tradeDetail.getTradeCounterpartyID(),tradeDetail.getTradeChannelID(),tradeDetail.getTradeCreateTime(),tradeDetail.getTradePaymentTime(),tradeDetail.getCreateTime(),tradeDetail.getLastUpdateTime());
	}

	@Override
	public void update(TradeDetail tradeDetail) {
		String sql = "update " + table + " set  tradeNO = ? , tradeType = ? , tradeStatus = ? , orderNO = ? , orderName = ? , orderDesc = ? , orderAddress = ? , feeType = ? , originalAmount = ? , paymentAmount = ? , tradePartyID = ? , tradeCounterpartyID = ? , tradeChannelID = ? , tradeCreateTime = ? , tradePaymentTime = ? , createTime = ? , lastUpdateTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,tradeDetail.getTradeNO(),tradeDetail.getTradeType(),tradeDetail.getTradeStatus(),tradeDetail.getOrderNO(),tradeDetail.getOrderName(),tradeDetail.getOrderDesc(),tradeDetail.getOrderAddress(),tradeDetail.getFeeType(),tradeDetail.getOriginalAmount(),tradeDetail.getPaymentAmount(),tradeDetail.getTradePartyID(),tradeDetail.getTradeCounterpartyID(),tradeDetail.getTradeChannelID(),tradeDetail.getTradeCreateTime(),tradeDetail.getTradePaymentTime(),tradeDetail.getCreateTime(),tradeDetail.getLastUpdateTime(), tradeDetail.getId());
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
	public List<TradeDetail> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeDetail.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
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
	public List<TradeDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeDetail.class, page, param);
	}

	@Override
	public List<TradeDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
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
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}
	
	@Override
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "delete from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		String sql = "delete from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}
}
