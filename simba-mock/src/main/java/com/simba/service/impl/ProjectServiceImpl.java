package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ProjectDao;
import com.simba.dao.ProjectUserDao;
import com.simba.dao.UrlDataDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MockProject;
import com.simba.service.ProjectService;

/**
 * Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private ProjectUserDao projectUserDao;

	@Autowired
	private UrlDataDao urlDataDao;

	@Override
	public void add(MockProject project) {
		projectDao.add(project);
	}

	@Override
	public void add(String sessAccount, MockProject project) {
		projectDao.add(sessAccount, project);
	}

	@Override
	public void delete(Integer id) {
		urlDataDao.deleteByProjectId(id);
		projectUserDao.deleteByProjectId(id);
		projectDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public MockProject get(Integer id) {
		return projectDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> page(Pager page) {
		return projectDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return projectDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return projectDao.countBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> listAll() {
		return projectDao.listAll();
	}

	@Override
	public void update(MockProject project) {
		projectDao.update(project);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public MockProject getBy(String field, Object value) {
		return projectDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public MockProject getByAnd(String field1, Object value1, String field2, Object value2) {
		return projectDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public MockProject getByOr(String field1, Object value1, String field2, Object value2) {
		return projectDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> listBy(String field, Object value) {
		return projectDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> listByAnd(String field1, Object value1, String field2, Object value2) {
		return projectDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> listByOr(String field1, Object value1, String field2, Object value2) {
		return projectDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> pageBy(String field, Object value, Pager page) {
		return projectDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MockProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectDao.pageByOr(field1, value1, field2, value2, page);
	}

}
