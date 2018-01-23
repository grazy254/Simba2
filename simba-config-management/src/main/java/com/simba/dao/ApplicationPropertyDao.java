package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ApplicationProperty;

/**
 * 应用配置表 Dao
 * 
 * @author caozj
 * 
 */
public interface ApplicationPropertyDao {

	void add(ApplicationProperty applicationProperty);

	void update(ApplicationProperty applicationProperty);

	void delete(Long id);

	List<ApplicationProperty> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<ApplicationProperty> page(Pager page);

	ApplicationProperty get(Long id);
	
	ApplicationProperty getBy(String field, Object value);

	ApplicationProperty getByAnd(String field1, Object value1, String field2, Object value2);

	ApplicationProperty getByOr(String field1, Object value1, String field2, Object value2);

	List<ApplicationProperty> listBy(String field, Object value);

	List<ApplicationProperty> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ApplicationProperty> listByOr(String field1, Object value1, String field2, Object value2);

	List<ApplicationProperty> pageBy(String field, Object value, Pager page);

	List<ApplicationProperty> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ApplicationProperty> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
