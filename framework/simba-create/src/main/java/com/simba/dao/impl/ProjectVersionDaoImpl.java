package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ProjectVersionDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ProjectVersion;

/**
 * 项目版本 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ProjectVersionDaoImpl implements ProjectVersionDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "projectVersion";

	@Override
	public void add(ProjectVersion projectVersion) {
		String sql = "insert into " + table + "( versionNo, filePath, createTime) values(?,?,?)";
		jdbc.updateForBoolean(sql, projectVersion.getVersionNo(),projectVersion.getFilePath(),projectVersion.getCreateTime());
	}

	@Override
	public void update(ProjectVersion projectVersion) {
		String sql = "update " + table + " set  versionNo = ? , filePath = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,projectVersion.getVersionNo(),projectVersion.getFilePath(),projectVersion.getCreateTime(), projectVersion.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ProjectVersion> page(Pager page) {
		String sql = "select * from " + table +" order by createTime desc";
		return jdbc.queryForPage(sql, ProjectVersion.class, page);
	}

	@Override
	public List<ProjectVersion> listAll(){
		String sql = "select * from " + table+" order by createTime desc";
		return jdbc.queryForList(sql, ProjectVersion.class);
	}

	@Override
	public Integer count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public ProjectVersion get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ProjectVersion.class, id);
	}
	
	@Override
	public ProjectVersion getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ProjectVersion.class, value);
	}

	@Override
	public ProjectVersion getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ProjectVersion.class, value1, value2);
	}

	@Override
	public ProjectVersion getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ProjectVersion.class, value1, value2);
	}

	@Override
	public List<ProjectVersion> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ProjectVersion.class, value);
	}

	@Override
	public List<ProjectVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ProjectVersion.class, value1, value2);
	}

	@Override
	public List<ProjectVersion> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ProjectVersion.class, value1, value2);
	}

	@Override
	public List<ProjectVersion> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ProjectVersion.class, page, param);
	}

	@Override
	public List<ProjectVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectVersion.class, page, param);
	}

	@Override
	public List<ProjectVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectVersion.class, page, param);
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

}
