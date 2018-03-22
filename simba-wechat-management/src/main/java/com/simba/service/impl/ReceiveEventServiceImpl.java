package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.ReceiveEventDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ReceiveEvent;
import com.simba.model.form.ReceiveEventSearchForm;
import com.simba.service.ReceiveEventService;

/**
 * 收到事件 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ReceiveEventServiceImpl implements ReceiveEventService {

	@Autowired
	private ReceiveEventDao receiveEventDao;

	@Override
	public void add(ReceiveEvent receiveEvent) {
		receiveEventDao.add(receiveEvent);
	}

	@Override
	public void delete(Long id) {
		receiveEventDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveEvent get(Long id) {
		return receiveEventDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> page(Pager page) {
		return receiveEventDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return receiveEventDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value){
		return receiveEventDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		receiveEventDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> listAll() {
		return receiveEventDao.listAll();
	}

	@Override
	public void update(ReceiveEvent receiveEvent) {
		receiveEventDao.update(receiveEvent);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ReceiveEvent getBy(String field, Object value) {
		return receiveEventDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveEvent getByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveEventDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveEvent getByOr(String field1, Object value1, String field2, Object value2) {
		return receiveEventDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> listBy(String field, Object value) {
		return receiveEventDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> listByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveEventDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> listByOr(String field1, Object value1, String field2, Object value2) {
		return receiveEventDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> pageBy(String field, Object value, Pager page) {
		return receiveEventDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveEventDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveEvent> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveEventDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public List<ReceiveEvent> page(Pager pager, ReceiveEventSearchForm searchForm) {
		return receiveEventDao.page(pager, searchForm);
	}

	@Override
	public long count(ReceiveEventSearchForm searchForm) {
		return receiveEventDao.count(searchForm);
	}
}
