package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ProjectDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Project;

/**
 * Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "project";

	@Override
	public void add(Project project) {
		String sql = "insert into " + table + "( code, name) values(?,?)";
		jdbc.updateForBoolean(sql, project.getCode(), project.getName());
	}

	@Override
	public void add(String sessAccount, Project project) {
		String sqlProject = "insert into " + table + "( code, name) values(?,?)";
		Number id = jdbc.updateForGeneratedKey(sqlProject, project.getCode(), project.getName());
		String sqlProjectUser = "insert into projectUser" + "( account, projectId, type) values(?,?,?)";
		jdbc.updateForBoolean(sqlProjectUser, sessAccount, id.intValue(), 1);
	}

	@Override
	public void update(Project project) {
		String sql = "update " + table + " set  code = ? , name = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, project.getCode(), project.getName(), project.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Project> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Project.class, page);
	}

	@Override
	public List<Project> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Project.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public Project get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Project.class, id);
	}

	@Override
	public Project getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Project.class, value);
	}

	@Override
	public Project getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Project.class, value1, value2);
	}

	@Override
	public Project getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Project.class, value1, value2);
	}

	@Override
	public List<Project> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Project.class, value);
	}

	@Override
	public List<Project> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Project.class, value1, value2);
	}

	@Override
	public List<Project> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Project.class, value1, value2);
	}

	@Override
	public List<Project> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Project.class, page, param);
	}

	@Override
	public List<Project> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Project.class, page, param);
	}

	@Override
	public List<Project> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Project.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from projectUser where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

}
