package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MsgTemplate;

/**
 * 短信模板 Dao
 * 
 * @author caozj
 * 
 */
public interface MsgTemplateDao {

	void add(MsgTemplate template);

	void update(MsgTemplate template);

	void delete(Integer id);

	List<MsgTemplate> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<MsgTemplate> page(Pager page);

	MsgTemplate get(Integer id);
	
	MsgTemplate getBy(String field, Object value);

	MsgTemplate getByAnd(String field1, Object value1, String field2, Object value2);

	MsgTemplate getByOr(String field1, Object value1, String field2, Object value2);

	List<MsgTemplate> listBy(String field, Object value);

	List<MsgTemplate> listByAnd(String field1, Object value1, String field2, Object value2);

	List<MsgTemplate> listByOr(String field1, Object value1, String field2, Object value2);

	List<MsgTemplate> pageBy(String field, Object value, Pager page);

	List<MsgTemplate> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<MsgTemplate> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
