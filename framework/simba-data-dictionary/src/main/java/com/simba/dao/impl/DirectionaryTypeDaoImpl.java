package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.DirectionaryTypeDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.DirectionaryType;
import com.simba.model.form.SearchDirectionaryTypeForm;
/**
 * 字典类型 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class DirectionaryTypeDaoImpl implements DirectionaryTypeDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "directionaryType";

	@Override
	public void add(DirectionaryType directionaryType) {
		String sql = "insert into " + table + "( code, description) values(?,?)";
		jdbc.updateForBoolean(sql, directionaryType.getCode(),directionaryType.getDescription());
	}

	@Override
	public void update(DirectionaryType directionaryType) {
		String sql = "update " + table + " set  code = ? , description = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,directionaryType.getCode(),directionaryType.getDescription(), directionaryType.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<DirectionaryType> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, DirectionaryType.class, page);
	}
	@Override
	public List<DirectionaryType> page(Pager page, SearchDirectionaryTypeForm searchDirectionaryTypeForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForPage(buildCondition(sql, searchDirectionaryTypeForm, param), DirectionaryType.class, page, param);
	}
	@Override
	public List<DirectionaryType> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, DirectionaryType.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public Long count(SearchDirectionaryTypeForm searchDirectionaryTypeForm){
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForLong(buildCondition(sql, searchDirectionaryTypeForm, param), param); 
	}
	@Override
	public DirectionaryType get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, DirectionaryType.class, id);
	}
	
	@Override
	public DirectionaryType getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, DirectionaryType.class, value);
	}

	@Override
	public DirectionaryType getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, DirectionaryType.class, value1, value2);
	}

	@Override
	public DirectionaryType getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, DirectionaryType.class, value1, value2);
	}

	@Override
	public List<DirectionaryType> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, DirectionaryType.class, value);
	}

	@Override
	public List<DirectionaryType> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, DirectionaryType.class, value1, value2);
	}

	@Override
	public List<DirectionaryType> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, DirectionaryType.class, value1, value2);
	}

	@Override
	public List<DirectionaryType> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, DirectionaryType.class, page, param);
	}

	@Override
	public List<DirectionaryType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DirectionaryType.class, page, param);
	}

	@Override
	public List<DirectionaryType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DirectionaryType.class, page, param);
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
	private String buildCondition(String sql, SearchDirectionaryTypeForm searchDirectionaryTypeForm, StatementParameter param) {
		sql += " where 1 = 1";
        if (searchDirectionaryTypeForm.getCode() != null 
        		&& StringUtils.isNotEmpty(searchDirectionaryTypeForm.getCode()+"")) {
			sql += " and code  = ?";
			param.set(searchDirectionaryTypeForm.getCode());
		}
		return sql;
	}
}
