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
import com.simba.model.TempMedia;
import com.simba.model.enums.MediaType;
import com.simba.model.form.TempMediaSearchForm;
import com.simba.service.TempMediaService;

/**
 * 临时素材控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tempMedia")
public class TempMediaController {

	@Autowired
	private TempMediaService tempMediaService;

	@ResponseBody
	@RequestMapping("/get")
	public JsonResult get(long id) {
		TempMedia tempMdia = tempMediaService.get(id);
		return new JsonResult(tempMdia);
	}

	/**
	 * 选择图片
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showImages")
	public String showImages() {
		return "tempMedia/showImages";
	}

	@RequestMapping("/getImageList")
	public String getImageList(Pager pager, TempMediaSearchForm searchForm, ModelMap model) {
		List<TempMedia> list = tempMediaService.page(pager, searchForm);
		model.put("list", list);
		return "tempMedia/imageTable";
	}

	@RequestMapping("/select")
	public String select(String type, String domId, ModelMap model) {
		model.put("type", type);
		model.put("domId", domId);
		return "tempMedia/select";
	}

	@RequestMapping("/getSelectList")
	public String getSelectList(Pager pager, TempMediaSearchForm searchForm, ModelMap model) {
		List<TempMedia> list = tempMediaService.page(pager, searchForm);
		model.put("list", list);
		return "tempMedia/selectTable";
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("types", MediaType.values());
		return "tempMedia/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, TempMediaSearchForm searchForm, ModelMap model) {
		List<TempMedia> list = tempMediaService.page(pager, searchForm);
		model.put("list", list);
		return "tempMedia/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(TempMediaSearchForm searchForm) {
		int count = tempMediaService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", MediaType.values());
		return "tempMedia/add";
	}

	@RequestMapping("/add")
	public String add(TempMedia tempMedia, MultipartFile file) throws IOException, FastdfsException {
		check(tempMedia, file);
		tempMediaService.add(tempMedia, file);
		return "redirect:/tempMedia/list";
	}

	private void check(TempMedia tempMedia, MultipartFile file) {
		if (StringUtils.isEmpty(tempMedia.getName())) {
			throw new RuntimeException("名称不能为空");
		}
		if (StringUtils.isEmpty(tempMedia.getType())) {
			throw new RuntimeException("类型不能为空");
		}
		if (file == null || file.getSize() == 0) {
			throw new RuntimeException("文件不能为空");
		}
		String type = tempMedia.getType();
		long size = file.getSize();
		String fileName = file.getOriginalFilename();
		String extFile = FileUtils.getFileExt(fileName);
		if (type.equalsIgnoreCase("image")) {
			if ((!extFile.equalsIgnoreCase("PNG") && !extFile.equalsIgnoreCase("JPEG") && !extFile.equalsIgnoreCase("JPG") && !extFile.equalsIgnoreCase("GIF")) || size > 2 * 1024 * 1024) {
				throw new RuntimeException("图片最大 2M,支持PNG\\JPEG\\JPG\\GIF格式");
			}
		} else if (type.equalsIgnoreCase("voice")) {
			if ((!extFile.equalsIgnoreCase("AMR") && !extFile.equalsIgnoreCase("MP3")) || size > 2 * 1024 * 1024) {
				throw new RuntimeException("语音最大2M,播放长度不超过60s,支持AMR\\MP3格式");
			}
		} else if (type.equalsIgnoreCase("video")) {
			if (!extFile.equalsIgnoreCase("MP4") || size > 10 * 1024 * 1024) {
				throw new RuntimeException("视频最大10MB，支持MP4格式");
			}
		} else if (type.equalsIgnoreCase("thumb")) {
			if (!extFile.equalsIgnoreCase("JPG") || size > 64 * 1024) {
				throw new RuntimeException("缩略图最大64KB，支持JPG格式");
			}
		} else {
			throw new RuntimeException("类型错误:" + type);
		}
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		TempMedia tempMedia = tempMediaService.get(id);
		model.put("tempMedia", tempMedia);
		return "tempMedia/update";
	}

	@RequestMapping("/update")
	public String update(TempMedia tempMedia) {
		tempMediaService.update(tempMedia);
		return "redirect:/tempMedia/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tempMediaService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tempMediaService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
