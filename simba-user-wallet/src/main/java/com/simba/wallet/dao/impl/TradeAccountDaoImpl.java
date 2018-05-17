package com.simba.wallet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.model.TradeAccount;
/**
 * 支付账号 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradeAccountDaoImpl implements TradeAccountDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradeAccount";

	@Override
	public long add(TradeAccount tradeAccount) {
		String sql = "insert into " + table + "( tradeUserID, accountID, accountType, feeType, isAllowRecharge, isAllowPay, isActive, isFrozen, accountBalance, availableBalance, frozenBalance, createTime, lastUpdateTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Number id = jdbc.updateForGeneratedKey(sql, tradeAccount.getTradeUserID(),tradeAccount.getAccountID(),tradeAccount.getAccountType(),tradeAccount.getFeeType(),tradeAccount.getIsAllowRecharge(),tradeAccount.getIsAllowPay(),tradeAccount.getIsActive(),tradeAccount.getIsFrozen(),tradeAccount.getAccountBalance(),tradeAccount.getAvailableBalance(),tradeAccount.getFrozenBalance(),tradeAccount.getCreateTime(),tradeAccount.getLastUpdateTime());
		return id.longValue();
	}

	@Override
	public void update(TradeAccount tradeAccount) {
		String sql = "update " + table + " set  tradeUserID = ? , accountID = ? , accountType = ? , feeType = ? , isAllowRecharge = ? , isAllowPay = ? , isActive = ? , isFrozen = ? , accountBalance = ? , availableBalance = ? , frozenBalance = ? , createTime = ? , lastUpdateTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,tradeAccount.getTradeUserID(),tradeAccount.getAccountID(),tradeAccount.getAccountType(),tradeAccount.getFeeType(),tradeAccount.getIsAllowRecharge(),tradeAccount.getIsAllowPay(),tradeAccount.getIsActive(),tradeAccount.getIsFrozen(),tradeAccount.getAccountBalance(),tradeAccount.getAvailableBalance(),tradeAccount.getFrozenBalance(),tradeAccount.getCreateTime(),tradeAccount.getLastUpdateTime(), tradeAccount.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradeAccount> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradeAccount.class, page);
	}
	@Override
	public List<TradeAccount> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeAccount.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradeAccount get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradeAccount.class, id);
	}
	
	@Override
	public TradeAccount getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradeAccount.class, value);
	}

	@Override
	public TradeAccount getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradeAccount.class, value1, value2);
	}

	@Override
	public TradeAccount getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradeAccount.class, value1, value2);
	}

	@Override
	public List<TradeAccount> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradeAccount.class, value);
	}

	@Override
	public List<TradeAccount> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeAccount.class, value1, value2);
	}

	@Override
	public List<TradeAccount> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeAccount.class, value1, value2);
	}

	@Override
	public List<TradeAccount> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradeAccount.class, page, param);
	}

	@Override
	public List<TradeAccount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeAccount.class, page, param);
	}

	@Override
	public List<TradeAccount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeAccount.class, page, param);
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
