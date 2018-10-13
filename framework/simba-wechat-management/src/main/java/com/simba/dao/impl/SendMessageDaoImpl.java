package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.SendMessageDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.SendMessage;
import com.simba.model.form.SendMessageSearchForm;

/**
 * 发消息 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class SendMessageDaoImpl implements SendMessageDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "sendMessage";

	@Override
	public void add(SendMessage sendMessage) {
		String sql = "insert into " + table
				+ "( openid, content, createTime, mediaId, type, thumbMediaId, title, descritption, musicUrl, hqMusicUrl, news,  json,account) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, sendMessage.getOpenid(), sendMessage.getContent(), sendMessage.getCreateTime(), sendMessage.getMediaId(), sendMessage.getType(), sendMessage.getThumbMediaId(),
				sendMessage.getTitle(), sendMessage.getDescritption(), sendMessage.getMusicUrl(), sendMessage.getHqMusicUrl(), sendMessage.getNews(), sendMessage.getJson(), sendMessage.getAccount());
	}

	@Override
	public void update(SendMessage sendMessage) {
		String sql = "update " + table
				+ " set  openid = ? , content = ? , createTime = ? , mediaId = ? , type = ? , thumbMediaId = ? , title = ? , descritption = ? , musicUrl = ? , hqMusicUrl = ? , news = ? , json = ? , account = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, sendMessage.getOpenid(), sendMessage.getContent(), sendMessage.getCreateTime(), sendMessage.getMediaId(), sendMessage.getType(), sendMessage.getThumbMediaId(),
				sendMessage.getTitle(), sendMessage.getDescritption(), sendMessage.getMusicUrl(), sendMessage.getHqMusicUrl(), sendMessage.getNews(), sendMessage.getJson(), sendMessage.getAccount(),
				sendMessage.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<SendMessage> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, SendMessage.class, page);
	}

	@Override
	public List<SendMessage> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, SendMessage.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public SendMessage get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, SendMessage.class, id);
	}

	@Override
	public SendMessage getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, SendMessage.class, value);
	}

	@Override
	public SendMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, SendMessage.class, value1, value2);
	}

	@Override
	public SendMessage getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, SendMessage.class, value1, value2);
	}

	@Override
	public List<SendMessage> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, SendMessage.class, value);
	}

	@Override
	public List<SendMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, SendMessage.class, value1, value2);
	}

	@Override
	public List<SendMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, SendMessage.class, value1, value2);
	}

	@Override
	public List<SendMessage> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, SendMessage.class, page, param);
	}

	@Override
	public List<SendMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, SendMessage.class, page, param);
	}

	@Override
	public List<SendMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, SendMessage.class, page, param);
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
	public List<SendMessage> page(Pager pager, SendMessageSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, SendMessage.class, pager, param);
	}

	@Override
	public int count(SendMessageSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, SendMessageSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getAccount())) {
			sql += " and account = ? ";
			param.setString(searchForm.getAccount());
		}
		if (StringUtils.isNotEmpty(searchForm.getOpenid())) {
			sql += " and openid = ? ";
			param.setString(searchForm.getOpenid());
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
