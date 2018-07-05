package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.enums.LooseMoneyBillStatus;
import com.simba.controller.form.LooseMoneyBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.LooseMoneyBill;
import com.simba.service.LooseMoneyBillService;

/**
 * 零钱账单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/looseMoneyBill")
public class LooseMoneyBillController {

	@Autowired
	private LooseMoneyBillService looseMoneyBillService;

	private  static final Log logger= LogFactory.getLog(LooseMoneyBillController.class);
	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("billTypeList",LooseMoneyBillStatus.maps);
		logger.info("-------billType------"+model);
		return "looseMoneyBill/list";
	}

	@RequestMapping("/getList")
	public String getList(LooseMoneyBillSearchForm searchForm, Pager pager, ModelMap model) {
		List<LooseMoneyBill> list = looseMoneyBillService.page(searchForm, pager);
		model.put("list", list);
		return "looseMoneyBill/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(LooseMoneyBillSearchForm searchForm) {
		Long count = looseMoneyBillService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "looseMoneyBill/add";
	}

	@RequestMapping("/add")
	public String add(LooseMoneyBill looseMoneyBill) {
		looseMoneyBillService.add(looseMoneyBill);
		return "redirect:/looseMoneyBill/list";
	}
 
	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		LooseMoneyBill looseMoneyBill = looseMoneyBillService.get(id);
		model.put("looseMoneyBill", looseMoneyBill);
		return "looseMoneyBill/update";
	}

	@RequestMapping("/update")
	public String update(LooseMoneyBill looseMoneyBill) {
		looseMoneyBillService.update(looseMoneyBill);
		return "redirect:/looseMoneyBill/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		looseMoneyBillService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		looseMoneyBillService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
