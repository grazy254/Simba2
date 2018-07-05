package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.NotifyUserDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.NotifyUser;
/**
 * 通知表和用户表的关联 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class NotifyUserDaoImpl implements NotifyUserDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "notifyUser";

	@Override
	public void add(NotifyUser notifyUser) {
		String sql = "insert into " + table + "( notifyId, smartUserId, status, readTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, notifyUser.getNotifyId(),notifyUser.getSmartUserId(),notifyUser.getStatus(),notifyUser.getReadTime());
	}

	@Override
	public void update(NotifyUser notifyUser) {
		String sql = "update " + table + " set  notifyId = ? , smartUserId = ? , status = ? , readTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,notifyUser.getNotifyId(),notifyUser.getSmartUserId(),notifyUser.getStatus(),notifyUser.getReadTime(), notifyUser.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<NotifyUser> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, NotifyUser.class, page);
	}
	@Override
	public List<NotifyUser> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, NotifyUser.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public NotifyUser get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, NotifyUser.class, id);
	}
	
	@Override
	public NotifyUser getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, NotifyUser.class, value);
	}

	@Override
	public NotifyUser getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, NotifyUser.class, value1, value2);
	}

	@Override
	public NotifyUser getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, NotifyUser.class, value1, value2);
	}

	@Override
	public List<NotifyUser> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, NotifyUser.class, value);
	}

	@Override
	public List<NotifyUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, NotifyUser.class, value1, value2);
	}

	@Override
	public List<NotifyUser> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, NotifyUser.class, value1, value2);
	}

	@Override
	public List<NotifyUser> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, NotifyUser.class, page, param);
	}

	@Override
	public List<NotifyUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, NotifyUser.class, page, param);
	}

	@Override
	public List<NotifyUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, NotifyUser.class, page, param);
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
