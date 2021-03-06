package com.simba.util.send;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.common.EnvironmentUtil;
import com.simba.exception.BussException;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.BeanUtils;
import com.simba.framework.util.common.XmlUtil;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.model.pay.closeOrder.CloseOrderReq;
import com.simba.model.pay.closeOrder.CloseOrderRes;
import com.simba.model.pay.downloadbill.DownloadBillReq;
import com.simba.model.pay.orderquery.OrderQueryReq;
import com.simba.model.pay.orderquery.OrderQueryRes;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.refund.RefundRes;
import com.simba.model.pay.refundquery.RefundQueryReq;
import com.simba.model.pay.refundquery.RefundQueryRes;
import com.simba.model.pay.sandbox.SandBoxRes;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.model.pay.unifiedorder.UnifiedOrderRes;
import com.simba.util.common.SignUtil;
import com.simba.util.common.WxPayConstantData;

/**
 * 微信支付工具类
 * 
 * @author caozhejun
 *
 */
public class WxPayUtil {

	private static final Log logger = LogFactory.getLog(WxPayUtil.class);
	private static final String[] TRADE_TYPES = new String[] { "JSAPI", "NATIVE", "APP", "MWEB" };
	private static final String[] REFUND_ACCOUNT = new String[] { "REFUND_SOURCE_RECHARGE_FUNDS", "REFUND_SOURCE_UNSETTLED_FUNDS" };
	private static final String[] BILL_TYPE = new String[] { "ALL", "REFUND", "SUCCESS" };
	private String key = null;
	private String appid = null;
	private String mchId = null;

