package com.simba.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.enums.PayBillType;
import com.simba.controller.form.PayBillSearchForm;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.PayBill;
import com.simba.model.pay.refund.RefundReq;
import com.simba.service.PayBillService;
import com.simba.service.PayService;

/**
 * 支付账单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/payBill")
public class PayBillController {

	private static final Log logger = LogFactory.getLog(PayBillController.class);

	@Value("${wx.pay.domain}")
	private String wxPayDomain;

	@Autowired
	private PayBillService payBillService;

	@Autowired
	private PayService payService;

	@RequestMapping("/close")
	@ResponseBody
	public JsonResult close(long id) {
		PayBill bill = payBillService.get(id);
		logger.info("接收到微信关闭请求" + bill.toString());
		payService.closeOrder(bill.getOutTradeNo());
		return new JsonResult();
	}

	@RequestMapping("/refund")
	@ResponseBody
	public JsonResult refund(long id) throws ParseException, IOException {
		PayBill bill = payBillService.get(id);
		logger.info("接收到微信退款请求" + bill.toString());
		RefundReq refundReq = new RefundReq();
		refundReq.setDevice_info(bill.getDeviceInfo());
		refundReq.setOp_user_id(StringUtils.EMPTY);
		refundReq.setOut_refund_no(RandomUtil.random32Chars());
		refundReq.setOut_trade_no(bill.getOutTradeNo());
		refundReq.setRefund_account("REFUND_SOURCE_UNSETTLED_FUNDS");
		refundReq.setTransaction_id(StringUtils.EMPTY);
		refundReq.setNotify_url(wxPayDomain + "/payCallback/refundReceive");
		refundReq.setTotal_fee(bill.getFee());
		refundReq.setRefund_fee(bill.getFee());
		refundReq.setRefund_desc("商家退款");
		payService.refund(refundReq);
		return new JsonResult();
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("payBill", PayBillType.maps);
		return "payBill/list";
	}

	@RequestMapping("/getList")
	public String getList(PayBillSearchForm searchForm, Pager pager, ModelMap model) {
		List<PayBill> list = payBillService.page(searchForm, pager);
		model.put("list", list);
		return "payBill/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(PayBillSearchForm searchForm) {
		Long count = payBillService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "payBill/add";
	}

	@RequestMapping("/add")
	public String add(PayBill payBill) {
		payBillService.add(payBill);
		return "redirect:/payBill/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		PayBill payBill = payBillService.get(id);
		model.put("payBill", payBill);
		return "payBill/update";
	}

	@RequestMapping("/update")
	public String update(PayBill payBill) {
		payBillService.update(payBill);
		return "redirect:/payBill/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		payBillService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		payBillService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
