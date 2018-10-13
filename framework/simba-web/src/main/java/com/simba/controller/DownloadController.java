package com.simba.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.simba.framework.util.upload.UploadUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 下载文件Controller
 * 
 * @author caozhejun
 *
 */
@Api(value = "下载文件的通用Controller", tags = "下载文件的通用Controller")
@Controller
@RequestMapping("/download")
public class DownloadController {

	private static final Log logger = LogFactory.getLog(DownloadController.class);

	@Value("${files.dir}")
	private String fileDir;

	@Value("${files.storage}")
	private String fileStorge;

	/**
	 * 下载文件
	 * 
	 * @param fileName
	 *            下载的文件地址
	 * @param response
	 * @throws IOException
	 */
	@ApiOperation(value = "通用组件下载文件", notes = "下载文件")
	@ApiImplicitParam(value = "文件地址", name = "fileName", dataType = "string", paramType = "query")
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(String fileName, HttpServletResponse response) {
		OutputStream out = null;
		InputStream in = null;
		try {
			logger.info("下载文件:" + fileName);
			out = response.getOutputStream();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			in = UploadUtil.getInstance().getUpload().download(fileName);
			IOUtils.copy(in, out);
		} catch (Exception e) {
			logger.error("下载文件:[" + fileName + "]出现异常", e);
		} finally {
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
	}

	/**
	 * 异步下载文件
	 * 
	 * @param fileName
	 *            下载的文件地址
	 * @throws IOException
	 */
	@ApiOperation(value = "通用组件下载文件", notes = "异步下载文件")
	@ApiImplicitParam(value = "文件地址", name = "fileName", dataType = "string", paramType = "query")
	@RequestMapping(value = "/asyncDownload", method = RequestMethod.GET)
	public StreamingResponseBody asyncDownload(String fileName) {
		return new StreamingResponseBody() {
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				InputStream in = null;
				try {
					in = UploadUtil.getInstance().getUpload().download(fileName);
					IOUtils.copy(in, outputStream);
				} catch (FastdfsException e) {
					logger.error("下载文件发生异常", e);
				} finally {
					IOUtils.closeQuietly(in);
				}
			}
		};
	}
}
