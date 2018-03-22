package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.enums.PayBillType;
import com.simba.controller.form.PayBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.PayBill;
import com.simba.service.PayBillService;

/**
 * 支付账单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/payBill")
public class PayBillController {

	@Autowired
	private PayBillService payBillService;

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
