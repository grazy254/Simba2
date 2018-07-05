package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ReceiveDealTypeDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ReceiveDealType;
import com.simba.model.form.DealTypeSearchForm;
import com.simba.service.ReceiveDealTypeService;

/**
 * 处理接收消息类型 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ReceiveDealTypeServiceImpl implements ReceiveDealTypeService {

	@Autowired
	private ReceiveDealTypeDao receiveDealTypeDao;

	@Override
	public void add(ReceiveDealType receiveDealType) {
		receiveDealTypeDao.add(receiveDealType);
	}

	@Override
	public void delete(Integer id) {
		receiveDealTypeDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveDealType get(Integer id) {
		return receiveDealTypeDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> page(Pager page) {
		return receiveDealTypeDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return receiveDealTypeDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return receiveDealTypeDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		receiveDealTypeDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> listAll() {
		return receiveDealTypeDao.listAll();
	}

	@Override
	public void update(ReceiveDealType receiveDealType) {
		receiveDealTypeDao.update(receiveDealType);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveDealType getBy(String field, Object value) {
		return receiveDealTypeDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveDealType getByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveDealTypeDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveDealType getByOr(String field1, Object value1, String field2, Object value2) {
		return receiveDealTypeDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> listBy(String field, Object value) {
		return receiveDealTypeDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> listByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveDealTypeDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> listByOr(String field1, Object value1, String field2, Object value2) {
		return receiveDealTypeDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> pageBy(String field, Object value, Pager page) {
		return receiveDealTypeDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveDealTypeDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveDealType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveDealTypeDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<ReceiveDealType> page(Pager pager, DealTypeSearchForm searchForm) {
		return receiveDealTypeDao.page(pager, searchForm);
	}

	@Override
	public Integer count(DealTypeSearchForm searchForm) {
		return receiveDealTypeDao.count(searchForm);
	}

}
