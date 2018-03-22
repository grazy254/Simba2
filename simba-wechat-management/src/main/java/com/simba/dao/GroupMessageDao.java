package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.GroupMessage;
import com.simba.model.form.GroupMessageSearchForm;

/**
 * 群发消息 Dao
 * 
 * @author caozj
 * 
 */
public interface GroupMessageDao {

	void add(GroupMessage groupMessage);

	void update(GroupMessage groupMessage);

	void delete(Long id);

	List<GroupMessage> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<GroupMessage> page(Pager page);

	GroupMessage get(Long id);

	GroupMessage getBy(String field, Object value);

	GroupMessage getByAnd(String field1, Object value1, String field2, Object value2);

	GroupMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<GroupMessage> listBy(String field, Object value);

	List<GroupMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<GroupMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<GroupMessage> pageBy(String field, Object value, Pager page);

	List<GroupMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<GroupMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<GroupMessage> page(Pager pager, GroupMessageSearchForm searchForm);

	int count(GroupMessageSearchForm searchForm);

}
