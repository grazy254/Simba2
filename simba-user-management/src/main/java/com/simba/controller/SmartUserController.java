package com.simba.controller;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.model.ThirdSystemUser;
import com.simba.model.form.SmartUserSearchForm;
import com.simba.service.SmartUserService;
import com.simba.service.ThirdSystemUserService;

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
	

	@RequestMapping("/getList")
	public String getList(Pager pager, SmartUserSearchForm searchForm, ModelMap model) {
		List<SmartUser> list = smartUserService.page(pager, searchForm);
		
		list.forEach((smartuser) -> {
			List<String> tslist =getTS(smartuser.getId());
			String tsString="";
			for(int i=0;i<tslist.size();i++){
				tsString+=tslist.get(i)+",";
			}
			smartuser.setThirdSystem(tsString);
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
