package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ExceptionInfoDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ExceptionInfo;
import com.simba.model.form.ExceptionInfoSearchForm;

/**
 * 异常信息 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ExceptionInfoDaoImpl implements ExceptionInfoDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "exceptionInfo";

	@Override
	public void add(ExceptionInfo exceptionInfo) {
		String sql = "insert into " + table + "( ip, ipInfo, exceptionInfo, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, exceptionInfo.getIp(), exceptionInfo.getIpInfo(), exceptionInfo.getExceptionInfo(), exceptionInfo.getCreateTime());
	}

	@Override
	public void update(ExceptionInfo exceptionInfo) {
		String sql = "update " + table + " set  ip = ? , ipInfo = ? , exceptionInfo = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, exceptionInfo.getIp(), exceptionInfo.getIpInfo(), exceptionInfo.getExceptionInfo(), exceptionInfo.getCreateTime(), exceptionInfo.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ExceptionInfo> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, ExceptionInfo.class, page);
	}

	@Override
	public List<ExceptionInfo> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, ExceptionInfo.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public ExceptionInfo get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ExceptionInfo.class, id);
	}

	@Override
	public ExceptionInfo getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ExceptionInfo.class, value);
	}

	@Override
	public ExceptionInfo getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ExceptionInfo.class, value1, value2);
	}

	@Override
	public ExceptionInfo getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ExceptionInfo.class, value1, value2);
	}

	@Override
	public List<ExceptionInfo> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ExceptionInfo.class, value);
	}

	@Override
	public List<ExceptionInfo> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ExceptionInfo.class, value1, value2);
	}

	@Override
	public List<ExceptionInfo> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ExceptionInfo.class, value1, value2);
	}

	@Override
	public List<ExceptionInfo> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ExceptionInfo.class, page, param);
	}

	@Override
	public List<ExceptionInfo> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ExceptionInfo.class, page, param);
	}

	@Override
	public List<ExceptionInfo> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ExceptionInfo.class, page, param);
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
	public List<ExceptionInfo> page(Pager pager, ExceptionInfoSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, ExceptionInfo.class, pager, param);
	}

	@Override
	public Long count(ExceptionInfoSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, ExceptionInfoSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getIp())) {
			sql += " and ip = ? ";
			param.setString(searchForm.getIp());
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
