package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ReceiveMessage;
import com.simba.model.form.ReceiveMessageSearchForm;

/**
 * 收到消息 Dao
 * 
 * @author caozj
 * 
 */
public interface ReceiveMessageDao {

	void add(ReceiveMessage receiveMessage);

	void update(ReceiveMessage receiveMessage);

	void delete(Long id);

	List<ReceiveMessage> listAll();

	int count();

	int countBy(String field, Object value);

	List<ReceiveMessage> page(Pager page);

	ReceiveMessage get(Long id);

	ReceiveMessage getBy(String field, Object value);

	ReceiveMessage getByAnd(String field1, Object value1, String field2, Object value2);

	ReceiveMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveMessage> listBy(String field, Object value);

	List<ReceiveMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ReceiveMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveMessage> pageBy(String field, Object value, Pager page);

	List<ReceiveMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveMessage> page(Pager pager, ReceiveMessageSearchForm searchForm);

	long count(ReceiveMessageSearchForm searchForm);

}
