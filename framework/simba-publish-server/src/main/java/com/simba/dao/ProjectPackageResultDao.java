package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectPackageResult;

/**
 * 项目打包结果 Dao
 * 
 * @author caozj
 * 
 */
public interface ProjectPackageResultDao {

	void add(ProjectPackageResult projectPackageResult);

	void update(ProjectPackageResult projectPackageResult);

	void delete(Integer id);

	List<ProjectPackageResult> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	Integer countByAnd(String field1, Object value1, String field2, Object value2);
	
	Integer countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<ProjectPackageResult> page(Pager page);

	ProjectPackageResult get(Integer id);
	
	ProjectPackageResult getBy(String field, Object value);

	ProjectPackageResult getByAnd(String field1, Object value1, String field2, Object value2);

	ProjectPackageResult getByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectPackageResult> listBy(String field, Object value);

	List<ProjectPackageResult> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ProjectPackageResult> listByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectPackageResult> pageBy(String field, Object value, Pager page);

	List<ProjectPackageResult> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ProjectPackageResult> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	
	

}
