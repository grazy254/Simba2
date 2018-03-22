package com.simba.controller.api;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.http.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.controller.form.BillDownloadForm;
import com.simba.controller.form.OrderForm;
import com.simba.controller.form.RefundForm;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.pay.downloadbill.DownloadBillReq;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.util.send.WxPayUtil;

/**
 * 微信支付api接口Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/wechatPayApi")
public class WechatPayApiController {

	//用户付款给用户所有提供的接口
	
	private WxPayUtil wxPayUtil;
	
	
	/**
	 * 统一下单 除被扫支付场景以外，商户系统先调用该接口在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识后再按扫码、JSAPI、
	 * APP等不同场景生成交易串调起支付
	 * @param orderForm
	 * @return
	 */
	@RequestMapping("/unifiedOrder")
	public JsonResult unifiedOrder(OrderForm orderForm){
		UnifiedOrderReq unifiedOrderReq=new UnifiedOrderReq();
		unifiedOrderReq.setAttach(orderForm.getAttach());
		unifiedOrderReq.setBody(orderForm.getBody());
		unifiedOrderReq.setDetail(orderForm.getDetail());
		unifiedOrderReq.setDevice_info(orderForm.getDevice_info());
		unifiedOrderReq.setFee_type(orderForm.getFee_type());
		unifiedOrderReq.setGoods_tag(orderForm.getGoods_tag());
		unifiedOrderReq.setLimit_pay(orderForm.getLimit_pay());
		unifiedOrderReq.setNotify_url(orderForm.getNotify_url());
		unifiedOrderReq.setOut_trade_no(orderForm.getOut_trade_no());
		unifiedOrderReq.setOpenid(orderForm.getOpenid());
		unifiedOrderReq.setProduct_id(orderForm.getProduct_id());
		unifiedOrderReq.setScene_info(orderForm.getScene_info());
		unifiedOrderReq.setSign_type(orderForm.getSign_type());
		unifiedOrderReq.setSpbill_create_ip(orderForm.getSpbill_create_ip());
		unifiedOrderReq.setTime_expire(orderForm.getTime_expire());
		unifiedOrderReq.setTime_start(orderForm.getTime_start());
		unifiedOrderReq.setTotal_fee(orderForm.getTotal_fee());
		unifiedOrderReq.setTrade_type(orderForm.getTrade_type());
		return new JsonResult(wxPayUtil.unifiedOrder(unifiedOrderReq),"",200);
	}
	
	/**
	 * 按照微信订单号查询订单
	 * @param transactionId
	 * @return
	 * @throws DOMException
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@RequestMapping("/queryOrderByTransactionId")
	public JsonResult queryOrderByTransactionId(String transactionId) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		return new JsonResult(wxPayUtil.queryOrderByTransactionId(transactionId),"",200);
	}
	
	/**
	 * 按照商户系统内部的订单号查询订单
	 * @param outTradeNo
	 * @return
	 * @throws DOMException
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@RequestMapping("/queryOrderByOutTradeNo")
	public JsonResult queryOrderByOutTradeNo(String outTradeNo) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		return new JsonResult(wxPayUtil.queryOrderByOutTradeNo(outTradeNo),"",200);
	}
	
	/**
	 * 关闭订单
	 * @param outTradeNo
	 * @return
	 */
	@RequestMapping("/closeOrder")
	public JsonResult closeOrder(String outTradeNo){
		return new JsonResult(wxPayUtil.closeOrder(outTradeNo),"",200);
	}
	/**
	 * 查询退款（微信订单号）
	 * @param transactionId
	 * @return
	 * @throws DOMException
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@RequestMapping("/refundQueryByTransactionId")
	public JsonResult refundQueryByTransactionId(String transactionId) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		return new JsonResult (wxPayUtil.refundQueryByTransactionId(transactionId));
	}
	/**
	 * 查询退款（商户系统内部的订单号）
	 * @param outTradeNo
	 * @return
	 * @throws DOMException
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@RequestMapping("/refundQueryByOutTradeNo")
	public JsonResult refundQueryByOutTradeNo(String outTradeNo) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		return new JsonResult (wxPayUtil.refundQueryByOutTradeNo(outTradeNo));
	}
	
	/**
	 * 查询退款（商户侧传给微信的退款单号）
	 * @param outRefundNo
	 * @return
	 * @throws DOMException
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@RequestMapping("/refundQueryByOutRefundNo")
	public JsonResult refundQueryByOutRefundNo(String outRefundNo) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		return new JsonResult (wxPayUtil.refundQueryByOutRefundNo(outRefundNo));
	}
	
	/**
	 * 查询退款（微信生成的退款单号）
	 * @param refundId
	 * @return
	 * @throws DOMException
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@RequestMapping("/refundQueryByRefundId")
	public JsonResult refundQueryByRefundId(String refundId) throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		return new JsonResult (wxPayUtil.refundQueryByRefundId(refundId));
	}
	
	/**下载对账单
	 * 
	 * @param billDownloadForm
	 * @return
	 */
	@RequestMapping("/downloadBill")
	public JsonResult downloadBill(BillDownloadForm billDownloadForm){
		DownloadBillReq downloadBillReq=new DownloadBillReq();
		downloadBillReq.setBill_date(billDownloadForm.getBill_date());
		downloadBillReq.setBill_type(billDownloadForm.getBill_type());
		downloadBillReq.setDevice_info(billDownloadForm.getDevice_info());
		downloadBillReq.setSign_type(billDownloadForm.getSign_type());
		downloadBillReq.setTar_type(billDownloadForm.getTar_type());
		
		return new JsonResult(wxPayUtil.downloadBill(downloadBillReq),"",200);
	}
	
	/**
	 * 申请退款
	 * @param refundForm
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/refund")
	public JsonResult refund(RefundForm refundForm) throws ParseException, IOException{
		RefundReq refundReq=new RefundReq();
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
		return new JsonResult(wxPayUtil.refund(refundReq),"",200);
	}
}
