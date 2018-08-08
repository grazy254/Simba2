package com.simba.dao;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ApkVersion;

import java.util.List;

/**
 * apk管理 Dao
 * 
 * @author caozj
 * 
 */
public interface ApkVersionDao {

	void add(ApkVersion apkVersion);

	void update(ApkVersion apkVersion);

	void delete(Integer id);

	List<ApkVersion> listAll();
	
	Integer count();
	
	Integer countBy(String field, Object value);
	
	Integer countByAnd(String field1, Object value1, String field2, Object value2);
	
	Integer countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<ApkVersion> page(Pager page);
	
	ApkVersion get(Integer id);
	
	ApkVersion getBy(String field, Object value);

	ApkVersion getByAnd(String field1, Object value1, String field2, Object value2);

	ApkVersion getByOr(String field1, Object value1, String field2, Object value2);

	List<ApkVersion> listBy(String field, Object value);

	List<ApkVersion> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ApkVersion> listByOr(String field1, Object value1, String field2, Object value2);

	List<ApkVersion> pageBy(String field, Object value, Pager page);

	List<ApkVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ApkVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);


    ApkVersion getNewest(int typeId);
}
