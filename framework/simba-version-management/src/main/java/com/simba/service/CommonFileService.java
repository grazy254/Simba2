package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.CommonFile;
import com.simba.model.form.CommonFileSearchForm;

/**
 * 通用文件 Service
 * 
 * @author caozj
 * 
 */
public interface CommonFileService {

	void add(CommonFile commonFile);

	void update(CommonFile commonFile);

	void delete(Integer id) throws IOException, FastdfsException;

	List<CommonFile> listAll();

	Integer count();

	Integer countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<CommonFile> page(Pager page);

	CommonFile get(Integer id);

	void batchDelete(List<Integer> idList) throws IOException, FastdfsException;

	CommonFile getBy(String field, Object value);

	CommonFile getByAnd(String field1, Object value1, String field2, Object value2);

	CommonFile getByOr(String field1, Object value1, String field2, Object value2);

	List<CommonFile> listBy(String field, Object value);

	List<CommonFile> listByAnd(String field1, Object value1, String field2, Object value2);

	List<CommonFile> listByOr(String field1, Object value1, String field2, Object value2);

	List<CommonFile> pageBy(String field, Object value, Pager page);

	List<CommonFile> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<CommonFile> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<CommonFile> page(Pager pager, CommonFileSearchForm searchForm);

	Integer count(CommonFileSearchForm searchForm);

	void add(CommonFile commonFile, MultipartFile file) throws IOException, FastdfsException;

	void update(CommonFile commonFile, MultipartFile file) throws IOException, FastdfsException;

}
