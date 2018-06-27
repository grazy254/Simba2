package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.enums.TradeStatus;
import com.simba.alipay.service.AliPayService;
import com.simba.alipay.util.AliPayUtil;
import com.simba.cache.Redis;
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

	private static final Log logger = LogFactory.getLog(AliPayBillServiceImpl.class);

	@Resource
	private Redis redisUtil;

	@Resource
	private TaskExecutor taskExecutor;

	@Autowired
	private AliPayBillDao aliPayBillDao;

	@Autowired
	private AliPayUtil aliPayUtil;

	@Autowired
	private AliPayService aliPayService;

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

	@Override
	public void checkUnfinishOrder() {
		List<AliPayBill> list = this.listUnfinish();
		for (AliPayBill bill : list) {
			if (redisUtil.tryLock("alipay_" + bill.getId(), 60)) {
				dealUnfinishOrder(bill);
			}
		}
	}

	private void dealUnfinishOrder(AliPayBill bill) {
		taskExecutor.execute(() -> {
			try {
				logger.info("开始处理未完成的订单:" + bill.toString());
				if (TradeStatus.REFUND.getName().equals(bill.getStatus())) {
					dealRefundOrder(bill);
				} else {
					dealUnpayOrder(bill);
				}
				logger.info("结束处理未完成的订单:" + bill.toString());
			} catch (Exception e) {
				logger.error("处理未完成的订单发生异常:" + bill.toString(), e);
			}
		});
	}

	private void dealUnpayOrder(AliPayBill bill) throws AlipayApiException {
		AlipayTradeQueryResponse response = aliPayUtil.query(bill.getOutTradeNo(), bill.getTradeNo());
		bill.setStatus(response.getTradeStatus());
		if (StringUtils.isEmpty(bill.getStatus())) {
			return;
		}
		if (TradeStatus.SUCCESS.getName().equals(bill.getStatus())) {
			AliPayCallbackForm callbackForm = new AliPayCallbackForm();
			callbackForm.setOut_trade_no(bill.getOutTradeNo());
			callbackForm.setTrade_status(TradeStatus.SUCCESS.getName());
			callbackForm.setTotal_amount(bill.getTotalAmount());
			aliPayService.dealCallback(callbackForm);
		} else {
			this.update(bill);
		}
	}

	private void dealRefundOrder(AliPayBill bill) throws AlipayApiException {
		AlipayTradeFastpayRefundQueryResponse response = aliPayUtil.refundQuery(bill.getTradeNo(), bill.getOutTradeNo(), null);
		if (StringUtils.isNotEmpty(response.getTotalAmount())) {
			AliPayCallbackForm callbackForm = new AliPayCallbackForm();
			callbackForm.setOut_trade_no(bill.getOutTradeNo());
			callbackForm.setTrade_status(TradeStatus.REFUNDSUCCESS.getName());
			callbackForm.setTotal_amount(bill.getTotalAmount());
			callbackForm.setRefund_fee(bill.getTotalAmount());
			aliPayService.dealCallback(callbackForm);
		}
	}

	@Override
	public List<AliPayBill> listUnfinish() {
		return aliPayBillDao.listUnfinish();
	}
}
