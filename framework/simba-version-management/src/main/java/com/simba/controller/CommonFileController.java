package com.simba.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.CommonFile;
import com.simba.model.FileType;
import com.simba.model.form.CommonFileSearchForm;
import com.simba.service.CommonFileService;
import com.simba.service.FileTypeService;

/**
 * 通用文件控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/commonFile")
public class CommonFileController {

	@Autowired
	private CommonFileService commonFileService;

	@Autowired
	private FileTypeService fileTypeService;

	@RequestMapping("/list")
	public String list(ModelMap model, Integer typeId) {
		String typeName = null;
		if (typeId != null && typeId > 0) {
			FileType fileType = fileTypeService.get(typeId);
			typeName = fileType.getName();
		}
		List<FileType> list = fileTypeService.listAll();
		model.put("typeId", typeId);
		model.put("typeName", typeName);
		model.put("list", list);
		return "commonFile/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, CommonFileSearchForm searchForm, ModelMap model) {
		List<CommonFile> list = commonFileService.page(pager, searchForm);
		list.forEach((commonFile) -> {
			commonFile.setType(getType(commonFile.getTypeId()));
		});
		model.put("list", list);
		return "commonFile/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(CommonFileSearchForm searchForm) {
		Integer count = commonFileService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(Integer typeId, ModelMap model) {
		List<FileType> list = fileTypeService.listAll();
		String typeName = null;
		if (typeId != null && typeId > 0) {
			FileType fileType = fileTypeService.get(typeId);
			typeName = fileType.getName();
		}
		model.put("typeName", typeName);
		model.put("list", list);
		model.put("typeId", typeId);
		return "commonFile/add";
	}

	@RequestMapping("/add")
	public String add(CommonFile commonFile, MultipartFile file) throws IOException, FastdfsException {
		commonFileService.add(commonFile, file);
		return "redirect:/commonFile/list?typeId=" + commonFile.getTypeId();
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		CommonFile commonFile = commonFileService.get(id);
		FileType fileType = fileTypeService.get(commonFile.getTypeId());
		String typeName = fileType.getName();
		model.put("typeName", typeName);
		model.put("commonFile", commonFile);
		return "commonFile/update";
	}

	@RequestMapping("/update")
	public String update(CommonFile commonFile, MultipartFile file) throws IOException, FastdfsException {
		commonFileService.update(commonFile, file);
		return "redirect:/commonFile/list?typeId=" + commonFile.getTypeId();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) throws IOException, FastdfsException {
		commonFileService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) throws IOException, FastdfsException {
		commonFileService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	private String getType(Integer id) {
		FileType f = fileTypeService.get(id);
		String type = f.getName();
		return type;
	}

}
