package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectServerRel;

/**
 * 项目绑定部署的服务器 Dao
 * 
 * @author caozj
 * 
 */
public interface ProjectServerRelDao {

	void add(ProjectServerRel projectServerRel);

	void update(ProjectServerRel projectServerRel);

	void delete(int id);

	List<ProjectServerRel> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	int countByAnd(String field1, Object value1, String field2, Object value2);
	
	int countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<ProjectServerRel> page(Pager page);

	ProjectServerRel get(int id);
	
	ProjectServerRel getBy(String field, Object value);

	ProjectServerRel getByAnd(String field1, Object value1, String field2, Object value2);

	ProjectServerRel getByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServerRel> listBy(String field, Object value);

	List<ProjectServerRel> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ProjectServerRel> listByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServerRel> pageBy(String field, Object value, Pager page);

	List<ProjectServerRel> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ProjectServerRel> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	
	

}
