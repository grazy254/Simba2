package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.controller.form.ShortMsgSearchForm;
import com.simba.dao.ShortMessageDao;
import com.simba.dao.impl.PO.DayCount;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ShortMessage;

/**
 * 短信 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ShortMessageDaoImpl implements ShortMessageDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "shortMessage";

	@Override
	public void add(ShortMessage shortMessage) {
		String sql = "insert into " + table + "( templateId, value, mobile, sendDate, projectId, status, platform, messageId) values(?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, shortMessage.getTemplateId(), shortMessage.getValue(), shortMessage.getMobile(), shortMessage.getSendDate(), shortMessage.getProjectId(), shortMessage.getStatus(),
				shortMessage.getPlatform(), shortMessage.getMessageId());
	}

	@Override
	public void update(ShortMessage shortMessage) {
		String sql = "update " + table + " set  templateId = ? , value = ? , mobile = ? , sendDate = ? , projectId = ? , status = ? , platform = ? , messageId = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, shortMessage.getTemplateId(), shortMessage.getValue(), shortMessage.getMobile(), shortMessage.getSendDate(), shortMessage.getProjectId(), shortMessage.getStatus(),
				shortMessage.getPlatform(), shortMessage.getMessageId(), shortMessage.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ShortMessage> page(Pager page) {
		String sql = "select * from " + table;
		sql += " order by sendDate desc";
		return jdbc.queryForPage(sql, ShortMessage.class, page);
	}

	@Override
	public List<ShortMessage> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ShortMessage.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public ShortMessage get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ShortMessage.class, id);
	}

	@Override
	public ShortMessage getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ShortMessage.class, value);
	}

	@Override
	public ShortMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ShortMessage.class, value1, value2);
	}

	@Override
	public ShortMessage getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ShortMessage.class, value1, value2);
	}

	@Override
	public List<ShortMessage> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ShortMessage.class, value);
	}

	@Override
	public List<ShortMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ShortMessage.class, value1, value2);
	}

	@Override
	public List<ShortMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ShortMessage.class, value1, value2);
	}

	@Override
	public List<ShortMessage> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ShortMessage.class, page, param);
	}

	@Override
	public List<ShortMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ShortMessage.class, page, param);
	}

	@Override
	public List<ShortMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ShortMessage.class, page, param);
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
	public List<ShortMessage> page(Pager pager, ShortMsgSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by sendDate desc";
		return jdbc.queryForPage(sql, ShortMessage.class, pager, param);
	}

	@Override
	public Long count(ShortMsgSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, ShortMsgSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getMobile())) {
			sql += " and mobile = ? ";
			param.setString(searchForm.getMobile());
		}
		if (StringUtils.isNotEmpty(searchForm.getPlatform())) {
			sql += " and platform = ? ";
			param.setString(searchForm.getPlatform());
		}
		if (StringUtils.isNotEmpty(searchForm.getProjectId())) {
			sql += " and projectId = ? ";
			param.setString(searchForm.getProjectId());
		}
		if (StringUtils.isNotEmpty(searchForm.getTemplateId())) {
			sql += " and templateId = ? ";
			param.setString(searchForm.getTemplateId());
		}
		if (StringUtils.isNotEmpty(searchForm.getStatus())) {
			sql += " and status = ? ";
			param.setString(searchForm.getStatus());
		}
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and sendDate > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and sendDate < ? ";
			param.setString(searchForm.getEndTime());
		}
		return sql;
	}

	public List<DayCount> countByDay(String startDate, String endDate) {
		String sql = "SELECT count(*) AS countmsg, DATE_FORMAT(msg.sendDate, '%Y-%m-%d') AS date " + " FROM shortMessage msg " + " WHERE DATE_FORMAT(msg.sendDate, '%Y-%m-%d') > " + "'" + startDate
				+ "'" + " AND DATE_FORMAT(msg.sendDate, '%Y-%m-%d') < " + "'" + endDate + "'" + " GROUP BY date " + " ORDER BY date ";
		List<DayCount> list = jdbc.queryForList(sql, DayCount.class);
		return list;
	}

}
