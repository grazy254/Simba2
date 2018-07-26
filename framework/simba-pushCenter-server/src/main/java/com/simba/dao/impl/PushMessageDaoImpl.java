package com.simba.dao.impl;

import com.simba.dao.PushMessageDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.PushMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 消息记录 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class PushMessageDaoImpl implements PushMessageDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "pushMessage";

	@Override
	public void add(PushMessage pushMessage) {
		String sql = "insert into " + table + "( toUserId, fromUserId, pushType, content, createTime) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, pushMessage.getToUserId(),pushMessage.getFromUserId(),pushMessage.getPushType(),pushMessage.getContent(),pushMessage.getCreateTime());
	}

	@Override
	public void update(PushMessage pushMessage) {
		String sql = "update " + table + " set  toUserId = ? , fromUserId = ? , pushType = ? , content = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,pushMessage.getToUserId(),pushMessage.getFromUserId(),pushMessage.getPushType(),pushMessage.getContent(),pushMessage.getCreateTime(), pushMessage.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<PushMessage> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, PushMessage.class, page);
	}
	@Override
	public List<PushMessage> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, PushMessage.class);
	}
	
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}
	
	@Override
	public PushMessage get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, PushMessage.class, id);
	}
	
	@Override
	public PushMessage getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, PushMessage.class, value);
	}

	@Override
	public PushMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, PushMessage.class, value1, value2);
	}

	@Override
	public PushMessage getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, PushMessage.class, value1, value2);
	}

	@Override
	public List<PushMessage> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, PushMessage.class, value);
	}

	@Override
	public List<PushMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, PushMessage.class, value1, value2);
	}

	@Override
	public List<PushMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, PushMessage.class, value1, value2);
	}

	@Override
	public List<PushMessage> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, PushMessage.class, page, param);
	}

	@Override
	public List<PushMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PushMessage.class, page, param);
	}

	@Override
	public List<PushMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PushMessage.class, page, param);
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
}
