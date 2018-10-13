package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.EmailDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Email;

/**
 * 邮件记录 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class EmailDaoImpl implements EmailDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "email";

	@Override
	public void add(Email email) {
		String sql = "insert into " + table + "( appid, toEmail, title, content, type, createTime) values(?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, email.getAppid(), email.getToEmail(), email.getTitle(), email.getContent(), email.getType(), email.getCreateTime());
	}

	@Override
	public void update(Email email) {
		String sql = "update " + table + " set  appid = ? , toEmail = ? , title = ? , content = ? , type = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, email.getAppid(), email.getToEmail(), email.getTitle(), email.getContent(), email.getType(), email.getCreateTime(), email.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Email> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Email.class, page);
	}

	@Override
	public List<Email> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Email.class);
	}

	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public Email get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Email.class, id);
	}

	@Override
	public Email getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Email.class, value);
	}

	@Override
	public Email getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Email.class, value1, value2);
	}

	@Override
	public Email getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Email.class, value1, value2);
	}

	@Override
	public List<Email> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Email.class, value);
	}

	@Override
	public List<Email> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Email.class, value1, value2);
	}

	@Override
	public List<Email> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Email.class, value1, value2);
	}

	@Override
	public List<Email> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Email.class, page, param);
	}

	@Override
	public List<Email> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Email.class, page, param);
	}

	@Override
	public List<Email> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Email.class, page, param);
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
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}

	@Override
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "delete from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "delete from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}
}
