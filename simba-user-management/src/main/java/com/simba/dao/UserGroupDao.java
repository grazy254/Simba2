package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UserGroup;

/**
 * 用户分组关联表 Dao
 * 
 * @author caozj
 * 
 */
public interface UserGroupDao {

	void add(UserGroup userGroup);

	void update(UserGroup userGroup);

	void delete(Long id);

	List<UserGroup> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<UserGroup> page(Pager page);

	UserGroup get(Long id);
	
	UserGroup getBy(String field, Object value);

	UserGroup getByAnd(String field1, Object value1, String field2, Object value2);

	UserGroup getByOr(String field1, Object value1, String field2, Object value2);

	List<UserGroup> listBy(String field, Object value);

	List<UserGroup> listByAnd(String field1, Object value1, String field2, Object value2);

	List<UserGroup> listByOr(String field1, Object value1, String field2, Object value2);

	List<UserGroup> pageBy(String field, Object value, Pager page);

	List<UserGroup> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<UserGroup> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	
	

}
