package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.FAQTypeDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.FAQType;

/**
 * 常见问题类型管理 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class FAQTypeDaoImpl implements FAQTypeDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "fAQType";

	@Override
	public void add(FAQType fAQType) {
		String sql = "insert into " + table + "( type) values(?)";
		jdbc.updateForBoolean(sql, fAQType.getType());
	}

	@Override
	public void update(FAQType fAQType) {
		String sql = "update " + table + " set  type = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,fAQType.getType(), fAQType.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<FAQType> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, FAQType.class, page);
	}

	@Override
	public List<FAQType> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, FAQType.class);
	}

	@Override
	public Integer count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public FAQType get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, FAQType.class, id);
	}
	
	@Override
	public FAQType getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, FAQType.class, value);
	}

	@Override
	public FAQType getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, FAQType.class, value1, value2);
	}

	@Override
	public FAQType getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, FAQType.class, value1, value2);
	}

	@Override
	public List<FAQType> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, FAQType.class, value);
	}

	@Override
	public List<FAQType> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, FAQType.class, value1, value2);
	}

	@Override
	public List<FAQType> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, FAQType.class, value1, value2);
	}

	@Override
	public List<FAQType> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, FAQType.class, page, param);
	}

	@Override
	public List<FAQType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FAQType.class, page, param);
	}

	@Override
	public List<FAQType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FAQType.class, page, param);
	}
	
	@Override
	public Integer countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}
	
	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

}
