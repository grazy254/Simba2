package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TemplateDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.PropertyTemplate;

/**
 * 配置模板表 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class TemplateDaoImpl implements TemplateDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "propertytemplate";

	@Override
	public void add(PropertyTemplate template) {
		String sql = "insert into " + table + "( name, description, template, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, template.getName(),template.getDescription(),template.getTemplate(),template.getCreateTime());
	}

	@Override
	public void update(PropertyTemplate template) {
		String sql = "update " + table + " set  name = ? , description = ? , template = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,template.getName(),template.getDescription(),template.getTemplate(),template.getCreateTime(), template.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<PropertyTemplate> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, PropertyTemplate.class, page);
	}

	@Override
	public List<PropertyTemplate> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, PropertyTemplate.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public PropertyTemplate get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, PropertyTemplate.class, id);
	}
	
	@Override
	public PropertyTemplate getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, PropertyTemplate.class, value);
	}

	@Override
	public PropertyTemplate getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, PropertyTemplate.class, value1, value2);
	}

	@Override
	public PropertyTemplate getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, PropertyTemplate.class, value1, value2);
	}

	@Override
	public List<PropertyTemplate> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, PropertyTemplate.class, value);
	}

	@Override
	public List<PropertyTemplate> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, PropertyTemplate.class, value1, value2);
	}

	@Override
	public List<PropertyTemplate> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, PropertyTemplate.class, value1, value2);
	}

	@Override
	public List<PropertyTemplate> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, PropertyTemplate.class, page, param);
	}

	@Override
	public List<PropertyTemplate> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PropertyTemplate.class, page, param);
	}

	@Override
	public List<PropertyTemplate> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PropertyTemplate.class, page, param);
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
