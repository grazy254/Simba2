package com.simba.gaode.model.keywords;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 关键字搜索请求参数对象
 * 
 * @author caozhejun
 *
 */
public class KeyWordsParam {

	public KeyWordsParam() {

	}

	public KeyWordsParam(String keywords, String types) {
		this.keywords = keywords;
		this.types = types;
	}

	/**
	 * 查询关键字 规则： 多个关键字用“|”分割
	 * 若不指定city，并且搜索的为泛词（例如“美食”）的情况下，返回的内容为城市列表以及此城市内有多少结果符合要求。 必填
	 * (keywords和types两者至少必选其一)
	 */
	private String keywords;

	/**
	 * 查询POI类型 多个类型用“|”分割； 可选值：分类代码 或 汉字（若用汉字，请严格按照附件之中的汉字填写）
	 * 分类代码由六位数字组成，一共分为三个部分，前两个数字代表大类；中间两个数字代表中类；最后两个数字代表小类。
	 * 若指定了某个大类，则所属的中类、小类都会被显示。 例如：010000为汽车服务（大类） 010100为加油站（中类） 010101为中国石化（小类）
	 * 010900为汽车租赁（中类） 010901为汽车租赁还车（小类） 当指定010000，则010100等中类、010101等小类都会被包含。
	 * 当指定010900，则010901等小类都会被包含 下载POI分类编码和城市编码表
	 * 
	 * 若不指定city，返回的内容为城市列表以及此城市内有多少结果符合要求。
	 * 当您的keywords和types都是空时，默认指定types为120000（商务住宅）&150000（交通设施服务）
	 */
	private String types;

	/**
	 * 查询城市 可选值：城市中文、中文全拼、citycode、adcode 如：北京/beijing/010/110000
	 * 填入此参数后，会尽量优先返回此城市数据，但是不一定仅局限此城市结果，若仅需要某个城市数据请调用citylimit参数。
	 * 如：在深圳市搜天安门，返回北京天安门结果。
	 */
	private String city;

	/**
	 * 仅返回指定城市数据 可选值：true/false
	 */
	private String citylimit;

	/**
	 * 是否按照层级展示子POI数据 可选值：children=1 当为0的时候，子POI都会显示。 当为1的时候，子POI会归类到父POI之中。
	 * 
	 * 仅在extensions=all的时候生效
	 */
	private String children;

	/**
	 * 每页记录数据 强烈建议不超过25，若超过25可能造成访问报错
	 */
	private String offset;

	/**
	 * 当前页数 最大翻页数100
	 */
	private String page;

	/**
	 * 建筑物的POI编号 传入建筑物POI编号之后，则只在该建筑物之内进行搜索
	 */
	private String building;

	/**
	 * 搜索楼层 若传入 建筑物的POI编号 + 楼层 ，则返回该建筑物内当前楼层的关键字搜索结果 若只传入楼层，则返回参数不完全的提示 若传入建筑物的POI编号
	 * + 楼层，该楼层没有对应的搜索结果，则会返回建筑物之内的内容。
	 */
	private String floor;

	/**
	 * 此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息。
	 */
	private String extensions;

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

	public String getCitylimit() {
		return citylimit;
	}

	public void setCitylimit(String citylimit) {
		this.citylimit = citylimit;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
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

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
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
		builder.append("KeyWordsParam [keywords=");
		builder.append(keywords);
		builder.append(", types=");
		builder.append(types);
		builder.append(", city=");
		builder.append(city);
		builder.append(", citylimit=");
		builder.append(citylimit);
		builder.append(", children=");
		builder.append(children);
		builder.append(", offset=");
		builder.append(offset);
		builder.append(", page=");
		builder.append(page);
		builder.append(", building=");
		builder.append(building);
		builder.append(", floor=");
		builder.append(floor);
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
		if (StringUtils.isNotEmpty(types)) {
			builder.append("&types=" + URLEncoder.encode(types, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(city)) {
			builder.append("&city=" + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(citylimit)) {
			builder.append("&citylimit=" + citylimit);
		}
		if (StringUtils.isNotEmpty(children)) {
			builder.append("&children=" + children);
		}
		if (StringUtils.isNotEmpty(floor)) {
			builder.append("&floor=" + URLEncoder.encode(floor, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(building)) {
			builder.append("&building=" + URLEncoder.encode(building, ConstantData.DEFAULT_CHARSET));
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
