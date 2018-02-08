package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectServer;

/**
 * 服务器 Dao
 * 
 * @author caozj
 * 
 */
public interface ProjectServerDao {

	void add(ProjectServer projectServer);

	void update(ProjectServer projectServer);

	void delete(int id);

	List<ProjectServer> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	int countByAnd(String field1, Object value1, String field2, Object value2);
	
	int countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<ProjectServer> page(Pager page);

	ProjectServer get(int id);
	
	ProjectServer getBy(String field, Object value);

	ProjectServer getByAnd(String field1, Object value1, String field2, Object value2);

	ProjectServer getByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServer> listBy(String field, Object value);

	List<ProjectServer> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ProjectServer> listByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServer> pageBy(String field, Object value, Pager page);

	List<ProjectServer> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ProjectServer> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	
	

}
