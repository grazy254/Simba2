package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UploadVideo;
import com.simba.model.form.UploadVideoSearchForm;

/**
 * 上传视频 Service
 * 
 * @author caozj
 * 
 */
public interface UploadVideoService {

	void add(UploadVideo uploadVideo);

	void update(UploadVideo uploadVideo);

	void delete(Long id);

	List<UploadVideo> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<UploadVideo> page(Pager page);

	UploadVideo get(Long id);

	void batchDelete(List<Long> idList);

	UploadVideo getBy(String field, Object value);

	UploadVideo getByAnd(String field1, Object value1, String field2, Object value2);

	UploadVideo getByOr(String field1, Object value1, String field2, Object value2);

	List<UploadVideo> listBy(String field, Object value);

	List<UploadVideo> listByAnd(String field1, Object value1, String field2, Object value2);

	List<UploadVideo> listByOr(String field1, Object value1, String field2, Object value2);

	List<UploadVideo> pageBy(String field, Object value, Pager page);

	List<UploadVideo> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<UploadVideo> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<UploadVideo> page(Pager pager, UploadVideoSearchForm searchForm);

	int count(UploadVideoSearchForm searchForm);

}
