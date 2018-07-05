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
import com.simba.model.ApplicationUser;
import com.simba.service.ApplicationUserService;

/**
 * 用户应用表控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/applicationUser")
public class ApplicationUserController {

	@Autowired
	private ApplicationUserService applicationUserService;

	@RequestMapping("/list")
	public String list() {
		return "applicationUser/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<ApplicationUser> list = applicationUserService.page(pager);
		model.put("list", list);
		return "applicationUser/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = applicationUserService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "applicationUser/add";
	}

	@RequestMapping("/add")
	public String add(ApplicationUser applicationUser) {
		applicationUserService.add(applicationUser);
		return "redirect:/applicationUser/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		ApplicationUser applicationUser = applicationUserService.get(id);
		model.put("applicationUser", applicationUser);
		return "applicationUser/update";
	}

	@RequestMapping("/update")
	public String update(ApplicationUser applicationUser) {
		applicationUserService.update(applicationUser);
		return "redirect:/applicationUser/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		applicationUserService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		applicationUserService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
