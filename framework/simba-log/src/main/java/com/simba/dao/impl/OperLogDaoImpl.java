package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.OperLogDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.OperLog;
import com.simba.model.form.OperLogSearchForm;

/**
 * 操作日志 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class OperLogDaoImpl implements OperLogDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "operLog";

	@Override
	public void add(OperLog operLog) {
		String sql = "insert into " + table + "( account, ip, address, content, createTime) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, operLog.getAccount(), operLog.getIp(), operLog.getAddress(), operLog.getContent(), operLog.getCreateTime());
	}

	@Override
	public void update(OperLog operLog) {
		String sql = "update " + table + " set  account = ? , ip = ? , address = ? , content = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, operLog.getAccount(), operLog.getIp(), operLog.getAddress(), operLog.getContent(), operLog.getCreateTime(), operLog.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<OperLog> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, OperLog.class, page);
	}

	@Override
	public List<OperLog> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, OperLog.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public OperLog get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, OperLog.class, id);
	}

	@Override
	public OperLog getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, OperLog.class, value);
	}

	@Override
	public OperLog getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, OperLog.class, value1, value2);
	}

	@Override
	public OperLog getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, OperLog.class, value1, value2);
	}

	@Override
	public List<OperLog> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, OperLog.class, value);
	}

	@Override
	public List<OperLog> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, OperLog.class, value1, value2);
	}

	@Override
	public List<OperLog> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, OperLog.class, value1, value2);
	}

	@Override
	public List<OperLog> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, OperLog.class, page, param);
	}

	@Override
	public List<OperLog> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, OperLog.class, page, param);
	}

	@Override
	public List<OperLog> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, OperLog.class, page, param);
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
	public List<OperLog> page(Pager pager, OperLogSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, OperLog.class, pager, param);
	}

	@Override
	public Long count(OperLogSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, OperLogSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getIp())) {
			sql += " and ip = ? ";
			param.setString(searchForm.getIp());
		}
		if (StringUtils.isNotEmpty(searchForm.getAccount())) {
			sql += " and account = ? ";
			param.setString(searchForm.getAccount());
		}
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		return sql;
	}

}
