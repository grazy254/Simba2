package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TemplateDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Template;

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

	private static final String table = "template";

	@Override
	public void add(Template template) {
		String sql = "insert into " + table + "( name, description, template, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, template.getName(),template.getDescription(),template.getTemplate(),template.getCreateTime());
	}

	@Override
	public void update(Template template) {
		String sql = "update " + table + " set  name = ? , description = ? , template = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,template.getName(),template.getDescription(),template.getTemplate(),template.getCreateTime(), template.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Template> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Template.class, page);
	}

	@Override
	public List<Template> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Template.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public Template get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Template.class, id);
	}
	
	@Override
	public Template getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Template.class, value);
	}

	@Override
	public Template getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Template.class, value1, value2);
	}

	@Override
	public Template getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Template.class, value1, value2);
	}

	@Override
	public List<Template> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Template.class, value);
	}

	@Override
	public List<Template> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Template.class, value1, value2);
	}

	@Override
	public List<Template> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Template.class, value1, value2);
	}

	@Override
	public List<Template> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Template.class, page, param);
	}

	@Override
	public List<Template> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Template.class, page, param);
	}

	@Override
	public List<Template> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Template.class, page, param);
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
