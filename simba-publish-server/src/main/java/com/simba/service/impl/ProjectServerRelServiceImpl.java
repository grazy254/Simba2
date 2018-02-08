package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ProjectServerRelDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectServerRel;
import com.simba.service.ProjectServerRelService;

/**
 * 项目绑定部署的服务器 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ProjectServerRelServiceImpl implements ProjectServerRelService {

	@Autowired
	private ProjectServerRelDao projectServerRelDao;

	@Override
	public void add(ProjectServerRel projectServerRel) {
		projectServerRelDao.add(projectServerRel);
	}

	@Override
	public void delete(Integer id) {
		projectServerRelDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServerRel get(Integer id) {
		return projectServerRelDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> page(Pager page) {
		return projectServerRelDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return projectServerRelDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return projectServerRelDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		projectServerRelDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> listAll() {
		return projectServerRelDao.listAll();
	}

	@Override
	public void update(ProjectServerRel projectServerRel) {
		projectServerRelDao.update(projectServerRel);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServerRel getBy(String field, Object value) {
		return projectServerRelDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServerRel getByAnd(String field1, Object value1, String field2, Object value2) {
		return projectServerRelDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServerRel getByOr(String field1, Object value1, String field2, Object value2) {
		return projectServerRelDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> listBy(String field, Object value) {
		return projectServerRelDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> listByAnd(String field1, Object value1, String field2, Object value2) {
		return projectServerRelDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> listByOr(String field1, Object value1, String field2, Object value2) {
		return projectServerRelDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> pageBy(String field, Object value, Pager page) {
		return projectServerRelDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectServerRelDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServerRel> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectServerRelDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		projectServerRelDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		projectServerRelDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countByAnd(String field1, Object value1, String field2, Object value2) {
		return projectServerRelDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countByOr(String field1, Object value1, String field2, Object value2) {
		return projectServerRelDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public void bindServers(int projectId, List<ProjectServerRel> rels) {
		projectServerRelDao.deleteBy("projectId", projectId);
		rels.forEach((ProjectServerRel rel) -> {
			this.add(rel);
		});
	}
}
