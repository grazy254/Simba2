package com.simba.controller;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.csource.common.FastdfsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.NotFoundException;
import com.simba.framework.util.json.JsonResult;
import com.simba.framework.util.upload.UploadUtil;

/**
 * 上传文件的Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

	/**
	 * 上传文件，返回可以访问的url地址
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 * @throws FastdfsException
	 */
	@PostMapping("/upload")
	public JsonResult upload(MultipartFile file) throws IOException, NotFoundException, FastdfsException {
		String url = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename());
		return new JsonResult(url);
	}

	/**
	 * 异步上传文件，返回可以访问的url地址
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 */
	@PostMapping("/asyncUpload")
	public Callable<JsonResult> asyncUpload(MultipartFile file) throws IOException, NotFoundException {
		Callable<JsonResult> callable = () -> {
			String url = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename());
			return new JsonResult(url);
		};
		return callable;
	}

}
