package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.UserProjectDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UserProject;
import com.simba.model.form.ProjectSearchForm;
import com.simba.service.UserProjectService;

/**
 * 项目 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class UserProjectServiceImpl implements UserProjectService {

	@Autowired
	private UserProjectDao projectDao;

	@Override
	public void add(UserProject project) {
		projectDao.add(project);
	}

	@Override
	public void delete(Integer id) {
		projectDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UserProject get(Integer id) {
		return projectDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> page(Pager page) {
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
	public void deleteBy(String field, Object value) {
		projectDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> listAll() {
		return projectDao.listAll();
	}

	@Override
	public void update(UserProject project) {
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
	public UserProject getBy(String field, Object value) {
		return projectDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public UserProject getByAnd(String field1, Object value1, String field2, Object value2) {
		return projectDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public UserProject getByOr(String field1, Object value1, String field2, Object value2) {
		return projectDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> listBy(String field, Object value) {
		return projectDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> listByAnd(String field1, Object value1, String field2, Object value2) {
		return projectDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> listByOr(String field1, Object value1, String field2, Object value2) {
		return projectDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> pageBy(String field, Object value, Pager page) {
		return projectDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<UserProject> page(Pager pager, ProjectSearchForm searchForm) {
		return projectDao.page(pager, searchForm);
	}

	@Override
	public int count(ProjectSearchForm searchForm) {
		return projectDao.count(searchForm);
	}

}
