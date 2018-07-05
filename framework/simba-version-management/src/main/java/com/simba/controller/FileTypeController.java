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
import com.simba.model.FileType;
import com.simba.service.FileTypeService;

/**
 * 文件类型管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/fileType")
public class FileTypeController {

	@Autowired
	private FileTypeService fileTypeService;

	@RequestMapping("/list")
	public String list() {
		return "fileType/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<FileType> list = fileTypeService.page(pager);
		model.put("list", list);
		return "fileType/table";
	}
	
	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		int count = fileTypeService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "fileType/add";
	}

	@RequestMapping("/add")
	public String add(FileType fileType) {
		fileTypeService.add(fileType);
		return "redirect:/fileType/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		FileType fileType = fileTypeService.get(id);
		model.put("fileType", fileType);
		return "fileType/update";
	}

	@RequestMapping("/update")
	public String update(FileType fileType) {
		fileTypeService.update(fileType);
		return "redirect:/fileType/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) {
		fileTypeService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		fileTypeService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	

}
