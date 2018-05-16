package com.simba.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.annotation.TimeAnnotation;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Activity;
import com.simba.service.ActivityService;

/**
 * 活动控制器
 * 
 * @author lilei
 * 
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	private static final Log logger=LogFactory.getLog(ActivityController.class);

	@RequestMapping("/list")
	public String list() {
		return "activity/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<Activity> list = activityService.page(pager);
		model.put("list", list);
		return "activity/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = activityService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "activity/add";
	}

	@TimeAnnotation
	@RequestMapping("/add")
	public String add(Activity activity ,HttpServletRequest request, HttpServletResponse response) throws ParseException{
		logger.info("id-----"+request.getSession().getAttribute("sessUser"));
		activity.setOwnerID(request.getSession().getAttribute("userId")+"");
		activityService.add(activity);
		return "redirect:/activity/list";
	}
	
	@TimeAnnotation
	@ResponseBody
	@RequestMapping("/isExistedActivityID")
	public JsonResult isExistedActivityID(String activityID ){
		if(activityService.isExistedActivityID(activityID)){
			return new JsonResult("此编号已经重复",400);
		}
		return new JsonResult("",200);
		
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		Activity activity = activityService.get(id);
		model.put("activity", activity);
		return "activity/update";
	}

	@RequestMapping("/update")
	public String update(Activity activity,HttpServletRequest request, HttpServletResponse response) throws ParseException {
		logger.info("id-----"+request.getSession().getAttribute("sessUser"));
		activity.setOwnerID(request.getSession().getAttribute("userId").toString());
		activityService.update(activity);
		return "redirect:/activity/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		activityService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		activityService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
