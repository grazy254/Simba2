package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ReceiveMessageDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ReceiveMessage;
import com.simba.model.form.ReceiveMessageSearchForm;

/**
 * 收到消息 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ReceiveMessageDaoImpl implements ReceiveMessageDao {

	private static final Log logger = LogFactory.getLog(ReceiveMessageDaoImpl.class);

	@Autowired
	private Jdbc jdbc;

	private static final String table = "receiveMessage";

	@Override
	public void add(ReceiveMessage receiveMessage) {
		String sql = "insert into " + table
				+ "( openid, createTime, type, msgId, content, picUrl, mediaId, fileUrl, format, recognition, thumbMediaId, thumbFileUrl, locationX, locationY, scale, messageLabel, title, description, url, xml) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		logger.info("新增消息:" + receiveMessage.toString());
		jdbc.updateForBoolean(sql, receiveMessage.getOpenid(), receiveMessage.getCreateTime(), receiveMessage.getType(), receiveMessage.getMsgId(), receiveMessage.getContent(),
				receiveMessage.getPicUrl(), receiveMessage.getMediaId(), receiveMessage.getFileUrl(), receiveMessage.getFormat(), receiveMessage.getRecognition(), receiveMessage.getThumbMediaId(),
				receiveMessage.getThumbFileUrl(), receiveMessage.getLocationX(), receiveMessage.getLocationY(), receiveMessage.getScale(), receiveMessage.getMessageLabel(), receiveMessage.getTitle(),
				receiveMessage.getDescription(), receiveMessage.getUrl(), receiveMessage.getXml());
	}

	@Override
	public void update(ReceiveMessage receiveMessage) {
		String sql = "update " + table
				+ " set  openid = ? , createTime = ? , type = ? , msgId = ? , content = ? , picUrl = ? , mediaId = ? , fileUrl = ? , format = ? , recognition = ? , thumbMediaId = ? , thumbFileUrl = ? , locationX = ? , locationY = ? , scale = ? , messageLabel = ? , title = ? , description = ? , url = ? , xml = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, receiveMessage.getOpenid(), receiveMessage.getCreateTime(), receiveMessage.getType(), receiveMessage.getMsgId(), receiveMessage.getContent(),
				receiveMessage.getPicUrl(), receiveMessage.getMediaId(), receiveMessage.getFileUrl(), receiveMessage.getFormat(), receiveMessage.getRecognition(), receiveMessage.getThumbMediaId(),
				receiveMessage.getThumbFileUrl(), receiveMessage.getLocationX(), receiveMessage.getLocationY(), receiveMessage.getScale(), receiveMessage.getMessageLabel(), receiveMessage.getTitle(),
				receiveMessage.getDescription(), receiveMessage.getUrl(), receiveMessage.getXml(), receiveMessage.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ReceiveMessage> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, ReceiveMessage.class, page);
	}

	@Override
	public List<ReceiveMessage> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMessage.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public ReceiveMessage get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ReceiveMessage.class, id);
	}

	@Override
	public ReceiveMessage getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ReceiveMessage.class, value);
	}

	@Override
	public ReceiveMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveMessage.class, value1, value2);
	}

	@Override
	public ReceiveMessage getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ReceiveMessage.class, value1, value2);
	}

	@Override
	public List<ReceiveMessage> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMessage.class, value);
	}

	@Override
	public List<ReceiveMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMessage.class, value1, value2);
	}

	@Override
	public List<ReceiveMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ReceiveMessage.class, value1, value2);
	}

	@Override
	public List<ReceiveMessage> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ReceiveMessage.class, page, param);
	}

	@Override
	public List<ReceiveMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveMessage.class, page, param);
	}

	@Override
	public List<ReceiveMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ReceiveMessage.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public List<ReceiveMessage> page(Pager pager, ReceiveMessageSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, ReceiveMessage.class, pager, param);
	}

	private String buildCondition(String sql, ReceiveMessageSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
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

	@Override
	public long count(ReceiveMessageSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

}
