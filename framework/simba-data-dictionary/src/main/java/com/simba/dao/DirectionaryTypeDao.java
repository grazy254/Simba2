package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DirectionaryType;
import com.simba.model.form.SearchDirectionaryTypeForm;
/**
 * 字典类型 Dao
 * 
 * @author caozj
 * 
 */
public interface DirectionaryTypeDao {

	void add(DirectionaryType directionaryType);

	void update(DirectionaryType directionaryType);

	void delete(Long id);

	List<DirectionaryType> listAll();
	
	Long count();
	
	Long count(SearchDirectionaryTypeForm searchDirectionaryTypeForm);
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<DirectionaryType> page(Pager page);
	
	List<DirectionaryType> page(Pager page, SearchDirectionaryTypeForm searchDirectionaryTypeForm);
	DirectionaryType get(Long id);
	
	DirectionaryType getBy(String field, Object value);

	DirectionaryType getByAnd(String field1, Object value1, String field2, Object value2);

	DirectionaryType getByOr(String field1, Object value1, String field2, Object value2);

	List<DirectionaryType> listBy(String field, Object value);

	List<DirectionaryType> listByAnd(String field1, Object value1, String field2, Object value2);

	List<DirectionaryType> listByOr(String field1, Object value1, String field2, Object value2);

	List<DirectionaryType> pageBy(String field, Object value, Pager page);

	List<DirectionaryType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<DirectionaryType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	

}
