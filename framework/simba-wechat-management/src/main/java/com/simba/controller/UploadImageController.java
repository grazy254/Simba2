package com.simba.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.file.FileUtils;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.UploadImage;
import com.simba.model.form.UploadImageSearchForm;
import com.simba.service.UploadImageService;

/**
 * 上传图片控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/uploadImage")
public class UploadImageController {

	@Autowired
	private UploadImageService uploadImageService;

	@RequestMapping("/list")
	public String list() {
		return "uploadImage/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, UploadImageSearchForm searchForm, ModelMap model) {
		List<UploadImage> list = uploadImageService.page(pager, searchForm);
		model.put("list", list);
		return "uploadImage/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(UploadImageSearchForm searchForm) {
		int count = uploadImageService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "uploadImage/add";
	}

	@RequestMapping("/add")
	public String add(UploadImage uploadImage, MultipartFile file) throws IOException, FastdfsException {
		check(uploadImage, file);
		uploadImageService.add(uploadImage, file);
		return "redirect:/uploadImage/list";
	}

	private void check(UploadImage uploadImage, MultipartFile file) {
		if (StringUtils.isEmpty(uploadImage.getName())) {
			throw new RuntimeException("名称不能为空");
		}
		if (file == null || file.getSize() == 0) {
			throw new RuntimeException("文件不能为空");
		}
		String fileName = file.getOriginalFilename();
		String extName = FileUtils.getFileExt(fileName);
		long size = file.getSize();
		if ((!"jpg".equalsIgnoreCase(extName) && !"png".equalsIgnoreCase(extName)) || size > 1024 * 1024) {
			throw new RuntimeException("图片仅支持jpg/png格式，大小必须在1MB以下");
		}
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		UploadImage uploadImage = uploadImageService.get(id);
		model.put("uploadImage", uploadImage);
		return "uploadImage/update";
	}

	@RequestMapping("/update")
	public String update(UploadImage uploadImage) {
		uploadImageService.update(uploadImage);
		return "redirect:/uploadImage/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) throws IOException, FastdfsException {
		uploadImageService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) throws IOException, FastdfsException {
		uploadImageService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
