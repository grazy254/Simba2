package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Email;
/**
 *邮件记录 Service
 * 
 * @author caozj
 * 
 */
public interface EmailService {

	void add(Email email);

	void update(Email email);

	void delete(Long id);

	List<Email> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<Email> page(Pager page);
	
	Email get(Long id);
	
	void batchDelete(List<Long> idList);

	Email getBy(String field, Object value);

	Email getByAnd(String field1, Object value1, String field2, Object value2);

	Email getByOr(String field1, Object value1, String field2, Object value2);

	List<Email> listBy(String field, Object value);

	List<Email> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Email> listByOr(String field1, Object value1, String field2, Object value2);

	List<Email> pageBy(String field, Object value, Pager page);

	List<Email> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Email> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
