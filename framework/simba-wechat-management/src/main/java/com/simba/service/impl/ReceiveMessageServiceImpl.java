package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ReceiveMessageDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ReceiveMessage;
import com.simba.model.form.ReceiveMessageSearchForm;
import com.simba.service.ReceiveMessageService;

/**
 * 收到消息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ReceiveMessageServiceImpl implements ReceiveMessageService {

	@Autowired
	private ReceiveMessageDao receiveMessageDao;

	@Override
	public void add(ReceiveMessage receiveMessage) {
		receiveMessageDao.add(receiveMessage);
	}

	@Override
	public void delete(Long id) {
		receiveMessageDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMessage get(Long id) {
		return receiveMessageDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> page(Pager page) {
		return receiveMessageDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return receiveMessageDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return receiveMessageDao.countBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> listAll() {
		return receiveMessageDao.listAll();
	}

	@Override
	public void update(ReceiveMessage receiveMessage) {
		receiveMessageDao.update(receiveMessage);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMessage getBy(String field, Object value) {
		return receiveMessageDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveMessageDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMessage getByOr(String field1, Object value1, String field2, Object value2) {
		return receiveMessageDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> listBy(String field, Object value) {
		return receiveMessageDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveMessageDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		return receiveMessageDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> pageBy(String field, Object value, Pager page) {
		return receiveMessageDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveMessageDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveMessageDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<ReceiveMessage> page(Pager pager, ReceiveMessageSearchForm searchForm) {
		return receiveMessageDao.page(pager, searchForm);
	}

	@Override
	public long count(ReceiveMessageSearchForm searchForm) {
		return receiveMessageDao.count(searchForm);
	}

}
