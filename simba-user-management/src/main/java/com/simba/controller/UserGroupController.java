package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.UserGroup;
import com.simba.service.SmartUserService;
import com.simba.service.UserGroupService;

import net.sf.json.JSONObject;
/**
 * 用户分组控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/userGroup")
public class UserGroupController {

	@Autowired
	private UserGroupService userGroupService;
	
	@Autowired
	private SmartUserService smartUserService;
	
	private static final Log logger = LogFactory.getLog(UserGroupService.class);
	

	@RequestMapping("/list")
	public String list() {
		return "userGroup/list";
	}
	
	@RequestMapping("/toGroupList")
	public String toGroupList(long smartUserId,ModelMap model) {
		logger.info("===="+smartUserId);
		model.put("smartUser", smartUserService.get(smartUserId));
		model.put("list", userGroupService.listAll());
		return "userGroup/toGroupList";
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
	public String add(UserGroup userGroup,HttpSession session) {
		
		JSONObject jo=JSONObject.fromObject(session.getAttribute("sessUser"));
		logger.info(jo);
		userGroup.setCreater(jo.getString("account"));
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
	public String update(UserGroup userGroup,HttpSession session) {
		JSONObject jo=JSONObject.fromObject(session.getAttribute("sessUser"));
		logger.info(jo);
		userGroup.setCreater(jo.getString("account"));
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
