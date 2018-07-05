package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TagFans;

/**
 * Dao
 * 
 * @author caozj
 * 
 */
public interface TagFansDao {

	void add(TagFans tagFans);

	void update(TagFans tagFans);

	void delete(Integer id);

	List<TagFans> listAll();

	int count();

	int countBy(String field, Object value);

	List<TagFans> page(Pager page);

	TagFans get(Integer id);

	TagFans getBy(String field, Object value);

	TagFans getByAnd(String field1, Object value1, String field2, Object value2);

	TagFans getByOr(String field1, Object value1, String field2, Object value2);

	List<TagFans> listBy(String field, Object value);

	List<TagFans> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TagFans> listByOr(String field1, Object value1, String field2, Object value2);

	List<TagFans> pageBy(String field, Object value, Pager page);

	List<TagFans> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TagFans> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void deleteByFansId(int fansId);

	void deleteByTagId(Integer tagId);

}
