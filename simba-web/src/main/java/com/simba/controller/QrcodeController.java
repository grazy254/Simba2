package com.simba.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.WriterException;
import com.simba.framework.util.code.QrcodeUtil;

/**
 * 二维码Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/qrcode")
public class QrcodeController {

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
	@RequestMapping("/download")
	public void download(String qrcode, Integer width, Integer height, HttpServletResponse response) throws IOException, WriterException {
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
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

	/**
	 * 解析图片文件中的二维码
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/read")
	public String read(MultipartFile file) throws IOException {
		return QrcodeUtil.read(file.getInputStream());
	}

}
