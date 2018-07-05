package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.OperLog;
import com.simba.model.form.OperLogSearchForm;

/**
 * 操作日志 Dao
 * 
 * @author caozj
 * 
 */
public interface OperLogDao {

	void add(OperLog operLog);

	void update(OperLog operLog);

	void delete(Long id);

	List<OperLog> listAll();

	Long count();

	Long countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<OperLog> page(Pager page);

	OperLog get(Long id);

	OperLog getBy(String field, Object value);

	OperLog getByAnd(String field1, Object value1, String field2, Object value2);

	OperLog getByOr(String field1, Object value1, String field2, Object value2);

	List<OperLog> listBy(String field, Object value);

	List<OperLog> listByAnd(String field1, Object value1, String field2, Object value2);

	List<OperLog> listByOr(String field1, Object value1, String field2, Object value2);

	List<OperLog> pageBy(String field, Object value, Pager page);

	List<OperLog> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<OperLog> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<OperLog> page(Pager pager, OperLogSearchForm searchForm);

	Long count(OperLogSearchForm searchForm);

}
