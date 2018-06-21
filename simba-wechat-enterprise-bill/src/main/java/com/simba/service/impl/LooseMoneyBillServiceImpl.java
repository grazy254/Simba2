package com.simba.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.cache.Redis;
import com.simba.controller.form.LooseMoneyBillSearchForm;
import com.simba.dao.LooseMoneyBillDao;
import com.simba.enterprise.pay.util.send.WxEnterprisePayUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.LooseMoneyBill;
import com.simba.service.LooseMoneyBillService;

/**
 * 零钱账单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class LooseMoneyBillServiceImpl implements LooseMoneyBillService {
	
	private static final Log logger = LogFactory.getLog(LooseMoneyBillServiceImpl.class);
	
	private WxEnterprisePayUtil wxEnterprisePayUtil;

	@Autowired
	private LooseMoneyBillDao looseMoneyBillDao;
	
	@Resource
	private Redis redisUtil;
	
	@Resource
	private TaskExecutor taskExecutor;
	
	@PostConstruct
	private void init() {
		wxEnterprisePayUtil = WxEnterprisePayUtil.getInstance();
	}

	@Override
	public void add(LooseMoneyBill looseMoneyBill) {
		looseMoneyBillDao.add(looseMoneyBill);
	}

	@Override
	public void delete(Long id) {
		looseMoneyBillDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public LooseMoneyBill get(Long id) {
		return looseMoneyBillDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> page(Pager page) {
		return looseMoneyBillDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return looseMoneyBillDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return looseMoneyBillDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		looseMoneyBillDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> listAll() {
		return looseMoneyBillDao.listAll();
	}

	@Override
	public void update(LooseMoneyBill looseMoneyBill) {
		looseMoneyBillDao.update(looseMoneyBill);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public LooseMoneyBill getBy(String field, Object value) {
		return looseMoneyBillDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public LooseMoneyBill getByAnd(String field1, Object value1, String field2, Object value2) {
		return looseMoneyBillDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public LooseMoneyBill getByOr(String field1, Object value1, String field2, Object value2) {
		return looseMoneyBillDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> listBy(String field, Object value) {
		return looseMoneyBillDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		return looseMoneyBillDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> listByOr(String field1, Object value1, String field2, Object value2) {
		return looseMoneyBillDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> pageBy(String field, Object value, Pager page) {
		return looseMoneyBillDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return looseMoneyBillDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LooseMoneyBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return looseMoneyBillDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		looseMoneyBillDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		looseMoneyBillDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return looseMoneyBillDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return looseMoneyBillDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public List<LooseMoneyBill> page(LooseMoneyBillSearchForm searchForm, Pager pager) {
		return looseMoneyBillDao.page(searchForm, pager);
	}

	@Override
	public Long count(LooseMoneyBillSearchForm searchForm) {
		return looseMoneyBillDao.count(searchForm);
	}

	@Override
	public void checkUnfinishOrder() throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
	}
}
