package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ApplicationUser;

/**
 * 用户应用表 Dao
 * 
 * @author caozj
 * 
 */
public interface ApplicationUserDao {

	void add(ApplicationUser applicationUser);

	void update(ApplicationUser applicationUser);

	void delete(Long id);

	List<ApplicationUser> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<ApplicationUser> page(Pager page);

	ApplicationUser get(Long id);
	
	ApplicationUser getBy(String field, Object value);

	ApplicationUser getByAnd(String field1, Object value1, String field2, Object value2);

	ApplicationUser getByOr(String field1, Object value1, String field2, Object value2);

	List<ApplicationUser> listBy(String field, Object value);

	List<ApplicationUser> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ApplicationUser> listByOr(String field1, Object value1, String field2, Object value2);

	List<ApplicationUser> pageBy(String field, Object value, Pager page);

	List<ApplicationUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ApplicationUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
