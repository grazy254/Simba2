package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.FileTypeDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.FileType;

/**
 * 文件类型管理 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class FileTypeDaoImpl implements FileTypeDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "fileType";

	@Override
	public void add(FileType fileType) {
		String sql = "insert into " + table + "( name) values(?)";
		jdbc.updateForBoolean(sql, fileType.getName());
	}

	@Override
	public void update(FileType fileType) {
		String sql = "update " + table + " set  name = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,fileType.getName(), fileType.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<FileType> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, FileType.class, page);
	}

	@Override
	public List<FileType> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, FileType.class);
	}

	@Override
	public int count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public FileType get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, FileType.class, id);
	}
	

	@Override
	public FileType getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, FileType.class, value);
	}
	


	@Override
	public FileType getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, FileType.class, value1, value2);
	}

	@Override
	public FileType getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, FileType.class, value1, value2);
	}

	@Override
	public List<FileType> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, FileType.class, value);
	}

	@Override
	public List<FileType> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, FileType.class, value1, value2);
	}

	@Override
	public List<FileType> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, FileType.class, value1, value2);
	}

	@Override
	public List<FileType> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, FileType.class, page, param);
	}

	@Override
	public List<FileType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FileType.class, page, param);
	}

	@Override
	public List<FileType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FileType.class, page, param);
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

}
