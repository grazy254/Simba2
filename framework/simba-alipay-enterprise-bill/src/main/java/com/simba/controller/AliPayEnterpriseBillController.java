package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.AliPayEnterpriseBill;
import com.simba.model.form.AliPayEnterpriseBillSearchForm;
import com.simba.service.AliPayEnterpriseBillService;

/**
 * 支付宝企业支付账单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/aliPayEnterpriseBill")
public class AliPayEnterpriseBillController {

	@Autowired
	private AliPayEnterpriseBillService aliPayEnterpriseBillService;

	@RequestMapping("/list")
	public String list() {
		return "aliPayEnterpriseBill/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<AliPayEnterpriseBill> list = aliPayEnterpriseBillService.page(pager);
		model.put("list", list);
		return "aliPayEnterpriseBill/table";
	}

	@RequestMapping("/doSearch")
	public String getList(Pager pager, AliPayEnterpriseBillSearchForm aliPayEnterpriseBillSearchForm, ModelMap model) {
		List<AliPayEnterpriseBill> list = aliPayEnterpriseBillService.page(pager, aliPayEnterpriseBillSearchForm);
		model.put("list", list);
		return "aliPayEnterpriseBill/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(AliPayEnterpriseBillSearchForm aliPayEnterpriseBillSearchForm) {
		Long count = aliPayEnterpriseBillService.count(aliPayEnterpriseBillSearchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "aliPayEnterpriseBill/add";
	}

	@RequestMapping("/add")
	public String add(AliPayEnterpriseBill aliPayEnterpriseBill, String sessAccount) throws AlipayApiException {
		aliPayEnterpriseBill.setCreateUser(sessAccount);
		aliPayEnterpriseBillService.add(aliPayEnterpriseBill);
		return "redirect:/aliPayEnterpriseBill/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		AliPayEnterpriseBill aliPayEnterpriseBill = aliPayEnterpriseBillService.get(id);
		model.put("aliPayEnterpriseBill", aliPayEnterpriseBill);
		return "aliPayEnterpriseBill/update";
	}

	@RequestMapping("/update")
	public String update(AliPayEnterpriseBill aliPayEnterpriseBill) {
		aliPayEnterpriseBillService.update(aliPayEnterpriseBill);
		return "redirect:/aliPayEnterpriseBill/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		aliPayEnterpriseBillService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		aliPayEnterpriseBillService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
