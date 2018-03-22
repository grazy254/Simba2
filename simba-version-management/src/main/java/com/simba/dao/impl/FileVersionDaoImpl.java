package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.FileVersionDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.FileVersion;

/**
 * 文件版本管理 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class FileVersionDaoImpl implements FileVersionDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "fileVersion";

	@Override
	public void add(FileVersion fileVersion) {
		String sql = "insert into " + table + "( version, typeId, fileSize, fileUrl,description, createTime, extProps) values(?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, fileVersion.getVersion(), fileVersion.getTypeId(), fileVersion.getFileSize(), fileVersion.getFileUrl(), fileVersion.getDescription(), fileVersion.getCreateTime(),
				fileVersion.getExtProps());
	}

	@Override
	public void update(FileVersion fileVersion) {
		String sql = "update " + table + " set  version = ? , typeId = ? , fileSize = ? ,fileUrl = ? , description = ? , createTime = ? , extProps = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, fileVersion.getVersion(), fileVersion.getTypeId(), fileVersion.getFileSize(), fileVersion.getFileUrl(), fileVersion.getDescription(), fileVersion.getCreateTime(),
				fileVersion.getExtProps(), fileVersion.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<FileVersion> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, FileVersion.class, page);
	}

	@Override
	public List<FileVersion> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, FileVersion.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public FileVersion get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, FileVersion.class, id);
	}

	@Override
	public FileVersion getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, FileVersion.class, value);
	}

	@Override
	public FileVersion getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, FileVersion.class, value1, value2);
	}

	@Override
	public FileVersion getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, FileVersion.class, value1, value2);
	}

	@Override
	public List<FileVersion> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, FileVersion.class, value);
	}

	@Override
	public List<FileVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, FileVersion.class, value1, value2);
	}

	@Override
	public List<FileVersion> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, FileVersion.class, value1, value2);
	}

	@Override
	public List<FileVersion> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, FileVersion.class, page, param);
	}

	@Override
	public List<FileVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FileVersion.class, page, param);
	}

	@Override
	public List<FileVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FileVersion.class, page, param);
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
	public FileVersion getNewest(int typeId) {
		String sql = "select * from " + table + " where typeId = ? order by createTime desc limit 1 ";
		return jdbc.query(sql, FileVersion.class, typeId);
	}

}
