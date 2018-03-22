package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UploadNews;
import com.simba.model.form.UploadNewsSearchForm;

/**
 * 上传图文 Dao
 * 
 * @author caozj
 * 
 */
public interface UploadNewsDao {

	void add(UploadNews uploadNews);

	void update(UploadNews uploadNews);

	void delete(Long id);

	List<UploadNews> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<UploadNews> page(Pager page);

	UploadNews get(Long id);

	UploadNews getBy(String field, Object value);

	UploadNews getByAnd(String field1, Object value1, String field2, Object value2);

	UploadNews getByOr(String field1, Object value1, String field2, Object value2);

	List<UploadNews> listBy(String field, Object value);

	List<UploadNews> listByAnd(String field1, Object value1, String field2, Object value2);

	List<UploadNews> listByOr(String field1, Object value1, String field2, Object value2);

	List<UploadNews> pageBy(String field, Object value, Pager page);

	List<UploadNews> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<UploadNews> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<UploadNews> page(Pager pager, UploadNewsSearchForm searchForm);

	int count(UploadNewsSearchForm searchForm);

}
