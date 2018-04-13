package com.simba.service;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MsgBlacklist;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service
 * 
 * @author caozj
 * 
 */
public interface MsgBlacklistService {

	void add(MsgBlacklist blacklist);

	void update(MsgBlacklist blacklist);

	void delete(Integer id);

	List<MsgBlacklist> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<MsgBlacklist> page(Pager page);

	MsgBlacklist get(Integer id);
	
	void batchDelete(List<Integer> idList);

	MsgBlacklist getBy(String field, Object value);

	MsgBlacklist getByAnd(String field1, Object value1, String field2, Object value2);

	MsgBlacklist getByOr(String field1, Object value1, String field2, Object value2);

	List<MsgBlacklist> listBy(String field, Object value);

	List<MsgBlacklist> listByAnd(String field1, Object value1, String field2, Object value2);

	List<MsgBlacklist> listByOr(String field1, Object value1, String field2, Object value2);

	List<MsgBlacklist> pageBy(String field, Object value, Pager page);

	List<MsgBlacklist> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<MsgBlacklist> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<String> filterBlacklist(List<String> mobileList);

	@Transactional(readOnly = true)
	boolean inBlackList(String mobile);

	boolean isDuplicated(String mobile);
}
