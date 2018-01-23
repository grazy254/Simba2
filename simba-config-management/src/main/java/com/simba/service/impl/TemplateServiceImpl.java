package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.TemplateDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Template;
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
	public void add(Template template) {
		templateDao.add(template);
	}

	@Override
	public void delete(Long id) {
		templateDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Template get(Long id) {
		return templateDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Template> page(Pager page) {
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
	public List<Template> listAll() {
		return templateDao.listAll();
	}

	@Override
	public void update(Template template) {
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
	public Template getBy(String field, Object value) {
		return templateDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Template getByAnd(String field1, Object value1, String field2, Object value2) {
		return templateDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Template getByOr(String field1, Object value1, String field2, Object value2) {
		return templateDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Template> listBy(String field, Object value) {
		return templateDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Template> listByAnd(String field1, Object value1, String field2, Object value2) {
		return templateDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Template> listByOr(String field1, Object value1, String field2, Object value2) {
		return templateDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Template> pageBy(String field, Object value, Pager page) {
		return templateDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Template> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return templateDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Template> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return templateDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
