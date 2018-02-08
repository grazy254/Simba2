package com.simba.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ProjectUserDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ProjectUser;
import com.simba.permission.model.User;

/**
 * Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ProjectUserDaoImpl implements ProjectUserDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "projectUser";

	@Override
	public void add(ProjectUser projectUser) {
		String sql = "insert into " + table + "( account, projectId, type) values(?,?,?)";
		jdbc.updateForBoolean(sql, projectUser.getAccount(), projectUser.getProjectId(), projectUser.getType());
	}

	@Override
	public void update(ProjectUser projectUser) {
		String sql = "update " + table + " set  account = ? , projectId = ? , type = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, projectUser.getAccount(), projectUser.getProjectId(), projectUser.getType(), projectUser.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ProjectUser> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ProjectUser.class, page);
	}

	@Override
	public List<ProjectUser> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ProjectUser.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public ProjectUser get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ProjectUser.class, id);
	}

	@Override
	public ProjectUser getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ProjectUser.class, value);
	}

	@Override
	public ProjectUser getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ProjectUser.class, value1, value2);
	}

	@Override
	public ProjectUser getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ProjectUser.class, value1, value2);
	}

	@Override
	public List<ProjectUser> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ProjectUser.class, value);
	}

	@Override
	public List<ProjectUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectUser.class, value1, value2);
	}

	@Override
	public List<ProjectUser> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectUser.class, value1, value2);
	}

	@Override
	public List<ProjectUser> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ProjectUser.class, page, param);
	}

	@Override
	public List<ProjectUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectUser.class, page, param);
	}

	@Override
	public List<ProjectUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectUser.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public List<User> pageByProjectId(String field, Object value, Pager page) {
		String sql1 = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		List<ProjectUser> projectUsers = jdbc.queryForList(sql1, ProjectUser.class, param);
		List<String> accountList = new ArrayList<>();
		for (ProjectUser projectUser : projectUsers) {
			accountList.add(projectUser.getAccount());
		}
		String sql2 = "select * from systemUser where 1=0 ";
		StatementParameter paramAccount = new StatementParameter();
		for (int i = 0; i < projectUsers.size(); i++) {
			sql2 += " or account=? ";
			paramAccount.set(accountList.get(i));
		}
		List<User> userList = jdbc.queryForPage(sql2, User.class, page, paramAccount);
		return userList;
	}

	@Override
	public int countUser(int projectId) {
		String sql = "select count(*) from " + table + " where projectId = ? ";
		StatementParameter param = new StatementParameter();
		param.set(projectId);
		return jdbc.queryForInt(sql, param);
	}

	@Override
	public void deleteUser(String account, Integer projectId) {
		String sql = "delete from " + table + " where account = ? " + " and " + " projectId=? ";
		Object[] objects = { account, projectId };
		StatementParameter param = new StatementParameter();
		param.set(objects);
		jdbc.updateForBoolean(sql, param);
	}

	@Override
	public Integer getUserType(String account, Integer projectId) {
		String sql = "select * from " + table + " where account = ? " + " and " + " projectId=? ";
		Object[] objects = { account, projectId };
		StatementParameter param = new StatementParameter();
		param.set(objects);
		return jdbc.query(sql, ProjectUser.class, param).getType();
	}

	@Override
	public List<User> listByProjectId(Integer projectId) {
		String sql1 = "select * from " + table + " where " + "projectId" + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(projectId);
		List<ProjectUser> projectUsers = jdbc.queryForList(sql1, ProjectUser.class, param);
		List<String> accountList = new ArrayList<>();
		for (ProjectUser projectUser : projectUsers) {
			accountList.add(projectUser.getAccount());
		}
		String sql2 = "select * from systemUser where 1=0 ";
		StatementParameter paramAccount = new StatementParameter();
		for (int i = 0; i < projectUsers.size(); i++) {
			sql2 += " or account=? ";
			paramAccount.set(accountList.get(i));
		}
		List<User> userList = jdbc.queryForList(sql2, User.class, paramAccount);
		return userList;
	}

	@Override
	public void deleteByProjectId(Integer projectId, String account) {
		String sql = "delete from " + table + " where projectId = ? and account != ? ";
		jdbc.updateForBoolean(sql, projectId, account);
	}

	@Override
	public void deleteByProjectId(int projectId) {
		String sql = "delete from " + table + " where projectId = ? ";
		jdbc.updateForBoolean(sql, projectId);
	}

}
