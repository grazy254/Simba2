package com.simba.dao.impl;

import com.simba.dao.ApkVersionDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ApkVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * apk管理 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ApkVersionDaoImpl implements ApkVersionDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "apkVersion";

	@Override
	public void add(ApkVersion apkVersion) {
		String sql = "insert into " + table + "( version, versionName, typeId, fileSize, fileUrl, description, createTime) values(?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, apkVersion.getVersion(),apkVersion.getVersionName(),apkVersion.getTypeId(),apkVersion.getFileSize(),apkVersion.getFileUrl(),apkVersion.getDescription(),apkVersion.getCreateTime());
	}

	@Override
	public void update(ApkVersion apkVersion) {
		String sql = "update " + table + " set  version = ? , versionName = ? , typeId = ? , fileSize = ? , fileUrl = ? , description = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,apkVersion.getVersion(),apkVersion.getVersionName(),apkVersion.getTypeId(),apkVersion.getFileSize(),apkVersion.getFileUrl(),apkVersion.getDescription(),apkVersion.getCreateTime(), apkVersion.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ApkVersion> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ApkVersion.class, page);
	}
	@Override
	public List<ApkVersion> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ApkVersion.class);
	}
	
	public Integer count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}
	
	@Override
	public ApkVersion get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ApkVersion.class, id);
	}
	
	@Override
	public ApkVersion getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ApkVersion.class, value);
	}

	@Override
	public ApkVersion getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ApkVersion.class, value1, value2);
	}

	@Override
	public ApkVersion getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ApkVersion.class, value1, value2);
	}

	@Override
	public List<ApkVersion> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ApkVersion.class, value);
	}

	@Override
	public List<ApkVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ApkVersion.class, value1, value2);
	}

	@Override
	public List<ApkVersion> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ApkVersion.class, value1, value2);
	}

	@Override
	public List<ApkVersion> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ApkVersion.class, page, param);
	}

	@Override
	public List<ApkVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ApkVersion.class, page, param);
	}

	@Override
	public List<ApkVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ApkVersion.class, page, param);
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
	public Integer countByOr(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForInt(sql, value1, value2);
	}
	
	@Override
	public Integer countByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForInt(sql, value1, value2);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "delete from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		String sql = "delete from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}

	@Override
	public ApkVersion getNewest(int typeId) {
		String sql = "select * from " + table + " where typeId = ? order by createTime desc limit 1 ";
		return jdbc.query(sql, ApkVersion.class, typeId);
	}
}
