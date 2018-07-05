package com.simba.dao;

import java.util.Date;
import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TempMedia;
import com.simba.model.form.TempMediaSearchForm;

/**
 * 临时素材 Dao
 * 
 * @author caozj
 * 
 */
public interface TempMediaDao {

	void add(TempMedia tempMedia);

	void update(TempMedia tempMedia);

	void delete(Long id);

	List<TempMedia> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<TempMedia> page(Pager page);

	TempMedia get(Long id);

	TempMedia getBy(String field, Object value);

	TempMedia getByAnd(String field1, Object value1, String field2, Object value2);

	TempMedia getByOr(String field1, Object value1, String field2, Object value2);

	List<TempMedia> listBy(String field, Object value);

	List<TempMedia> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TempMedia> listByOr(String field1, Object value1, String field2, Object value2);

	List<TempMedia> pageBy(String field, Object value, Pager page);

	List<TempMedia> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TempMedia> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	int count(TempMediaSearchForm searchForm);

	List<TempMedia> page(Pager pager, TempMediaSearchForm searchForm);

	List<TempMedia> listBefore(Date date);

	void deleteBefore(Date date);

}
