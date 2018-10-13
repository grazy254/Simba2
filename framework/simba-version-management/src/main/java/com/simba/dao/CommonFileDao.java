package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.CommonFile;
import com.simba.model.form.CommonFileSearchForm;

/**
 * 通用文件 Dao
 * 
 * @author caozj
 * 
 */
public interface CommonFileDao {

	void add(CommonFile commonFile);

	void update(CommonFile commonFile);

	void delete(Integer id);

	List<CommonFile> listAll();

	Integer count();

	Integer countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<CommonFile> page(Pager page);

	CommonFile get(Integer id);

	CommonFile getBy(String field, Object value);

	CommonFile getByAnd(String field1, Object value1, String field2, Object value2);

	CommonFile getByOr(String field1, Object value1, String field2, Object value2);

	List<CommonFile> listBy(String field, Object value);

	List<CommonFile> listByAnd(String field1, Object value1, String field2, Object value2);

	List<CommonFile> listByOr(String field1, Object value1, String field2, Object value2);

	List<CommonFile> pageBy(String field, Object value, Pager page);

	List<CommonFile> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<CommonFile> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<CommonFile> page(Pager pager, CommonFileSearchForm searchForm);

	Integer count(CommonFileSearchForm searchForm);

}
