package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.FAQTypeDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FAQType;
import com.simba.service.FAQTypeService;

/**
 * 常见问题类型管理 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class FAQTypeServiceImpl implements FAQTypeService {

	@Autowired
	private FAQTypeDao fAQTypeDao;

	@Override
	public void add(FAQType fAQType) {
		fAQTypeDao.add(fAQType);
	}

	@Override
	public void delete(Integer id) {
		fAQTypeDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public FAQType get(Integer id) {
		return fAQTypeDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> page(Pager page) {
		return fAQTypeDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return fAQTypeDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value){
		return fAQTypeDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		fAQTypeDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> listAll() {
		return fAQTypeDao.listAll();
	}

	@Override
	public void update(FAQType fAQType) {
		fAQTypeDao.update(fAQType);
	}
	
	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public FAQType getBy(String field, Object value) {
		return fAQTypeDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public FAQType getByAnd(String field1, Object value1, String field2, Object value2) {
		return fAQTypeDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public FAQType getByOr(String field1, Object value1, String field2, Object value2) {
		return fAQTypeDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> listBy(String field, Object value) {
		return fAQTypeDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> listByAnd(String field1, Object value1, String field2, Object value2) {
		return fAQTypeDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> listByOr(String field1, Object value1, String field2, Object value2) {
		return fAQTypeDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> pageBy(String field, Object value, Pager page) {
		return fAQTypeDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return fAQTypeDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FAQType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return fAQTypeDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
