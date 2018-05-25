package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.AliPayBill;
import com.simba.service.AliPayBillService;
import com.simba.model.form.AliPayBillSearchForm;
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

	@RequestMapping("/list")
	public String list() {
		return "aliPayBill/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<AliPayBill> list = aliPayBillService.page(pager);
		model.put("list", list);
		return "aliPayBill/table";
	}
	
	@RequestMapping("/doSearch")
	public String getList(Pager pager, AliPayBillSearchForm aliPayBillSearchForm, ModelMap model){
		List<AliPayBill> list = aliPayBillService.page(pager, aliPayBillSearchForm);
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
