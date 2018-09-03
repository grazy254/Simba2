package com.simba.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.simba.framework.util.code.QrcodeUtil;
import com.simba.framework.util.json.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 二维码Controller
 * 
 * @author caozhejun
 *
 */
@Api(value = "二维码Controller", tags = "二维码Controller")
@RestController
@RequestMapping("/qrcode")
public class QrcodeController {

	private static final Log logger = LogFactory.getLog(QrcodeController.class);

	/**
	 * 异步下载二维码
	 * 
	 * @param qrcode
	 * @param width
	 * @param height
	 * @throws IOException
	 * @throws WriterException
	 */
	@ApiOperation(value = "异步下载二维码", notes = "异步下载二维码")
	@ApiImplicitParams({ @ApiImplicitParam(value = "二维码内容", name = "qrcode", dataType = "string", paramType = "query"),
			@ApiImplicitParam(value = "宽度", name = "width", dataType = "int", paramType = "query"), @ApiImplicitParam(value = "高度", name = "height", dataType = "int", paramType = "query") })
	@GetMapping("/asyncDownload")
	public StreamingResponseBody asyncDownload(String qrcode, Integer width, Integer height) throws IOException, WriterException {
		if (height == null || height <= 0) {
			height = QrcodeUtil.HEIGHT;
		}
		if (width == null || width <= 0) {
			width = QrcodeUtil.WIDTH;
		}
		final Integer qrcodeImageHeight = height;
		final Integer qrcodeImageWidth = width;
		return new StreamingResponseBody() {
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				try {
					QrcodeUtil.writeToStream(qrcode, qrcodeImageHeight, qrcodeImageWidth, outputStream);
				} catch (WriterException e) {
					logger.error("生成二维码发生异常", e);
				}
			}
		};
	}

	/**
	 * 下载二维码
	 * 
	 * @param qrcode
	 *            二维码
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param response
	 * @throws IOException
	 * @throws WriterException
	 */
	@ApiOperation(value = "下载二维码", notes = "下载二维码")
	@ApiImplicitParams({ @ApiImplicitParam(value = "二维码内容", name = "qrcode", dataType = "string", paramType = "query"),
			@ApiImplicitParam(value = "宽度", name = "width", dataType = "int", paramType = "query"), @ApiImplicitParam(value = "高度", name = "height", dataType = "int", paramType = "query") })
	@GetMapping("/download")
	public void download(String qrcode, Integer width, Integer height, HttpServletResponse response) throws IOException, WriterException {
		setResponse(response);
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = response.getOutputStream();
		if (height == null || height <= 0) {
			height = QrcodeUtil.HEIGHT;
		}
		if (width == null || width <= 0) {
			width = QrcodeUtil.WIDTH;
		}
		QrcodeUtil.writeToStream(qrcode, height, width, sos);
		sos.close();
	}

	private void setResponse(HttpServletResponse response) {
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
	}

	/**
	 * 解析图片文件中的二维码
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "解析图片文件中的二维码", notes = "解析图片文件中的二维码")
	@ApiImplicitParam(value = "二维码文件流", name = "file", dataType = "string", paramType = "body")
	@PostMapping("/read")
	public JsonResult read(MultipartFile file) throws IOException, NotFoundException {
		return new JsonResult(QrcodeUtil.read(file.getInputStream()));
	}

	/**
	 * 异步解析图片文件中的二维码
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 */
	@ApiOperation(value = "异步解析图片文件中的二维码", notes = "异步解析图片文件中的二维码")
	@ApiImplicitParam(value = "二维码文件流", name = "file", dataType = "string", paramType = "body")
	@PostMapping("/asyncRead")
	public Callable<JsonResult> asyncRead(MultipartFile file) throws IOException, NotFoundException {
		Callable<JsonResult> callable = () -> {
			return new JsonResult(QrcodeUtil.read(file.getInputStream()));
		};
		return callable;
	}

}
