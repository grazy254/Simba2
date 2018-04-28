package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.AutoIdDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AutoId;
import com.simba.service.AutoIdService;

/**
 * 自增id Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class AutoIdServiceImpl implements AutoIdService {

	@Autowired
	private AutoIdDao autoIdDao;

	@Override
	public void add(AutoId autoId) {
		autoIdDao.add(autoId);
	}

	@Override
	public void delete(String id) {
		autoIdDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AutoId get(String id) {
		return autoIdDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> page(Pager page) {
		return autoIdDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return autoIdDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value){
		return autoIdDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		autoIdDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> listAll() {
		return autoIdDao.listAll();
	}

	@Override
	public void update(AutoId autoId) {
		autoIdDao.update(autoId);
	}
	
	@Override
	public void batchDelete(List<String> idList) {
		for (String id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public AutoId getBy(String field, Object value) {
		return autoIdDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public AutoId getByAnd(String field1, Object value1, String field2, Object value2) {
		return autoIdDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public AutoId getByOr(String field1, Object value1, String field2, Object value2) {
		return autoIdDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> listBy(String field, Object value) {
		return autoIdDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> listByAnd(String field1, Object value1, String field2, Object value2) {
		return autoIdDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> listByOr(String field1, Object value1, String field2, Object value2) {
		return autoIdDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> pageBy(String field, Object value, Pager page) {
		return autoIdDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return autoIdDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoId> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return autoIdDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		autoIdDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		autoIdDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer countByAnd(String field1, Object value1, String field2, Object value2){
		return autoIdDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Integer countByOr(String field1, Object value1, String field2, Object value2){
		return autoIdDao.countByOr(field1,value1,field2,value2);
	}
}
