package com.simba.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.model.UserGroup;
import com.simba.model.form.SmartUserSearchForm;
import com.simba.service.SmartGroupService;
import com.simba.service.SmartUserService;
import com.simba.service.UserGroupService;

/**
 * 用户控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/smartUser")
public class SmartUserController {

	@Autowired
	private SmartUserService smartUserService;

	@Autowired
	private UserGroupService userGroupService;

	@Autowired
	private SmartGroupService smartGroupService;

	@RequestMapping("/list")
	public String list() {
		return "smartUser/list";
	}

	@ResponseBody
	@RequestMapping("/group")
	public JsonResult group(long groupId, long smartUserId) {
		if (userGroupService.countByAnd("groupId", groupId, "userId", smartUserId) > 0) {
			return new JsonResult(1, "已在此分组", 400);
		}
		if (smartUserService.countBy("id", smartUserId) > 0) {
			UserGroup userGroup = new UserGroup();
			userGroup.setUserId(smartUserId);
			userGroup.setGroupId(groupId);
			userGroup.setCreateTime(new Date());
			userGroupService.add(userGroup);
			return new JsonResult("分组成功", 200);
		}
		return new JsonResult(0, "此用户不存在", 400);
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, SmartUserSearchForm searchForm, ModelMap model) {
		List<SmartUser> list = smartUserService.page(pager, searchForm);
		list.forEach((smartuser) -> {
			smartuser.setThirdSystem(StringUtils.EMPTY);
			String group = "";
			List<UserGroup> userGroupList = userGroupService.listBy("userId", smartuser.getId());
			for (int i = 0; i < userGroupList.size(); i++) {
				group += smartGroupService.get(userGroupList.get(i).getGroupId()).getName() + " ";
			}
			smartuser.setGroup(group);
		});
		model.put("list", list);
		return "smartUser/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(SmartUserSearchForm searchForm) {
		Long count = smartUserService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "smartUser/add";
	}

	@RequestMapping("/add")
	public String add(SmartUser smartUser) {
		smartUserService.add(smartUser);
		return "redirect:/smartUser/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		SmartUser smartUser = smartUserService.get(id);
		model.put("smartUser", smartUser);
		return "smartUser/update";
	}

	@RequestMapping("/update")
	public String update(SmartUser smartUser) {
		smartUserService.update(smartUser);
		return "redirect:/smartUser/list";
	}

	@RequestMapping("/updateNoPwdTime")
	public String updateNoPwdTime(SmartUser smartUser) {
		smartUserService.updateNoPwdTime(smartUser);
		return "redirect:/smartUser/list";
	}

	@RequestMapping("/resetPwd")
	public String resetPwd(long id) {
		smartUserService.resetPwd(id);
		return "redirect:/smartUser/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		smartUserService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		smartUserService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
