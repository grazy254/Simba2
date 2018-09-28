package com.simba.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.json.JsonResult;
import com.simba.model.Email;
import com.simba.service.EmailService;

/**
 * 邮件记录控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@ResponseBody
	@RequestMapping("/list")
	public List<Email> list() {
		List<Email> list = emailService.listAll();
		return list;
	}

	/**
	 * 新增邮件记录
	 * 
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(Email email) {
		emailService.add(email);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(Email email) {
		emailService.update(email);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		emailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		emailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
