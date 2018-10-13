package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.simba.dao.ReceiveDealTypeDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ReceiveDealType;
import com.simba.model.form.DealTypeSearchForm;

/**
 * 处理接收消息类型 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ReceiveDealTypeDaoImpl implements ReceiveDealTypeDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "receiveDealType";

	@Override
	public void add(ReceiveDealType receiveDealType) {
		String sql = "insert into " + table + "( name, beanId, sync, description, ext) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, receiveDealType.getName(), receiveDealType.getBeanId(), receiveDealType.getSync(), receiveDealType.getDescription(), receiveDealType.getExt());
	}

	@Override
	@CacheEvict(cacheNames = "receiveDealType", allEntries = true)
	public void update(ReceiveDealType receiveDealType) {
		String sql = "update " + table + " set  name = ? , beanId = ? , sync = ? , description = ? , ext = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, receiveDealType.getName(), receiveDealType.getBeanId(), receiveDealType.getSync(), receiveDealType.getDescription(), receiveDealType.getExt(),
				receiveDealType.getId());
	}

	@Override
	@CacheEvict(cacheNames = "receiveDealType", allEntries = true)
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ReceiveDealType> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ReceiveDealType.class, page);
	}

	@Override
	public List<ReceiveDealType> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ReceiveDealType.class);
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public ReceiveDealType get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ReceiveDealType.class, id);
	}

	@Cacheable(cacheNames = "receiveDealType", key = "#field.concat(#value.toString())")
	@Override
	public ReceiveDealType getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ReceiveDealType.class, value);
	}

	@Override
	public ReceiveDealType getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveDealType.class, value1, value2);
	}

	@Override
	public ReceiveDealType getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveDealType.class, value1, value2);
	}

	@Override
	public List<ReceiveDealType> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ReceiveDealType.class, value);
	}

	@Override
	public List<ReceiveDealType> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ReceiveDealType.class, value1, value2);
	}

	@Override
	public List<ReceiveDealType> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ReceiveDealType.class, value1, value2);
	}

	@Override
	public List<ReceiveDealType> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ReceiveDealType.class, page, param);
	}

	@Override
	public List<ReceiveDealType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveDealType.class, page, param);
	}

	@Override
	public List<ReceiveDealType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveDealType.class, page, param);
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

	@Override
	public List<ReceiveDealType> page(Pager pager, DealTypeSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForPage(sql, ReceiveDealType.class, pager, param);
	}

	@Override
	public Integer count(DealTypeSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, DealTypeSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getBeanId())) {
			sql += " and beanId like '%" + searchForm.getBeanId() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getName())) {
			sql += " and name like '%" + searchForm.getName() + "%' ";
		}
		if (searchForm.getSync() != null) {
			sql += " and sync = ? ";
			param.setInt(searchForm.getSync());
		}
		return sql;
	}

}
