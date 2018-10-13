package com.simba.gaode.model.polygon;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 多边形搜索请求参数对象
 * 
 * @author caozhejun
 *
 */
public class PolygonParam {

	public PolygonParam() {

	}

	public PolygonParam(String polygon) {
		this.polygon = polygon;
	}

	/**
	 * 经纬度坐标对 规则：经度和纬度用","分割，经度在前，纬度在后，坐标对用"|"分割。经纬度小数点后不得超过6位。
	 * 多边形为矩形时，可传入左上右下两顶点坐标对；其他情况下首尾坐标对需相同。
	 */
	private String polygon;

	/**
	 * 查询关键字 规则： 多个关键字用“|”分割
	 */
	private String keywords;

	/**
	 * 查询POI类型 多个类型用“|”分割； 可选值：分类代码 或 汉字 （若用汉字，请严格按照附件之中的汉字填写）
	 * 分类代码由六位数字组成，一共分为三个部分，前两个数字代表大类；中间两个数字代表中类；最后两个数字代表小类。
	 * 若指定了某个大类，则所属的中类、小类都会被显示。 例如：010000为汽车服务（大类） 010100为加油站（中类） 010101为中国石化（小类）
	 * 010900为汽车租赁（中类） 010901为汽车租赁还车（小类） 当指定010000，则010100等中类、010101等小类都会被包含。
	 * 当指定010900，则010901等小类都会被包含 下载POI分类编码和城市编码表
	 * 
	 * 当keywords和types为空的时候， 我们会默认指定types为120000（商务住宅）&150000（交通设施服务）
	 */
	private String types;

	/**
	 * 每页记录数据 强烈建议不超过25，若超过25可能造成访问报错
	 */
	private String offset;

	/**
	 * 当前页数 最大翻页数100
	 */
	private String page;

	/**
	 * 此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息。
	 */
	private String extensions;

	public String getPolygon() {
		return polygon;
	}

	public void setPolygon(String polygon) {
		this.polygon = polygon;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PolygonParam [polygon=");
		builder.append(polygon);
		builder.append(", keywords=");
		builder.append(keywords);
		builder.append(", types=");
		builder.append(types);
		builder.append(", offset=");
		builder.append(offset);
		builder.append(", page=");
		builder.append(page);
		builder.append(", extensions=");
		builder.append(extensions);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(polygon)) {
			builder.append("&polygon=" + URLEncoder.encode(polygon, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(keywords)) {
			builder.append("&keywords=" + URLEncoder.encode(keywords, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(types)) {
			builder.append("&types=" + types);
		}
		if (StringUtils.isNotEmpty(page)) {
			builder.append("&page=" + page);
		}
		if (StringUtils.isNotEmpty(offset)) {
			builder.append("&offset=" + offset);
		}
		if (StringUtils.isNotEmpty(extensions)) {
			builder.append("&extensions=" + extensions);
		}
		return builder.toString();
	}
}
