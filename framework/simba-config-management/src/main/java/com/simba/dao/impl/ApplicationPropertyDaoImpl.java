package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ApplicationPropertyDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ApplicationProperty;

/**
 * 应用配置表 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ApplicationPropertyDaoImpl implements ApplicationPropertyDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "property";

	@Override
	public void add(ApplicationProperty applicationProperty) {
		String sql = "insert into " + table + "( name, templateId, dev, prod, test, createTime) values(?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, applicationProperty.getName(),applicationProperty.getTemplateId(),applicationProperty.getDev(),applicationProperty.getProd(),applicationProperty.getTest(),applicationProperty.getCreateTime());
	}

	@Override
	public void update(ApplicationProperty applicationProperty) {
		String sql = "update " + table + " set  name = ? , templateId = ? , dev = ? , prod = ? , test = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,applicationProperty.getName(),applicationProperty.getTemplateId(),applicationProperty.getDev(),applicationProperty.getProd(),applicationProperty.getTest(),applicationProperty.getCreateTime(), applicationProperty.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ApplicationProperty> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ApplicationProperty.class, page);
	}

	@Override
	public List<ApplicationProperty> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ApplicationProperty.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public ApplicationProperty get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ApplicationProperty.class, id);
	}
	
	@Override
	public ApplicationProperty getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ApplicationProperty.class, value);
	}

	@Override
	public ApplicationProperty getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ApplicationProperty.class, value1, value2);
	}

	@Override
	public ApplicationProperty getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ApplicationProperty.class, value1, value2);
	}

	@Override
	public List<ApplicationProperty> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ApplicationProperty.class, value);
	}

	@Override
	public List<ApplicationProperty> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ApplicationProperty.class, value1, value2);
	}

	@Override
	public List<ApplicationProperty> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ApplicationProperty.class, value1, value2);
	}

	@Override
	public List<ApplicationProperty> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ApplicationProperty.class, page, param);
	}

	@Override
	public List<ApplicationProperty> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ApplicationProperty.class, page, param);
	}

	@Override
	public List<ApplicationProperty> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ApplicationProperty.class, page, param);
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
