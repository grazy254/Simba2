package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TradePartyDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.TradeParty;
/**
 * 交易主体 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradePartyDaoImpl implements TradePartyDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradeParty";

	@Override
	public void add(TradeParty tradeParty) {
		String sql = "insert into " + table + "( tradeUserID, partyName, partyType, tradeAccountID, ip, mobileNumber, device, noticeMail, location, createTime) values(?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, tradeParty.getTradeUserID(),tradeParty.getPartyName(),tradeParty.getPartyType(),tradeParty.getTradeAccountID(),tradeParty.getIp(),tradeParty.getMobileNumber(),tradeParty.getDevice(),tradeParty.getNoticeMail(),tradeParty.getLocation(),tradeParty.getCreateTime());
	}

	@Override
	public void update(TradeParty tradeParty) {
		String sql = "update " + table + " set  tradeUserID = ? , partyName = ? , partyType = ? , tradeAccountID = ? , ip = ? , mobileNumber = ? , device = ? , noticeMail = ? , location = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,tradeParty.getTradeUserID(),tradeParty.getPartyName(),tradeParty.getPartyType(),tradeParty.getTradeAccountID(),tradeParty.getIp(),tradeParty.getMobileNumber(),tradeParty.getDevice(),tradeParty.getNoticeMail(),tradeParty.getLocation(),tradeParty.getCreateTime(), tradeParty.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradeParty> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradeParty.class, page);
	}
	@Override
	public List<TradeParty> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeParty.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradeParty get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradeParty.class, id);
	}
	
	@Override
	public TradeParty getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradeParty.class, value);
	}

	@Override
	public TradeParty getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradeParty.class, value1, value2);
	}

	@Override
	public TradeParty getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradeParty.class, value1, value2);
	}

	@Override
	public List<TradeParty> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradeParty.class, value);
	}

	@Override
	public List<TradeParty> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeParty.class, value1, value2);
	}

	@Override
	public List<TradeParty> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeParty.class, value1, value2);
	}

	@Override
	public List<TradeParty> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradeParty.class, page, param);
	}

	@Override
	public List<TradeParty> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeParty.class, page, param);
	}

	@Override
	public List<TradeParty> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeParty.class, page, param);
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
