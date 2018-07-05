package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FAQType;

/**
 * 常见问题类型管理 Dao
 * 
 * @author caozj
 * 
 */
public interface FAQTypeDao {

	void add(FAQType fAQType);

	void update(FAQType fAQType);

	void delete(Integer id);

	List<FAQType> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<FAQType> page(Pager page);

	FAQType get(Integer id);
	
	FAQType getBy(String field, Object value);

	FAQType getByAnd(String field1, Object value1, String field2, Object value2);

	FAQType getByOr(String field1, Object value1, String field2, Object value2);

	List<FAQType> listBy(String field, Object value);

	List<FAQType> listByAnd(String field1, Object value1, String field2, Object value2);

	List<FAQType> listByOr(String field1, Object value1, String field2, Object value2);

	List<FAQType> pageBy(String field, Object value, Pager page);

	List<FAQType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<FAQType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
