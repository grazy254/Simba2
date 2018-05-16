package com.simba.dao.impl;

import com.simba.dao.NotifyDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Notify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 通知表 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class NotifyDaoImpl implements NotifyDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "notify";

	@Override
	public void add(Notify notify) {
		String sql = "insert into " + table + "( title, content, type, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, notify.getTitle(),notify.getContent(),notify.getType(),notify.getCreateTime());
	}

	@Override
	public void update(Notify notify) {
		String sql = "update " + table + " set  title = ? , content = ? , type = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,notify.getTitle(),notify.getContent(),notify.getType(),notify.getCreateTime(), notify.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Notify> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Notify.class, page);
	}
	@Override
	public List<Notify> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Notify.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public Notify get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Notify.class, id);
	}
	
	@Override
	public Notify getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		System.out.println(sql);
		System.out.println(value);
		return jdbc.query(sql, Notify.class, value);
	}

	@Override
	public Notify getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Notify.class, value1, value2);
	}

	@Override
	public Notify getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Notify.class, value1, value2);
	}

	@Override
	public List<Notify> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Notify.class, value);
	}

	@Override
	public List<Notify> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Notify.class, value1, value2);
	}

	@Override
	public List<Notify> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Notify.class, value1, value2);
	}

	@Override
	public List<Notify> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Notify.class, page, param);
	}

	@Override
	public List<Notify> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Notify.class, page, param);
	}

	@Override
	public List<Notify> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Notify.class, page, param);
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
