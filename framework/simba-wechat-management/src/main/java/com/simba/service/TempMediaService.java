package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TempMedia;
import com.simba.model.form.TempMediaSearchForm;

/**
 * 临时素材 Service
 * 
 * @author caozj
 * 
 */
public interface TempMediaService {

	void add(TempMedia tempMedia);

	void update(TempMedia tempMedia);

	void delete(Long id);

	List<TempMedia> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<TempMedia> page(Pager page);

	TempMedia get(Long id);

	void batchDelete(List<Long> idList);

	TempMedia getBy(String field, Object value);

	TempMedia getByAnd(String field1, Object value1, String field2, Object value2);

	TempMedia getByOr(String field1, Object value1, String field2, Object value2);

	List<TempMedia> listBy(String field, Object value);

	List<TempMedia> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TempMedia> listByOr(String field1, Object value1, String field2, Object value2);

	List<TempMedia> pageBy(String field, Object value, Pager page);

	List<TempMedia> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TempMedia> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void add(TempMedia tempMedia, MultipartFile file) throws IOException, FastdfsException;

	int count(TempMediaSearchForm searchForm);

	List<TempMedia> page(Pager pager, TempMediaSearchForm searchForm);

	/**
	 * 清理过期的临时素材
	 */
	void clearInvalidMedia() throws IOException, FastdfsException;

}
