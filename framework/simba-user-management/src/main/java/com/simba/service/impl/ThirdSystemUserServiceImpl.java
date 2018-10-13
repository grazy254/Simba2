package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.ThirdSystemUserDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ThirdSystemUser;
import com.simba.service.ThirdSystemUserService;

/**
 *  Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ThirdSystemUserServiceImpl implements ThirdSystemUserService {

	@Autowired
	private ThirdSystemUserDao thirdSystemUserDao;

	@Override
	public void add(ThirdSystemUser thirdSystemUser) {
		thirdSystemUserDao.add(thirdSystemUser);
	}

	@Override
	public void delete(Long id) {
		thirdSystemUserDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ThirdSystemUser get(Long id) {
		return thirdSystemUserDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> page(Pager page) {
		return thirdSystemUserDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return thirdSystemUserDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return thirdSystemUserDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		thirdSystemUserDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> listAll() {
		return thirdSystemUserDao.listAll();
	}

	@Override
	public void update(ThirdSystemUser thirdSystemUser) {
		thirdSystemUserDao.update(thirdSystemUser);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ThirdSystemUser getBy(String field, Object value) {
		return thirdSystemUserDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ThirdSystemUser getByAnd(String field1, Object value1, String field2, Object value2) {
		return thirdSystemUserDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ThirdSystemUser getByOr(String field1, Object value1, String field2, Object value2) {
		return thirdSystemUserDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> listBy(String field, Object value) {
		return thirdSystemUserDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		return thirdSystemUserDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> listByOr(String field1, Object value1, String field2, Object value2) {
		return thirdSystemUserDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> pageBy(String field, Object value, Pager page) {
		return thirdSystemUserDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return thirdSystemUserDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ThirdSystemUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return thirdSystemUserDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
