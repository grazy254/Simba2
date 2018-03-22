package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.RealTimeMessageDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.RealTimeMessage;
import com.simba.model.form.RealTimeMessageSearchForm;

/**
 * 设备功能表 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class RealTimeMessageDaoImpl implements RealTimeMessageDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "realTimeMessage";

	@Override
	public void add(RealTimeMessage realTimeMessage) {
		String sql = "insert into " + table + "( userId, message, createTime) values(?,?,?)";
		jdbc.updateForBoolean(sql, realTimeMessage.getUserId(), realTimeMessage.getMessage(), realTimeMessage.getCreateTime());
	}

	@Override
	public void update(RealTimeMessage realTimeMessage) {
		String sql = "update " + table + " set  userId = ? , message = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, realTimeMessage.getUserId(), realTimeMessage.getMessage(), realTimeMessage.getCreateTime(), realTimeMessage.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<RealTimeMessage> page(Pager page) {
		
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, RealTimeMessage.class, page);
	}

	@Override
	public List<RealTimeMessage> page(Pager page, RealTimeMessageSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, RealTimeMessage.class, page, param);
	}

	@Override
	public List<RealTimeMessage> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, RealTimeMessage.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public RealTimeMessage get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, RealTimeMessage.class, id);
	}

	@Override
	public RealTimeMessage getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, RealTimeMessage.class, value);
	}

	@Override
	public RealTimeMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, RealTimeMessage.class, value1, value2);
	}

	@Override
	public RealTimeMessage getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, RealTimeMessage.class, value1, value2);
	}

	@Override
	public List<RealTimeMessage> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, RealTimeMessage.class, value);
	}

	@Override
	public List<RealTimeMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, RealTimeMessage.class, value1, value2);
	}

	@Override
	public List<RealTimeMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, RealTimeMessage.class, value1, value2);
	}

	@Override
	public List<RealTimeMessage> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, RealTimeMessage.class, page, param);
	}

	@Override
	public List<RealTimeMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, RealTimeMessage.class, page, param);
	}

	@Override
	public List<RealTimeMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, RealTimeMessage.class, page, param);
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

	// new add
	private String buildCondition(String sql, RealTimeMessageSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (searchForm.getUserId() != null && searchForm.getUserId() > 0) {
			sql += " and userId = ? ";
			param.setInt(searchForm.getUserId());
		}
		if (StringUtils.isNotEmpty(searchForm.getMessage())) {
			sql += " and message like '%" + searchForm.getMessage() + "%'";
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
	// new add end !!!

}
