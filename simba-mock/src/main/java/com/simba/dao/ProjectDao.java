package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Project;

/**
 *  Dao
 * 
 * @author caozj
 * 
 */
public interface ProjectDao {

	void add(Project project);

	void update(Project project);

	void delete(Integer id);

	List<Project> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	List<Project> page(Pager page);

	Project get(Integer id);
	
	Project getBy(String field, Object value);

	Project getByAnd(String field1, Object value1, String field2, Object value2);

	Project getByOr(String field1, Object value1, String field2, Object value2);

	List<Project> listBy(String field, Object value);

	List<Project> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Project> listByOr(String field1, Object value1, String field2, Object value2);

	List<Project> pageBy(String field, Object value, Pager page);

	List<Project> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Project> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

    void add(String sessAccount, Project project);

}
