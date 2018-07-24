package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.simba.alipay.model.EnterprisePay;
import com.simba.alipay.util.AliPayUtil;
import com.simba.cache.Redis;
import com.simba.dao.AliPayEnterpriseBillDao;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AliPayEnterpriseBill;
import com.simba.model.form.AliPayEnterpriseBillSearchForm;
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

	private static final Log logger = LogFactory.getLog(AliPayEnterpriseBillServiceImpl.class);

	@Autowired
	private AliPayEnterpriseBillDao aliPayEnterpriseBillDao;

	@Autowired
	private AliPayUtil aliPayUtil;

	@Resource
	private TaskExecutor taskExecutor;

	@Resource
	private Redis redisUtil;

	@Override
	public void add(AliPayEnterpriseBill aliPayEnterpriseBill) throws AlipayApiException {
		aliPayEnterpriseBill.setOutBizNo(RandomUtil.random32Chars());
		aliPayEnterpriseBill.setOrderId(StringUtils.EMPTY);
		aliPayEnterpriseBill.setPayDate(StringUtils.EMPTY);
		aliPayEnterpriseBill.setCreateTime(new Date());
		aliPayEnterpriseBill.setStatus("INIT");
		aliPayEnterpriseBill.setReason(StringUtils.EMPTY);
		aliPayEnterpriseBill.setOrderFee(StringUtils.EMPTY);
		aliPayEnterpriseBillDao.add(aliPayEnterpriseBill);
		EnterprisePay enterprisePay = new EnterprisePay();
		enterprisePay.setOut_biz_no(aliPayEnterpriseBill.getOutBizNo());
		enterprisePay.setPayee_type(aliPayEnterpriseBill.getPayType());
		enterprisePay.setPayee_account(aliPayEnterpriseBill.getAccount());
		enterprisePay.setAmount(aliPayEnterpriseBill.getAmount());
		enterprisePay.setPayer_show_name(aliPayEnterpriseBill.getPayerName());
		enterprisePay.setPayee_real_name(aliPayEnterpriseBill.getPeyeeName());
		enterprisePay.setRemark(aliPayEnterpriseBill.getRemark());
		aliPayUtil.enterprisePay(enterprisePay);
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
	public List<AliPayEnterpriseBill> page(Pager page, AliPayEnterpriseBillSearchForm aliPayEnterpriseBillSearchForm) {
		return aliPayEnterpriseBillDao.page(page, aliPayEnterpriseBillSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return aliPayEnterpriseBillDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count(AliPayEnterpriseBillSearchForm aliPayEnterpriseBillSearchForm) {
		return aliPayEnterpriseBillDao.count(aliPayEnterpriseBillSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return aliPayEnterpriseBillDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		aliPayEnterpriseBillDao.deleteBy(field, value);
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
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		aliPayEnterpriseBillDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		aliPayEnterpriseBillDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return aliPayEnterpriseBillDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return aliPayEnterpriseBillDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public void checkUnfinishOrder() {
		List<AliPayEnterpriseBill> list = this.listAllUnfinish();
		list.forEach((AliPayEnterpriseBill bill) -> {
			if (redisUtil.tryLock("alienterprisepay_" + bill.getId(), 60)) {
				dealUnfinishOrder(bill);
			}
		});
	}

	private void dealUnfinishOrder(AliPayEnterpriseBill bill) {
		taskExecutor.execute(() -> {
			try {
				logger.info("开始处理未完成的订单:" + bill.toString());
				dealBill(bill);
				logger.info("结束处理未完成的订单:" + bill.toString());
			} catch (Exception e) {
				logger.error("处理未完成的订单发生异常:" + bill.toString(), e);
			}
		});
	}

	private void dealBill(AliPayEnterpriseBill bill) throws AlipayApiException {
		AlipayFundTransOrderQueryResponse res = aliPayUtil.searchEnterprisePayByOutBizNo(bill.getOutBizNo());
		bill.setOrderId(StringUtils.defaultString(res.getOrderId()));
		bill.setOrderFee(StringUtils.defaultString(res.getOrderFee()));
		bill.setStatus(StringUtils.defaultString(res.getStatus()));
		bill.setReason(StringUtils.defaultString(res.getFailReason()));
		bill.setPayDate(StringUtils.defaultString(res.getPayDate()));
		this.update(bill);
	}

	@Override
	public List<AliPayEnterpriseBill> listAllUnfinish() {
		return aliPayEnterpriseBillDao.listAllUnfinish();
	}
}
