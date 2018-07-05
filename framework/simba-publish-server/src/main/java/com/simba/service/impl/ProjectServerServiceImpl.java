package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ProjectServerDao;
import com.simba.dao.ProjectServerRelDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectServer;
import com.simba.service.ProjectServerService;

/**
 * 服务器 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ProjectServerServiceImpl implements ProjectServerService {

	@Autowired
	private ProjectServerDao projectServerDao;

	@Autowired
	private ProjectServerRelDao projectServerRelDao;

	@Override
	public void add(ProjectServer projectServer) {
		projectServerDao.add(projectServer);
	}

	@Override
	public void delete(Integer id) {
		projectServerDao.delete(id);
		projectServerRelDao.deleteBy("serverId", id);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServer get(Integer id) {
		return projectServerDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> page(Pager page) {
		return projectServerDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return projectServerDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return projectServerDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		projectServerDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> listAll() {
		return projectServerDao.listAll();
	}

	@Override
	public void update(ProjectServer projectServer) {
		projectServerDao.update(projectServer);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServer getBy(String field, Object value) {
		return projectServerDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServer getByAnd(String field1, Object value1, String field2, Object value2) {
		return projectServerDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectServer getByOr(String field1, Object value1, String field2, Object value2) {
		return projectServerDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> listBy(String field, Object value) {
		return projectServerDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> listByAnd(String field1, Object value1, String field2, Object value2) {
		return projectServerDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> listByOr(String field1, Object value1, String field2, Object value2) {
		return projectServerDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> pageBy(String field, Object value, Pager page) {
		return projectServerDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectServerDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectServer> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectServerDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		projectServerDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		projectServerDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countByAnd(String field1, Object value1, String field2, Object value2) {
		return projectServerDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countByOr(String field1, Object value1, String field2, Object value2) {
		return projectServerDao.countByOr(field1, value1, field2, value2);
	}
}
