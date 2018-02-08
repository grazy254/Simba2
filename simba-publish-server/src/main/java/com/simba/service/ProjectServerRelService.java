package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectServerRel;

/**
 * 项目绑定部署的服务器 Service
 * 
 * @author caozj
 * 
 */
public interface ProjectServerRelService {

	void add(ProjectServerRel projectServerRel);

	void update(ProjectServerRel projectServerRel);

	void delete(Integer id);

	List<ProjectServerRel> listAll();

	Integer count();

	Integer countBy(String field, Object value);

	Integer countByAnd(String field1, Object value1, String field2, Object value2);

	Integer countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServerRel> page(Pager page);

	ProjectServerRel get(Integer id);

	void batchDelete(List<Integer> idList);

	ProjectServerRel getBy(String field, Object value);

	ProjectServerRel getByAnd(String field1, Object value1, String field2, Object value2);

	ProjectServerRel getByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServerRel> listBy(String field, Object value);

	List<ProjectServerRel> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ProjectServerRel> listByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServerRel> pageBy(String field, Object value, Pager page);

	List<ProjectServerRel> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ProjectServerRel> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void bindServers(int projectId, List<ProjectServerRel> rels);

}
