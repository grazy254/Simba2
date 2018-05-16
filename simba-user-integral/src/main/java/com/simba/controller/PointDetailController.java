package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Activity;
import com.simba.model.PointDetail;
import com.simba.service.ActivityService;
import com.simba.service.PointDetailService;

/**
 * null控制器
 * 
 * @author lilei
 * 
 */
@Controller
@RequestMapping("/pointDetail")
public class PointDetailController {

	@Autowired
	private PointDetailService pointDetailService;
	
	@Autowired
	private ActivityService activityService;

	@RequestMapping("/list")
	public String list() {
		return "pointDetail/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<PointDetail> list = pointDetailService.page(pager);
		//通过activit查找出activityName
		for(int i =0;i<list.size();i++){
			List<Activity> activityList=new ArrayList<Activity>();
			activityList=activityService.listBy("activityID",list.get(i).getActivityID());
			if(activityList.size()>0){
				list.get(i).setActivityName(activityList.get(0).getName());
			}else{
				list.get(i).setActivityName("未知");
			}
		}
		model.put("list", list);
		return "pointDetail/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = pointDetailService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "pointDetail/add";
	}

	@RequestMapping("/add")
	public String add(PointDetail pointDetail) {
		pointDetailService.add(pointDetail);
		return "redirect:/pointDetail/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		PointDetail pointDetail = pointDetailService.get(id);
		model.put("pointDetail", pointDetail);
		return "pointDetail/update";
	}

	@RequestMapping("/update")
	public String update(PointDetail pointDetail) {
		pointDetailService.update(pointDetail);
		return "redirect:/pointDetail/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		pointDetailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		pointDetailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
