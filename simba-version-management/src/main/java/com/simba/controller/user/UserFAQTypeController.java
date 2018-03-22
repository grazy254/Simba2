package com.simba.controller.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.FAQType;
import com.simba.service.FAQTypeService;

/**
 * 常见问题类型管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/user/fAQType")
public class UserFAQTypeController {

	@Autowired
	private FAQTypeService fAQTypeService;

	@ResponseBody
	@RequestMapping("/list")
	public List<FAQType> list() {
		List<FAQType> list = fAQTypeService.listAll();
		return list;
	}

	/**
	 * 新增常见问题类型管理
	 * 
	 * @param fAQType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(FAQType fAQType) {
		fAQTypeService.add(fAQType);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(FAQType fAQType) {
		fAQTypeService.update(fAQType);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		fAQTypeService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		fAQTypeService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
