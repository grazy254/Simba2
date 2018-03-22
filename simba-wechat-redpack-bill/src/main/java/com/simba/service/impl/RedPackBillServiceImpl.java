package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.controller.form.RedPackBillSearchForm;
import com.simba.dao.RedPackBillDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.RedPackBill;
import com.simba.service.RedPackBillService;

/**
 * 红包账单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class RedPackBillServiceImpl implements RedPackBillService {

	@Autowired
	private RedPackBillDao redPackBillDao;

	@Override
	public void add(RedPackBill redPackBill) {
		redPackBillDao.add(redPackBill);
	}

	@Override
	public void delete(Long id) {
		redPackBillDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public RedPackBill get(Long id) {
		return redPackBillDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> page(Pager page) {
		return redPackBillDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return redPackBillDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return redPackBillDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		redPackBillDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> listAll() {
		return redPackBillDao.listAll();
	}

	@Override
	public void update(RedPackBill redPackBill) {
		redPackBillDao.update(redPackBill);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public RedPackBill getBy(String field, Object value) {
		return redPackBillDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public RedPackBill getByAnd(String field1, Object value1, String field2, Object value2) {
		return redPackBillDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public RedPackBill getByOr(String field1, Object value1, String field2, Object value2) {
		return redPackBillDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> listBy(String field, Object value) {
		return redPackBillDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		return redPackBillDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> listByOr(String field1, Object value1, String field2, Object value2) {
		return redPackBillDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> pageBy(String field, Object value, Pager page) {
		return redPackBillDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return redPackBillDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RedPackBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return redPackBillDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		redPackBillDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		redPackBillDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return redPackBillDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return redPackBillDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public List<RedPackBill> page(RedPackBillSearchForm searchForm, Pager pager) {
		return redPackBillDao.page(searchForm, pager);
	}

	@Override
	public Long count(RedPackBillSearchForm searchForm) {
		return redPackBillDao.count(searchForm);
	}
}
