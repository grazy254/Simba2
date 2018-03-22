package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UploadImage;
import com.simba.model.form.UploadImageSearchForm;

/**
 * 上传图片 Service
 * 
 * @author caozj
 * 
 */
public interface UploadImageService {

	void add(UploadImage uploadImage);

	void update(UploadImage uploadImage);

	void delete(Long id) throws IOException, FastdfsException;

	List<UploadImage> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<UploadImage> page(Pager page);

	UploadImage get(Long id);

	void batchDelete(List<Long> idList) throws IOException, FastdfsException;

	UploadImage getBy(String field, Object value);

	UploadImage getByAnd(String field1, Object value1, String field2, Object value2);

	UploadImage getByOr(String field1, Object value1, String field2, Object value2);

	List<UploadImage> listBy(String field, Object value);

	List<UploadImage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<UploadImage> listByOr(String field1, Object value1, String field2, Object value2);

	List<UploadImage> pageBy(String field, Object value, Pager page);

	List<UploadImage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<UploadImage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void add(UploadImage uploadImage, MultipartFile file) throws IOException, FastdfsException;

	List<UploadImage> page(Pager pager, UploadImageSearchForm searchForm);

	int count(UploadImageSearchForm searchForm);

}
