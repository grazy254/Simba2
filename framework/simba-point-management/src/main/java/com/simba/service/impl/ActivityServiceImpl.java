package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.ActivityDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Activity;
import com.simba.service.ActivityService;

/**
 * 活动 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Override
	public void add(Activity activity) {
		activityDao.add(activity);
	}

	@Override
	public void delete(Long id) {
		activityDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Activity get(Long id) {
		return activityDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> page(Pager page) {
		return activityDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return activityDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return activityDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		activityDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> listAll() {
		return activityDao.listAll();
	}

	@Override
	public void update(Activity activity) {
		activityDao.update(activity);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Activity getBy(String field, Object value) {
		return activityDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Activity getByAnd(String field1, Object value1, String field2, Object value2) {
		return activityDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Activity getByOr(String field1, Object value1, String field2, Object value2) {
		return activityDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> listBy(String field, Object value) {
		return activityDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> listByAnd(String field1, Object value1, String field2, Object value2) {
		return activityDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> listByOr(String field1, Object value1, String field2, Object value2) {
		return activityDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> pageBy(String field, Object value, Pager page) {
		return activityDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return activityDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activity> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return activityDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		activityDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		activityDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return activityDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return activityDao.countByOr(field1,value1,field2,value2);
	}
}
