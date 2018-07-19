package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.DictionaryDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Dictionary;

/**
 * 字典 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class DictionaryDaoImpl implements DictionaryDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "dictionary";

	@Override
	public void add(Dictionary dictionary) {
		String sql = "insert into " + table + "( typeId, name, value,orderNo) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, dictionary.getTypeId(), dictionary.getName(), dictionary.getValue(), dictionary.getOrderNo());
	}

	@Override
	public void update(Dictionary dictionary) {
		String sql = "update " + table + " set  typeId = ? , name = ? , value = ? , orderNo = ? where id = ?  ";
		jdbc.updateForBoolean(sql, dictionary.getTypeId(), dictionary.getName(), dictionary.getValue(), dictionary.getOrderNo(), dictionary.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Dictionary> page(Pager page) {
		String sql = "select * from " + table + " order by orderNo";
		return jdbc.queryForPage(sql, Dictionary.class, page);
	}

	@Override
	public List<Dictionary> listAll() {
		String sql = "select * from " + table + " order by orderNo";
		return jdbc.queryForList(sql, Dictionary.class);
	}

	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public Dictionary get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Dictionary.class, id);
	}

	@Override
	public Dictionary getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Dictionary.class, value);
	}

	@Override
	public Dictionary getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Dictionary.class, value1, value2);
	}

	@Override
	public Dictionary getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Dictionary.class, value1, value2);
	}

	@Override
	public List<Dictionary> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by orderNo";
		return jdbc.queryForList(sql, Dictionary.class, value);
	}

	@Override
	public List<Dictionary> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by orderNo";
		return jdbc.queryForList(sql, Dictionary.class, value1, value2);
	}

	@Override
	public List<Dictionary> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by orderNo";
		return jdbc.queryForList(sql, Dictionary.class, value1, value2);
	}

	@Override
	public List<Dictionary> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by orderNo";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Dictionary.class, page, param);
	}

	@Override
	public List<Dictionary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by orderNo";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Dictionary.class, page, param);
	}

	@Override
	public List<Dictionary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by orderNo";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Dictionary.class, page, param);
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
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}

	@Override
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "delete from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "delete from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}
}
