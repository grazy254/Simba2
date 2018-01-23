package com.simba.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ProjectVersionDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectVersion;
import com.simba.service.ProjectVersionService;

/**
 * 项目版本 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ProjectVersionServiceImpl implements ProjectVersionService {

	@Autowired
	private ProjectVersionDao projectVersionDao;

	@Override
	public void add(ProjectVersion projectVersion) {
		projectVersionDao.add(projectVersion);
	}

	@Override
	public void delete(Integer id) {
		ProjectVersion projectVersion = this.get(id);
		projectVersionDao.delete(id);
		FileUtils.deleteQuietly(new File(projectVersion.getFilePath()));
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectVersion get(Integer id) {
		return projectVersionDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> page(Pager page) {
		return projectVersionDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return projectVersionDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return projectVersionDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		projectVersionDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> listAll() {
		return projectVersionDao.listAll();
	}

	@Override
	public void update(ProjectVersion projectVersion) {
		projectVersionDao.update(projectVersion);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectVersion getBy(String field, Object value) {
		return projectVersionDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectVersion getByAnd(String field1, Object value1, String field2, Object value2) {
		return projectVersionDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectVersion getByOr(String field1, Object value1, String field2, Object value2) {
		return projectVersionDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> listBy(String field, Object value) {
		return projectVersionDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
		return projectVersionDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> listByOr(String field1, Object value1, String field2, Object value2) {
		return projectVersionDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> pageBy(String field, Object value, Pager page) {
		return projectVersionDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectVersionDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectVersionDao.pageByOr(field1, value1, field2, value2, page);
	}

}
