package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ForeverMedia;
import com.simba.model.form.ForeverMediaSearchForm;

/**
 * 永久素材 Dao
 * 
 * @author caozj
 * 
 */
public interface ForeverMediaDao {

	void add(ForeverMedia foreverMedia);

	void update(ForeverMedia foreverMedia);

	void delete(Long id);

	List<ForeverMedia> listAll();

	int count();

	int countBy(String field, Object value);

	List<ForeverMedia> page(Pager page);

	ForeverMedia get(Long id);

	ForeverMedia getBy(String field, Object value);

	ForeverMedia getByAnd(String field1, Object value1, String field2, Object value2);

	ForeverMedia getByOr(String field1, Object value1, String field2, Object value2);

	List<ForeverMedia> listBy(String field, Object value);

	List<ForeverMedia> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ForeverMedia> listByOr(String field1, Object value1, String field2, Object value2);

	List<ForeverMedia> pageBy(String field, Object value, Pager page);

	List<ForeverMedia> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ForeverMedia> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<ForeverMedia> page(Pager pager, ForeverMediaSearchForm searchForm);

	int count(ForeverMediaSearchForm searchForm);

}
