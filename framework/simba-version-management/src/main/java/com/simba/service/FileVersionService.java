package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FileVersion;

/**
 * 文件版本管理 Service
 * 
 * @author caozj
 * 
 */
public interface FileVersionService {

	void add(FileVersion fileVersion);

	void add(FileVersion fileVersion, MultipartFile file) throws IOException, FastdfsException;

	void update(FileVersion fileVersion);

	void delete(Integer id) throws IOException, FastdfsException;

	List<FileVersion> listAll();

	FileVersion getNewest(int typeId);

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<FileVersion> page(Pager page);

	FileVersion get(Integer id);

	void batchDelete(List<Integer> idList) throws IOException, FastdfsException;

	FileVersion getBy(String field, Object value);

	FileVersion getByAnd(String field1, Object value1, String field2, Object value2);

	FileVersion getByOr(String field1, Object value1, String field2, Object value2);

	List<FileVersion> listBy(String field, Object value);

	List<FileVersion> listByAnd(String field1, Object value1, String field2, Object value2);

	List<FileVersion> listByOr(String field1, Object value1, String field2, Object value2);

	List<FileVersion> pageBy(String field, Object value, Pager page);

	List<FileVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<FileVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void update(FileVersion fileVersion, MultipartFile file) throws IOException, FastdfsException;

}
