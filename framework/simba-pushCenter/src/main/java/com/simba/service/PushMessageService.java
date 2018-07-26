package com.simba.service;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PushMessage;

import java.util.List;

/**
 *消息记录 Service
 * 
 * @author caozj
 * 
 */
public interface PushMessageService {

	void add(PushMessage pushMessage);

	void update(PushMessage pushMessage);

	void delete(Long id);

	List<PushMessage> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<PushMessage> page(Pager page);
	
	PushMessage get(Long id);
	
	void batchDelete(List<Long> idList);

	PushMessage getBy(String field, Object value);

	PushMessage getByAnd(String field1, Object value1, String field2, Object value2);

	PushMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<PushMessage> listBy(String field, Object value);

	List<PushMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<PushMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<PushMessage> pageBy(String field, Object value, Pager page);

	List<PushMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<PushMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
