package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@ResponseBody
	@RequestMapping("/list")
	public List<TradeDepartment> list() {
		List<TradeDepartment> list = tradeDepartmentService.listAll();
		return list;
	}

	/**
	 * 新增收款部门
	 * 
	 * @param tradeDepartment
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeDepartment tradeDepartment) {
		tradeDepartmentService.add(tradeDepartment);
		return new JsonResult("添加成功");
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeDepartment tradeDepartment) {
		tradeDepartmentService.update(tradeDepartment);
		return new JsonResult();
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
