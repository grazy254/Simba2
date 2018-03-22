package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.MsgBlacklistDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.MsgBlacklist;

/**
 * 黑名单 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class MsgBlacklistDaoImpl implements MsgBlacklistDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "blacklist";

	@Override
	public void add(MsgBlacklist blacklist) {
		String sql = "insert into " + table + "( mobile, createTime) values(?,?)";
		jdbc.updateForBoolean(sql, blacklist.getMobile(),blacklist.getCreateTime());
	}

	@Override
	public void update(MsgBlacklist blacklist) {
		String sql = "update " + table + " set  mobile = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,blacklist.getMobile(),blacklist.getCreateTime(), blacklist.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<MsgBlacklist> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, MsgBlacklist.class, page);
	}

	@Override
	public List<MsgBlacklist> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, MsgBlacklist.class);
	}

	@Override
	public Integer count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public MsgBlacklist get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, MsgBlacklist.class, id);
	}
	
	@Override
	public MsgBlacklist getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, MsgBlacklist.class, value);
	}

	@Override
	public MsgBlacklist getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, MsgBlacklist.class, value1, value2);
	}

	@Override
	public MsgBlacklist getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, MsgBlacklist.class, value1, value2);
	}

	@Override
	public List<MsgBlacklist> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, MsgBlacklist.class, value);
	}

	@Override
	public List<MsgBlacklist> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, MsgBlacklist.class, value1, value2);
	}

	@Override
	public List<MsgBlacklist> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, MsgBlacklist.class, value1, value2);
	}

	@Override
	public List<MsgBlacklist> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, MsgBlacklist.class, page, param);
	}

	@Override
	public List<MsgBlacklist> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, MsgBlacklist.class, page, param);
	}

	@Override
	public List<MsgBlacklist> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, MsgBlacklist.class, page, param);
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

}
