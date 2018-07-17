package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.DirectionaryTypeDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DirectionaryType;
import com.simba.service.DirectionaryTypeService;
import com.simba.model.form.SearchDirectionaryTypeForm;
/**
 * 字典类型 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DirectionaryTypeServiceImpl implements DirectionaryTypeService {

	@Autowired
	private DirectionaryTypeDao directionaryTypeDao;

	@Override
	public void add(DirectionaryType directionaryType) {
		directionaryTypeDao.add(directionaryType);
	}

	@Override
	public void delete(Long id) {
		directionaryTypeDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DirectionaryType get(Long id) {
		return directionaryTypeDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> page(Pager page) {
		return directionaryTypeDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> page(Pager page, SearchDirectionaryTypeForm searchDirectionaryTypeForm) {
		return directionaryTypeDao.page(page, searchDirectionaryTypeForm);
	}
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return directionaryTypeDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count(SearchDirectionaryTypeForm searchDirectionaryTypeForm) {
		return directionaryTypeDao.count(searchDirectionaryTypeForm);
	}
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return directionaryTypeDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		directionaryTypeDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> listAll() {
		return directionaryTypeDao.listAll();
	}

	@Override
	public void update(DirectionaryType directionaryType) {
		directionaryTypeDao.update(directionaryType);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public DirectionaryType getBy(String field, Object value) {
		return directionaryTypeDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public DirectionaryType getByAnd(String field1, Object value1, String field2, Object value2) {
		return directionaryTypeDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public DirectionaryType getByOr(String field1, Object value1, String field2, Object value2) {
		return directionaryTypeDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> listBy(String field, Object value) {
		return directionaryTypeDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> listByAnd(String field1, Object value1, String field2, Object value2) {
		return directionaryTypeDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> listByOr(String field1, Object value1, String field2, Object value2) {
		return directionaryTypeDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> pageBy(String field, Object value, Pager page) {
		return directionaryTypeDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return directionaryTypeDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionaryType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return directionaryTypeDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		directionaryTypeDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		directionaryTypeDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return directionaryTypeDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return directionaryTypeDao.countByOr(field1,value1,field2,value2);
	}
}
