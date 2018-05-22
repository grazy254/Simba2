package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.NotifyUserDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.NotifyUser;
import com.simba.service.NotifyUserService;
/**
 * 通知表和用户表的关联 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class NotifyUserServiceImpl implements NotifyUserService {

	@Autowired
	private NotifyUserDao notifyUserDao;

	@Override
	public void add(NotifyUser notifyUser) {
		notifyUser.setReadTime(new Date());
		notifyUserDao.add(notifyUser);
	}

	@Override
	public void delete(Long id) {
		notifyUserDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public NotifyUser get(Long id) {
		return notifyUserDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> page(Pager page) {
		return notifyUserDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return notifyUserDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return notifyUserDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		notifyUserDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> listAll() {
		return notifyUserDao.listAll();
	}

	@Override
	public void update(NotifyUser notifyUser) {
		notifyUserDao.update(notifyUser);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public NotifyUser getBy(String field, Object value) {
		return notifyUserDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public NotifyUser getByAnd(String field1, Object value1, String field2, Object value2) {
		return notifyUserDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public NotifyUser getByOr(String field1, Object value1, String field2, Object value2) {
		return notifyUserDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> listBy(String field, Object value) {
		return notifyUserDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		return notifyUserDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> listByOr(String field1, Object value1, String field2, Object value2) {
		return notifyUserDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> pageBy(String field, Object value, Pager page) {
		return notifyUserDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return notifyUserDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<NotifyUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return notifyUserDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		notifyUserDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		notifyUserDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return notifyUserDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return notifyUserDao.countByOr(field1,value1,field2,value2);
	}
}
