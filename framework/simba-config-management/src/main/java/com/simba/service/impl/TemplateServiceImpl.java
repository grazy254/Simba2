package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.TemplateDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PropertyTemplate;
import com.simba.service.TemplateService;

/**
 * 配置模板表 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDao templateDao;

	@Override
	public void add(PropertyTemplate template) {
		templateDao.add(template);
	}

	@Override
	public void delete(Long id) {
		templateDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PropertyTemplate get(Long id) {
		return templateDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> page(Pager page) {
		return templateDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return templateDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return templateDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		templateDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> listAll() {
		return templateDao.listAll();
	}

	@Override
	public void update(PropertyTemplate template) {
		templateDao.update(template);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public PropertyTemplate getBy(String field, Object value) {
		return templateDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public PropertyTemplate getByAnd(String field1, Object value1, String field2, Object value2) {
		return templateDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public PropertyTemplate getByOr(String field1, Object value1, String field2, Object value2) {
		return templateDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> listBy(String field, Object value) {
		return templateDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> listByAnd(String field1, Object value1, String field2, Object value2) {
		return templateDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> listByOr(String field1, Object value1, String field2, Object value2) {
		return templateDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> pageBy(String field, Object value, Pager page) {
		return templateDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return templateDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PropertyTemplate> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return templateDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
