package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.UserGroupDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UserGroup;
import com.simba.service.UserGroupService;

/**
 * 用户分组关联表 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	public void add(UserGroup userGroup) {
		userGroupDao.add(userGroup);
	}

	@Override
	public void delete(Long id) {
		userGroupDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UserGroup get(Long id) {
		return userGroupDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> page(Pager page) {
		return userGroupDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return userGroupDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return userGroupDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		userGroupDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> listAll() {
		return userGroupDao.listAll();
	}

	@Override
	public void update(UserGroup userGroup) {
		userGroupDao.update(userGroup);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserGroup getBy(String field, Object value) {
		return userGroupDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public UserGroup getByAnd(String field1, Object value1, String field2, Object value2) {
		return userGroupDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public UserGroup getByOr(String field1, Object value1, String field2, Object value2) {
		return userGroupDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> listBy(String field, Object value) {
		return userGroupDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> listByAnd(String field1, Object value1, String field2, Object value2) {
		return userGroupDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> listByOr(String field1, Object value1, String field2, Object value2) {
		return userGroupDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> pageBy(String field, Object value, Pager page) {
		return userGroupDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return userGroupDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserGroup> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return userGroupDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		userGroupDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		userGroupDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return userGroupDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return userGroupDao.countByOr(field1,value1,field2,value2);
	}
}
