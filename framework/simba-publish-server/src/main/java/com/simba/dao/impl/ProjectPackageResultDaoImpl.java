package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ProjectPackageResultDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ProjectPackageResult;

/**
 * 项目打包结果 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ProjectPackageResultDaoImpl implements ProjectPackageResultDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "projectPackageResult";

	@Override
	public void add(ProjectPackageResult projectPackageResult) {
		String sql = "insert into " + table + "( projectId, filePath) values(?,?)";
		jdbc.updateForBoolean(sql, projectPackageResult.getProjectId(),projectPackageResult.getFilePath());
	}

	@Override
	public void update(ProjectPackageResult projectPackageResult) {
		String sql = "update " + table + " set  projectId = ? , filePath = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,projectPackageResult.getProjectId(),projectPackageResult.getFilePath(), projectPackageResult.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ProjectPackageResult> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ProjectPackageResult.class, page);
	}

	@Override
	public List<ProjectPackageResult> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ProjectPackageResult.class);
	}

	@Override
	public Integer count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public ProjectPackageResult get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ProjectPackageResult.class, id);
	}
	
	@Override
	public ProjectPackageResult getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ProjectPackageResult.class, value);
	}

	@Override
	public ProjectPackageResult getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ProjectPackageResult.class, value1, value2);
	}

	@Override
	public ProjectPackageResult getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ProjectPackageResult.class, value1, value2);
	}

	@Override
	public List<ProjectPackageResult> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ProjectPackageResult.class, value);
	}

	@Override
	public List<ProjectPackageResult> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectPackageResult.class, value1, value2);
	}

	@Override
	public List<ProjectPackageResult> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectPackageResult.class, value1, value2);
	}

	@Override
	public List<ProjectPackageResult> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ProjectPackageResult.class, page, param);
	}

	@Override
	public List<ProjectPackageResult> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectPackageResult.class, page, param);
	}

	@Override
	public List<ProjectPackageResult> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectPackageResult.class, page, param);
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
}
