package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ForeverMedia;
import com.simba.model.form.ForeverMediaSearchForm;

/**
 * 永久素材 Service
 * 
 * @author caozj
 * 
 */
public interface ForeverMediaService {

	void add(ForeverMedia foreverMedia);

	void update(ForeverMedia foreverMedia);

	void delete(Long id) throws IOException, FastdfsException;

	List<ForeverMedia> listAll();

	int count();

	int countBy(String field, Object value);

	List<ForeverMedia> page(Pager page);

	ForeverMedia get(Long id);

	void batchDelete(List<Long> idList) throws IOException, FastdfsException;

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

	void add(ForeverMedia foreverMedia, MultipartFile file) throws IOException, FastdfsException;

}
