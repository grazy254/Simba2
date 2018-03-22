package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ReceiveMsg;
import com.simba.model.form.ReceiveMsgSearchForm;

/**
 * 接收消息 Dao
 * 
 * @author caozj
 * 
 */
public interface ReceiveMsgDao {

	void add(ReceiveMsg receiveMsg);

	void update(ReceiveMsg receiveMsg);

	void delete(Long id);

	List<ReceiveMsg> listAll();

	Long count();

	Long countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<ReceiveMsg> page(Pager page);

	ReceiveMsg get(Long id);

	ReceiveMsg getBy(String field, Object value);

	ReceiveMsg getByAnd(String field1, Object value1, String field2, Object value2);

	ReceiveMsg getByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveMsg> listBy(String field, Object value);

	List<ReceiveMsg> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ReceiveMsg> listByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveMsg> pageBy(String field, Object value, Pager page);

	List<ReceiveMsg> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveMsg> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveMsg> page(Pager pager, ReceiveMsgSearchForm searchForm);

	Long count(ReceiveMsgSearchForm searchForm);

}
