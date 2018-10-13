package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ReceiveEvent;
import com.simba.model.form.ReceiveEventSearchForm;

/**
 * 收到事件 Dao
 * 
 * @author caozj
 * 
 */
public interface ReceiveEventDao {

	void add(ReceiveEvent receiveEvent);

	void update(ReceiveEvent receiveEvent);

	void delete(Long id);

	List<ReceiveEvent> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<ReceiveEvent> page(Pager page);

	ReceiveEvent get(Long id);
	
	ReceiveEvent getBy(String field, Object value);

	ReceiveEvent getByAnd(String field1, Object value1, String field2, Object value2);

	ReceiveEvent getByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveEvent> listBy(String field, Object value);

	List<ReceiveEvent> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ReceiveEvent> listByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveEvent> pageBy(String field, Object value, Pager page);

	List<ReceiveEvent> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveEvent> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveEvent> page(Pager pager, ReceiveEventSearchForm searchForm);

	long count(ReceiveEventSearchForm searchForm);
}
