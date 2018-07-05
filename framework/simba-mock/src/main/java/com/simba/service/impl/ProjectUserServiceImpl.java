package com.simba.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ProjectUserDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectUser;
import com.simba.permission.model.User;
import com.simba.service.ProjectUserService;

/**
 * Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ProjectUserServiceImpl implements ProjectUserService {

	@Autowired
	private ProjectUserDao projectUserDao;

	@Override
	public void add(ProjectUser projectUser) {
		projectUserDao.add(projectUser);
	}

	@Override
	public void delete(Integer id) {
		projectUserDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectUser get(Integer id) {
		return projectUserDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> page(Pager page) {
		return projectUserDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return projectUserDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return projectUserDao.countBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> listAll() {
		return projectUserDao.listAll();
	}

	@Override
	public void update(ProjectUser projectUser) {
		projectUserDao.update(projectUser);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectUser getBy(String field, Object value) {
		return projectUserDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectUser getByAnd(String field1, Object value1, String field2, Object value2) {
		return projectUserDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectUser getByOr(String field1, Object value1, String field2, Object value2) {
		return projectUserDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> listBy(String field, Object value) {
		return projectUserDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		return projectUserDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> listByOr(String field1, Object value1, String field2, Object value2) {
		return projectUserDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> pageBy(String field, Object value, Pager page) {
		return projectUserDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectUserDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return projectUserDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public int countUser(int projectId) {
		return projectUserDao.countUser(projectId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> pageByProjectId(String field, Object value, Pager page) {
		return projectUserDao.pageByProjectId(field, value, page);
	}

	@Override
	public void deleteUser(String account, Integer projectId) {
		projectUserDao.deleteUser(account, projectId);
	}

	@Override
	public void batchDeleteUser(List<String> accountList, Integer projectId) {
		for (String account : accountList) {
			this.deleteUser(account, projectId);
		}
	}

	@Override
	public Integer getUserType(String account, Integer projectId) {
		return projectUserDao.getUserType(account, projectId);
	}

	@Override
	public List<User> listByProjectId(Integer projectId) {
		return projectUserDao.listByProjectId(projectId);
	}

	@Override
	public void assignUsers(Integer projectId, List<String> accountsChecked, String currentAccount) {
		projectUserDao.deleteByProjectId(projectId, currentAccount);
		if (accountsChecked.size() > 0) {
			for (String accountToAssign : accountsChecked) {
				if (StringUtils.isNotEmpty(accountToAssign)) {
					ProjectUser newProjectUser = new ProjectUser();
					newProjectUser.setAccount(accountToAssign);
					newProjectUser.setProjectId(projectId);
					newProjectUser.setType(2);
					projectUserDao.add(newProjectUser);
				}
			}
		}
	}

}
