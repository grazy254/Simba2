package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MsgBlacklist;

/**
 * 黑名单 Dao
 * 
 * @author caozj
 * 
 */
public interface MsgBlacklistDao {

	void add(MsgBlacklist blacklist);

	void update(MsgBlacklist blacklist);

	void delete(Integer id);

	List<MsgBlacklist> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<MsgBlacklist> page(Pager page);

	MsgBlacklist get(Integer id);
	
	MsgBlacklist getBy(String field, Object value);

	MsgBlacklist getByAnd(String field1, Object value1, String field2, Object value2);

	MsgBlacklist getByOr(String field1, Object value1, String field2, Object value2);

	List<MsgBlacklist> listBy(String field, Object value);

	List<MsgBlacklist> listByAnd(String field1, Object value1, String field2, Object value2);

	List<MsgBlacklist> listByOr(String field1, Object value1, String field2, Object value2);

	List<MsgBlacklist> pageBy(String field, Object value, Pager page);

	List<MsgBlacklist> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<MsgBlacklist> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
