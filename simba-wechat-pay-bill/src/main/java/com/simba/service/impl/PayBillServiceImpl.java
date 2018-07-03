package com.simba.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.simba.model.constant.ConstantData;
import com.simba.model.pay.downloadbill.DownloadBillReq;
import com.simba.model.pay.orderquery.OrderQueryRes;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
import com.simba.service.PayBillService;
import com.simba.service.PayService;
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

	@Value("${wx.pay.bill.dir}")
	private String billDir;

	@Autowired
	private PayBillDao payBillDao;

	@Resource
	private Redis redisUtil;

	@Resource
	private TaskExecutor taskExecutor;

	@Autowired
	private PayService payService;

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
				logger.info("开始处理未完成的订单:" + bill.toString());
				if ("REFUND".equals(bill.getStatus())) {
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
		OrderQueryRes res = WxPayUtil.getInstance().queryOrderByOutTradeNo(bill.getOutTradeNo());
		String status = res.getTrade_state();
		bill.setStatus(status);
		if ("SUCCESS".equals(status)) {
			PayResult payResult = new PayResult();
			payResult.setOut_trade_no(bill.getOutTradeNo());
			payResult.setTotal_fee(bill.getFee());
			payService.dealResult(payResult);
		} else {
			this.update(bill);
		}
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
		WxPayUtil.getInstance().refundQueryByOutTradeNo(bill.getOutTradeNo());
		RefundResult refundResult = new RefundResult();
		RefundCallbackInfo callbackInfo = new RefundCallbackInfo();
		callbackInfo.setOut_trade_no(bill.getOutTradeNo());
		callbackInfo.setRefund_status("SUCCESS");
		payService.dealRefundCallback(refundResult, callbackInfo);
	}

	@Override
	public List<PayBill> listUnfinish() {
		return payBillDao.listUnfinish();
	}

	@Override
	public void checkBill() throws IOException {
		Date yesterday = DateUtils.addDays(new Date(), -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String billDate = format.format(yesterday);
		DownloadBillReq request = new DownloadBillReq();
		request.setBill_date(billDate);
		request.setBill_type("ALL");
		String billContent = WxPayUtil.getInstance().downloadBill(request);
		File dir = new File(billDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String billFile = billDir + "/" + "wechatpay" + "/" + billDate + ".txt";
		FileUtils.write(new File(billFile), billContent, ConstantData.DEFAULT_CHARSET);
		logger.info("写入微信支付对账单成功:" + billFile);
	}

}
