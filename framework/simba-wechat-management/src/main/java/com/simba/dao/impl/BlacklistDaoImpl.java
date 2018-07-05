package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.BlacklistDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Blacklist;

/**
 * 黑名单 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class BlacklistDaoImpl implements BlacklistDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "blacklist";

	@Override
	public void add(Blacklist blacklist) {
		String sql = "insert into " + table + "( fansId, createTime) values(?,?)";
		jdbc.updateForBoolean(sql, blacklist.getFansId(),blacklist.getCreateTime());
	}

	@Override
	public void update(Blacklist blacklist) {
		String sql = "update " + table + " set  fansId = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,blacklist.getFansId(),blacklist.getCreateTime(), blacklist.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Blacklist> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, Blacklist.class, page);
	}

	@Override
	public List<Blacklist> listAll(){
		String sql = "select * from " + table+" order by createTime desc";
		return jdbc.queryForList(sql, Blacklist.class);
	}

	@Override
	public int count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public Blacklist get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Blacklist.class, id);
	}
	
	@Override
	public Blacklist getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Blacklist.class, value);
	}

	@Override
	public Blacklist getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Blacklist.class, value1, value2);
	}

	@Override
	public Blacklist getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Blacklist.class, value1, value2);
	}

	@Override
	public List<Blacklist> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, Blacklist.class, value);
	}

	@Override
	public List<Blacklist> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, Blacklist.class, value1, value2);
	}

	@Override
	public List<Blacklist> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, Blacklist.class, value1, value2);
	}

	@Override
	public List<Blacklist> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Blacklist.class, page, param);
	}

	@Override
	public List<Blacklist> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Blacklist.class, page, param);
	}

	@Override
	public List<Blacklist> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Blacklist.class, page, param);
	}
	
	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

}
