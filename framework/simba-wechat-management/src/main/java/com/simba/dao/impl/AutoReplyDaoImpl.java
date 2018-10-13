package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.AutoReplyDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.AutoReply;

/**
 * 自动回复设置 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class AutoReplyDaoImpl implements AutoReplyDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "autoReply";

	@Override
	public void add(AutoReply autoReply) {
		String sql = "insert into " + table + "( type, content) values(?,?)";
		jdbc.updateForBoolean(sql, autoReply.getType(),autoReply.getContent());
	}

	@Override
	public void update(AutoReply autoReply) {
		String sql = "update " + table + " set  type = ? , content = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,autoReply.getType(),autoReply.getContent(), autoReply.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<AutoReply> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, AutoReply.class, page);
	}

	@Override
	public List<AutoReply> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, AutoReply.class);
	}

	@Override
	public int count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public AutoReply get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, AutoReply.class, id);
	}
	
	@Override
	public AutoReply getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, AutoReply.class, value);
	}

	@Override
	public AutoReply getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, AutoReply.class, value1, value2);
	}

	@Override
	public AutoReply getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, AutoReply.class, value1, value2);
	}

	@Override
	public List<AutoReply> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, AutoReply.class, value);
	}

	@Override
	public List<AutoReply> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, AutoReply.class, value1, value2);
	}

	@Override
	public List<AutoReply> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, AutoReply.class, value1, value2);
	}

	@Override
	public List<AutoReply> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, AutoReply.class, page, param);
	}

	@Override
	public List<AutoReply> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, AutoReply.class, page, param);
	}

	@Override
	public List<AutoReply> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, AutoReply.class, page, param);
	}
	
	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

}
