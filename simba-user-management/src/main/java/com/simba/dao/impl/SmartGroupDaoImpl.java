package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.SmartGroupDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.SmartGroup;

/**
 * 分组表 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class SmartGroupDaoImpl implements SmartGroupDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "smartGroup";

	@Override
	public void add(SmartGroup smartGroup) {
		String sql = "insert into " + table + "( name, description, status, type, creater, createTime) values(?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, smartGroup.getName(),smartGroup.getDescription(),smartGroup.getStatus(),smartGroup.getType(),smartGroup.getCreater(),smartGroup.getCreateTime());
	}

	@Override
	public void update(SmartGroup smartGroup) {
		String sql = "update " + table + " set  name = ? , description = ? , status = ? , type = ? , creater = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,smartGroup.getName(),smartGroup.getDescription(),smartGroup.getStatus(),smartGroup.getType(),smartGroup.getCreater(),smartGroup.getCreateTime(), smartGroup.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<SmartGroup> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, SmartGroup.class, page);
	}

	@Override
	public List<SmartGroup> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, SmartGroup.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public SmartGroup get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, SmartGroup.class, id);
	}
	
	@Override
	public SmartGroup getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, SmartGroup.class, value);
	}

	@Override
	public SmartGroup getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, SmartGroup.class, value1, value2);
	}

	@Override
	public SmartGroup getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, SmartGroup.class, value1, value2);
	}

	@Override
	public List<SmartGroup> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, SmartGroup.class, value);
	}

	@Override
	public List<SmartGroup> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, SmartGroup.class, value1, value2);
	}

	@Override
	public List<SmartGroup> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, SmartGroup.class, value1, value2);
	}

	@Override
	public List<SmartGroup> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, SmartGroup.class, page, param);
	}

	@Override
	public List<SmartGroup> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, SmartGroup.class, page, param);
	}

	@Override
	public List<SmartGroup> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, SmartGroup.class, page, param);
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
