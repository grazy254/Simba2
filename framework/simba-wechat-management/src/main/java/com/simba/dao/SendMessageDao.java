package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.SendMessage;
import com.simba.model.form.SendMessageSearchForm;

/**
 * 发消息 Dao
 * 
 * @author caozj
 * 
 */
public interface SendMessageDao {

	void add(SendMessage sendMessage);

	void update(SendMessage sendMessage);

	void delete(Long id);

	List<SendMessage> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<SendMessage> page(Pager page);

	SendMessage get(Long id);

	SendMessage getBy(String field, Object value);

	SendMessage getByAnd(String field1, Object value1, String field2, Object value2);

	SendMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<SendMessage> listBy(String field, Object value);

	List<SendMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<SendMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<SendMessage> pageBy(String field, Object value, Pager page);

	List<SendMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<SendMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<SendMessage> page(Pager pager, SendMessageSearchForm searchForm);

	int count(SendMessageSearchForm searchForm);

}
