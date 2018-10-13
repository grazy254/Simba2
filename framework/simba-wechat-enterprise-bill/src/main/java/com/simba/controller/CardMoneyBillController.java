package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.enums.Bank;
import com.simba.controller.enums.CardMoneyBillStatus;
import com.simba.controller.form.CardMoneyBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.CardMoneyBill;
import com.simba.service.CardMoneyBillService;

/**
 * 银行卡账单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/cardMoneyBill")
public class CardMoneyBillController {

	@Autowired
	private CardMoneyBillService cardMoneyBillService;

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("billType", CardMoneyBillStatus.maps);
		model.put("banks", Bank.values());
		return "cardMoneyBill/list";
	}

	@RequestMapping("/getList")
	public String getList(CardMoneyBillSearchForm searchForm, Pager pager, ModelMap model) {
		List<CardMoneyBill> list = cardMoneyBillService.page(searchForm, pager);
		list.forEach((CardMoneyBill bill) -> {
			String bank = bill.getBankCode();
			bill.setBankCode(Bank.get(bank).getName());
		});
		model.put("list", list);
		return "cardMoneyBill/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(CardMoneyBillSearchForm searchForm) {
		Long count = cardMoneyBillService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("banks", Bank.values());
		return "cardMoneyBill/add";
	}

	@RequestMapping("/add")
	public String add(CardMoneyBill cardMoneyBill) {
		cardMoneyBillService.add(cardMoneyBill);
		return "redirect:/cardMoneyBill/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		CardMoneyBill cardMoneyBill = cardMoneyBillService.get(id);
		model.put("cardMoneyBill", cardMoneyBill);
		return "cardMoneyBill/update";
	}

	@RequestMapping("/update")
	public String update(CardMoneyBill cardMoneyBill) {
		cardMoneyBillService.update(cardMoneyBill);
		return "redirect:/cardMoneyBill/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		cardMoneyBillService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		cardMoneyBillService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
