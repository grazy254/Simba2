package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.AliPayEnterpriseBillDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AliPayEnterpriseBill;
import com.simba.service.AliPayEnterpriseBillService;
/**
 * 支付宝企业支付账单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class AliPayEnterpriseBillServiceImpl implements AliPayEnterpriseBillService {

	@Autowired
	private AliPayEnterpriseBillDao aliPayEnterpriseBillDao;

	@Override
	public void add(AliPayEnterpriseBill aliPayEnterpriseBill) {
		aliPayEnterpriseBillDao.add(aliPayEnterpriseBill);
	}

	@Override
	public void delete(Long id) {
		aliPayEnterpriseBillDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AliPayEnterpriseBill get(Long id) {
		return aliPayEnterpriseBillDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> page(Pager page) {
		return aliPayEnterpriseBillDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return aliPayEnterpriseBillDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return aliPayEnterpriseBillDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		aliPayEnterpriseBillDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> listAll() {
		return aliPayEnterpriseBillDao.listAll();
	}

	@Override
	public void update(AliPayEnterpriseBill aliPayEnterpriseBill) {
		aliPayEnterpriseBillDao.update(aliPayEnterpriseBill);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public AliPayEnterpriseBill getBy(String field, Object value) {
		return aliPayEnterpriseBillDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public AliPayEnterpriseBill getByAnd(String field1, Object value1, String field2, Object value2) {
		return aliPayEnterpriseBillDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public AliPayEnterpriseBill getByOr(String field1, Object value1, String field2, Object value2) {
		return aliPayEnterpriseBillDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> listBy(String field, Object value) {
		return aliPayEnterpriseBillDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		return aliPayEnterpriseBillDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> listByOr(String field1, Object value1, String field2, Object value2) {
		return aliPayEnterpriseBillDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> pageBy(String field, Object value, Pager page) {
		return aliPayEnterpriseBillDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return aliPayEnterpriseBillDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayEnterpriseBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return aliPayEnterpriseBillDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		aliPayEnterpriseBillDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		aliPayEnterpriseBillDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return aliPayEnterpriseBillDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return aliPayEnterpriseBillDao.countByOr(field1,value1,field2,value2);
	}
}
