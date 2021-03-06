package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.UserGroupDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.UserGroup;

/**
 * 用户分组关联表 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class UserGroupDaoImpl implements UserGroupDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "userGroup";

	@Override
	public void add(UserGroup userGroup) {
		String sql = "insert into " + table + "( userId, groupId, createTime) values(?,?,?)";
		jdbc.updateForBoolean(sql, userGroup.getUserId(),userGroup.getGroupId(),userGroup.getCreateTime());
	}

	@Override
	public void update(UserGroup userGroup) {
		String sql = "update " + table + " set  userId = ? , groupId = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,userGroup.getUserId(),userGroup.getGroupId(),userGroup.getCreateTime(), userGroup.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<UserGroup> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, UserGroup.class, page);
	}

	@Override
	public List<UserGroup> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, UserGroup.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public UserGroup get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, UserGroup.class, id);
	}
	
	@Override
	public UserGroup getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, UserGroup.class, value);
	}

	@Override
	public UserGroup getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, UserGroup.class, value1, value2);
	}

	@Override
	public UserGroup getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, UserGroup.class, value1, value2);
	}

	@Override
	public List<UserGroup> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, UserGroup.class, value);
	}

	@Override
	public List<UserGroup> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, UserGroup.class, value1, value2);
	}

	@Override
	public List<UserGroup> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, UserGroup.class, value1, value2);
	}

	@Override
	public List<UserGroup> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, UserGroup.class, page, param);
	}

	@Override
	public List<UserGroup> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UserGroup.class, page, param);
	}

	@Override
	public List<UserGroup> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UserGroup.class, page, param);
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


	@Override
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}
	
	@Override
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
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
