package com.simba.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.controller.form.RefundForm;
import com.simba.exception.BussException;
import com.simba.framework.util.common.ServerUtil;
import com.simba.framework.util.common.ThreadUtil;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.constant.ConstantData;
import com.simba.model.pay.downloadbill.DownloadBillReq;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.model.pay.unifiedorder.UnifiedOrderRes;
import com.simba.service.PayService;
import com.simba.util.common.SignUtil;
import com.simba.util.send.WxPayUtil;

/**
 * 微信支付Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/pay")
public class PayController {

	private static final Log logger = LogFactory.getLog(PayController.class);

	@Value("${appID}")
	private String appid;

	@Value("${wx.pay.mchid}")
	private String mchId;

	@Value("${wx.pay.domain}")
	private String wxPayDomain;

	@Value("${wx.pay.key}")
	private String key;

	@Value("${wx.pay.sandbox}")
	private String sandboxEnabled;

	@Value("${wx.pay.bill.dir}")
	private String billDir;

	@Autowired
	private PayService payService;

	/**
	 * 产生订单
	 * 
	 * @param req
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/order")
	public JsonResult order(HttpServletRequest request, UnifiedOrderReq req) throws Exception {
		logger.info("接收到微信[支付订单]:" + req.toString());
		req.setAppid(appid);
		req.setMch_id(mchId);
		req.setOut_trade_no(RandomUtil.random32Chars());
		req.setSpbill_create_ip(ServerUtil.getProxyIp(request));
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		req.setTime_start(format.format(now));
		if (StringUtils.isEmpty(req.getNotify_url())) {
			String notifyUrl = wxPayDomain + "/payCallback/orderReceive";
			req.setNotify_url(notifyUrl);
		}
		if (StringUtils.isEmpty(req.getOpenid())) {
			String openid = (String) request.getSession().getAttribute("openid");
			req.setOpenid(openid);
		}
		UnifiedOrderRes res = WxPayUtil.getInstance().unifiedOrder(req);
		String prePayId = res.getPrepay_id();
		String codeUrl = res.getCode_url();
		String mwebUrl = res.getMweb_url();
		Map<String, String> params = new HashMap<>();
		params.put("appId", appid);
		params.put("timeStamp", now.getTime() / 1000 + "");
		params.put("nonceStr", RandomUtil.random32Chars());
		params.put("package", "prepay_id=" + prePayId);
		params.put("signType", "MD5");
		String sign = SignUtil.getInstance().createSign(params, key);
		params.put("paySign", sign);
		params.put("prePayId", prePayId);
		params.put("codeUrl", codeUrl);
		params.put("mchId", mchId);
		params.put("mwebUrl", mwebUrl);
		params.put("totalFee", req.getTotal_fee() + "");
		params.put("outTradeNo", req.getOut_trade_no());
		payService.dealOrder(req, prePayId, codeUrl, mwebUrl);
		return new JsonResult(params);
	}

	/**
	 * 关闭订单
	 * 
	 * @param outTradeNo
	 * @return
	 */
	@RequestMapping("/closeOrder")
	public JsonResult closeOrder(String outTradeNo) {
		logger.info("接收到微信[关闭订单]:" + outTradeNo);
		payService.closeOrder(outTradeNo);
		return new JsonResult();
	}

	/**
	 * 申请退款
	 * 
	 * @param refundForm
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/refund")
	public JsonResult refund(RefundForm refundForm) throws ParseException, IOException {
		logger.info("接收到微信[申请退款]:" + refundForm.toString());
		refundForm.setOut_refund_no(RandomUtil.random32Chars());
		RefundReq refundReq = new RefundReq();
		refundReq.setDevice_info(refundForm.getDevice_info());
		refundReq.setOp_user_id(refundForm.getOp_user_id());
		refundReq.setOut_refund_no(refundForm.getOut_refund_no());
		refundReq.setOut_trade_no(refundForm.getOut_trade_no());
		refundReq.setRefund_account(refundForm.getRefund_account());
		refundReq.setSign_type(refundForm.getSign_type());
		refundReq.setTransaction_id(refundForm.getTransaction_id());
		refundReq.setRefund_fee_type(refundForm.getRefund_fee_type());
		if (StringUtils.isEmpty(refundForm.getNotify_url())) {
			refundReq.setNotify_url(wxPayDomain + "/payCallback/refundReceive");
		}
		refundReq.setTotal_fee(refundForm.getTotal_fee());
		refundReq.setRefund_fee(refundForm.getRefund_fee());
		payService.refund(refundReq);
		return new JsonResult();
	}

	/**
	 * 完成沙箱测试用例
	 * 
	 * @param request
	 * @param tradeType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sandbox")
	public JsonResult sandbox(HttpServletRequest request, String tradeType) throws Exception {
		// 是否启用沙箱测试
		boolean sandbox = true;
		if ("false".equals(sandboxEnabled)) {
			sandbox = false;
		}
		if (!sandbox) {
			throw new BussException("没有启动沙箱测试环境");
		}
		if ("APP".equals(tradeType)) {
			sandboxTestApp(request);
		}
		return new JsonResult();
	}

	/**
	 * 启动沙箱测试微信App支付
	 * 
	 * @param request
	 * @throws Exception
	 */
	private void sandboxTestApp(HttpServletRequest request) throws Exception {
		logger.info("开始执行微信App支付沙箱测试用例");
		logger.info("测试用例1[APP-正常] 订单金额2.01元，用户支付成功");
		UnifiedOrderReq req = new UnifiedOrderReq();
		req.setBody("testwechatpay");
		req.setDetail("testdetail");
		req.setAttach("attach");
		req.setDevice_info("deviceInfo");
		req.setGoods_tag("goodsTag");
		req.setLimit_pay("no_credit");
		req.setProduct_id("testProductId");
		req.setScene_info("sceneInfo");
		req.setTrade_type("APP");
		req.setTotal_fee(201);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		logger.info("测试用例2[APP-正常] 订单金额2.02元 (含0.01元充值代金券，0.02元免充值代金券)，用户支付成功");
		req.setTotal_fee(202);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		logger.info("测试用例3 [APP-异常] 订单金额2.30元， 用户支付成功，商户未收到微信支付结果通知");
		req.setTotal_fee(230);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		logger.info("测试用例4 [APP-异常] 订单金额2.31元，用户支付失败，商户未收到微信支付结果通知");
		req.setTotal_fee(231);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		logger.info("测试用例5 [APP-异常] 订单金额2.32元，用户支付成功，微信支付重复通知商户");
		req.setTotal_fee(232);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		logger.info("测试用例6 [APP-异常] 订单金额2.33元，用户支付成功，微信支付通知签名非法");
		req.setTotal_fee(233);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		logger.info("测试用例7 [APP-异常] 订单金额2.34元，用户支付成功，微信支付通知关键信息部一致");
		req.setTotal_fee(234);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		logger.info("测试用例8 [APP-对账]　订单金额2.79元，支付成功，通知失败，对账不平");
		req.setTotal_fee(279);
		order(request, req);
		ThreadUtil.sleep(6000);
		WxPayUtil.getInstance().queryOrderByOutTradeNo(req.getOut_trade_no());
		Date yesterday = DateUtils.addDays(new Date(), -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String billDate = format.format(yesterday);
		DownloadBillReq requestBill = new DownloadBillReq();
		requestBill.setBill_date(billDate);
		requestBill.setBill_type("ALL");
		String billContent = WxPayUtil.getInstance().downloadBill(requestBill);
		File dir = new File(billDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String billFile = billDir + "/" + "wechatpay" + "/" + billDate + ".txt";
		FileUtils.write(new File(billFile), billContent, ConstantData.DEFAULT_CHARSET);
		logger.info("写入微信支付对账单成功:" + billFile);
	}
}
