package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.AliPayBillDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AliPayBill;
import com.simba.model.form.AliPayBillSearchForm;
import com.simba.service.AliPayBillService;

/**
 * 阿里支付账单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class AliPayBillServiceImpl implements AliPayBillService {

	@Autowired
	private AliPayBillDao aliPayBillDao;

	@Override
	public void add(AliPayBill aliPayBill) {
		aliPayBill.setCreateTime(new Date());
		aliPayBillDao.add(aliPayBill);
	}

	@Override
	public void delete(Long id) {
		aliPayBillDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public AliPayBill get(Long id) {
		return aliPayBillDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> page(Pager page) {
		return aliPayBillDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> page(Pager page, AliPayBillSearchForm aliPayBillSearchForm) {
		return aliPayBillDao.page(page, aliPayBillSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return aliPayBillDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count(AliPayBillSearchForm aliPayBillSearchForm) {
		return aliPayBillDao.count(aliPayBillSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return aliPayBillDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		aliPayBillDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> listAll() {
		return aliPayBillDao.listAll();
	}

	@Override
	public void update(AliPayBill aliPayBill) {
		aliPayBill.setCreateTime(new Date());
		aliPayBillDao.update(aliPayBill);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public AliPayBill getBy(String field, Object value) {
		return aliPayBillDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public AliPayBill getByAnd(String field1, Object value1, String field2, Object value2) {
		return aliPayBillDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public AliPayBill getByOr(String field1, Object value1, String field2, Object value2) {
		return aliPayBillDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> listBy(String field, Object value) {
		return aliPayBillDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		return aliPayBillDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> listByOr(String field1, Object value1, String field2, Object value2) {
		return aliPayBillDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> pageBy(String field, Object value, Pager page) {
		return aliPayBillDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return aliPayBillDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AliPayBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return aliPayBillDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		aliPayBillDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		aliPayBillDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return aliPayBillDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return aliPayBillDao.countByOr(field1, value1, field2, value2);
	}
}
