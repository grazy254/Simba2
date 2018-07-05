package com.simba.controller.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.FAQ;
import com.simba.service.FAQService;

/**
 * 常见问题管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/user/fAQ")
public class UserFAQController {

	@Autowired
	private FAQService fAQService;

	@ResponseBody
	@RequestMapping("/list")
	public List<FAQ> list() {
		List<FAQ> list = fAQService.listAll();
		return list;
		
	}

	/**
	 * 新增常见问题管理
	 * 
	 * @param fAQ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(FAQ fAQ) {
		fAQService.add(fAQ);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(FAQ fAQ) {
		fAQService.update(fAQ);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		fAQService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		fAQService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
