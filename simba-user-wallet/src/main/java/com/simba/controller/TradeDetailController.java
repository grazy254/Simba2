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
import com.simba.model.TradeDetail;
import com.simba.service.TradeDetailService;
import com.simba.model.form.TradeDetailSearchForm;
/**
 * 交易详情信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeDetail")
public class TradeDetailController {

	@Autowired
	private TradeDetailService tradeDetailService;

	@RequestMapping("/list")
	public String list() {
		return "tradeDetail/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<TradeDetail> list = tradeDetailService.page(pager);
		model.put("list", list);
		return "tradeDetail/table";
	}
	
	@RequestMapping("/doSearch")
	public String getList(Pager pager, TradeDetailSearchForm tradeDetailSearchForm, ModelMap model){
		List<TradeDetail> list = tradeDetailService.page(pager, tradeDetailSearchForm);
		model.put("list", list);
		return "tradeDetail/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(TradeDetailSearchForm tradeDetailSearchForm) {
		Long count = tradeDetailService.count(tradeDetailSearchForm);
		return new JsonResult(count, "", 200);
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "tradeDetail/add";
	}

	@RequestMapping("/add")
	public String add(TradeDetail tradeDetail) {
		tradeDetailService.add(tradeDetail);
		return "redirect:/tradeDetail/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		TradeDetail tradeDetail = tradeDetailService.get(id);
		model.put("tradeDetail", tradeDetail);
		return "tradeDetail/update";
	}

	@RequestMapping("/update")
	public String update(TradeDetail tradeDetail) {
		tradeDetailService.update(tradeDetail);
		return "redirect:/tradeDetail/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeDetailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeDetailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
