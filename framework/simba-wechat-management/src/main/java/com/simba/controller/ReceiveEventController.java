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
import com.simba.model.ReceiveEvent;
import com.simba.model.form.ReceiveEventSearchForm;
import com.simba.service.ReceiveEventService;

/**
 * 收到事件控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/receiveEvent")
public class ReceiveEventController {

	@Autowired
	private ReceiveEventService receiveEventService;

	/**
	 * 查看完整的XML内容
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/showXML")
	public String showXML(long id, ModelMap model) {
		ReceiveEvent event = receiveEventService.get(id);
		model.put("event", event);
		return "receiveEvent/showXML";
	}
	
	@RequestMapping("/list")
	public String list() {
		return "receiveEvent/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager, ReceiveEventSearchForm searchForm, ModelMap model) {
		List<ReceiveEvent> list = receiveEventService.page(pager, searchForm);
		model.put("list", list);
		return "receiveEvent/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(ReceiveEventSearchForm searchForm) {
		long count = receiveEventService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "receiveEvent/add";
	}

	@RequestMapping("/add")
	public String add(ReceiveEvent receiveEvent) {
		receiveEventService.add(receiveEvent);
		return "redirect:/receiveEvent/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		ReceiveEvent receiveEvent = receiveEventService.get(id);
		model.put("receiveEvent", receiveEvent);
		return "receiveEvent/update";
	}

	@RequestMapping("/update")
	public String update(ReceiveEvent receiveEvent) {
		receiveEventService.update(receiveEvent);
		return "redirect:/receiveEvent/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		receiveEventService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		receiveEventService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
