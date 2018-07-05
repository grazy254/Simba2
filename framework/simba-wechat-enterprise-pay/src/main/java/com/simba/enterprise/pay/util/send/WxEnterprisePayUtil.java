package com.simba.enterprise.pay.util.send;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;

import com.simba.common.EnvironmentUtil;
import com.simba.enterprise.pay.model.card.CardReq;
import com.simba.enterprise.pay.model.card.CardRes;
import com.simba.enterprise.pay.model.loosemoney.LooseMoneyReq;
import com.simba.enterprise.pay.model.loosemoney.LooseMoneyRes;
import com.simba.enterprise.pay.model.publickey.PublicKeyReq;
import com.simba.enterprise.pay.model.publickey.PublicKeyRes;
import com.simba.enterprise.pay.model.searchCard.SearchCardReq;
import com.simba.enterprise.pay.model.searchCard.SearchCardRes;
import com.simba.enterprise.pay.model.searchloosemoney.SearchLooseMoneyReq;
import com.simba.enterprise.pay.model.searchloosemoney.SearchLooseMoneyRes;
import com.simba.enterprise.pay.util.common.WxEnterprisePayConstantData;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.code.RSAUtil;
import com.simba.framework.util.common.BeanUtils;
import com.simba.framework.util.common.XmlUtil;
import com.simba.framework.util.data.RandomUtil;
import com.simba.util.common.SignUtil;
import com.simba.util.send.CertRequestUrl;

/**
 * 微信企业转账工具类
 * 
 * @author caozhejun
 *
 */
public class WxEnterprisePayUtil {

	private static final Log logger = LogFactory.getLog(WxEnterprisePayUtil.class);
	private String key = null;
	private String appid = null;
	private String mchId = null;
	private String rsaKey = null;

	private WxEnterprisePayUtil() {
		try {
			init();
		} catch (Exception e) {
			logger.error("初始化微信企业转账功能发生异常", e);
		}
	}

