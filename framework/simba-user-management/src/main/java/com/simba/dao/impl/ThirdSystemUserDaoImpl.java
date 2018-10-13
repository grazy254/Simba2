package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ThirdSystemUserDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ThirdSystemUser;

/**
 *  Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ThirdSystemUserDaoImpl implements ThirdSystemUserDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "thirdSystemUser";

	@Override
	public void add(ThirdSystemUser thirdSystemUser) {
		String sql = "insert into " + table + "( userId, thirdSystem, thirdSystemUserId) values(?,?,?)";
		jdbc.updateForBoolean(sql, thirdSystemUser.getUserId(),thirdSystemUser.getThirdSystem(),thirdSystemUser.getThirdSystemUserId());
	}

	@Override
	public void update(ThirdSystemUser thirdSystemUser) {
		String sql = "update " + table + " set  userId = ? , thirdSystem = ? , thirdSystemUserId = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,thirdSystemUser.getUserId(),thirdSystemUser.getThirdSystem(),thirdSystemUser.getThirdSystemUserId(), thirdSystemUser.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ThirdSystemUser> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ThirdSystemUser.class, page);
	}

	@Override
	public List<ThirdSystemUser> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ThirdSystemUser.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public ThirdSystemUser get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ThirdSystemUser.class, id);
	}
	
	@Override
	public ThirdSystemUser getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ThirdSystemUser.class, value);
	}

	@Override
	public ThirdSystemUser getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ThirdSystemUser.class, value1, value2);
	}

	@Override
	public ThirdSystemUser getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ThirdSystemUser.class, value1, value2);
	}

	@Override
	public List<ThirdSystemUser> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ThirdSystemUser.class, value);
	}

	@Override
	public List<ThirdSystemUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ThirdSystemUser.class, value1, value2);
	}

	@Override
	public List<ThirdSystemUser> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ThirdSystemUser.class, value1, value2);
	}

	@Override
	public List<ThirdSystemUser> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ThirdSystemUser.class, page, param);
	}

	@Override
	public List<ThirdSystemUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ThirdSystemUser.class, page, param);
	}

	@Override
	public List<ThirdSystemUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ThirdSystemUser.class, page, param);
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
