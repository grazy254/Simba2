package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.DictionaryTypeDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.DictionaryType;
import com.simba.model.form.SearchDictionaryTypeForm;
/**
 * 字典类型 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class DictionaryTypeDaoImpl implements DictionaryTypeDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "dictionaryType";

	@Override
	public void add(DictionaryType dictionaryType) {
		String sql = "insert into " + table + "( code, description) values(?,?)";
		jdbc.updateForBoolean(sql, dictionaryType.getCode(),dictionaryType.getDescription());
	}

	@Override
	public void update(DictionaryType dictionaryType) {
		String sql = "update " + table + " set  code = ? , description = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,dictionaryType.getCode(),dictionaryType.getDescription(), dictionaryType.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<DictionaryType> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, DictionaryType.class, page);
	}
	@Override
	public List<DictionaryType> page(Pager page, SearchDictionaryTypeForm searchDictionaryTypeForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForPage(buildCondition(sql, searchDictionaryTypeForm, param), DictionaryType.class, page, param);
	}
	@Override
	public List<DictionaryType> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, DictionaryType.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public Long count(SearchDictionaryTypeForm searchDictionaryTypeForm){
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForLong(buildCondition(sql, searchDictionaryTypeForm, param), param); 
	}
	@Override
	public DictionaryType get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, DictionaryType.class, id);
	}
	
	@Override
	public DictionaryType getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, DictionaryType.class, value);
	}

	@Override
	public DictionaryType getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, DictionaryType.class, value1, value2);
	}

	@Override
	public DictionaryType getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, DictionaryType.class, value1, value2);
	}

	@Override
	public List<DictionaryType> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, DictionaryType.class, value);
	}

	@Override
	public List<DictionaryType> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, DictionaryType.class, value1, value2);
	}

	@Override
	public List<DictionaryType> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, DictionaryType.class, value1, value2);
	}

	@Override
	public List<DictionaryType> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, DictionaryType.class, page, param);
	}

	@Override
	public List<DictionaryType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DictionaryType.class, page, param);
	}

	@Override
	public List<DictionaryType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DictionaryType.class, page, param);
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
	private String buildCondition(String sql, SearchDictionaryTypeForm searchDictionaryTypeForm, StatementParameter param) {
		sql += " where 1 = 1";
        if (searchDictionaryTypeForm.getCode() != null 
        		&& StringUtils.isNotEmpty(searchDictionaryTypeForm.getCode()+"")) {
			sql += " and code  = ?";
			param.set(searchDictionaryTypeForm.getCode());
		}
		return sql;
	}
}
