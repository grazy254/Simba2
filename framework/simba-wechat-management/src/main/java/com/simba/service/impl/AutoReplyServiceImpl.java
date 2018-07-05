package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.AutoReplyDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AutoReply;
import com.simba.service.AutoReplyService;

/**
 * 自动回复设置 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class AutoReplyServiceImpl implements AutoReplyService {

	@Autowired
	private AutoReplyDao autoReplyDao;

	@Override
	public void add(AutoReply autoReply) {
		autoReplyDao.add(autoReply);
	}

	@Override
	public void delete(Integer id) {
		autoReplyDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AutoReply get(Integer id) {
		return autoReplyDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> page(Pager page) {
		return autoReplyDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return autoReplyDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value){
		return autoReplyDao.countBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> listAll() {
		return autoReplyDao.listAll();
	}

	@Override
	public void update(AutoReply autoReply) {
		autoReplyDao.update(autoReply);
	}
	
	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public AutoReply getBy(String field, Object value) {
		return autoReplyDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public AutoReply getByAnd(String field1, Object value1, String field2, Object value2) {
		return autoReplyDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public AutoReply getByOr(String field1, Object value1, String field2, Object value2) {
		return autoReplyDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> listBy(String field, Object value) {
		return autoReplyDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> listByAnd(String field1, Object value1, String field2, Object value2) {
		return autoReplyDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> listByOr(String field1, Object value1, String field2, Object value2) {
		return autoReplyDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> pageBy(String field, Object value, Pager page) {
		return autoReplyDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return autoReplyDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AutoReply> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return autoReplyDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
