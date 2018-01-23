package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ExceptionInfo;
import com.simba.model.form.ExceptionInfoSearchForm;

/**
 * 异常信息 Dao
 * 
 * @author caozj
 * 
 */
public interface ExceptionInfoDao {

	void add(ExceptionInfo exceptionInfo);

	void update(ExceptionInfo exceptionInfo);

	void delete(Long id);

	List<ExceptionInfo> listAll();

	Long count();

	Long countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<ExceptionInfo> page(Pager page);

	ExceptionInfo get(Long id);

	ExceptionInfo getBy(String field, Object value);

	ExceptionInfo getByAnd(String field1, Object value1, String field2, Object value2);

	ExceptionInfo getByOr(String field1, Object value1, String field2, Object value2);

	List<ExceptionInfo> listBy(String field, Object value);

	List<ExceptionInfo> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ExceptionInfo> listByOr(String field1, Object value1, String field2, Object value2);

	List<ExceptionInfo> pageBy(String field, Object value, Pager page);

	List<ExceptionInfo> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ExceptionInfo> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<ExceptionInfo> page(Pager pager, ExceptionInfoSearchForm searchForm);

	Long count(ExceptionInfoSearchForm searchForm);

}
