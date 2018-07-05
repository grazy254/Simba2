package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.GroupMessageDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.GroupMessage;
import com.simba.model.form.GroupMessageSearchForm;

/**
 * 群发消息 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class GroupMessageDaoImpl implements GroupMessageDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "groupMessage";

	@Override
	public void add(GroupMessage groupMessage) {
		String sql = "insert into " + table + "( createTime, type, account, content, mediaId, wxTagId, isAll, openids, status, msgId, msgDataId, json) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, groupMessage.getCreateTime(), groupMessage.getType(), groupMessage.getAccount(), groupMessage.getContent(), groupMessage.getMediaId(), groupMessage.getWxTagId(),
				groupMessage.getIsAll(), groupMessage.getOpenids(), groupMessage.getStatus(), groupMessage.getMsgId(), groupMessage.getMsgDataId(), groupMessage.getJson());
	}

	@Override
	public void update(GroupMessage groupMessage) {
		String sql = "update " + table
				+ " set  createTime = ? , type = ? , account = ? , content = ? , mediaId = ? , wxTagId = ? , isAll = ? , openids = ? , status = ? , msgId = ? , msgDataId = ? , json = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, groupMessage.getCreateTime(), groupMessage.getType(), groupMessage.getAccount(), groupMessage.getContent(), groupMessage.getMediaId(), groupMessage.getWxTagId(),
				groupMessage.getIsAll(), groupMessage.getOpenids(), groupMessage.getStatus(), groupMessage.getMsgId(), groupMessage.getMsgDataId(), groupMessage.getJson(), groupMessage.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<GroupMessage> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, GroupMessage.class, page);
	}

	@Override
	public List<GroupMessage> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, GroupMessage.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public GroupMessage get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, GroupMessage.class, id);
	}

	@Override
	public GroupMessage getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, GroupMessage.class, value);
	}

	@Override
	public GroupMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, GroupMessage.class, value1, value2);
	}

	@Override
	public GroupMessage getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, GroupMessage.class, value1, value2);
	}

	@Override
	public List<GroupMessage> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, GroupMessage.class, value);
	}

	@Override
	public List<GroupMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, GroupMessage.class, value1, value2);
	}

	@Override
	public List<GroupMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, GroupMessage.class, value1, value2);
	}

	@Override
	public List<GroupMessage> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, GroupMessage.class, page, param);
	}

	@Override
	public List<GroupMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, GroupMessage.class, page, param);
	}

	@Override
	public List<GroupMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, GroupMessage.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

	@Override
	public List<GroupMessage> page(Pager pager, GroupMessageSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, GroupMessage.class, pager, param);
	}

	@Override
	public int count(GroupMessageSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, GroupMessageSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (searchForm.getIsAll() != null && searchForm.getIsAll() > 0) {
			sql += " and isAll = ? ";
			param.setInt(searchForm.getIsAll());
		}
		if (searchForm.getStatus() != null && searchForm.getStatus() > 0) {
			sql += " and status = ? ";
			param.setInt(searchForm.getStatus());
		}
		if (searchForm.getWxTagId() != null && searchForm.getWxTagId() > 0) {
			sql += " and wxTagId = ? ";
			param.setInt(searchForm.getWxTagId());
		}
		if (StringUtils.isNotEmpty(searchForm.getMediaId())) {
			sql += " and mediaId = ? ";
			param.setString(searchForm.getMediaId());
		}
		if (StringUtils.isNotEmpty(searchForm.getAccount())) {
			sql += " and account = ? ";
			param.setString(searchForm.getAccount());
		}
		if (StringUtils.isNotEmpty(searchForm.getType())) {
			sql += " and type = ? ";
			param.setString(searchForm.getType());
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
