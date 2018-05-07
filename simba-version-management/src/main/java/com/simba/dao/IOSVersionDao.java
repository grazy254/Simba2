package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.IOSVersion;

/**
 * IOS安装包版本管理 Dao
 * 
 * @author caozj
 * 
 */
public interface IOSVersionDao {

	void add(IOSVersion iOSVersion);

	void update(IOSVersion iOSVersion);

	void delete(Integer id);

	List<IOSVersion> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<IOSVersion> page(Pager page);

	IOSVersion get(Integer id);

	IOSVersion getBy(String field, Object value);

	IOSVersion getByAnd(String field1, Object value1, String field2, Object value2);

	IOSVersion getByOr(String field1, Object value1, String field2, Object value2);

	List<IOSVersion> listBy(String field, Object value);

	List<IOSVersion> listByAnd(String field1, Object value1, String field2, Object value2);

	List<IOSVersion> listByOr(String field1, Object value1, String field2, Object value2);

	List<IOSVersion> pageBy(String field, Object value, Pager page);

	List<IOSVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<IOSVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	IOSVersion getNewestVersionByTpeId(int typeId);

}
