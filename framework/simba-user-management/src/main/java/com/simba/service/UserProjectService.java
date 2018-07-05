package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UserProject;
import com.simba.model.form.ProjectSearchForm;

/**
 * 项目 Service
 * 
 * @author caozj
 * 
 */
public interface UserProjectService {

	void add(UserProject project);

	void update(UserProject project);

	void delete(Integer id);

	List<UserProject> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<UserProject> page(Pager page);

	UserProject get(Integer id);

	void batchDelete(List<Integer> idList);

	UserProject getBy(String field, Object value);

	UserProject getByAnd(String field1, Object value1, String field2, Object value2);

	UserProject getByOr(String field1, Object value1, String field2, Object value2);

	List<UserProject> listBy(String field, Object value);

	List<UserProject> listByAnd(String field1, Object value1, String field2, Object value2);

	List<UserProject> listByOr(String field1, Object value1, String field2, Object value2);

	List<UserProject> pageBy(String field, Object value, Pager page);

	List<UserProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<UserProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<UserProject> page(Pager pager, ProjectSearchForm searchForm);

	int count(ProjectSearchForm searchForm);

}
