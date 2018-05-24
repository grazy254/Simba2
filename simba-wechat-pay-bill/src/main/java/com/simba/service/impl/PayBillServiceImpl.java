package com.simba.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
import com.simba.controller.form.PayBillSearchForm;
import com.simba.dao.PayBillDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PayBill;
import com.simba.model.pay.orderquery.OrderQueryRes;
import com.simba.service.PayBillService;
import com.simba.util.send.WxPayUtil;

/**
 * 支付账单 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class PayBillServiceImpl implements PayBillService {

	private static final Log logger = LogFactory.getLog(PayBillServiceImpl.class);

	@Autowired
	private PayBillDao payBillDao;

	@Resource
	private Redis redisUtil;

	@Autowired
	private WxPayUtil wxPayUtil;

	@Resource
	private TaskExecutor taskExecutor;

	@Override
	public void add(PayBill payBill) {
		payBillDao.add(payBill);
	}

	@Override
	public void delete(Long id) {
		payBillDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PayBill get(Long id) {
		return payBillDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> page(Pager page) {
		return payBillDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return payBillDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return payBillDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		payBillDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> listAll() {
		return payBillDao.listAll();
	}

	@Override
	public void update(PayBill payBill) {
		payBillDao.update(payBill);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PayBill getBy(String field, Object value) {
		return payBillDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public PayBill getByAnd(String field1, Object value1, String field2, Object value2) {
		return payBillDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public PayBill getByOr(String field1, Object value1, String field2, Object value2) {
		return payBillDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> listBy(String field, Object value) {
		return payBillDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		return payBillDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> listByOr(String field1, Object value1, String field2, Object value2) {
		return payBillDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> pageBy(String field, Object value, Pager page) {
		return payBillDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return payBillDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PayBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return payBillDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		payBillDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		payBillDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return payBillDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return payBillDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public List<PayBill> page(PayBillSearchForm searchForm, Pager pager) {
		return payBillDao.page(searchForm, pager);
	}

	@Override
	public Long count(PayBillSearchForm searchForm) {
		return payBillDao.count(searchForm);
	}

	@Override
	public void checkUnfinishOrder() throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		List<PayBill> list = this.listUnfinish();
		for (PayBill bill : list) {
			if (redisUtil.tryLock("wechatpay_" + bill.getId(), 60)) {
				dealUnfinishOrder(bill);
			}
		}
	}

	/**
	 * 处理未完成的订单
	 * 
	 * @param bill
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	private void dealUnfinishOrder(PayBill bill) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		taskExecutor.execute(() -> {
			try {
				if ("REFUND".equals(bill.getStatus())) {
					dealRefundOrder(bill);
				} else {
					dealUnpayOrder(bill);
				}
			} catch (Exception e) {
				logger.error("处理未完成的订单发生异常:" + bill.toString(), e);
			}
		});
	}

	/**
	 * 处理还未支付的订单
	 * 
	 * @param bill
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	private void dealUnpayOrder(PayBill bill) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		OrderQueryRes res = wxPayUtil.queryOrderByOutTradeNo(bill.getOutTradeNo());
		String status = res.getTrade_state();
		bill.setStatus(status);
		bill.setCreateTime(new Date());
		this.update(bill);
	}

	/**
	 * 处理正在退款的订单
	 * 
	 * @param bill
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	private void dealRefundOrder(PayBill bill) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		wxPayUtil.refundQueryByOutTradeNo(bill.getOutTradeNo());
		bill.setStatus("REVOKED");
		bill.setCreateTime(new Date());
		this.update(bill);
	}

	@Override
	public List<PayBill> listUnfinish() {
		return payBillDao.listUnfinish();
	}
}
