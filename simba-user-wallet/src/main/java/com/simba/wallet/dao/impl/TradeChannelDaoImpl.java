package com.simba.wallet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.wallet.dao.TradeChannelDao;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.util.ErrConfig;
/**
 * 渠道信息 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradeChannelDaoImpl implements TradeChannelDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradeChannel";

	@Override
	public void add(TradeChannel tradeChannel) {
		String sql = "insert into " + table + "( name, type) values(?,?)";
		jdbc.updateForBoolean(sql, tradeChannel.getName(), tradeChannel.getType());
	}

	@Override
	public void update(TradeChannel tradeChannel) {
		String sql = "update " + table + " set  name = ? , type = ? where id = ?  ";
		jdbc.updateForBoolean(sql, tradeChannel.getName(), tradeChannel.getType(), tradeChannel.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradeChannel> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradeChannel.class, page);
	}
	@Override
	public List<TradeChannel> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeChannel.class);
	}
	
	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradeChannel get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradeChannel.class, id);
	}
	
	@Override
	public TradeChannel getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradeChannel.class, value);
	}

	@Override
	public TradeChannel getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradeChannel.class, value1, value2);
	}

	@Override
	public TradeChannel getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradeChannel.class, value1, value2);
	}

	@Override
	public List<TradeChannel> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradeChannel.class, value);
	}

	@Override
	public List<TradeChannel> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeChannel.class, value1, value2);
	}

	@Override
	public List<TradeChannel> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeChannel.class, value1, value2);
	}

	@Override
	public List<TradeChannel> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradeChannel.class, page, param);
	}

	@Override
	public List<TradeChannel> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeChannel.class, page, param);
	}

	@Override
	public List<TradeChannel> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeChannel.class, page, param);
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

	@Override
	public TradeChannel get(String type) {
		TradeChannel tradeChannel = getBy("type", type);
		if (tradeChannel == null) {
			throw ErrConfig.CHANNEL_NOT_EXIST_ERR;
		}
		return tradeChannel;
	}
}
