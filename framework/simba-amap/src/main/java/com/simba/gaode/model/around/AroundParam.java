package com.simba.gaode.model.around;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 周边搜索请求参数对象
 * 
 * @author caozhejun
 *
 */
public class AroundParam {

	public AroundParam() {

	}

	public AroundParam(String location) {
		this.location = location;
	}

	/**
	 * 中心点坐标 规则： 经度和纬度用","分割，经度在前，纬度在后，经纬度小数点后不得超过6位
	 */
	private String location;

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
	 * 当keywords和types均为空的时候，默认指定types为050000（餐饮服务）、070000（生活服务）、120000（商务住宅）
	 */
	private String types;

	/**
	 * 查询城市 可选值：城市中文、中文全拼、citycode、adcode 如：北京/beijing/010/110000
	 * 当用户指定的经纬度和city出现冲突，若范围内有用户指定city的数据，则返回相关数据，否则返回为空。
	 * 如：经纬度指定石家庄，而city却指定天津，若搜索范围内有天津的数据则返回相关数据，否则返回为空。
	 */
	private String city;

	/**
	 * 查询半径 取值范围:0-50000。规则：大于50000按默认值，单位：米
	 */
	private String radius;

	/**
	 * 排序规则 规定返回结果的排序规则。 按距离排序：distance；综合排序：weight
	 */
	private String sortrule;

	/**
	 * 每页记录数据 强烈建议不超过25，若超过25可能造成访问报错
	 */
	private String offset;

	/**
	 * 当前页数 最大翻页数100
	 */
	private String page;

	/**
	 * 返回结果控制 此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息。
	 */
	private String extensions;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getSortrule() {
		return sortrule;
	}

	public void setSortrule(String sortrule) {
		this.sortrule = sortrule;
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
		builder.append("AroundParam [location=");
		builder.append(location);
		builder.append(", keywords=");
		builder.append(keywords);
		builder.append(", types=");
		builder.append(types);
		builder.append(", city=");
		builder.append(city);
		builder.append(", radius=");
		builder.append(radius);
		builder.append(", sortrule=");
		builder.append(sortrule);
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
		if (StringUtils.isNotEmpty(keywords)) {
			builder.append("&keywords=" + URLEncoder.encode(keywords, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(city)) {
			builder.append("&city=" + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(sortrule)) {
			builder.append("&sortrule=" + sortrule);
		}
		if (StringUtils.isNotEmpty(location)) {
			builder.append("&location=" + location);
		}
		if (StringUtils.isNotEmpty(radius)) {
			builder.append("&radius=" + radius);
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
		if (StringUtils.isNotEmpty(types)) {
			builder.append("&types=" + types);
		}
		return builder.toString();
	}

}
