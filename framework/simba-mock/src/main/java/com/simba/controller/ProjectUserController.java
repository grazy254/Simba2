package com.simba.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.ProjectUser;
import com.simba.permission.model.User;
import com.simba.permission.service.UserService;
import com.simba.service.ProjectUserService;

/**
 * 控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/projectUser")
public class ProjectUserController {

	@Autowired
	private ProjectUserService projectUserService;

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list() {
		return "projectUser/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<ProjectUser> list = projectUserService.page(pager);
		model.put("list", list);
		return "projectUser/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		int count = projectUserService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "projectUser/add";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, ProjectUser projectUser) {
		projectUserService.add(projectUser);
		return "redirect:/projectUser/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		ProjectUser projectUser = projectUserService.get(id);
		model.put("projectUser", projectUser);
		return "projectUser/update";
	}

	@RequestMapping("/update")
	public String update(ProjectUser projectUser) {
		projectUserService.update(projectUser);
		return "redirect:/projectUser/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		projectUserService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		projectUserService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@RequestMapping("/userBackList")
	public String listBackUser() {
		return "projectUserExt/userList";
	}

	@RequestMapping("/userList")
	public String listUser(Integer projectId, HttpServletRequest request) {
		request.getSession().setAttribute("projectId", projectId);
		return "projectUserExt/userList";
	}

	/**
	 * @description 获取某个项目对应的开发者人数
	 * @param projectId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/countUser")
	public JsonResult countUser(Integer projectId) {
		int count = projectUserService.countUser(projectId);
		return new JsonResult(count, "", 200);
	}

	/**
	 * @description 获取某个projectId对应的开发人员列表
	 * @param request
	 * @param pager
	 * @param projectId
	 * @param model
	 * @return
	 */
	@RequestMapping("/getUserList")
	public String getListUser(Pager pager, Integer projectId, ModelMap model) {
		List<User> userlist = projectUserService.pageByProjectId("projectId", projectId, pager);
		model.put("userList", userlist);
		return "projectUserExt/userTable";
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "projectUserExt/addUser";
	}

	@ResponseBody
	@RequestMapping("/batchDeleteUser")
	public JsonResult batchDeleteUser(String[] accountList, Integer projectId, ModelMap model) {
		projectUserService.batchDeleteUser(Arrays.asList(accountList), projectId);
		return new JsonResult();
	}

	/**
	 * @description 根据projectId和account获取对应的type
	 * @param account
	 * @param projectId
	 * @return type值
	 */
	@ResponseBody
	@RequestMapping("/getUserType")
	public JsonResult getUserType(String account, Integer projectId) {
		JsonResult jsonResult = new JsonResult();
		Integer typeValue = projectUserService.getUserType(account, projectId);
		jsonResult.setData(typeValue);
		return jsonResult;
	}

	/**
	 * @description 获取人员分配情况, 包括所有人员和已分配成员(这2个list都排除了sessAccount)
	 * @param session
	 * @param sessAccount
	 * @param projectId
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAssignUser")
	public String toAssignUser(HttpSession session, String sessAccount, Integer projectId, ModelMap model) {
		session.setAttribute("projectId", projectId);
		List<User> userlistByProject = projectUserService.listByProjectId(projectId);
		/* 将sessAccount从list中去除 */
		Iterator<User> iteratorList = userlistByProject.iterator();
		while (iteratorList.hasNext()) {
			User temp = iteratorList.next();
			if (temp.getAccount().equals(sessAccount)) {
				iteratorList.remove();
			}
		}
		List<User> userlistAll = userService.listAll();
		/* 将sessAccount从list中去除 */
		Iterator<User> iteratorList2 = userlistAll.iterator();
		while (iteratorList2.hasNext()) {
			User temp = iteratorList2.next();
			if (temp.getAccount().equals(sessAccount)) {
				iteratorList2.remove();
			}
		}
		model.put("userlistByProject", userlistByProject);
		model.put("userlistAll", userlistAll);
		model.put("account", sessAccount);
		return "projectUserExt/assignUser";
	}

	/**
	 * @description 人员分配 (sessAccount不会被删除也不会被分配)
	 * @param accountsChecked
	 * @param sessAccount
	 * @param projectId
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/assignUser")
	public JsonResult assignUser(String[] accountsChecked, String sessAccount, Integer projectId, ModelMap model) {
		if (accountsChecked == null) {
			throw new RuntimeException("没有选择分配的用户");
		}
		projectUserService.assignUsers(projectId, Arrays.asList(accountsChecked), sessAccount);
		return new JsonResult();
	}

}
