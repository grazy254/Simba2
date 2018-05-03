package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.OperLoggerDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.OperLogger;
import com.simba.model.form.OperLoggerSearchForm;

/**
 * 操作日志 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class OperLoggerDaoImpl implements OperLoggerDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "operLogger";

	@Override
	public void add(OperLogger operLogger) {
		String sql = "insert into " + table + "( account, ip, address, content, createTime) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, operLogger.getAccount(),operLogger.getIp(),operLogger.getAddress(),operLogger.getContent(),operLogger.getCreateTime());
	}

	@Override
	public void update(OperLogger operLogger) {
		String sql = "update " + table + " set  account = ? , ip = ? , address = ? , content = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,operLogger.getAccount(),operLogger.getIp(),operLogger.getAddress(),operLogger.getContent(),operLogger.getCreateTime(), operLogger.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<OperLogger> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, OperLogger.class, page);
	}
	
	@Override
	public List<OperLogger> page(Pager page, OperLoggerSearchForm operLoggerSearchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForPage(buildCondition(sql, operLoggerSearchForm, param), OperLogger.class, page, param);
	}
	
	@Override
	public List<OperLogger> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, OperLogger.class);
	}

	@Override
	public Long count(OperLoggerSearchForm operLoggerSearchForm){
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
//		sql = buildCondition(sql, operLoggerSearchForm, param);
		return jdbc.queryForLong(buildCondition(sql, operLoggerSearchForm, param), param);
	}

	@Override
	public OperLogger get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, OperLogger.class, id);
	}
	
	@Override
	public OperLogger getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, OperLogger.class, value);
	}

	@Override
	public OperLogger getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, OperLogger.class, value1, value2);
	}

	@Override
	public OperLogger getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, OperLogger.class, value1, value2);
	}

	@Override
	public List<OperLogger> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, OperLogger.class, value);
	}

	@Override
	public List<OperLogger> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, OperLogger.class, value1, value2);
	}

	@Override
	public List<OperLogger> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, OperLogger.class, value1, value2);
	}

	@Override
	public List<OperLogger> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, OperLogger.class, page, param);
	}

	@Override
	public List<OperLogger> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, OperLogger.class, page, param);
	}

	@Override
	public List<OperLogger> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, OperLogger.class, page, param);
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
	private String buildCondition(String sql, OperLoggerSearchForm operLoggerSearchForm, StatementParameter param) {
        sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(operLoggerSearchForm.getIp())) {
			sql += " and ip = ? ";
			param.set(operLoggerSearchForm.getIp());
		}
        if (StringUtils.isNotEmpty(operLoggerSearchForm.getStartTime())) {
			sql += " and startTime = ? ";
			param.set(operLoggerSearchForm.getStartTime());
		}
        if (StringUtils.isNotEmpty(operLoggerSearchForm.getEndTime())) {
			sql += " and endTime = ? ";
			param.set(operLoggerSearchForm.getEndTime());
		}
        if (StringUtils.isNotEmpty(operLoggerSearchForm.getAccount())) {
			sql += " and account = ? ";
			param.set(operLoggerSearchForm.getAccount());
		}
		return sql;
	}
}
