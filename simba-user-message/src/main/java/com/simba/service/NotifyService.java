package com.simba.service;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Notify;

import java.util.List;

/**
 *通知表 Service
 * 
 * @author caozj
 * 
 */
public interface NotifyService {

	void add(Notify notify);

	void update(Notify notify);

	void delete(Long id);

	List<Notify> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<Notify> page(Pager page);
	
	Notify get(Long id);
	
	void batchDelete(List<Long> idList);

	Notify getBy(String field, Object value);

	Notify getByAnd(String field1, Object value1, String field2, Object value2);

	Notify getByOr(String field1, Object value1, String field2, Object value2);

	List<Notify> listBy(String field, Object value);

	List<Notify> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Notify> listByOr(String field1, Object value1, String field2, Object value2);

	List<Notify> pageBy(String field, Object value, Pager page);

	List<Notify> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Notify> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

    void sendNotify(String title, String content, Long[] smartUserId, int type);

	List<Notify> pullNotify(Long smartUserId, int status);

	List<Notify> pullNotify(Long smartUserId);

    void setNotifyRead(Long smartUserId, Long notifyId);
}
