package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ReceiveEventDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ReceiveEvent;
import com.simba.model.form.ReceiveEventSearchForm;

/**
 * 收到事件 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ReceiveEventDaoImpl implements ReceiveEventDao {

	private static final Log logger = LogFactory.getLog(ReceiveEventDaoImpl.class);

	@Autowired
	private Jdbc jdbc;

	private static final String table = "receiveEvent";

	@Override
	public void add(ReceiveEvent receiveEvent) {
		String sql = "insert into " + table
				+ "( openid, createTime, type, event, eventKey, menuId, scanType, scanResult, ticket, latitude, longitude, eventPrecision, xml) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		logger.info("新增事件:" + receiveEvent.toString());
		jdbc.updateForBoolean(sql, receiveEvent.getOpenid(), receiveEvent.getCreateTime(), receiveEvent.getType(), receiveEvent.getEvent(), receiveEvent.getEventKey(), receiveEvent.getMenuId(),
				receiveEvent.getScanType(), receiveEvent.getScanResult(), receiveEvent.getTicket(), receiveEvent.getLatitude(), receiveEvent.getLongitude(), receiveEvent.getEventPrecision(),
				receiveEvent.getXml());
	}

	@Override
	public void update(ReceiveEvent receiveEvent) {
		String sql = "update " + table
				+ " set  openid = ? , createTime = ? , type = ? , event = ? , eventKey = ? , menuId = ? , scanType = ? , scanResult = ? , ticket = ? , latitude = ? , longitude = ? , eventPrecision = ? , xml = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, receiveEvent.getOpenid(), receiveEvent.getCreateTime(), receiveEvent.getType(), receiveEvent.getEvent(), receiveEvent.getEventKey(), receiveEvent.getMenuId(),
				receiveEvent.getScanType(), receiveEvent.getScanResult(), receiveEvent.getTicket(), receiveEvent.getLatitude(), receiveEvent.getLongitude(), receiveEvent.getEventPrecision(),
				receiveEvent.getXml(), receiveEvent.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ReceiveEvent> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc ";
		return jdbc.queryForPage(sql, ReceiveEvent.class, page);
	}

	@Override
	public List<ReceiveEvent> listAll() {
		String sql = "select * from " + table + " order by createTime desc ";
		return jdbc.queryForList(sql, ReceiveEvent.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public ReceiveEvent get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ReceiveEvent.class, id);
	}

	@Override
	public ReceiveEvent getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ReceiveEvent.class, value);
	}

	@Override
	public ReceiveEvent getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveEvent.class, value1, value2);
	}

	@Override
	public ReceiveEvent getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveEvent.class, value1, value2);
	}

	@Override
	public List<ReceiveEvent> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveEvent.class, value);
	}

	@Override
	public List<ReceiveEvent> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveEvent.class, value1, value2);
	}

	@Override
	public List<ReceiveEvent> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveEvent.class, value1, value2);
	}

	@Override
	public List<ReceiveEvent> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ReceiveEvent.class, page, param);
	}

	@Override
	public List<ReceiveEvent> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveEvent.class, page, param);
	}

	@Override
	public List<ReceiveEvent> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveEvent.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public List<ReceiveEvent> page(Pager pager, ReceiveEventSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, ReceiveEvent.class, pager, param);
	}

	private String buildCondition(String sql, ReceiveEventSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getOpenid())) {
			sql += " and openid = ? ";
			param.setString(searchForm.getOpenid());
		}
		if (StringUtils.isNotEmpty(searchForm.getType())) {
			sql += " and event = ? ";
			param.setString(searchForm.getType());
		}
		if (StringUtils.isNotEmpty(searchForm.getEventKey())) {
			sql += " and eventKey = ? ";
			param.setString(searchForm.getEventKey());
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

	@Override
	public long count(ReceiveEventSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

}
