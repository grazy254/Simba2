package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Dictionary;
import com.simba.model.DictionaryType;
import com.simba.model.form.SearchDictionaryTypeForm;

/**
 * 字典类型 Service
 * 
 * @author caozj
 * 
 */
public interface DictionaryTypeService {

	void add(DictionaryType dictionaryType);

	void update(DictionaryType dictionaryType);

	void delete(Long id);

	List<DictionaryType> listAll();

	Long count();

	Long count(SearchDictionaryTypeForm searchDictionaryTypeForm);

	Long countBy(String field, Object value);

	Long countByAnd(String field1, Object value1, String field2, Object value2);

	Long countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<DictionaryType> page(Pager page);

	List<DictionaryType> page(Pager page, SearchDictionaryTypeForm searchDictionaryTypeForm);

	DictionaryType get(Long id);

	void batchDelete(List<Long> idList);

	DictionaryType getBy(String field, Object value);

	DictionaryType getByAnd(String field1, Object value1, String field2, Object value2);

	DictionaryType getByOr(String field1, Object value1, String field2, Object value2);

	List<DictionaryType> listBy(String field, Object value);

	List<DictionaryType> listByAnd(String field1, Object value1, String field2, Object value2);

	List<DictionaryType> listByOr(String field1, Object value1, String field2, Object value2);

	List<DictionaryType> pageBy(String field, Object value, Pager page);
//
	List<DictionaryType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<DictionaryType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<Dictionary> listByCode(String code);

}
