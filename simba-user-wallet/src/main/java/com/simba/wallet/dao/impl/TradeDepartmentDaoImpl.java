package com.simba.wallet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.wallet.dao.TradeDepartmentDao;
import com.simba.wallet.model.TradeDepartment;
/**
 * 收款部门 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TradeDepartmentDaoImpl implements TradeDepartmentDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tradeDepartment";

	@Override
	public void add(TradeDepartment tradeDepartment) {
		String sql = "insert into " + table + "( deptNO, deptName) values(?,?)";
		jdbc.updateForBoolean(sql, tradeDepartment.getDeptNO(), tradeDepartment.getDeptName());
	}

	@Override
	public void update(TradeDepartment tradeDepartment) {
		String sql = "update " + table + " set  deptNO = ? , deptName = ? where id = ?  ";
		jdbc.updateForBoolean(sql, tradeDepartment.getDeptNO(), tradeDepartment.getDeptName(), tradeDepartment.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TradeDepartment> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TradeDepartment.class, page);
	}
	@Override
	public List<TradeDepartment> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TradeDepartment.class);
	}
	
	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public TradeDepartment get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TradeDepartment.class, id);
	}
	
	@Override
	public TradeDepartment getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TradeDepartment.class, value);
	}

	@Override
	public TradeDepartment getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TradeDepartment.class, value1, value2);
	}

	@Override
	public TradeDepartment getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TradeDepartment.class, value1, value2);
	}

	@Override
	public List<TradeDepartment> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TradeDepartment.class, value);
	}

	@Override
	public List<TradeDepartment> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeDepartment.class, value1, value2);
	}

	@Override
	public List<TradeDepartment> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TradeDepartment.class, value1, value2);
	}

	@Override
	public List<TradeDepartment> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TradeDepartment.class, page, param);
	}

	@Override
	public List<TradeDepartment> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeDepartment.class, page, param);
	}

	@Override
	public List<TradeDepartment> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TradeDepartment.class, page, param);
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
