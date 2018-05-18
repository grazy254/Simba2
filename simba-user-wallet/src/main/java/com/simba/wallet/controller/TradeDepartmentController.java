package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeDepartment;
import com.simba.wallet.service.TradeDepartmentService;

/**
 * 收款部门控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeDepartment")
public class TradeDepartmentController {

	@Autowired
	private TradeDepartmentService tradeDepartmentService;

	@RequestMapping("/list")
	public String list() {
		return "tradeDepartment/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<TradeDepartment> list = tradeDepartmentService.page(pager);
		model.put("list", list);
		return "tradeDepartment/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = tradeDepartmentService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "tradeDepartment/add";
	}

	@RequestMapping("/add")
	public String add(TradeDepartment tradeDepartment) {
		tradeDepartmentService.add(tradeDepartment);
		return "redirect:/tradeDepartment/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		TradeDepartment tradeDepartment = tradeDepartmentService.get(id);
		model.put("tradeDepartment", tradeDepartment);
		return "tradeDepartment/update";
	}

	@RequestMapping("/update")
	public String update(TradeDepartment tradeDepartment) {
		tradeDepartmentService.update(tradeDepartment);
		return "redirect:/tradeDepartment/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeDepartmentService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeDepartmentService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
