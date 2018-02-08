package com.simba.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.DeployLogDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.DeployLog;

/**
 * 部署日志 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class DeployLogDaoImpl implements DeployLogDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "deployLog";

	@Override
	public void add(DeployLog deployLog) {
		deployLog.setCreateTime(new Date());
		String sql = "insert into " + table + "( projectId, name, createTime) values(?,?,?)";
		jdbc.updateForBoolean(sql, deployLog.getProjectId(), deployLog.getName(), deployLog.getCreateTime());
	}

	@Override
	public void update(DeployLog deployLog) {
		deployLog.setCreateTime(new Date());
		String sql = "update " + table + " set  projectId = ? , name = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, deployLog.getProjectId(), deployLog.getName(), deployLog.getCreateTime(), deployLog.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<DeployLog> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, DeployLog.class, page);
	}

	@Override
	public List<DeployLog> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, DeployLog.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public DeployLog get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, DeployLog.class, id);
	}

	@Override
	public DeployLog getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, DeployLog.class, value);
	}

	@Override
	public DeployLog getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, DeployLog.class, value1, value2);
	}

	@Override
	public DeployLog getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, DeployLog.class, value1, value2);
	}

	@Override
	public List<DeployLog> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, DeployLog.class, value);
	}

	@Override
	public List<DeployLog> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, DeployLog.class, value1, value2);
	}

	@Override
	public List<DeployLog> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc ";
		return jdbc.queryForList(sql, DeployLog.class, value1, value2);
	}

	@Override
	public List<DeployLog> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, DeployLog.class, page, param);
	}

	@Override
	public List<DeployLog> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DeployLog.class, page, param);
	}

	@Override
	public List<DeployLog> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DeployLog.class, page, param);
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
