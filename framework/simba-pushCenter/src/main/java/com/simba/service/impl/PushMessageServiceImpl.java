package com.simba.service.impl;

import com.simba.dao.PushMessageDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PushMessage;
import com.simba.service.PushMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 消息记录 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class PushMessageServiceImpl implements PushMessageService {

	@Autowired
	private PushMessageDao pushMessageDao;

	@Override
	public void add(PushMessage pushMessage) {
		pushMessageDao.add(pushMessage);
	}

	@Override
	public void delete(Long id) {
		pushMessageDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PushMessage get(Long id) {
		return pushMessageDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> page(Pager page) {
		return pushMessageDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return pushMessageDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return pushMessageDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		pushMessageDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> listAll() {
		return pushMessageDao.listAll();
	}

	@Override
	public void update(PushMessage pushMessage) {
		pushMessageDao.update(pushMessage);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public PushMessage getBy(String field, Object value) {
		return pushMessageDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public PushMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		return pushMessageDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public PushMessage getByOr(String field1, Object value1, String field2, Object value2) {
		return pushMessageDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> listBy(String field, Object value) {
		return pushMessageDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		return pushMessageDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		return pushMessageDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> pageBy(String field, Object value, Pager page) {
		return pushMessageDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return pushMessageDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PushMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return pushMessageDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		pushMessageDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		pushMessageDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return pushMessageDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return pushMessageDao.countByOr(field1,value1,field2,value2);
	}
}
