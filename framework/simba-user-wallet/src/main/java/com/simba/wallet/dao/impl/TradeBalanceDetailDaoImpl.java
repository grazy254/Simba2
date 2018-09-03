package com.simba.wallet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.wallet.dao.TradeBalanceDetailDao;
import com.simba.wallet.model.TradeBalanceDetail;
/**
 *  Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradeBalanceDetailDaoImpl implements TradeBalanceDetailDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradeBalanceDetail";

	@Override
	public void add(TradeBalanceDetail tradeBalanceDetail) {
		String sql = "insert into " + table + "( tradeNo, balanceType, balanceAmount) values(?,?,?)";
		jdbc.updateForBoolean(sql, tradeBalanceDetail.getTradeNo(),tradeBalanceDetail.getBalanceType(),tradeBalanceDetail.getBalanceAmount());
	}

	@Override
	public void update(TradeBalanceDetail tradeBalanceDetail) {
		String sql = "update " + table + " set  tradeNo = ? , balanceType = ? , balanceAmount =?  where id = ?  ";
		jdbc.updateForBoolean(sql,tradeBalanceDetail.getTradeNo(),tradeBalanceDetail.getBalanceType(),tradeBalanceDetail.getBalanceAmount(), tradeBalanceDetail.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradeBalanceDetail> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradeBalanceDetail.class, page);
	}
	@Override
	public List<TradeBalanceDetail> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeBalanceDetail.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradeBalanceDetail get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradeBalanceDetail.class, id);
	}
	
	@Override
	public TradeBalanceDetail getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradeBalanceDetail.class, value);
	}

	@Override
	public TradeBalanceDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradeBalanceDetail.class, value1, value2);
	}

	@Override
	public TradeBalanceDetail getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradeBalanceDetail.class, value1, value2);
	}

	@Override
	public List<TradeBalanceDetail> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradeBalanceDetail.class, value);
	}

	@Override
	public List<TradeBalanceDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeBalanceDetail.class, value1, value2);
	}

	@Override
	public List<TradeBalanceDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeBalanceDetail.class, value1, value2);
	}

	@Override
	public List<TradeBalanceDetail> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradeBalanceDetail.class, page, param);
	}

	@Override
	public List<TradeBalanceDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeBalanceDetail.class, page, param);
	}

	@Override
	public List<TradeBalanceDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeBalanceDetail.class, page, param);
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
