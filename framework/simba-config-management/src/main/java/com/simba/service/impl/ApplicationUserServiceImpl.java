package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.ApplicationUserDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ApplicationUser;
import com.simba.service.ApplicationUserService;

/**
 * 用户应用表 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ApplicationUserServiceImpl implements ApplicationUserService {

	@Autowired
	private ApplicationUserDao applicationUserDao;

	@Override
	public void add(ApplicationUser applicationUser) {
		applicationUserDao.add(applicationUser);
	}

	@Override
	public void delete(Long id) {
		applicationUserDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ApplicationUser get(Long id) {
		return applicationUserDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> page(Pager page) {
		return applicationUserDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return applicationUserDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return applicationUserDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		applicationUserDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> listAll() {
		return applicationUserDao.listAll();
	}

	@Override
	public void update(ApplicationUser applicationUser) {
		applicationUserDao.update(applicationUser);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ApplicationUser getBy(String field, Object value) {
		return applicationUserDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ApplicationUser getByAnd(String field1, Object value1, String field2, Object value2) {
		return applicationUserDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ApplicationUser getByOr(String field1, Object value1, String field2, Object value2) {
		return applicationUserDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> listBy(String field, Object value) {
		return applicationUserDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		return applicationUserDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> listByOr(String field1, Object value1, String field2, Object value2) {
		return applicationUserDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> pageBy(String field, Object value, Pager page) {
		return applicationUserDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return applicationUserDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return applicationUserDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
