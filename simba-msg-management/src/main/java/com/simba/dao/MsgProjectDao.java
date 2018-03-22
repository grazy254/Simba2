package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MsgProject;

/**
 * 项目 Dao
 * 
 * @author caozj
 * 
 */
public interface MsgProjectDao {

	void add(MsgProject project);

	void update(MsgProject project);

	void delete(Integer id);

	List<MsgProject> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<MsgProject> page(Pager page);

	MsgProject get(Integer id);
	
	MsgProject getBy(String field, Object value);

	MsgProject getByAnd(String field1, Object value1, String field2, Object value2);

	MsgProject getByOr(String field1, Object value1, String field2, Object value2);

	List<MsgProject> listBy(String field, Object value);

	List<MsgProject> listByAnd(String field1, Object value1, String field2, Object value2);

	List<MsgProject> listByOr(String field1, Object value1, String field2, Object value2);

	List<MsgProject> pageBy(String field, Object value, Pager page);

	List<MsgProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<MsgProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}