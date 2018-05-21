package com.simba.wallet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.wallet.dao.TradePartyDetailDao;
import com.simba.wallet.model.TradePartyDetail;
/**
 * 交易主体 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradePartyDetailDaoImpl implements TradePartyDetailDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradePartyDetail";

	@Override
	public Long add(TradePartyDetail tradePartyDetail) {
		String sql = "insert into " + table
				+ "( tradeUserID, partyName, partyType, tradeAccountID, ip, mobileNumber, device, noticeMail, location, createTime, createDate) values(?,?,?,?,?,?,?,?,?,?,?)";
		Number id = jdbc.updateForGeneratedKey(sql, tradePartyDetail.getTradeUserID(), tradePartyDetail.getPartyName(),
				tradePartyDetail.getPartyType(), tradePartyDetail.getTradeAccountID(), tradePartyDetail.getIp(),
				tradePartyDetail.getMobileNumber(), tradePartyDetail.getDevice(), tradePartyDetail.getNoticeMail(),
				tradePartyDetail.getLocation(), tradePartyDetail.getCreateTime(), tradePartyDetail.getCreateDate());
		return id.longValue();
	}

	@Override
	public void update(TradePartyDetail tradePartyDetail) {
		String sql = "update " + table + " set  tradeUserID = ? , partyName = ? , partyType = ? , tradeAccountID = ? , ip = ? , mobileNumber = ? , device = ? , noticeMail = ? , location = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,tradePartyDetail.getTradeUserID(),tradePartyDetail.getPartyName(),tradePartyDetail.getPartyType(),tradePartyDetail.getTradeAccountID(),tradePartyDetail.getIp(),tradePartyDetail.getMobileNumber(),tradePartyDetail.getDevice(),tradePartyDetail.getNoticeMail(),tradePartyDetail.getLocation(),tradePartyDetail.getCreateTime(), tradePartyDetail.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradePartyDetail> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradePartyDetail.class, page);
	}
	@Override
	public List<TradePartyDetail> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradePartyDetail.class);
	}
	
	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradePartyDetail get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradePartyDetail.class, id);
	}
	
	@Override
	public TradePartyDetail getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradePartyDetail.class, value);
	}

	@Override
	public TradePartyDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradePartyDetail.class, value1, value2);
	}

	@Override
	public TradePartyDetail getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradePartyDetail.class, value1, value2);
	}

	@Override
	public List<TradePartyDetail> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradePartyDetail.class, value);
	}

	@Override
	public List<TradePartyDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradePartyDetail.class, value1, value2);
	}

	@Override
	public List<TradePartyDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradePartyDetail.class, value1, value2);
	}

	@Override
	public List<TradePartyDetail> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ?";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradePartyDetail.class, page, param);
	}

	@Override
	public List<TradePartyDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradePartyDetail.class, page, param);
	}

	@Override
	public List<TradePartyDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradePartyDetail.class, page, param);
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
