package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DevProject;

/**
 * 项目 Dao
 * 
 * @author caozj
 * 
 */
public interface DevProjectDao {

	int add(DevProject devProject);

	void update(DevProject devProject);

	void delete(int id);

	List<DevProject> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	int countByAnd(String field1, Object value1, String field2, Object value2);
	
	int countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<DevProject> page(Pager page);

	DevProject get(int id);
	
	DevProject getBy(String field, Object value);

	DevProject getByAnd(String field1, Object value1, String field2, Object value2);

	DevProject getByOr(String field1, Object value1, String field2, Object value2);

	List<DevProject> listBy(String field, Object value);

	List<DevProject> listByAnd(String field1, Object value1, String field2, Object value2);

	List<DevProject> listByOr(String field1, Object value1, String field2, Object value2);

	List<DevProject> pageBy(String field, Object value, Pager page);

	List<DevProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<DevProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	
	

}
