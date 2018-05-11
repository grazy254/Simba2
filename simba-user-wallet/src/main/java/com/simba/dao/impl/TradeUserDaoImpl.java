package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TradeUserDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.TradeUser;
/**
 * 钱包用户信息 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradeUserDaoImpl implements TradeUserDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradeUser";

	@Override
	public void add(TradeUser tradeUser) {
		String sql = "insert into " + table + "( userID, name, isAllowPay, payPassword, payPhone, payEmail, createTime, lastUpdateTime) values(?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, tradeUser.getUserID(),tradeUser.getName(),tradeUser.getIsAllowPay(),tradeUser.getPayPassword(),tradeUser.getPayPhone(),tradeUser.getPayEmail(),tradeUser.getCreateTime(),tradeUser.getLastUpdateTime());
	}

	@Override
	public void update(TradeUser tradeUser) {
		String sql = "update " + table + " set  userID = ? , name = ? , isAllowPay = ? , payPassword = ? , payPhone = ? , payEmail = ? , createTime = ? , lastUpdateTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,tradeUser.getUserID(),tradeUser.getName(),tradeUser.getIsAllowPay(),tradeUser.getPayPassword(),tradeUser.getPayPhone(),tradeUser.getPayEmail(),tradeUser.getCreateTime(),tradeUser.getLastUpdateTime(), tradeUser.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradeUser> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradeUser.class, page);
	}
	@Override
	public List<TradeUser> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeUser.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradeUser get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradeUser.class, id);
	}
	
	@Override
	public TradeUser getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradeUser.class, value);
	}

	@Override
	public TradeUser getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradeUser.class, value1, value2);
	}

	@Override
	public TradeUser getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradeUser.class, value1, value2);
	}

	@Override
	public List<TradeUser> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradeUser.class, value);
	}

	@Override
	public List<TradeUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeUser.class, value1, value2);
	}

	@Override
	public List<TradeUser> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeUser.class, value1, value2);
	}

	@Override
	public List<TradeUser> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradeUser.class, page, param);
	}

	@Override
	public List<TradeUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeUser.class, page, param);
	}

	@Override
	public List<TradeUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeUser.class, page, param);
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
