package com.simba.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.OperLog;
import com.simba.model.form.OperLogSearchForm;

/**
 * 操作日志 Service
 * 
 * @author caozj
 * 
 */
public interface OperLogService {

	/**
	 * 增加操作日志
	 * 
	 * @param request
	 * @param content
	 *            日志内容
	 * @param async
	 *            是否异步
	 */
	void add(HttpServletRequest request, String content, boolean async);

	void add(OperLog operLog);

	void update(OperLog operLog);

	void delete(Long id);

	List<OperLog> listAll();

	Long count();

	Long countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<OperLog> page(Pager page);

	OperLog get(Long id);

	void batchDelete(List<Long> idList);

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
