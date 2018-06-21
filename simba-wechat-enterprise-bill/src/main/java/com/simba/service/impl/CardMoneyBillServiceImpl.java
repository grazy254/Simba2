package com.simba.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.cache.Redis;
import com.simba.controller.form.CardMoneyBillSearchForm;
import com.simba.dao.CardMoneyBillDao;
import com.simba.enterprise.pay.model.searchCard.SearchCardRes;
import com.simba.enterprise.pay.util.send.WxEnterprisePayUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.CardMoneyBill;
import com.simba.service.CardMoneyBillService;

/**
 * 银行卡账单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class CardMoneyBillServiceImpl implements CardMoneyBillService {
	
	private static final Log logger = LogFactory.getLog(CardMoneyBillServiceImpl.class);
	
	private WxEnterprisePayUtil wxEnterprisePayUtil;

	@Autowired
	private CardMoneyBillDao cardMoneyBillDao;
	
	@Resource
	private Redis redisUtil;
	
	@Resource
	private TaskExecutor taskExecutor;
	
	@PostConstruct
	private void init() {
		wxEnterprisePayUtil = WxEnterprisePayUtil.getInstance();
	}

	@Override
	public void add(CardMoneyBill cardMoneyBill) {
		cardMoneyBillDao.add(cardMoneyBill);
	}

	@Override
	public void delete(Long id) {
		cardMoneyBillDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CardMoneyBill get(Long id) {
		return cardMoneyBillDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> page(Pager page) {
		return cardMoneyBillDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return cardMoneyBillDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return cardMoneyBillDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		cardMoneyBillDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> listAll() {
		return cardMoneyBillDao.listAll();
	}

	@Override
	public void update(CardMoneyBill cardMoneyBill) {
		cardMoneyBillDao.update(cardMoneyBill);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CardMoneyBill getBy(String field, Object value) {
		return cardMoneyBillDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public CardMoneyBill getByAnd(String field1, Object value1, String field2, Object value2) {
		return cardMoneyBillDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public CardMoneyBill getByOr(String field1, Object value1, String field2, Object value2) {
		return cardMoneyBillDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> listBy(String field, Object value) {
		return cardMoneyBillDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		return cardMoneyBillDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> listByOr(String field1, Object value1, String field2, Object value2) {
		return cardMoneyBillDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> pageBy(String field, Object value, Pager page) {
		return cardMoneyBillDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return cardMoneyBillDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CardMoneyBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return cardMoneyBillDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		cardMoneyBillDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		cardMoneyBillDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return cardMoneyBillDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return cardMoneyBillDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public Long count(CardMoneyBillSearchForm searchForm) {
		return cardMoneyBillDao.count(searchForm);
	}

	@Override
	public List<CardMoneyBill> page(CardMoneyBillSearchForm searchForm, Pager pager) {
		return cardMoneyBillDao.page(searchForm, pager);
	}

	@Override
	public void checkUnfinishOrder() throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		List<CardMoneyBill> list = this.listAllUnfinish();
		for(CardMoneyBill bill : list) {
			if (redisUtil.tryLock("wechatenterprisepaycard_" + bill.getId(), 60)) {
				dealUnfinishOrder(bill);
			}
		}
	}

	private void dealUnfinishOrder(CardMoneyBill bill) {
		taskExecutor.execute(() -> {
			try {
				dealUnfinishOrderBill(bill);
			} catch (Exception e) {
				logger.error("处理未完成的订单发生异常:" + bill.toString(), e);
			}
		});
	}

	private void dealUnfinishOrderBill(CardMoneyBill bill) throws ParseException, IOException {
		SearchCardRes res = wxEnterprisePayUtil.searchCard(bill.getPartnerTradeNo());
		String status = res.getStatus();
		bill.setStatus(status);
		this.update(bill);
	}

	@Override
	public List<CardMoneyBill> listAllUnfinish() {
		return cardMoneyBillDao.listAllUnfinish();
	}
}
