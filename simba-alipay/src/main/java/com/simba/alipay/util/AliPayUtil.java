package com.simba.alipay.util;

import java.util.List;

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
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeOrderSettleRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeOrderSettleResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.simba.alipay.cosntantData.AliPayConstantData;
import com.simba.alipay.model.RoyaltyParameter;
import com.simba.exception.BussException;
import com.simba.framework.util.json.FastJsonUtil;
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
	 * 交易查询(该接口提供所有支付宝支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。 需要调用查询接口的情况：
	 * 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知； 调用支付接口后，返回系统错误或未知交易状态情况；
	 * 调用alipay.trade.pay，返回INPROCESS的状态； 调用alipay.trade.cancel之前，需确认支付状态)
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
	 * 交易退款(当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，支付宝将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。
	 * 交易超过约定时间（签约时设置的可退款时间）的订单无法进行退款
	 * 支付宝退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。总退款金额不能超过用户实际支付金额)
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

	/**
	 * 统一收单交易退款查询(商户可使用该接口查询自已通过alipay.trade.refund提交的退款请求是否执行成功。
	 * 该接口的返回码10000，仅代表本次查询操作成功，不代表退款成功。如果该接口返回了查询数据，则代表退款成功，如果没有查询到则代表未退款成功，可以调用退款接口进行重试。重试时请务必保证退款请求号一致)
	 * 
	 * @param trade_no
	 *            支付宝交易号，和商户订单号不能同时为空
	 * @param out_trade_no
	 *            订单支付时传入的商户订单号,和支付宝交易号不能同时为空。
	 *            trade_no,out_trade_no如果同时存在优先取trade_no
	 * @param out_request_no
	 *            请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
	 * @return
	 * @throws AlipayApiException
	 */
	public AlipayTradeFastpayRefundQueryResponse refundQuery(String trade_no, String out_trade_no, String out_request_no) throws AlipayApiException {
		AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
		request.setBizContent("{" + "\"trade_no\":\"" + StringUtils.defaultString(trade_no) + "\"," + "\"out_trade_no\":\"" + StringUtils.defaultString(out_trade_no) + "\"," + "\"out_request_no\":\""
				+ StringUtils.defaultString(out_request_no) + "\"" + "  }");
		AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
		logger.info("统一收单交易退款查询返回结果:" + response.getBody());
		return response;
	}

	/**
	 * 统一收单交易结算(用于在线下场景交易支付后，进行结算)
	 * 
	 * @param out_request_no
	 *            结算请求流水号 开发者自行生成并保证唯一性
	 * @param trade_no
	 *            支付宝订单号
	 * @param royalty_parameters
	 *            分账明细信息
	 * @param operator_id
	 *            操作员id
	 * @return
	 * @throws AlipayApiException
	 */
	public AlipayTradeOrderSettleResponse orderSettle(String out_request_no, String trade_no, List<RoyaltyParameter> royalty_parameters, String operator_id) throws AlipayApiException {
		AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
		request.setBizContent("{" + "\"out_request_no\":\"" + StringUtils.defaultString(out_request_no) + "\"," + "\"trade_no\":\"" + StringUtils.defaultString(trade_no) + "\","
				+ "      \"royalty_parameters\":" + FastJsonUtil.toJson(royalty_parameters) + "," + "\"operator_id\":\"" + StringUtils.defaultString(operator_id) + "\"" + "  }");
		AlipayTradeOrderSettleResponse response = alipayClient.execute(request);
		logger.info("统一收单交易结算返回结果:" + response.getBody());
		return response;
	}

	/**
	 * 统一收单交易关闭(用于交易创建后，用户在一定时间内未进行支付，可调用该接口直接将未付款的交易进行关闭)
	 * 
	 * @param out_trade_no
	 *            订单支付时传入的商户订单号,和支付宝交易号不能同时为空。
	 *            trade_no,out_trade_no如果同时存在优先取trade_no
	 * @param trade_no
	 *            该交易在支付宝系统中的交易流水号。最短 16 位，最长 64 位。和out_trade_no不能同时为空，如果同时传了
	 *            out_trade_no和 trade_no，则以 trade_no为准
	 * @param operator_id
	 *            卖家端自定义的的操作员 ID
	 * @return
	 * @throws AlipayApiException
	 */
	public AlipayTradeCloseResponse close(String out_trade_no, String trade_no, String operator_id) throws AlipayApiException {
		AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
		request.setBizContent("{" + "\"trade_no\":\"" + StringUtils.defaultString(trade_no) + "\"," + "\"out_trade_no\":\"" + StringUtils.defaultString(out_trade_no) + "\"," + "\"operator_id\":\""
				+ StringUtils.defaultString(operator_id) + "\"" + "  }");
		AlipayTradeCloseResponse response = alipayClient.execute(request);
		logger.info("统一收单交易关闭返回结果:" + response.getBody());
		return response;
	}

	/**
	 * 统一收单交易撤销(支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，支付宝系统会将此订单关闭；如果用户支付成功，支付宝系统会将此订单资金退还给用户。
	 * 注意：只有发生支付系统超时或者支付结果未知时可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】)
	 * 
	 * @param out_trade_no
	 *            原支付请求的商户订单号,和支付宝交易号不能同时为空
	 * @param trade_no
	 *            支付宝交易号，和商户订单号不能同时为空
	 * @return
	 * @throws AlipayApiException
	 */
	public AlipayTradeCancelResponse cancel(String out_trade_no, String trade_no) throws AlipayApiException {
		AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
		request.setBizContent("{" + "\"out_trade_no\":\"" + StringUtils.defaultString(out_trade_no) + "\"," + "\"trade_no\":\"" + StringUtils.defaultString(trade_no) + "\"" + "  }");
		AlipayTradeCancelResponse response = alipayClient.execute(request);
		logger.info("统一收单交易撤销返回结果:" + response.getBody());
		return response;
	}

	public AlipayTradePrecreateResponse precreate() {
		return null;
	}
}
