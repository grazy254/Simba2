package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.IOSVersionDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.IOSVersion;

/**
 * IOS安装包版本管理 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class IOSVersionDaoImpl implements IOSVersionDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "iOSVersion";

	@Override
	public void add(IOSVersion iOSVersion) {
		String sql = "insert into " + table + "( version, fileSize, description, createTime, identifer, title, ipaFileUrl, fullImageFileUrl, logFileUrl,typeId) values(?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, iOSVersion.getVersion(), iOSVersion.getFileSize(), iOSVersion.getDescription(), iOSVersion.getCreateTime(), iOSVersion.getIdentifer(), iOSVersion.getTitle(),
				iOSVersion.getIpaFileUrl(), iOSVersion.getFullImageFileUrl(), iOSVersion.getLogFileUrl(), iOSVersion.getTypeId());
	}

	@Override
	public void update(IOSVersion iOSVersion) {
		String sql = "update " + table
				+ " set  version = ? , fileSize = ? , description = ? , createTime = ? , identifer = ? , title = ? , ipaFileUrl = ? , fullImageFileUrl = ? , logFileUrl = ? , typeId = ? where id = ?  ";
		jdbc.updateForBoolean(sql, iOSVersion.getVersion(), iOSVersion.getFileSize(), iOSVersion.getDescription(), iOSVersion.getCreateTime(), iOSVersion.getIdentifer(), iOSVersion.getTitle(),
				iOSVersion.getIpaFileUrl(), iOSVersion.getFullImageFileUrl(), iOSVersion.getLogFileUrl(), iOSVersion.getTypeId(), iOSVersion.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<IOSVersion> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, IOSVersion.class, page);
	}

	@Override
	public List<IOSVersion> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, IOSVersion.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public IOSVersion get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, IOSVersion.class, id);
	}

	@Override
	public IOSVersion getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, IOSVersion.class, value);
	}

	@Override
	public IOSVersion getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, IOSVersion.class, value1, value2);
	}

	@Override
	public IOSVersion getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, IOSVersion.class, value1, value2);
	}

	@Override
	public List<IOSVersion> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, IOSVersion.class, value);
	}

	@Override
	public List<IOSVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, IOSVersion.class, value1, value2);
	}

	@Override
	public List<IOSVersion> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, IOSVersion.class, value1, value2);
	}

	@Override
	public List<IOSVersion> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, IOSVersion.class, page, param);
	}

	@Override
	public List<IOSVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, IOSVersion.class, page, param);
	}

	@Override
	public List<IOSVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, IOSVersion.class, page, param);
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
	public IOSVersion getNewestVersion() {
		String sql = "select * from " + table + " order by createTime desc limit 1 ";
		return jdbc.query(sql, IOSVersion.class);
	}

}
