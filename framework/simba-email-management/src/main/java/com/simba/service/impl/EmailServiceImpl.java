package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.EmailDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Email;
import com.simba.service.EmailService;
/**
 * 邮件记录 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDao emailDao;

	@Override
	public void add(Email email) {
		emailDao.add(email);
	}

	@Override
	public void delete(Long id) {
		emailDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Email get(Long id) {
		return emailDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> page(Pager page) {
		return emailDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return emailDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return emailDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		emailDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> listAll() {
		return emailDao.listAll();
	}

	@Override
	public void update(Email email) {
		emailDao.update(email);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Email getBy(String field, Object value) {
		return emailDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Email getByAnd(String field1, Object value1, String field2, Object value2) {
		return emailDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Email getByOr(String field1, Object value1, String field2, Object value2) {
		return emailDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> listBy(String field, Object value) {
		return emailDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> listByAnd(String field1, Object value1, String field2, Object value2) {
		return emailDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> listByOr(String field1, Object value1, String field2, Object value2) {
		return emailDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> pageBy(String field, Object value, Pager page) {
		return emailDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return emailDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Email> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return emailDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		emailDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		emailDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return emailDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return emailDao.countByOr(field1,value1,field2,value2);
	}
}
