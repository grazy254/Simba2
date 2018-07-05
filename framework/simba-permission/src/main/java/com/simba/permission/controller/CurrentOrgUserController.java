package com.simba.permission.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simba.framework.util.collection.ListUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.constant.ConstantData;
import com.simba.permission.controller.vo.UserVo;
import com.simba.permission.model.User;
import com.simba.permission.model.UserExt;
import com.simba.permission.model.UserExtDesc;
import com.simba.permission.model.UserOrg;
import com.simba.permission.service.OrgService;
import com.simba.permission.service.UserOrgService;
import com.simba.permission.service.UserService;
import com.simba.util.SessionUtil;

/**
 * 获取当前登录用户所在的机构用户信息Controller
 * 
 * @author caozhejun
 *
 */
@Controller
@RequestMapping("/currentOrgUser")
public class CurrentOrgUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserOrgService userOrgService;

	@Autowired
	private OrgService orgService;

	@RequestMapping("/list")
	public String list(Integer sessOrgId, ModelMap model) {
		String orgName = "机构树";
		int orgID = ConstantData.TREE_ROOT_ID;
		if (sessOrgId != null && sessOrgId != ConstantData.TREE_ROOT_ID) {
			orgID = sessOrgId;
			orgName = orgService.get(orgID).getText();
		}
		Map<String, String> desc = UserExtDesc.getAllDesc();
		model.put("parentID", orgID);
		model.put("parentName", orgName);
		model.put("values", desc.values());
		return "currentOrgUser/listUser";
	}

	@RequestMapping("/getUserList")
	public String getUserList(int orgID, Pager pager, ModelMap model) {
		List<UserOrg> userOrgList = userOrgService.pageBy("orgID", orgID, pager);
		List<User> userList = new ArrayList<User>(userOrgList.size());
		List<UserVo> voList = new ArrayList<>(userOrgList.size());
		for (UserOrg userOrg : userOrgList) {
			User user = userService.get(userOrg.getUserAccount());
			userList.add(user);
		}
		userList.forEach((user) -> {
			UserVo vo = new UserVo();
			vo.setUser(user);
			vo.setUserExt(userService.getUserExt(user.getAccount()));
			voList.add(vo);
		});
		Map<String, String> desc = UserExtDesc.getAllDesc();
		List<Map<String, Object>> mapList = new ArrayList<>(userOrgList.size());
		voList.forEach((vo) -> {
			Map<String, Object> map = new HashMap<>();
			map.put("account", vo.getUser().getAccount());
			map.put("name", vo.getUser().getName());
			List<String> exts = new ArrayList<>();
			desc.keySet().forEach((String key) -> {
				exts.add(vo.getUserExt().getExtMap().get(key));
			});
			map.put("exts", exts);
			mapList.add(map);
		});
		model.put("list", mapList);
		return "currentOrgUser/userTable";
	}

	@RequestMapping("/toAdd")
	public String toAdd(Integer orgID, ModelMap model) {
		Map<String, String> desc = UserExtDesc.getAllDesc();
		List<Map<String, Object>> descs = new ArrayList<>(desc.size());
		desc.forEach((key, value) -> {
			Map<String, Object> m = new HashMap<>(2);
			m.put("key", key);
			m.put("name", value);
			m.put("required", key.endsWith("_r"));
			descs.add(m);
		});
		String orgName = null;
		if (orgID == ConstantData.TREE_ROOT_ID) {
			orgName = "机构树";
		} else {
			orgName = orgService.get(orgID).getText();
		}
		model.put("orgID", orgID);
		model.put("orgName", orgName);
		model.put("descs", descs);
		return "currentOrgUser/addUser";
	}

	@RequestMapping("/add")
	public String add(User user, Integer[] orgID, HttpServletRequest request, ModelMap model) {
		UserExt userExt = new UserExt();
		Map<String, String> extMap = new HashMap<>();
		userExt.setExtMap(extMap);
		userExt.setUserAccount(user.getAccount());
		Map<String, String> descMap = UserExtDesc.getAllDesc();
		descMap.keySet().forEach((key) -> {
			extMap.put(key, request.getParameter(key));
		});
		List<UserOrg> userOrgList = new ArrayList<UserOrg>();
		for (Integer org : orgID) {
			UserOrg userOrg = new UserOrg();
			userOrg.setOrgID(org);
			userOrg.setUserAccount(user.getAccount());
			userOrgList.add(userOrg);
		}
		userService.add(user, userExt, userOrgList);
		return "redirect:/currentOrgUser/list?orgID=" + orgID[0];
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String account, HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException {
		User loginUser = SessionUtil.getUser(request.getSession());
		User user = null;
		boolean self = true;
		if (StringUtils.isNotEmpty(account)) {
			account = URLDecoder.decode(account, ConstantData.DEFAULT_CHARSET);
			user = userService.get(account);
			if (!loginUser.getAccount().equals(account)) {
				self = false;
			}
		} else {
			user = loginUser;
		}
		UserExt userExt = userService.getUserExt(user.getAccount());
		Map<String, String> desc = UserExtDesc.getAllDesc();
		List<Map<String, Object>> descs = new ArrayList<>(desc.size());
		desc.forEach((key, value) -> {
			Map<String, Object> m = new HashMap<>(2);
			m.put("key", key);
			m.put("name", value);
			m.put("value", StringUtils.defaultString(userExt.getExtMap().get(key)));
			m.put("required", key.endsWith("_r"));
			descs.add(m);
		});
		List<UserOrg> userOrgList = userOrgService.listBy("userAccount", account);
		List<String> orgIDs = new ArrayList<>(userOrgList.size());
		List<String> orgNames = new ArrayList<>(userOrgList.size());
		userOrgList.forEach((userOrg) -> {
			orgIDs.add(userOrg.getOrgID() + "");
			String orgName = null;
			if (userOrg.getOrgID() == ConstantData.TREE_ROOT_ID) {
				orgName = "机构树";
			} else {
				orgName = orgService.get(userOrg.getOrgID()).getText();
			}
			orgNames.add(orgName);
		});
		model.put("descs", descs);
		model.put("self", self);
		model.put("user", user);
		model.put("orgID", ListUtil.join(orgIDs));
		model.put("orgName", ListUtil.join(orgNames));
		return "currentOrgUser/updateUser";
	}

	@RequestMapping("/update")
	public String update(User user, Integer[] orgID, HttpServletRequest request, ModelMap model) {
		UserExt userExt = new UserExt();
		Map<String, String> extMap = new HashMap<>();
		userExt.setExtMap(extMap);
		userExt.setUserAccount(user.getAccount());
		Map<String, String> descMap = UserExtDesc.getAllDesc();
		descMap.keySet().forEach((key) -> {
			extMap.put(key, request.getParameter(key));
		});
		List<UserOrg> userOrgList = new ArrayList<UserOrg>();
		for (Integer org : orgID) {
			UserOrg userOrg = new UserOrg();
			userOrg.setOrgID(org);
			userOrg.setUserAccount(user.getAccount());
			userOrgList.add(userOrg);
		}
		userService.update(user, userExt, userOrgList);
		return "redirect:/currentOrgUser/list?orgID=" + orgID[0];
	}

}
