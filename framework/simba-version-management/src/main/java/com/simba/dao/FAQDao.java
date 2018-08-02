package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FAQ;
import com.simba.model.form.FAQSearchForm;

/**
 * 常见问题管理 Dao
 * 
 * @author caozj
 * 
 */
public interface FAQDao {

	void add(FAQ fAQ);

	void update(FAQ fAQ);

	void delete(Integer id);

	List<FAQ> listAll();

	Integer count();

	Integer countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<FAQ> page(Pager page);

	List<FAQ> page(Pager page, FAQSearchForm searchForm);

	FAQ get(Integer id);

	FAQ getBy(String field, Object value);

	FAQ getByAnd(String field1, Object value1, String field2, Object value2);

	FAQ getByOr(String field1, Object value1, String field2, Object value2);

	List<FAQ> listBy(String field, Object value);

	List<FAQ> listByAnd(String field1, Object value1, String field2, Object value2);

	List<FAQ> listByOr(String field1, Object value1, String field2, Object value2);

	List<FAQ> pageBy(String field, Object value, Pager page);

	List<FAQ> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<FAQ> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	Integer count(FAQSearchForm searchForm);

}
