package com.simba.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.simba.CaptchaUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 验证码Controller
 * 
 * @author caozj
 *
 */
@Api(value = "验证码Controller", tags = "验证码Controller")
@Controller
@RequestMapping("/captcha")
public class CaptchaController {

	private static final int height = 30;

	private static final int width = 160;

	private static final int codeCount = 4;

	private static final char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9' };

	/**
	 * 获取验证码图片
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ApiOperation(value = "获取验证码图片", notes = "获取验证码图片")
	@GetMapping("/get")
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedImage buffImg = buildCaptcha(request);
		setResponse(response);
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
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
	 * 异步获取验证码图片
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "异步获取验证码图片", notes = "异步获取验证码图片")
	@GetMapping("/asyncGet")
	public StreamingResponseBody asyncGet(HttpServletRequest request) {
		return new StreamingResponseBody() {
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				BufferedImage buffImg = buildCaptcha(request);
				ImageIO.write(buffImg, "jpeg", outputStream);
			}

		};
	}

	private BufferedImage buildCaptcha(HttpServletRequest request) {
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.PLAIN, height - 2);
		// 设置字体。
		g.setFont(font);
		// 画边框。
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// 随机产生10条干扰线，使图象中的认证码不易被其它程序探测到。
		g.setColor(Color.BLACK);
		// 创建一个随机数生成器类
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuilder randomCode = new StringBuilder();
		int red = 0, green = 0, blue = 0;
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// 用随机产生的颜色将验证码绘制到图像中。
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * width / (codeCount + 1), height - 4);
			// 将产生的随机数组合在一起。
			randomCode.append(strRand);
		}
		CaptchaUtil.setCaptcha(request.getSession(), randomCode.toString());
		return buffImg;
	}

}
