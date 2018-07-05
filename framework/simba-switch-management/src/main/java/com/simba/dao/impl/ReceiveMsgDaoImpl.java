package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ReceiveMsgDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ReceiveMsg;
import com.simba.model.form.ReceiveMsgSearchForm;

/**
 * 接收消息 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ReceiveMsgDaoImpl implements ReceiveMsgDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "receiveMsg";

	@Override
	public void add(ReceiveMsg receiveMsg) {
		String sql = "insert into " + table + "( type, source, message, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, receiveMsg.getType(), receiveMsg.getSource(), receiveMsg.getMessage(), receiveMsg.getCreateTime());
	}

	@Override
	public void update(ReceiveMsg receiveMsg) {
		String sql = "update " + table + " set  type = ? , source = ? , message = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, receiveMsg.getType(), receiveMsg.getSource(), receiveMsg.getMessage(), receiveMsg.getCreateTime(), receiveMsg.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ReceiveMsg> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, ReceiveMsg.class, page);
	}

	@Override
	public List<ReceiveMsg> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMsg.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public ReceiveMsg get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ReceiveMsg.class, id);
	}

	@Override
	public ReceiveMsg getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ReceiveMsg.class, value);
	}

	@Override
	public ReceiveMsg getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveMsg.class, value1, value2);
	}

	@Override
	public ReceiveMsg getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveMsg.class, value1, value2);
	}

	@Override
	public List<ReceiveMsg> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMsg.class, value);
	}

	@Override
	public List<ReceiveMsg> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMsg.class, value1, value2);
	}

	@Override
	public List<ReceiveMsg> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMsg.class, value1, value2);
	}

	@Override
	public List<ReceiveMsg> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ReceiveMsg.class, page, param);
	}

	@Override
	public List<ReceiveMsg> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveMsg.class, page, param);
	}

	@Override
	public List<ReceiveMsg> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveMsg.class, page, param);
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
	public List<ReceiveMsg> page(Pager pager, ReceiveMsgSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, ReceiveMsg.class, pager, param);
	}

	@Override
	public Long count(ReceiveMsgSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, ReceiveMsgSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getType())) {
			sql += " and type like '%" + searchForm.getType() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getSource())) {
			sql += " and source like '%" + searchForm.getSource() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		return sql;
	}

}
