package com.simba.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.form.RefundForm;
import com.simba.framework.util.common.ServerUtil;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;
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
@Controller
@RequestMapping("/pay")
public class PayController {

	@Value("${appID}")
	private String appid;

	@Value("${wx.pay.mchid}")
	private String mchId;

	@Value("${wx.pay.domain}")
	private String wxPayDomain;

	@Value("${wx.pay.key}")
	private String key;

	@Autowired
	private PayService payService;

	/**
	 * 产生订单
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/order")
	public String order(HttpServletRequest request, UnifiedOrderReq req, ModelMap model) {
		req.setAppid(appid);
		req.setMch_id(mchId);
		req.setOut_trade_no(RandomUtil.random32Chars());
		req.setSpbill_create_ip(ServerUtil.getProxyIp(request));
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		req.setTime_start(format.format(now));
		if (StringUtils.isEmpty(req.getNotify_url())) {
			req.setNotify_url(wxPayDomain + "/payCallback/orderReceive");
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
		params.put("mwebUrl", mwebUrl);
		String json = FastJsonUtil.toJson(params);
		model.put("message", json);
		payService.dealOrder(req, prePayId, codeUrl, mwebUrl);
		return "message";
	}

	/**
	 * 关闭订单
	 * 
	 * @param outTradeNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/closeOrder")
	public JsonResult closeOrder(String outTradeNo) {
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
		RefundReq refundReq = new RefundReq();
		refundReq.setDevice_info(refundForm.getDevice_info());
		refundReq.setOp_user_id(refundForm.getOp_user_id());
		refundReq.setOut_refund_no(refundForm.getOut_refund_no());
		refundReq.setOut_trade_no(refundForm.getOut_trade_no());
		refundReq.setRefund_account(refundForm.getRefund_account());
		refundReq.setRefund_fee(refundForm.getRefund_fee());
		refundReq.setSign_type(refundForm.getSign_type());
		refundReq.setTotal_fee(refundForm.getTotal_fee());
		refundReq.setTransaction_id(refundForm.getTransaction_id());
		refundReq.setRefund_fee_type(refundForm.getRefund_fee_type());
		if (StringUtils.isEmpty(refundForm.getNotify_url())) {
			refundReq.setNotify_url(wxPayDomain + "/payCallback/refundReceive");
		}
		payService.refund(refundReq);
		return new JsonResult();
	}
}
