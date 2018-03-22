package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ThirdSystemUser;

/**
 *  Dao
 * 
 * @author caozj
 * 
 */
public interface ThirdSystemUserDao {

	void add(ThirdSystemUser thirdSystemUser);

	void update(ThirdSystemUser thirdSystemUser);

	void delete(Long id);

	List<ThirdSystemUser> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<ThirdSystemUser> page(Pager page);

	ThirdSystemUser get(Long id);
	
	ThirdSystemUser getBy(String field, Object value);

	ThirdSystemUser getByAnd(String field1, Object value1, String field2, Object value2);

	ThirdSystemUser getByOr(String field1, Object value1, String field2, Object value2);

	List<ThirdSystemUser> listBy(String field, Object value);

	List<ThirdSystemUser> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ThirdSystemUser> listByOr(String field1, Object value1, String field2, Object value2);

	List<ThirdSystemUser> pageBy(String field, Object value, Pager page);

	List<ThirdSystemUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ThirdSystemUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
