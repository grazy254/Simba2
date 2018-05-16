package com.simba.alipay.util;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.simba.alipay.cosntantData.AliPayConstantData;
import com.simba.exception.BussException;
import com.simba.model.constant.ConstantData;

/**
 * 阿里支付工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class AliPayUtil {

	private static final Log logger = LogFactory.getLog(AliPayUtil.class);

	@Value("${alipay.appid}")
	private String appId;

	@Value("${alipay.private.key}")
	private String privateKey;

	@Value("${alipay.public.key}")
	private String publicKey;

	private AlipayClient alipayClient;

	@PostConstruct
	private void init() {
		alipayClient = new DefaultAlipayClient(AliPayConstantData.payUrl, appId, privateKey, AliPayConstantData.format, ConstantData.DEFAULT_CHARSET, publicKey, AliPayConstantData.signType);
	}

	/**
	 * 交易查询
	 * 
	 * @param out_trade_no
	 *            支付时传入的商户订单号，与trade_no必填一个
	 * @param trade_no
	 *            支付时返回的支付宝交易号，与out_trade_no必填一个
	 * @return
	 * @throws AlipayApiException
	 */
	public AlipayTradeQueryResponse query(String out_trade_no, String trade_no) throws AlipayApiException {
		checkParams(out_trade_no, trade_no);
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();// 创建API对应的request类
		request.setBizContent("{" + "   \"out_trade_no\":\"" + StringUtils.defaultString(out_trade_no) + "\"," + "   \"trade_no\":\"" + StringUtils.defaultString(trade_no) + "\"" + "  }");// 设置业务参数
		AlipayTradeQueryResponse response = alipayClient.execute(request);// 通过alipayClient调用API，获得对应的response类
		logger.info("交易查询返回结果:" + response.getBody());
		return response;
	}

	private void checkParams(String out_trade_no, String trade_no) {
		if (StringUtils.isEmpty(out_trade_no) && StringUtils.isEmpty(trade_no)) {
			throw new BussException("支付时传入的商户订单号和支付时返回的支付宝交易号不能同时为空");
		}
	}

	/**
	 * 交易退款
	 * 
	 * @param out_trade_no
	 *            支付时传入的商户订单号，与trade_no必填一个
	 * @param trade_no
	 *            支付时返回的支付宝交易号，与out_trade_no必填一个
	 * @param out_request_no
	 *            本次退款请求流水号，部分退款时必传
	 * @param refund_amount
	 *            本次退款金额
	 * @return
	 * @throws AlipayApiException
	 */
	public AlipayTradeRefundResponse refund(String out_trade_no, String trade_no, String out_request_no, int refund_amount) throws AlipayApiException {
		checkParams(out_trade_no, trade_no);
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();// 创建API对应的request类
		request.setBizContent("{" + "    \"out_trade_no\":\"" + StringUtils.defaultString(out_trade_no) + "\"," + "    \"trade_no\":\"" + StringUtils.defaultString(trade_no) + "\","
				+ "    \"out_request_no\":\"" + StringUtils.defaultString(out_request_no) + "\"," + "    \"refund_amount\":\"" + refund_amount + "\"" + "  }");// 设置业务参数
		AlipayTradeRefundResponse response = alipayClient.execute(request);// 通过alipayClient调用API，获得对应的response类
		logger.info("交易退款返回结果:" + response.getBody());
		return response;
	}

	/**
	 * 查询对账单下载地址
	 * 
	 * @param bill_date
	 *            需要下载的账单日期，最晚是当期日期的前一天
	 * @return
	 * @throws AlipayApiException
	 */
	public AlipayDataDataserviceBillDownloadurlQueryResponse billDown(String bill_date) throws AlipayApiException {
		AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();// 创建API对应的request类
		request.setBizContent("{" + "    \"bill_type\":\"trade\"," + "    \"bill_date\":\"" + bill_date + "\"" + "  }");// 设置业务参数
		AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
		logger.info("查询对账单下载地址返回结果:" + response.getBody());
		return response;
	}

}
