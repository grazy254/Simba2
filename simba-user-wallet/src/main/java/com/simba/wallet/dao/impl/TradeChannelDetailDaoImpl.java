package com.simba.wallet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.wallet.dao.TradeChannelDetailDao;
import com.simba.wallet.model.TradeChannelDetail;
/**
 * 交易的渠道信息 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradeChannelDetailDaoImpl implements TradeChannelDetailDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradeChannelDetail";

	@Override
	public Long add(TradeChannelDetail tradeChannelDetail) {
		String sql = "insert into " + table + "( tradeAccountID, channelID, orderCreateTime, paymentTime, orderNO, openID, errorMsg, errorCode, createTime, lastUpdateTime) values(?,?,?,?,?,?,?,?,?,?)";
		Number id = jdbc.updateForGeneratedKey(sql, tradeChannelDetail.getTradeAccountID(),
				tradeChannelDetail.getChannelID(), tradeChannelDetail.getOrderCreateTime(),
				tradeChannelDetail.getPaymentTime(), tradeChannelDetail.getOrderNO(), tradeChannelDetail.getOpenID(),
				tradeChannelDetail.getErrorMsg(), tradeChannelDetail.getErrorCode(), tradeChannelDetail.getCreateTime(),
				tradeChannelDetail.getLastUpdateTime());
		return id.longValue();
	}

	@Override
	public void update(TradeChannelDetail tradeChannelDetail) {
		String sql = "update " + table + " set  tradeAccountID = ? , channelID = ? , orderCreateTime = ? , paymentTime = ? , orderNO = ? , openID = ? , errorMsg = ? , errorCode = ? , createTime = ? , lastUpdateTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,tradeChannelDetail.getTradeAccountID(),tradeChannelDetail.getChannelID(),tradeChannelDetail.getOrderCreateTime(),tradeChannelDetail.getPaymentTime(),tradeChannelDetail.getOrderNO(),tradeChannelDetail.getOpenID(),tradeChannelDetail.getErrorMsg(),tradeChannelDetail.getErrorCode(),tradeChannelDetail.getCreateTime(),tradeChannelDetail.getLastUpdateTime(), tradeChannelDetail.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradeChannelDetail> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradeChannelDetail.class, page);
	}
	@Override
	public List<TradeChannelDetail> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeChannelDetail.class);
	}
	
	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradeChannelDetail get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradeChannelDetail.class, id);
	}
	
	@Override
	public TradeChannelDetail getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradeChannelDetail.class, value);
	}

	@Override
	public TradeChannelDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradeChannelDetail.class, value1, value2);
	}

	@Override
	public TradeChannelDetail getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradeChannelDetail.class, value1, value2);
	}

	@Override
	public List<TradeChannelDetail> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradeChannelDetail.class, value);
	}

	@Override
	public List<TradeChannelDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeChannelDetail.class, value1, value2);
	}

	@Override
	public List<TradeChannelDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeChannelDetail.class, value1, value2);
	}

	@Override
	public List<TradeChannelDetail> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradeChannelDetail.class, page, param);
	}

	@Override
	public List<TradeChannelDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeChannelDetail.class, page, param);
	}

	@Override
	public List<TradeChannelDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeChannelDetail.class, page, param);
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
