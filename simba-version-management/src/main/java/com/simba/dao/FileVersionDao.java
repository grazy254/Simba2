package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FileVersion;

/**
 * 文件版本管理 Dao
 * 
 * @author caozj
 * 
 */
public interface FileVersionDao {

	void add(FileVersion fileVersion);

	void update(FileVersion fileVersion);

	void delete(Integer id);

	List<FileVersion> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<FileVersion> page(Pager page);

	FileVersion get(Integer id);

	FileVersion getNewest(int typeId);

	FileVersion getBy(String field, Object value);

	FileVersion getByAnd(String field1, Object value1, String field2, Object value2);

	FileVersion getByOr(String field1, Object value1, String field2, Object value2);

	List<FileVersion> listBy(String field, Object value);

	List<FileVersion> listByAnd(String field1, Object value1, String field2, Object value2);

	List<FileVersion> listByOr(String field1, Object value1, String field2, Object value2);

	List<FileVersion> pageBy(String field, Object value, Pager page);

	List<FileVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<FileVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
