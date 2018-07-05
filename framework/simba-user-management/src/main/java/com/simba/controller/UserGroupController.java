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
import com.simba.model.UserGroup;
import com.simba.service.UserGroupService;

/**
 * 用户分组关联表控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/userGroup")
public class UserGroupController {

	@Autowired
	private UserGroupService userGroupService;

	@RequestMapping("/list")
	public String list() {
		return "userGroup/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<UserGroup> list = userGroupService.page(pager);
		model.put("list", list);
		return "userGroup/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = userGroupService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "userGroup/add";
	}

	@RequestMapping("/add")
	public String add(UserGroup userGroup) {
		userGroupService.add(userGroup);
		return "redirect:/userGroup/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		UserGroup userGroup = userGroupService.get(id);
		model.put("userGroup", userGroup);
		return "userGroup/update";
	}

	@RequestMapping("/update")
	public String update(UserGroup userGroup) {
		userGroupService.update(userGroup);
		return "redirect:/userGroup/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		userGroupService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		userGroupService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
