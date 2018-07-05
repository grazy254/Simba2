package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.simba.dao.UserProjectDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.UserProject;
import com.simba.model.form.ProjectSearchForm;

/**
 * 项目 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class UserProjectDaoImpl implements UserProjectDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "project";

	@Override
	public void add(UserProject project) {
		String sql = "insert into " + table + "( code, name, projectKey, loginSuccessUrl, forgetBackUrl, createTime, createUserAccount) values(?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, project.getCode(), project.getName(), project.getProjectKey(), project.getLoginSuccessUrl(), project.getForgetBackUrl(), project.getCreateTime(),
				project.getCreateUserAccount());
	}

	@Override
	@CacheEvict(cacheNames = "project", allEntries = true)
	public void update(UserProject project) {
		String sql = "update " + table + " set  code = ? , name = ? , projectKey = ? , loginSuccessUrl = ? , forgetBackUrl = ? , createTime = ? , createUserAccount = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, project.getCode(), project.getName(), project.getProjectKey(), project.getLoginSuccessUrl(), project.getForgetBackUrl(), project.getCreateTime(),
				project.getCreateUserAccount(), project.getId());
	}

	@Override
	@CacheEvict(cacheNames = "project", allEntries = true)
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<UserProject> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, UserProject.class, page);
	}

	@Override
	public List<UserProject> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, UserProject.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public UserProject get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, UserProject.class, id);
	}

	@Override
	@Cacheable(cacheNames = "project", key = "#field.concat(#value.toString())")
	public UserProject getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, UserProject.class, value);
	}

	@Override
	public UserProject getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, UserProject.class, value1, value2);
	}

	@Override
	public UserProject getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, UserProject.class, value1, value2);
	}

	@Override
	public List<UserProject> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UserProject.class, value);
	}

	@Override
	public List<UserProject> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UserProject.class, value1, value2);
	}

	@Override
	public List<UserProject> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UserProject.class, value1, value2);
	}

	@Override
	public List<UserProject> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, UserProject.class, page, param);
	}

	@Override
	public List<UserProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UserProject.class, page, param);
	}

	@Override
	public List<UserProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UserProject.class, page, param);
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
	public List<UserProject> page(Pager pager, ProjectSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, UserProject.class, pager, param);
	}

	@Override
	public int count(ProjectSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, ProjectSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getAccount())) {
			sql += " and createUserAccount like '%" + searchForm.getAccount() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getName())) {
			sql += " and name like '%" + searchForm.getName() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getCode())) {
			sql += " and code like '%" + searchForm.getCode() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		return sql;
	}

}
