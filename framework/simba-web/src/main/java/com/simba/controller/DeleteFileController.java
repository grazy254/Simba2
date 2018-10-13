package com.simba.controller;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.csource.common.FastdfsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.framework.util.upload.UploadUtil;

/**
 * 删除文件操作Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/file")
public class DeleteFileController {

	/**
	 * 删除文件
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws FastdfsException
	 */
	@PostMapping("/delete")
	public JsonResult delete(String fileName) throws IOException, FastdfsException {
		UploadUtil.getInstance().getUpload().delete(fileName);
		return new JsonResult();
	}

	/**
	 * 异步删除文件
	 * 
	 * @param fileName
	 * @return
	 */
	@PostMapping("/asyncDelete")
	public Callable<JsonResult> asyncDelete(String fileName) {
		Callable<JsonResult> callable = () -> {
			UploadUtil.getInstance().getUpload().delete(fileName);
			return new JsonResult();
		};
		return callable;
	}
}
