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
import com.simba.controller.form.RedPackBillSearchForm;
import com.simba.dao.RedPackBillDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.RedPackBill;
import com.simba.redpack.model.search.SearchReq;
import com.simba.redpack.model.search.SearchRes;
import com.simba.redpack.util.send.WxRedPackUtil;
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

	private static final Log logger = LogFactory.getLog(RedPackBillServiceImpl.class);

	private WxRedPackUtil wxRedPackUtil;

	@Resource
	private Redis redisUtil;

	@Autowired
	private RedPackBillDao redPackBillDao;

	@Resource
	private TaskExecutor taskExecutor;

	@PostConstruct
	private void init() {
		wxRedPackUtil = WxRedPackUtil.getInstance();
	}

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

	@Override
	public void checkUnfinishOrder() throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		List<RedPackBill> list = this.listAllUnfinish();
		for (RedPackBill bill : list) {
			if (redisUtil.tryLock("wechatredpackpay_" + bill.getId(), 60)) {
				dealUnfinishOrder(bill);
			}
		}
	}

	private void dealUnfinishOrder(RedPackBill bill) {
		taskExecutor.execute(() -> {
			try {
				dealUnfinishOrderBill(bill);
			} catch (Exception e) {
				logger.error("处理未完成的订单发生异常:" + bill.toString(), e);
			}
		});
	}

	private void dealUnfinishOrderBill(RedPackBill bill) throws ParseException, IOException {
		SearchReq searchReq = new SearchReq();
		searchReq.setMch_billno(bill.getBillNo());
		SearchRes res = wxRedPackUtil.searchRedPack(searchReq);
		String status = res.getStatus();
		bill.setStatus(status);
		this.update(bill);
	}

	@Override
	public List<RedPackBill> listAllUnfinish() {
		return redPackBillDao.listAllUnfinish();
	}
}
