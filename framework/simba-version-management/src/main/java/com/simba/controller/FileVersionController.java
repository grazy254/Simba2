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
import com.simba.model.FileType;
import com.simba.model.FileVersion;
import com.simba.service.FileTypeService;
import com.simba.service.FileVersionService;

/**
 * 文件版本管理控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/fileVersion")
public class FileVersionController {

	@Autowired
	private FileVersionService fileVersionService;

	@Autowired
	private FileTypeService fileTypeService;

	@RequestMapping("/list")
	public String list(ModelMap model, Integer typeId) {
		String typeName = null;
		if (typeId != null && typeId > 0) {
			FileType fileType = fileTypeService.get(typeId);
			typeName = fileType.getName();
		}
		model.put("typeId", typeId);
		model.put("typeName", typeName);
		return "fileVersion/list";
	}

	private String getType(Integer id) {
		FileType f = fileTypeService.get(id);
		String type = f.getName();
		return type;
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, Integer typeId, ModelMap model) {
		List<FileVersion> list = null;
		if (typeId != null && typeId > 0) {
			list = fileVersionService.pageBy("typeId", typeId, pager);
		} else {
			list = fileVersionService.page(pager);
		}
		list.forEach((fileversion) -> {
			fileversion.setType(getType(fileversion.getTypeId()));
		});
		model.put("list", list);
		return "fileVersion/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(Integer typeId) {
		int count = 0;
		if (typeId != null && typeId > 0) {
			count = fileVersionService.countBy("typeId", typeId);
		} else {
			count = fileVersionService.count();
		}
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
		return "fileVersion/add";
	}

	@RequestMapping("/add")
	public String add(FileVersion fileVersion, MultipartFile file) throws IOException, FastdfsException {
		fileVersionService.add(fileVersion, file);
		return "redirect:/fileVersion/list?typeId=" + fileVersion.getTypeId();
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, ModelMap model) {
		FileVersion fileVersion = fileVersionService.get(id);
		FileType fileType = fileTypeService.get(fileVersion.getTypeId());
		String typeName = fileType.getName();
		model.put("typeName", typeName);
		model.put("fileVersion", fileVersion);
		return "fileVersion/update";
	}

	@RequestMapping("/update")
	public String update(FileVersion fileVersion, MultipartFile file) throws IOException, FastdfsException {
		fileVersionService.update(fileVersion, file);
		return "redirect:/fileVersion/list?typeId=" + fileVersion.getTypeId();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Integer id, ModelMap model) throws IOException, FastdfsException {
		fileVersionService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) throws IOException, FastdfsException {
		fileVersionService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
