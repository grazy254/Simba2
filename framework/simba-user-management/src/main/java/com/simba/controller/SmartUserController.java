package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.model.ThirdSystemUser;
import com.simba.model.UserGroup;
import com.simba.model.form.SmartUserSearchForm;
import com.simba.service.SmartGroupService;
import com.simba.service.SmartUserService;
import com.simba.service.ThirdSystemUserService;
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
	private ThirdSystemUserService thirdSystemUserService;
	
	@Autowired
	private UserGroupService userGroupService;
	
	@Autowired
	private SmartGroupService smartGroupService;
	

	@Autowired
	private static final Log logger = LogFactory.getLog(SmartUserController.class);
	
	@RequestMapping("/list")
	public String list() {
		return "smartUser/list";
	}
	
	private List<String> getTS(Long userId) {
		
		//用来存放获取到的数据
		List <String> list = new ArrayList<String>();
		List<ThirdSystemUser> tlist =thirdSystemUserService.listBy("userId",userId);
		if(tlist.size()==0){

		}else{
			for(int i=0;i<tlist.size();i++){
					
				list.add(tlist.get(i).getThirdSystem());
				list.add(tlist.get(i).getThirdSystemUserId());
			}	
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("/group")
	public JsonResult group(long groupId,long smartUserId){
		List<UserGroup> userGroupList =userGroupService.listByAnd("groupId",groupId ,"userId", smartUserId);
		if(userGroupList.size()>0){
			return new JsonResult(1,"已在此分组",400);
		}
		List<SmartUser> smartUserList=smartUserService.listBy("id", smartUserId);
		if(smartUserList.size()>0){
			UserGroup userGroup =new UserGroup();
			userGroup.setUserId(smartUserId);
			userGroup.setGroupId(groupId);
			userGroup.setCreateTime(new Date());
			userGroupService.add(userGroup);
			return new JsonResult("分组成功",200);
		}else{
			return new JsonResult(0,"此用户不存在",400);
		}
		
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, SmartUserSearchForm searchForm, ModelMap model) {
		List<SmartUser> list = smartUserService.page(pager, searchForm);
		list.forEach((smartuser) -> {
			String tsString="";
			smartuser.setThirdSystem(tsString);
			String group="";
			List <UserGroup> userGroupList =userGroupService.listBy("userId", smartuser.getId());
			for(int i =0 ;i<userGroupList.size();i++){
				group+=smartGroupService.get(userGroupList.get(i).getGroupId()).getName()+" ";
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