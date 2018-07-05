package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UploadImage;
import com.simba.model.form.UploadImageSearchForm;

/**
 * 上传图片 Dao
 * 
 * @author caozj
 * 
 */
public interface UploadImageDao {

	void add(UploadImage uploadImage);

	void update(UploadImage uploadImage);

	void delete(Long id);

	List<UploadImage> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<UploadImage> page(Pager page);

	UploadImage get(Long id);

	UploadImage getBy(String field, Object value);

	UploadImage getByAnd(String field1, Object value1, String field2, Object value2);

	UploadImage getByOr(String field1, Object value1, String field2, Object value2);

	List<UploadImage> listBy(String field, Object value);

	List<UploadImage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<UploadImage> listByOr(String field1, Object value1, String field2, Object value2);

	List<UploadImage> pageBy(String field, Object value, Pager page);

	List<UploadImage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<UploadImage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<UploadImage> page(Pager pager, UploadImageSearchForm searchForm);

	int count(UploadImageSearchForm searchForm);

}
