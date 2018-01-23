package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.ApplicationPropertyDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ApplicationProperty;
import com.simba.service.ApplicationPropertyService;

/**
 * 应用配置表 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ApplicationPropertyServiceImpl implements ApplicationPropertyService {

	@Autowired
	private ApplicationPropertyDao applicationPropertyDao;

	@Override
	public void add(ApplicationProperty applicationProperty) {
		applicationPropertyDao.add(applicationProperty);
	}

	@Override
	public void delete(Long id) {
		applicationPropertyDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ApplicationProperty get(Long id) {
		return applicationPropertyDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> page(Pager page) {
		return applicationPropertyDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return applicationPropertyDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return applicationPropertyDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		applicationPropertyDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> listAll() {
		return applicationPropertyDao.listAll();
	}

	@Override
	public void update(ApplicationProperty applicationProperty) {
		applicationPropertyDao.update(applicationProperty);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ApplicationProperty getBy(String field, Object value) {
		return applicationPropertyDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ApplicationProperty getByAnd(String field1, Object value1, String field2, Object value2) {
		return applicationPropertyDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ApplicationProperty getByOr(String field1, Object value1, String field2, Object value2) {
		return applicationPropertyDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> listBy(String field, Object value) {
		return applicationPropertyDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> listByAnd(String field1, Object value1, String field2, Object value2) {
		return applicationPropertyDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> listByOr(String field1, Object value1, String field2, Object value2) {
		return applicationPropertyDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> pageBy(String field, Object value, Pager page) {
		return applicationPropertyDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return applicationPropertyDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ApplicationProperty> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return applicationPropertyDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
