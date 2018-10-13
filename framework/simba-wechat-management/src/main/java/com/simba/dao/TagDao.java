package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Tag;

/**
 * 标签 Dao
 * 
 * @author caozj
 * 
 */
public interface TagDao {

	void add(Tag tag);

	void update(Tag tag);

	void delete(Integer id);

	List<Tag> listAll();

	int count();

	int countBy(String field, Object value);

	List<Tag> page(Pager page);

	Tag get(Integer id);

	Tag getBy(String field, Object value);

	Tag getByAnd(String field1, Object value1, String field2, Object value2);

	Tag getByOr(String field1, Object value1, String field2, Object value2);

	List<Tag> listBy(String field, Object value);

	List<Tag> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Tag> listByOr(String field1, Object value1, String field2, Object value2);

	List<Tag> pageBy(String field, Object value, Pager page);

	List<Tag> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Tag> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void deleteByWxTagId(int wxTagId);

	List<Integer> listAllWxTagIds();

	void updateName(Tag tag);

}
