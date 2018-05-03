package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.OperLogger;
import com.simba.model.form.OperLoggerSearchForm;

/**
 * 操作日志 Dao
 * 
 * @author caozj
 * 
 */
public interface OperLoggerDao {

	void add(OperLogger operLogger);

	void update(OperLogger operLogger);

	void delete(Long id);

	List<OperLogger> listAll();

	Long count(OperLoggerSearchForm operLoggerSearchForm);
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<OperLogger> page(Pager page);
	
	List<OperLogger> page(Pager page, OperLoggerSearchForm operLoggerSearchForm);

	OperLogger get(Long id);
	
	OperLogger getBy(String field, Object value);

	OperLogger getByAnd(String field1, Object value1, String field2, Object value2);

	OperLogger getByOr(String field1, Object value1, String field2, Object value2);

	List<OperLogger> listBy(String field, Object value);

	List<OperLogger> listByAnd(String field1, Object value1, String field2, Object value2);

	List<OperLogger> listByOr(String field1, Object value1, String field2, Object value2);

	List<OperLogger> pageBy(String field, Object value, Pager page);

	List<OperLogger> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<OperLogger> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	

}
