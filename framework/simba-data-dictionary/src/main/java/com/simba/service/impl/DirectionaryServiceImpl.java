package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.DirectionaryDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Directionary;
import com.simba.service.DirectionaryService;
/**
 * 字典 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DirectionaryServiceImpl implements DirectionaryService {

	@Autowired
	private DirectionaryDao directionaryDao;

	@Override
	public void add(Directionary directionary) {
		directionaryDao.add(directionary);
	}

	@Override
	public void delete(Long id) {
		directionaryDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Directionary get(Long id) {
		return directionaryDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> page(Pager page) {
		return directionaryDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return directionaryDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return directionaryDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		directionaryDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> listAll() {
		return directionaryDao.listAll();
	}

	@Override
	public void update(Directionary directionary) {
		directionaryDao.update(directionary);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Directionary getBy(String field, Object value) {
		return directionaryDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Directionary getByAnd(String field1, Object value1, String field2, Object value2) {
		return directionaryDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Directionary getByOr(String field1, Object value1, String field2, Object value2) {
		return directionaryDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> listBy(String field, Object value) {
		return directionaryDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> listByAnd(String field1, Object value1, String field2, Object value2) {
		return directionaryDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> listByOr(String field1, Object value1, String field2, Object value2) {
		return directionaryDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> pageBy(String field, Object value, Pager page) {
		return directionaryDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return directionaryDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Directionary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return directionaryDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		directionaryDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		directionaryDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return directionaryDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return directionaryDao.countByOr(field1,value1,field2,value2);
	}
}
