package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.enums.TradeStatus;
import com.simba.alipay.service.AliPayService;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.AliPayBill;
import com.simba.model.form.AliPayBillSearchForm;
import com.simba.service.AliPayBillService;

/**
 * 阿里支付账单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/aliPayBill")
public class AliPayBillController {

	@Autowired
	private AliPayBillService aliPayBillService;

	@Autowired
	private AliPayService aliPayService;

	@RequestMapping("/close")
	@ResponseBody
	public JsonResult close(long id) throws AlipayApiException {
		AliPayBill bill = aliPayBillService.get(id);
		AliPayCloseForm closeForm = new AliPayCloseForm();
		aliPayService.close(closeForm);
		return new JsonResult();
	}

	@RequestMapping("/cancel")
	@ResponseBody
	public JsonResult cancel(long id) {
		AliPayBill bill = aliPayBillService.get(id);
		AliPayCancelForm cancelForm = new AliPayCancelForm();
		return new JsonResult();
	}

	@RequestMapping("/refund")
	@ResponseBody
	public JsonResult refund(long id) {
		AliPayRefundForm refundForm = new AliPayRefundForm();
		AliPayBill bill = aliPayBillService.get(id);
		return new JsonResult();
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("statuses", TradeStatus.values());
		return "aliPayBill/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<AliPayBill> list = aliPayBillService.page(pager);
		setStatusDescription(list);
		model.put("list", list);
		return "aliPayBill/table";
	}

	private void setStatusDescription(List<AliPayBill> list) {
		list.forEach((bill) -> {
			bill.setStatus(TradeStatus.get(bill.getStatus()).getDescription() + "(" + bill.getStatus() + ")");
		});
	}

	@RequestMapping("/doSearch")
	public String getList(Pager pager, AliPayBillSearchForm aliPayBillSearchForm, ModelMap model) {
		List<AliPayBill> list = aliPayBillService.page(pager, aliPayBillSearchForm);
		setStatusDescription(list);
		model.put("list", list);
		return "aliPayBill/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(AliPayBillSearchForm aliPayBillSearchForm) {
		Long count = aliPayBillService.count(aliPayBillSearchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "aliPayBill/add";
	}

	@RequestMapping("/add")
	public String add(AliPayBill aliPayBill) {
		aliPayBillService.add(aliPayBill);
		return "redirect:/aliPayBill/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		AliPayBill aliPayBill = aliPayBillService.get(id);
		model.put("aliPayBill", aliPayBill);
		return "aliPayBill/update";
	}

	@RequestMapping("/update")
	public String update(AliPayBill aliPayBill) {
		aliPayBillService.update(aliPayBill);
		return "redirect:/aliPayBill/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		aliPayBillService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		aliPayBillService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
