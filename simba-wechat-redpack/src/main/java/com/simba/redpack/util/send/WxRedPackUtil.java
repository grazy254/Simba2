package com.simba.redpack.util.send;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.BeanUtils;
import com.simba.framework.util.common.XmlUtil;
import com.simba.framework.util.data.RandomUtil;
import com.simba.redpack.model.group.GroupRedPackReq;
import com.simba.redpack.model.group.GroupRedPackRes;
import com.simba.redpack.model.normal.NormalRedPackReq;
import com.simba.redpack.model.normal.NormalRedPackRes;
import com.simba.redpack.model.search.SearchReq;
import com.simba.redpack.model.search.SearchRes;
import com.simba.redpack.util.common.WxRedPackConstantData;
import com.simba.util.common.SignUtil;
import com.simba.util.send.CertRequestUrl;

/**
 * 微信现金红包工具类
 * 
 * @author caozhejun
 *
 */
public class WxRedPackUtil {

	private static final Log logger = LogFactory.getLog(WxRedPackUtil.class);
	private String key = null;
	private String appid = null;
	private String mchId = null;

	private WxRedPackUtil() {
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		key = environmentUtil.get("wx.pay.key");
		appid = environmentUtil.get("appID");
		mchId = environmentUtil.get("wx.pay.mchid");
	}

	private static final class WxRedPackUtilHolder {
		private static final WxRedPackUtil instance = new WxRedPackUtil();
	}

	public static WxRedPackUtil getInstance() {
		return WxRedPackUtilHolder.instance;
	}

	/**
	 * 发放普通红包 --
	 * 
	 * 发放规则 1.发送频率限制------默认1800/min
	 * 
	 * 2.发送个数上限------按照默认1800/min算
	 * 
	 * 3.金额上限------根据传入场景id不同默认上限不同，可以在商户平台产品设置进行设置和申请，最大不大于4999元/个
	 * 
	 * 4.其他的“量”上的限制还有哪些？------用户当天的领取上限次数,默认是10
	 * 
	 * 5.如果量上满足不了我们的需求，如何提高各个上限？------金额上限和用户当天领取次数上限可以在商户平台进行设置
	 * 
	 * 注意-红包金额大于200时，请求参数scene_id必传，参数说明见下文。
	 * 注意2-根据监管要求，新申请商户号使用现金红包需要满足两个条件：1、入驻时间超过90天 2、连续正常交易30天。
	 * 
	 * 
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public NormalRedPackRes sendNormalRedPack(NormalRedPackReq request) throws ParseException, IOException {
		String nonce_str = RandomUtil.random32Chars();
		request.setWxappid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("微信发放普通红包:" + WxRedPackConstantData.sendNormalRedPackUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxRedPackConstantData.sendNormalRedPackUrl, xml);
		logger.info("微信发放普通红包返回结果:" + resp);
		NormalRedPackRes result = XmlUtil.toOject(resp, NormalRedPackRes.class);
		checkResult(result);
		return result;
	}

	private void checkResult(Object result) {
		Map<String, String> params = BeanUtils.xmlBean2Map(result);
		if (params.get("sign") != null && !checkSign(params)) {
			throw new RuntimeException("微信支付服务器返回签名错误");
		}
	}

	private boolean checkSign(Map<String, String> params) {
		String sign = SignUtil.getInstance().createSign(params, key);
		return sign.equals(params.get("sign"));
	}

	/**
	 * 发送裂变红包
	 * 
	 * 发放规则
	 * 裂变红包：一次可以发放一组红包。首先领取的用户为种子用户，种子用户领取一组红包当中的一个，并可以通过社交分享将剩下的红包给其他用户。裂变红包充分利用了人际传播的优势。
	 * 
	 * 
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public GroupRedPackRes sendGroupRedPack(GroupRedPackReq request) throws ParseException, IOException {
		String nonce_str = RandomUtil.random32Chars();
		request.setWxappid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("微信发放裂变红包:" + WxRedPackConstantData.sendGroupRedPackUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxRedPackConstantData.sendGroupRedPackUrl, xml);
		logger.info("微信发放裂变红包返回结果:" + resp);
		GroupRedPackRes result = XmlUtil.toOject(resp, GroupRedPackRes.class);
		checkResult(result);
		return result;
	}

	/**
	 * 查询红包记录 使用说明 用于商户对已发放的红包进行查询红包的具体信息，可支持普通红包和裂变包。
	 * 
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public SearchRes searchRedPack(SearchReq request) throws ParseException, IOException {
		String nonce_str = RandomUtil.random32Chars();
		request.setAppid(appid);
		request.setMch_id(mchId);
		request.setNonce_str(nonce_str);
		Map<String, String> params = BeanUtils.xmlBean2Map(request);
		String sign = SignUtil.getInstance().createSign(params, key);
		request.setSign(sign);
		String xml = request.toXML();
		logger.info("查询红包记录 :" + WxRedPackConstantData.searchRedPackUrl + ",内容:" + xml);
		String resp = CertRequestUrl.getInstance().executeWithKey(WxRedPackConstantData.searchRedPackUrl, xml);
		logger.info("查询红包记录 返回结果:" + resp);
		SearchRes result = XmlUtil.toOject(resp, SearchRes.class);
		checkResult(result);
		return result;
	}

}
