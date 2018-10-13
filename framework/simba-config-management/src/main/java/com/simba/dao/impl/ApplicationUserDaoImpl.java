package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ApplicationUserDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ApplicationUser;

/**
 * 用户应用表 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ApplicationUserDaoImpl implements ApplicationUserDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "applicationUser";

	@Override
	public void add(ApplicationUser applicationUser) {
		String sql = "insert into " + table + "( applicationId, userId, userType) values(?,?,?)";
		jdbc.updateForBoolean(sql, applicationUser.getApplicationId(),applicationUser.getUserId(),applicationUser.getUserType());
	}

	@Override
	public void update(ApplicationUser applicationUser) {
		String sql = "update " + table + " set  applicationId = ? , userId = ? , userType = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,applicationUser.getApplicationId(),applicationUser.getUserId(),applicationUser.getUserType(), applicationUser.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ApplicationUser> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ApplicationUser.class, page);
	}

	@Override
	public List<ApplicationUser> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ApplicationUser.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public ApplicationUser get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ApplicationUser.class, id);
	}
	
	@Override
	public ApplicationUser getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ApplicationUser.class, value);
	}

	@Override
	public ApplicationUser getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ApplicationUser.class, value1, value2);
	}

	@Override
	public ApplicationUser getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ApplicationUser.class, value1, value2);
	}

	@Override
	public List<ApplicationUser> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ApplicationUser.class, value);
	}

	@Override
	public List<ApplicationUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ApplicationUser.class, value1, value2);
	}

	@Override
	public List<ApplicationUser> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ApplicationUser.class, value1, value2);
	}

	@Override
	public List<ApplicationUser> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ApplicationUser.class, page, param);
	}

	@Override
	public List<ApplicationUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ApplicationUser.class, page, param);
	}

	@Override
	public List<ApplicationUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ApplicationUser.class, page, param);
	}
	
	@Override
	public Long countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForLong(sql, value);
	}
	
	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

}
