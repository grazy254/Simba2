package com.simba.alipay.util;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.simba.alipay.cosntantData.AliPayConstantData;
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
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();// 创建API对应的request类
		request.setBizContent("{" + "   \"out_trade_no\":\"20150320010101001\"," + "   \"trade_no\":\"2014112611001004680073956707\"" + "  }");// 设置业务参数
		AlipayTradeQueryResponse response = alipayClient.execute(request);// 通过alipayClient调用API，获得对应的response类
		logger.info("交易查询返回结果:" + response.getBody());
		return response;
	}

}
