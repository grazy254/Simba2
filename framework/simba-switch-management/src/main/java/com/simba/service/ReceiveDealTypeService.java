package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ReceiveDealType;
import com.simba.model.form.DealTypeSearchForm;

/**
 * 处理接收消息类型 Service
 * 
 * @author caozj
 * 
 */
public interface ReceiveDealTypeService {

	void add(ReceiveDealType receiveDealType);

	void update(ReceiveDealType receiveDealType);

	void delete(Integer id);

	List<ReceiveDealType> listAll();

	Integer count();

	Integer countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<ReceiveDealType> page(Pager page);

	ReceiveDealType get(Integer id);

	void batchDelete(List<Integer> idList);

	ReceiveDealType getBy(String field, Object value);

	ReceiveDealType getByAnd(String field1, Object value1, String field2, Object value2);

	ReceiveDealType getByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveDealType> listBy(String field, Object value);

	List<ReceiveDealType> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ReceiveDealType> listByOr(String field1, Object value1, String field2, Object value2);

	List<ReceiveDealType> pageBy(String field, Object value, Pager page);

	List<ReceiveDealType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveDealType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<ReceiveDealType> page(Pager pager, DealTypeSearchForm searchForm);

	Integer count(DealTypeSearchForm searchForm);

}
