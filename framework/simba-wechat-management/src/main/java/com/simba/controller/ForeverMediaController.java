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
import com.simba.model.ForeverMedia;
import com.simba.model.enums.ForeverMediaType;
import com.simba.model.form.ForeverMediaSearchForm;
import com.simba.model.wx.media.MediaCount;
import com.simba.service.ForeverMediaService;
import com.simba.util.send.MediaWxUtil;

/**
 * 永久素材控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/foreverMedia")
public class ForeverMediaController {

	@Autowired
	private ForeverMediaService foreverMediaService;

	@Autowired
	private MediaWxUtil mediaWxUtil;

	/**
	 * 获取已经使用的永久素材数量
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/countWxMedia")
	public JsonResult countWxMedia() {
		MediaCount count = mediaWxUtil.count();
		return new JsonResult(count);
	}

	@RequestMapping("/select")
	public String select(String type, String domId, ModelMap model) {
		model.put("type", type);
		model.put("domId", domId);
		return "foreverMedia/select";
	}

	@RequestMapping("/getSelectList")
	public String getSelectList(Pager pager, ForeverMediaSearchForm searchForm, ModelMap model) {
		List<ForeverMedia> list = foreverMediaService.page(pager, searchForm);
		model.put("list", list);
		return "foreverMedia/selectTable";
	}

	/**
	 * 选择图片
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showImages")
	public String showImages() {
		return "foreverMedia/showImages";
	}

	@RequestMapping("/getImageList")
	public String getImageList(Pager pager, ForeverMediaSearchForm searchForm, ModelMap model) {
		List<ForeverMedia> list = foreverMediaService.page(pager, searchForm);
		model.put("list", list);
		return "foreverMedia/imageTable";
	}

	@ResponseBody
	@RequestMapping("/get")
	public JsonResult get(long id) {
		ForeverMedia foreverMedia = foreverMediaService.get(id);
		return new JsonResult(foreverMedia);
	}

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("types", ForeverMediaType.values());
		return "foreverMedia/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ForeverMediaSearchForm searchForm, ModelMap model) {
		List<ForeverMedia> list = foreverMediaService.page(pager, searchForm);
		model.put("list", list);
		return "foreverMedia/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(ForeverMediaSearchForm searchForm) {
		int count = foreverMediaService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd(ModelMap model) {
		model.put("types", ForeverMediaType.values());
		return "foreverMedia/add";
	}

	@RequestMapping("/add")
	public String add(ForeverMedia foreverMedia, MultipartFile file) throws IOException, FastdfsException {
		check(foreverMedia, file);
		foreverMediaService.add(foreverMedia, file);
		return "redirect:/foreverMedia/list";
	}

	private void check(ForeverMedia foreverMedia, MultipartFile file) {
		String type = foreverMedia.getType();
		if (StringUtils.isEmpty(type)) {
			throw new RuntimeException("类型不能为空");
		}
		if (!type.equals("news") && (file == null || file.getSize() == 0)) {
			throw new RuntimeException("文件不能为空");
		}
		if (type.equals("news")) {
			if (StringUtils.isEmpty(foreverMedia.getArticles())) {
				throw new RuntimeException("图文内容不能为空");
			}
		} else {
			String fileName = file.getOriginalFilename();
			long size = file.getSize();
			String extFile = FileUtils.getFileExt(fileName);
			if (type.equals("image")) {
				if ((!"bmp".equalsIgnoreCase(extFile) && !"png".equalsIgnoreCase(extFile) && !"jpeg".equalsIgnoreCase(extFile) && !"jpg".equalsIgnoreCase(extFile) && !"gif".equalsIgnoreCase(extFile))
						|| size > 2 * 1024 * 1024) {
					throw new RuntimeException("图片最大 2M，支持bmp/png/jpeg/jpg/gif格式");
				}
			} else if (type.equals("voice")) {
				if ((!"mp3".equalsIgnoreCase(extFile) && !"wma".equalsIgnoreCase(extFile) && !"wav".equalsIgnoreCase(extFile) && !"amr".equalsIgnoreCase(extFile)) || size > 2 * 1024 * 1024) {
					throw new RuntimeException("语音最大 2M，播放长度不超过60s，mp3/wma/wav/amr格式");
				}
			} else if (type.equals("video")) {
				if (!"MP4".equalsIgnoreCase(extFile) || size > 10 * 1024 * 1024) {
					throw new RuntimeException("视频最大 10MB，支持MP4格式");
				}
			} else if (type.equals("thumb")) {
				if (!"JPG".equalsIgnoreCase(extFile) || size > 64 * 1024) {
					throw new RuntimeException("缩略图最大64KB，支持JPG格式");
				}
			} else {
				throw new RuntimeException("类型错误:" + type);
			}
		}
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		ForeverMedia foreverMedia = foreverMediaService.get(id);
		model.put("foreverMedia", foreverMedia);
		return "foreverMedia/update";
	}

	@RequestMapping("/update")
	public String update(ForeverMedia foreverMedia) {
		foreverMediaService.update(foreverMedia);
		return "redirect:/foreverMedia/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) throws IOException, FastdfsException {
		foreverMediaService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) throws IOException, FastdfsException {
		foreverMediaService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