	private void init() throws ParseException, IOException {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		key = environmentUtil.get("wx.pay.key");
		appid = environmentUtil.get("appID");
		mchId = environmentUtil.get("wx.pay.mchid");
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(appid) || StringUtils.isEmpty(mchId)) {
			logger.warn("没有配置微信企业支付相关信息，不能使用微信企业支付");
			return;
		}
		rsaKey = getRSAKey();
	}

	private static final class WxEnterprisePayUtilHolder {
		private static WxEnterprisePayUtil instance = new WxEnterprisePayUtil();
	}

	public static WxEnterprisePayUtil getInstance() {
		return WxEnterprisePayUtilHolder.instance;
	}

	/**
	 * 企业付款到零钱
	 * 
	 * 
	 * 接口调用规则： ◆ 给同一个实名用户付款，单笔单日限额2W/2W
	 * 
	 * ◆ 不支持给非实名用户打款
	 * 
	 * ◆ 一个商户同一日付款总额限额100W
	 * 
	 * ◆ 单笔最小金额默认为1元
	 * 
	 * ◆ 每个用户每天最多可付款10次，可以在商户平台--API安全进行设置
	 * 
	 * 注意1-当返回错误码为“SYSTEMERROR”时，一定要使用原单号重试，否则可能造成重复支付等资金风险。
	 * 
	 * 注意2-根据监管要求，新申请商户号使用企业付款需要满足两个条件：1、入驻时间超过90天 2、连续正常交易30天。
	 * 
	 * 
	 * 
	 * @param req
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public LooseMoneyRes transfersLooseMoney(LooseMoneyReq request) throws ParseException, IOException {
		String nonce_str = RandomUtil.random32Chars();
		request.setMch_appid(appid);
		request.setMchid(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("企业付款到零钱:" + WxEnterprisePayConstantData.transfersLooseMoneyUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxEnterprisePayConstantData.transfersLooseMoneyUrl, xml);
		logger.info("企业付款到零钱返回结果:" + resp);
		LooseMoneyRes result = XmlUtil.toOject(resp, LooseMoneyRes.class);
		checkResult(result);
		return result;
	}

	private void checkResult(Object result) {
		Map<String, String> params = BeanUtils.xmlBean2Map(result);
		if (params.get("sign") != null && !checkSign(params)) {
			throw new RuntimeException("微信支付服务器返回签名错误");
		}
		String return_code = params.get("return_code");
		String result_code = params.get("result_code");
		if (!"SUCCESS".equals(return_code) || !"SUCCESS".equals(result_code)) {
			throw new RuntimeException("微信企业支付异常");
		}
	}

	private boolean checkSign(Map<String, String> params) {
		String sign = SignUtil.getInstance().createSign(params, key);
		return sign.equals(params.get("sign"));
	}

	/**
	 * 用于商户的企业付款操作进行结果查询，返回付款操作详细结果。
	 * 
	 * 查询企业付款API只支持查询30天内的订单，30天之前的订单请登录商户平台查询
	 * 
	 * 
	 * @param partner_trade_no
	 *            商户订单号(商户调用企业付款API时使用的商户订单号)
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public SearchLooseMoneyRes searchLooseMoney(String partner_trade_no) throws ParseException, IOException {
		SearchLooseMoneyReq request = new SearchLooseMoneyReq();
		request.setPartner_trade_no(partner_trade_no);
		request.setAppid(appid);
		request.setMch_id(mchId);
		String nonce_str = RandomUtil.random32Chars();
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("企业付款到零钱查询:" + WxEnterprisePayConstantData.searchLooseMoneyUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxEnterprisePayConstantData.searchLooseMoneyUrl, xml);
		logger.info("企业付款到零钱查询返回结果:" + resp);
		SearchLooseMoneyRes result = XmlUtil.toOject(resp, SearchLooseMoneyRes.class);
		checkResult(result);
		return result;
	}

	/**
	 * 获取商户的RSA密钥
	 * 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getRSAKey() throws ParseException, IOException {
		PublicKeyReq request = new PublicKeyReq();
		request.setMch_id(mchId);
		String nonce_str = RandomUtil.random32Chars();
		request.setNonce_str(nonce_str);
		request.setSign_type("MD5");
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("获取商户的RSA密钥:" + WxEnterprisePayConstantData.getPublicUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxEnterprisePayConstantData.getPublicUrl, xml);
		logger.info("获取商户的RSA密钥返回结果:" + resp);
		PublicKeyRes result = XmlUtil.toOject(resp, PublicKeyRes.class);
		checkResult(result);
		return result.getPub_key();
	}

	/**
	 * 微信企业付款到银行卡
	 * 
	 * ◆ 单商户日限额——单日100w
	 * 
	 * ◆ 单次限额——单次5w
	 * 
	 * ◆ 单商户给同一银行卡单日限额——单日5w
	 * 
	 * 
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public CardRes transfersCard(CardReq request) throws Exception {
		String nonce_str = RandomUtil.random32Chars();
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		// 对卡号和用户名进行rsa加密
		String bankNo = RSAUtil.encode(request.getEnc_bank_no(), rsaKey);
		String name = RSAUtil.encode(request.getEnc_true_name(), rsaKey);
		request.setEnc_bank_no(bankNo);
		request.setEnc_true_name(name);
		String xml = request.toXML();
		logger.info("企业付款到银行卡:" + WxEnterprisePayConstantData.transfersCardUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxEnterprisePayConstantData.transfersCardUrl, xml);
		logger.info("企业付款到银行卡返回结果:" + resp);
		CardRes result = XmlUtil.toOject(resp, CardRes.class);
		checkResult(result);
		return result;
	}

	/**
	 * 用于对商户企业付款到银行卡操作进行结果查询，返回付款操作详细结果。
	 * 
	 * 
	 * @param partner_trade_no
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public SearchCardRes searchCard(String partner_trade_no) throws ParseException, IOException {
		SearchCardReq request = new SearchCardReq();
		request.setPartner_trade_no(partner_trade_no);
		String nonce_str = RandomUtil.random32Chars();
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("企业付款到银行卡查询:" + WxEnterprisePayConstantData.searchCardUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxEnterprisePayConstantData.searchCardUrl, xml);
		logger.info("企业付款到银行卡查询返回结果:" + resp);
		SearchCardRes result = XmlUtil.toOject(resp, SearchCardRes.class);
		checkResult(result);
		return result;
	}
}
