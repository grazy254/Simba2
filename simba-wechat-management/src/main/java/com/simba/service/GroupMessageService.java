package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.GroupMessage;
import com.simba.model.form.GroupMessageSearchForm;

/**
 * 群发消息 Service
 * 
 * @author caozj
 * 
 */
public interface GroupMessageService {

	void add(GroupMessage groupMessage);

	void update(GroupMessage groupMessage);

	void delete(Long id);

	List<GroupMessage> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<GroupMessage> page(Pager page);

	GroupMessage get(Long id);

	void batchDelete(List<Long> idList);

	GroupMessage getBy(String field, Object value);

	GroupMessage getByAnd(String field1, Object value1, String field2, Object value2);

	GroupMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<GroupMessage> listBy(String field, Object value);

	List<GroupMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<GroupMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<GroupMessage> pageBy(String field, Object value, Pager page);

	List<GroupMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<GroupMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	int count(GroupMessageSearchForm searchForm);

	List<GroupMessage> page(Pager pager, GroupMessageSearchForm searchForm);

	/**
	 * 检查所有群发消息状态，如果发送完成，则修改状态
	 */
	void checkStatus();

	void preview(GroupMessage groupMessage, String previewOpenid);

}
