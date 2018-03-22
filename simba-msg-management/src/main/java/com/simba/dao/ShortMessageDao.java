package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ShortMessage;
import com.simba.model.form.ShortMsgSearchForm;

/**
 * 短信 Dao
 * 
 * @author caozj
 * 
 */
public interface ShortMessageDao {

	void add(ShortMessage shortMessage);

	void update(ShortMessage shortMessage);

	void delete(Long id);

	List<ShortMessage> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<ShortMessage> page(Pager page);

	ShortMessage get(Long id);
	
	ShortMessage getBy(String field, Object value);

	ShortMessage getByAnd(String field1, Object value1, String field2, Object value2);

	ShortMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<ShortMessage> listBy(String field, Object value);

	List<ShortMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ShortMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<ShortMessage> pageBy(String field, Object value, Pager page);

	List<ShortMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ShortMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	Long count(ShortMsgSearchForm searchForm);

	List<ShortMessage> page(Pager pager, ShortMsgSearchForm searchForm);

}
