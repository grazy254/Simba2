package com.simba.gaode.model.status;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 矩形区域交通态势请求参数对象
 * 
 * @author caozhejun
 *
 */
public class ReactangleStatusParam {

	public ReactangleStatusParam() {

	}

	public ReactangleStatusParam(String rectangle) {
		this.rectangle = rectangle;
	}

	/**
	 * 道路等级 指定道路等级，下面各值代表的含义： 1：高速（京藏高速） 2：城市快速路、国道(西三环、103国道) 3：高速辅路（G6辅路）
	 * 4：主要道路（长安街、三环辅路路） 5：一般道路（彩和坊路） 6：无名道路
	 */
	private String level;

	/**
	 * 返回结果控制 可选值：base,all
	 */
	private String extensions;

	/**
	 * 代表此为矩形区域查询 左下右上顶点坐标对。矩形对角线不能超过10公里 两个坐标对之间用”;”间隔 xy之间用”,”间隔 最后格式为
	 */
	private String rectangle;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getRectangle() {
		return rectangle;
	}

	public void setRectangle(String rectangle) {
		this.rectangle = rectangle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReactangleStatusParam [level=");
		builder.append(level);
		builder.append(", extensions=");
		builder.append(extensions);
		builder.append(", rectangle=");
		builder.append(rectangle);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(rectangle)) {
			builder.append("&rectangle=" + URLEncoder.encode(rectangle, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(level)) {
			builder.append("&level=" + level);
		}
		if (StringUtils.isNotEmpty(extensions)) {
			builder.append("&extensions=" + extensions);
		}
		return builder.toString();
	}
}
