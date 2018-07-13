package com.simba.gaode.model.staticmap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 静态地图请求参数对象
 * 
 * 
 * 注：如果有标注/标签/折线等覆盖物，则中心点（location）和地图级别（zoom）可选填。当请求中无location值时，地图区域以包含请求中所有的标注/标签/折线的几何中心为中心点；如请求中无zoom，地图区域以包含请求中所有的标注/标签/折线为准，系统计算出zoom值。
 * markers 格式：
 * markers=markersStyle1:location1;location2..|markersStyle2:location3;location4..|markersStyleN:locationN;locationM..
 * location为经纬度信息，经纬度之间使用","分隔，不同的点使用";"分隔。 markersStyle可以使用系统提供的样式，也可以使用自定义图片。
 * 系统marersStyle：label，font ,bold, fontSize，fontColor，background。 参数名称 说明 默认值
 * size 可选值： small,mid,large small color 选值范围：[0x000000, 0xffffff] 例如： 0x000000
 * black, 0x008000 green, 0x800080 purple, 0xFFFF00 yellow, 0x0000FF blue,
 * 0x808080 gray, 0xffa500 orange, 0xFF0000 red, 0xFFFFFF white 0xFC6054 label
 * [0-9]、[A-Z]、[单个中文字] 当size为small时，图片不展现标注名。 无 markers示例：
 * https://restapi.amap.com/v3/staticmap?markers=mid,0xFF0000,A:116.37359,39.92437;116.47359,39.92437&key=您的key
 * 自定义markersStyle： -1，url，0。 -1表示为自定义图片，URL为图片的网址。自定义图片只支持PNG格式。 markers示例
 * https://restapi.amap.com/v3/staticmap?markers=-1,http://ico.ooopic.com/ajax/iconpng/?id=158688.png,0:116.37359,39.92437&key=您的key
 * labels 格式：
 * labels=labelsStyle1:location1;location2..|labelsStyle2:location3;location4..|labelsStyleN:locationN;locationM..
 * location为经纬度信息，经纬度之间使用","分隔，不同的点使用";"分隔。 labelsStyle：label, font, bold,
 * fontSize, fontColor, background。 各参数使用","分隔，如有默认值则可为空。 参数名称 说明 默认值 content
 * 标签内容，字符最大数目为15 无 font 0：微软雅黑； 1：宋体； 2：Times New Roman; 3：Helvetica 0 bold
 * 0：非粗体； 1：粗体 0 fontSize 字体大小，可选值[1,72] 10 fontColor 字体颜色，取值范围：[0x000000,
 * 0xffffff] 0xFFFFFF background 背景色，取值范围：[0x000000, 0xffffff] 0x5288d8
 * labels示例：
 * https://restapi.amap.com/v3/staticmap?location=116.48482,39.94858&zoom=10&size=400*400&labels=朝阳公园,2,0,16,0xFFFFFF,0x008000:116.48482,39.94858&key=您的key
 * paths 格式：
 * paths=pathsStyle1:location1;location2..|pathsStyle2:location3;location4..|pathsStyleN:locationN;locationM..
 * location为经纬度，经纬度之间使用","分隔，不同的点使用";"分隔。 pathsStyle：weight, color,
 * transparency, fillcolor, fillTransparency。 参数名称 说明 默认值 weight 线条粗细。 可选值：
 * [2,15] 5 color 折线颜色。 选值范围：[0x000000, 0xffffff] 例如： 0x000000 black, 0x008000
 * green, 0x800080 purple, 0xFFFF00 yellow, 0x0000FF blue, 0x808080 gray,
 * 0xffa500 orange, 0xFF0000 red, 0xFFFFFF white 0x0000FF transparency 透明度。
 * 可选值[0,1]，小数后最多2位，0表示完全透明，1表示完全不透明。 1 fillcolor
 * 多边形的填充颜色，此值不为空时折线封闭成多边形。取值规则同color 无 fillTransparency 填充面透明度。
 * 可选值[0,1]，小数后最多2位，0表示完全透明，1表示完全不透明。 0.5 paths示例：
 * https://restapi.amap.com/v3/staticmap?zoom=15&size=500*500&paths=10,0x0000ff,1,,:116.31604,39.96491;116.320816,39.966606;116.321785,39.966827;116.32361,39.966957&key=您的key
 * 
 * @author caozhejun
 *
 */
public class StaticMapParam {

	/**
	 * 地图中心点 中心点坐标。 规则：经度和纬度用","分隔 经纬度小数点后不得超过6位。
	 */
	private String location;

	/**
	 * 地图级别 地图缩放级别:[1,17]
	 */
	private String zoom;

	/**
	 * 地图大小 图片宽度*图片高度。最大值为1024*1024
	 */
	private String size;

	/**
	 * 普通/高清 1:返回普通图； 2:调用高清图，图片高度和宽度都增加一倍，zoom也增加一倍（当zoom为最大值时，zoom不再改变）。
	 */
	private String scale;

	/**
	 * 标注 使用规则见markers详细说明，标注最大数10个
	 */
	private String markers;

	/**
	 * 标签 使用规则见labels详细说明，标签最大数10个
	 */
	private String labels;

	/**
	 * 折线 使用规则见paths详细说明，折线和多边形最大数4个
	 */
	private String paths;

	/**
	 * 交通路况标识 底图是否展现实时路况。 可选值： 0，不展现；1，展现。
	 */
	private String traffic;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getZoom() {
		return zoom;
	}

	public void setZoom(String zoom) {
		this.zoom = zoom;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getMarkers() {
		return markers;
	}

	public void setMarkers(String markers) {
		this.markers = markers;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getPaths() {
		return paths;
	}

	public void setPaths(String paths) {
		this.paths = paths;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StaticMapParam [location=");
		builder.append(location);
		builder.append(", zoom=");
		builder.append(zoom);
		builder.append(", size=");
		builder.append(size);
		builder.append(", scale=");
		builder.append(scale);
		builder.append(", markers=");
		builder.append(markers);
		builder.append(", labels=");
		builder.append(labels);
		builder.append(", paths=");
		builder.append(paths);
		builder.append(", traffic=");
		builder.append(traffic);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(markers)) {
			builder.append("&markers=" + URLEncoder.encode(markers, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(labels)) {
			builder.append("&labels=" + URLEncoder.encode(labels, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(paths)) {
			builder.append("&paths=" + URLEncoder.encode(paths, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(scale)) {
			builder.append("&scale=" + scale);
		}
		if (StringUtils.isNotEmpty(size)) {
			builder.append("&size=" + size);
		}
		if (StringUtils.isNotEmpty(zoom)) {
			builder.append("&zoom=" + zoom);
		}
		if (StringUtils.isNotEmpty(location)) {
			builder.append("&location=" + location);
		}
		if (StringUtils.isNotEmpty(traffic)) {
			builder.append("&traffic=" + traffic);
		}
		return builder.toString();
	}
}
