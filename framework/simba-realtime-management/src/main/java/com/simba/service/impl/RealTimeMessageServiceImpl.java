package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.RealTimeMessageDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.RealTimeMessage;
import com.simba.model.form.RealTimeMessageSearchForm;
import com.simba.service.RealTimeMessageService;

/**
 * 设备功能表 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class RealTimeMessageServiceImpl implements RealTimeMessageService {

	@Autowired
	private RealTimeMessageDao realTimeMessageDao;

	@Override
	@Async
	public void add(RealTimeMessage realTimeMessage) {
		realTimeMessage.setCreateTime(new Date());
		realTimeMessageDao.add(realTimeMessage);
	}

	@Override
	public void delete(Long id) {
		realTimeMessageDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public RealTimeMessage get(Long id) {
		return realTimeMessageDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> page(Pager page) {
		return realTimeMessageDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> page(Pager page, RealTimeMessageSearchForm searchForm) {
		return realTimeMessageDao.page(page, searchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return realTimeMessageDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return realTimeMessageDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		realTimeMessageDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> listAll() {
		return realTimeMessageDao.listAll();
	}

	@Override
	public void update(RealTimeMessage realTimeMessage) {
		realTimeMessageDao.update(realTimeMessage);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public RealTimeMessage getBy(String field, Object value) {
		return realTimeMessageDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public RealTimeMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		return realTimeMessageDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public RealTimeMessage getByOr(String field1, Object value1, String field2, Object value2) {
		return realTimeMessageDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> listBy(String field, Object value) {
		return realTimeMessageDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		return realTimeMessageDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		return realTimeMessageDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> pageBy(String field, Object value, Pager page) {
		return realTimeMessageDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return realTimeMessageDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RealTimeMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return realTimeMessageDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public Long count(RealTimeMessageSearchForm searchForm) {
		return realTimeMessageDao.count(searchForm);
	}

}
