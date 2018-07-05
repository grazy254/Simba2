package com.simba.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.DevProjectDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.DevProject;

/**
 * 项目 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class DevProjectDaoImpl implements DevProjectDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "devProject";

	@Override
	public int add(DevProject devProject) {
		devProject.setCreateTime(new Date());
		String sql = "insert into " + table + "( code, name, versionType, account, pwd, versionUrl, packageCommandFile, startParams, createTime,notifyEmails) values(?,?,?,?,?,?,?,?,?,?)";
		Number n = jdbc.updateForGeneratedKey(sql, devProject.getCode(), devProject.getName(), devProject.getVersionType(), devProject.getAccount(), devProject.getPwd(), devProject.getVersionUrl(),
				devProject.getPackageCommandFile(), devProject.getStartParams(), devProject.getCreateTime(), devProject.getNotifyEmails());
		return n.intValue();
	}

	@Override
	public void update(DevProject devProject) {
		devProject.setCreateTime(new Date());
		String sql = "update " + table
				+ " set  code = ? , name = ? , versionType = ? , account = ? , pwd = ? , versionUrl = ? , packageCommandFile = ? , startParams = ? , createTime = ? , notifyEmails = ? where id = ?  ";
		jdbc.updateForBoolean(sql, devProject.getCode(), devProject.getName(), devProject.getVersionType(), devProject.getAccount(), devProject.getPwd(), devProject.getVersionUrl(),
				devProject.getPackageCommandFile(), devProject.getStartParams(), devProject.getCreateTime(), devProject.getNotifyEmails(), devProject.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<DevProject> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, DevProject.class, page);
	}

	@Override
	public List<DevProject> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, DevProject.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public DevProject get(int id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, DevProject.class, id);
	}

	@Override
	public DevProject getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, DevProject.class, value);
	}

	@Override
	public DevProject getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, DevProject.class, value1, value2);
	}

	@Override
	public DevProject getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, DevProject.class, value1, value2);
	}

	@Override
	public List<DevProject> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, DevProject.class, value);
	}

	@Override
	public List<DevProject> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, DevProject.class, value1, value2);
	}

	@Override
	public List<DevProject> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, DevProject.class, value1, value2);
	}

	@Override
	public List<DevProject> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, DevProject.class, page, param);
	}

	@Override
	public List<DevProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DevProject.class, page, param);
	}

	@Override
	public List<DevProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DevProject.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

	@Override
	public int countByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForInt(sql, value1, value2);
	}

	@Override
	public int countByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForInt(sql, value1, value2);
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