	private WxPayUtil() {
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		key = environmentUtil.get("wx.pay.key");
		appid = environmentUtil.get("appID");
		mchId = environmentUtil.get("wx.pay.mchid");
		String sandboxEnabled = environmentUtil.get("wx.pay.sandbox");
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(appid) || StringUtils.isEmpty(mchId)) {
			logger.warn("没有配置微信支付信息，不能使用微信支付功能");
		}
		// 是否启用沙箱测试
		boolean sandbox = true;
		if ("false".equals(sandboxEnabled)) {
			sandbox = false;
		}
		if (sandbox) {
			key = getSandboxKey();
			logger.info("启动沙箱key:" + key);
		} else {
			WxPayConstantData.getInstance().changeReal();
			logger.info("启动微信支付正式环境");
		}
	}

	private static final class WxPayUtilHolder {
		private static final WxPayUtil instance = new WxPayUtil();
	}

	public static WxPayUtil getInstance() {
		return WxPayUtilHolder.instance;
	}

	/**
	 * 统一下单 除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、
	 * APP等不同场景生成交易串调起支付。
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public UnifiedOrderRes unifiedOrder(UnifiedOrderReq request) throws Exception {
		checkParameters(request);// 校验参数
		String nonce_str = RandomUtil.random32Chars();
		request.setAppid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		logger.info("订单参数为" + params.toString());
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("统一下单:" + WxPayConstantData.getInstance().getUnifiedorderUrl() + ",内容:" + xml + "," + key);
		String resp = HttpClientUtil.postXML(WxPayConstantData.getInstance().getUnifiedorderUrl(), xml);
		logger.info("统一下单返回结果:" + resp);
		UnifiedOrderRes result = XmlUtil.toOject(resp, UnifiedOrderRes.class);
		checkSign(result);
		if (!"SUCCESS".equals(result.getReturn_code()) || !"SUCCESS".equals(result.getResult_code())) {
			throw new BussException("微信统一下单发生异常:" + result.getReturn_msg() + "," + result.getErr_code_des());
		}
		return result;
	}

	/**
	 * 查询订单(该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
	 * 
	 * 需要调用查询接口的情况：
	 * 
	 * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知； ◆ 调用支付接口后，返回系统错误或未知交易状态情况； ◆
	 * 调用被扫支付API，返回USERPAYING的状态； ◆ 调用关单或撤销接口API之前，需确认支付状态；)
	 * 
	 * @param transactionId
	 *            微信订单号
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	public OrderQueryRes queryOrderByTransactionId(String transactionId) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		return queryOrder(transactionId, null);
	}

	/**
	 * 查询订单(该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
	 * 
	 * 需要调用查询接口的情况：
	 * 
	 * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知； ◆ 调用支付接口后，返回系统错误或未知交易状态情况； ◆
	 * 调用被扫支付API，返回USERPAYING的状态； ◆ 调用关单或撤销接口API之前，需确认支付状态；)
	 * 
	 * @param outTradeNo
	 *            商户系统内部的订单号
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	public OrderQueryRes queryOrderByOutTradeNo(String outTradeNo) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		return queryOrder(null, outTradeNo);
	}

	/**
	 * 查询订单
	 * 
	 * @param transactionId
	 *            微信订单号
	 * @param outTradeNo
	 *            商户系统内部的订单号
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	private OrderQueryRes queryOrder(String transactionId, String outTradeNo) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		OrderQueryReq request = new OrderQueryReq();
		if (StringUtils.isNotEmpty(transactionId)) {
			request.setTransaction_id(transactionId);
		}
		if (StringUtils.isNotEmpty(outTradeNo)) {
			request.setOut_trade_no(outTradeNo);
		}
		String nonce_str = RandomUtil.random32Chars();
		request.setAppid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("查询订单:" + WxPayConstantData.getInstance().getOrderqueryUrl() + ",内容:" + xml);
		String resp = HttpClientUtil.postXML(WxPayConstantData.getInstance().getOrderqueryUrl(), xml);
		logger.info("查询订单返回结果:" + resp);
		OrderQueryRes result = XmlUtil.toOject(resp, OrderQueryRes.class);
		checkSign(result);
		result.composeCoupons(resp);
		if (!"SUCCESS".equals(result.getReturn_code()) || !"SUCCESS".equals(result.getResult_code())) {
			throw new BussException("微信查询订单发生异常:" + result.getReturn_msg() + "," + result.getErr_code_des());
		}
		return result;
	}

	/**
	 * 关闭订单(以下情况需要调用关单接口：商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；系统下单后，用户支付超时，
	 * 系统退出不再受理，避免用户继续，请调用关单接口。
	 * 
	 * 注意：订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。 )
	 * 
	 * @param outTradeNo
	 *            商户系统内部的订单号
	 * @return
	 */
	public CloseOrderRes closeOrder(String outTradeNo) {
		if (StringUtils.isBlank(outTradeNo)) {
			throw new IllegalArgumentException("out_trade_no 不能为空");
		}
		CloseOrderReq request = new CloseOrderReq();
		String nonce_str = RandomUtil.random32Chars();
		request.setAppid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		request.setOut_trade_no(outTradeNo);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("关闭订单:" + WxPayConstantData.getInstance().getCloseorderUrl() + ",内容:" + xml);
		String resp = HttpClientUtil.postXML(WxPayConstantData.getInstance().getCloseorderUrl(), xml);
		logger.info("关闭订单返回结果:" + resp);
		CloseOrderRes result = XmlUtil.toOject(resp, CloseOrderRes.class);
		checkSign(result);
		if (!"SUCCESS".equals(result.getReturn_code()) || !"SUCCESS".equals(result.getResult_code())) {
			throw new BussException("微信关闭订单发生异常:" + result.getReturn_msg() + "," + result.getErr_code_des());
		}
		return result;
	}

	/**
	 * 查询退款(提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账， 银行卡支付的退款3个工作日后重新查询退款状态。 )
	 * 
	 * @param transactionId
	 *            微信订单号
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	public RefundQueryRes refundQueryByTransactionId(String transactionId) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		return refundQuery(transactionId, null, null, null);
	}

	/**
	 * 查询退款(提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账， 银行卡支付的退款3个工作日后重新查询退款状态。 )
	 * 
	 * @param outTradeNo
	 *            商户系统内部的订单号
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	public RefundQueryRes refundQueryByOutTradeNo(String outTradeNo) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		return refundQuery(null, outTradeNo, null, null);
	}

	/**
	 * 查询退款(提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账， 银行卡支付的退款3个工作日后重新查询退款状态。 )
	 * 
	 * @param outRefundNo
	 *            商户侧传给微信的退款单号
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	public RefundQueryRes refundQueryByOutRefundNo(String outRefundNo) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		return refundQuery(null, null, outRefundNo, null);
	}

	/**
	 * 查询退款(提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账， 银行卡支付的退款3个工作日后重新查询退款状态。 )
	 * 
	 * @param refundId
	 *            微信生成的退款单号，在申请退款接口有返回
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	public RefundQueryRes refundQueryByRefundId(String refundId) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		return refundQuery(null, null, null, refundId);
	}

	/**
	 * 查询退款
	 * 
	 * @param transactionId
	 *            微信订单号
	 * @param outTradeNo
	 *            商户系统内部的订单号
	 * @param outRefundNo
	 *            商户侧传给微信的退款单号
	 * @param refundId
	 *            微信生成的退款单号，在申请退款接口有返回
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	private RefundQueryRes refundQuery(String transactionId, String outTradeNo, String outRefundNo, String refundId)
			throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		RefundQueryReq request = new RefundQueryReq();
		if (StringUtils.isNotEmpty(transactionId)) {
			request.setTransaction_id(transactionId);
		}
		if (StringUtils.isNotEmpty(outTradeNo)) {
			request.setOut_trade_no(outTradeNo);
		}
		if (StringUtils.isNotEmpty(outRefundNo)) {
			request.setOut_refund_no(outRefundNo);
		}
		if (StringUtils.isNotEmpty(refundId)) {
			request.setRefund_id(refundId);
		}
		String nonce_str = RandomUtil.random32Chars();
		request.setAppid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("查询退款:" + WxPayConstantData.getInstance().getRefundqueryUrl() + ",内容:" + xml);
		String resp = HttpClientUtil.postXML(WxPayConstantData.getInstance().getRefundqueryUrl(), xml);
		logger.info("查询退款返回结果:" + resp);
		RefundQueryRes result = XmlUtil.toOject(resp, RefundQueryRes.class);
		checkSign(result);
		if (!"SUCCESS".equals(result.getReturn_code()) || !"SUCCESS".equals(result.getResult_code())) {
			throw new BussException("微信查询退款发生异常:" + result.getReturn_msg() + "," + result.getErr_code_des());
		}
		return result;
	}

	/**
	 * 下载对账单 (商户可以通过该接口下载历史交易清单。比如掉单、系统错误等导致商户侧和微信侧数据不一致，通过对账单核对后可校正支付状态。
	 * 
	 * 注意：
	 * 
	 * 1、微信侧未成功下单的交易不会出现在对账单中。支付成功后撤销的交易会出现在对账单中，跟原支付单订单号一致；
	 * 
	 * 2、微信在次日9点启动生成前一天的对账单，建议商户10点后再获取；
	 * 
	 * 3、对账单中涉及金额的字段单位为“元”。
	 * 
	 * 4、对账单接口只能下载三个月以内的账单。
	 * 
	 * )
	 * 
	 * @param request
	 * @return
	 */
	public String downloadBill(DownloadBillReq request) {
		checkParameters(request);
		String nonce_str = RandomUtil.random32Chars();
		request.setAppid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("下载对账单:" + WxPayConstantData.getInstance().getDownloadbillUrl() + ",内容:" + xml);
		String resp = HttpClientUtil.postXML(WxPayConstantData.getInstance().getDownloadbillUrl(), xml);
		logger.info("下载对账单返回结果:" + resp);
		return resp;
	}

	/**
	 * 申请退款 (当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，
	 * 按照退款规则将支付款按原路退到买家帐号上。
	 * 
	 * 注意：
	 * 
	 * 1、交易时间超过一年的订单无法提交退款；
	 * 
	 * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。总退款金额不能超过用户实际支付金额。
	 * 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号。
	 * 
	 * 3、请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次 错误或无效请求频率限制：6qps，即每秒钟异常或错误的退款申请请求不超过6次
	 * 
	 * 4、每个支付订单的部分退款次数不能超过50次
	 * 
	 * 
	 * 
	 * 请求需要双向证书)
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public RefundRes refund(RefundReq request) throws ParseException, IOException {
		checkParameters(request);
		String nonce_str = RandomUtil.random32Chars();
		request.setAppid(appid);
		request.setMch_id(mchId);
		request.setOp_user_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		String resp = CertRequestUrl.getInstance().executeWithKey(WxPayConstantData.getInstance().getRefundUrl(), xml);
		RefundRes result = XmlUtil.toOject(resp, RefundRes.class);
		checkSign(result);
		if (!"SUCCESS".equals(result.getReturn_code()) || !"SUCCESS".equals(result.getResult_code())) {
			throw new BussException("微信申请退款发生异常:" + result.getReturn_msg() + "," + result.getErr_code_des());
		}
		return result;
	}

	private void checkParameters(RefundReq request) {
		if (StringUtils.isNotBlank(request.getRefund_account())) {
			if (!ArrayUtils.contains(REFUND_ACCOUNT, request.getRefund_account())) {
				throw new IllegalArgumentException("refund_account目前必须为" + Arrays.toString(REFUND_ACCOUNT) + "其中之一,实际值：" + request.getRefund_account());
			}
		}
		if (StringUtils.isBlank(request.getOut_trade_no()) && StringUtils.isBlank(request.getTransaction_id())) {
			throw new IllegalArgumentException("transaction_id 和 out_trade_no 不能同时为空，必须提供一个");
		}
	}

	private void checkParameters(DownloadBillReq request) {
		if (StringUtils.isNotBlank(request.getTar_type()) && !"GZIP".equals(request.getTar_type())) {
			throw new IllegalArgumentException("tar_type值如果存在，只能为GZIP");
		}
		if (!ArrayUtils.contains(BILL_TYPE, request.getBill_type())) {
			throw new IllegalArgumentException("bill_tpye目前必须为" + Arrays.toString(BILL_TYPE) + "其中之一,实际值：" + request.getBill_type());
		}
	}

	public void checkSign(Object result) {
		Map<String, String> params = BeanUtils.xmlBean2Map(result);
		Map<String, String> signParams = new HashMap<>();
		for (String key : params.keySet()) {
			String value = params.get(key);
			if (StringUtils.isNotEmpty(value) && !"0".equals(value)) {
				signParams.put(key, value);
			} else if (StringUtils.isNotEmpty(value) && ("coupon_refund_count".equals(key) || "coupon_refund_fee".equals(key))) {
				signParams.put(key, value);
			}
		}
		if (params.get("sign") != null && !checkSign(signParams)) {
			throw new RuntimeException("微信支付服务器返回签名错误");
		}
	}

	private boolean checkSign(Map<String, String> params) {
		String sign = SignUtil.getInstance().createSign(params, key);
		return sign.equals(params.get("sign"));
	}

	private void checkParameters(UnifiedOrderReq request) {
		if (!ArrayUtils.contains(TRADE_TYPES, request.getTrade_type())) {
			throw new IllegalArgumentException("trade_type目前必须为" + Arrays.toString(TRADE_TYPES) + "其中之一,实际值：" + request.getTrade_type());
		}
		if ("JSAPI".equals(request.getTrade_type()) && request.getOpenid() == null) {
			throw new IllegalArgumentException("当 trade_type是'JSAPI'时未指定openid");
		}
		if ("NATIVE".equals(request.getTrade_type()) && request.getProduct_id() == null) {
			throw new IllegalArgumentException("当 trade_type是'NATIVE'时未指定product_id");
		}
	}

	/**
	 * 获取沙箱的key
	 * 
	 * @return
	 */
	public String getSandboxKey() {
		Map<String, String> params = new HashMap<>();
		params.put("mch_id", mchId);
		params.put("nonce_str", RandomUtil.random32Chars());
		String sign = SignUtil.getInstance().createSign(params, key);
		params.put("sign", sign);
		String xml = "<xml>" + "<mch_id>" + params.get("mch_id") + "</mch_id>" + "<nonce_str>" + params.get("nonce_str") + "</nonce_str>" + "<sign>" + params.get("sign") + "</sign>" + "</xml>";
		logger.info("获取沙箱key的xml内容为:" + xml);
		String res = HttpClientUtil.postXML(WxPayConstantData.getInstance().getSandboxnewKeyUrl(), xml);
		logger.info("获取沙箱key返回:" + res);
		SandBoxRes result = XmlUtil.toOject(res, SandBoxRes.class);
		checkSign(result);
		if (!"SUCCESS".equals(result.getReturn_code())) {
			throw new BussException("获取沙箱key发生异常:" + result.getReturn_msg());
		}
		return result.getSandbox_signkey();
	}

}
