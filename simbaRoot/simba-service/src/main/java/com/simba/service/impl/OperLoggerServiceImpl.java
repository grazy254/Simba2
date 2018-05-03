package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.OperLoggerDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.OperLogger;
import com.simba.service.OperLoggerService;
import com.simba.model.form.OperLoggerSearchForm;

/**
 * 操作日志 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class OperLoggerServiceImpl implements OperLoggerService {

	@Autowired
	private OperLoggerDao operLoggerDao;

	@Override
	public void add(OperLogger operLogger) {
		operLoggerDao.add(operLogger);
	}

	@Override
	public void delete(Long id) {
		operLoggerDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public OperLogger get(Long id) {
		return operLoggerDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> page(Pager page) {
		return operLoggerDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> page(Pager page, OperLoggerSearchForm operLoggerSearchForm) {
		return operLoggerDao.page(page, operLoggerSearchForm);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count(OperLoggerSearchForm operLoggerSearchForm) {
		return operLoggerDao.count(operLoggerSearchForm);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return operLoggerDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		operLoggerDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> listAll() {
		return operLoggerDao.listAll();
	}

	@Override
	public void update(OperLogger operLogger) {
		operLoggerDao.update(operLogger);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public OperLogger getBy(String field, Object value) {
		return operLoggerDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public OperLogger getByAnd(String field1, Object value1, String field2, Object value2) {
		return operLoggerDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public OperLogger getByOr(String field1, Object value1, String field2, Object value2) {
		return operLoggerDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> listBy(String field, Object value) {
		return operLoggerDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> listByAnd(String field1, Object value1, String field2, Object value2) {
		return operLoggerDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> listByOr(String field1, Object value1, String field2, Object value2) {
		return operLoggerDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> pageBy(String field, Object value, Pager page) {
		return operLoggerDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return operLoggerDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLogger> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return operLoggerDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		operLoggerDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		operLoggerDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return operLoggerDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return operLoggerDao.countByOr(field1,value1,field2,value2);
	}
}
