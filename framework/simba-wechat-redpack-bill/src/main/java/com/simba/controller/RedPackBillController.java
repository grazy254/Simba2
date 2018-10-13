package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.enums.RedPackBillStatus;
import com.simba.controller.enums.RedPackType;
import com.simba.controller.enums.Scene;
import com.simba.controller.form.RedPackBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.RedPackBill;
import com.simba.service.RedPackBillService;

/**
 * 红包账单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/redPackBill")
public class RedPackBillController {

	@Autowired
	private RedPackBillService redPackBillService;

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("redPackBill", RedPackBillStatus.maps);
		model.put("types", RedPackType.values());
		model.put("scenes", Scene.values());
		return "redPackBill/list";

	}

	@RequestMapping("/getList")
	public String getList(RedPackBillSearchForm searchForm, Pager pager, ModelMap model) {
		List<RedPackBill> list = redPackBillService.page(searchForm, pager);
		model.put("list", list);
		return "redPackBill/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(RedPackBillSearchForm searchForm) {
		Long count = redPackBillService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", RedPackType.values());
		model.put("scenes", Scene.values());
		return "redPackBill/add";
	}

	@RequestMapping("/add")
	public String add(RedPackBill redPackBill) {
		redPackBillService.add(redPackBill);
		return "redirect:/redPackBill/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		RedPackBill redPackBill = redPackBillService.get(id);
		model.put("redPackBill", redPackBill);
		return "redPackBill/update";
	}

	@RequestMapping("/update")
	public String update(RedPackBill redPackBill) {
		redPackBillService.update(redPackBill);
		return "redirect:/redPackBill/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		redPackBillService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		redPackBillService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
