package com.simba.gaode.model.fence;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 围栏设备监控请求参数对象
 * 
 * @author caozhejun
 *
 */
public class MonitorFenceParam {

	public MonitorFenceParam() {

	}

	public MonitorFenceParam(String diu, String locations) {
		this.diu = diu;
		this.locations = locations;
	}

	/**
	 * 
	 * 用户设备唯一标识符
	 * 
	 * 设备唯一标识符。Android为imei，iOS为idfv
	 */
	private String diu;

	/**
	 * 设备在开发者自有系统中的id
	 */
	private String uid;

	/**
	 * 设备位置坐标组
	 * 
	 * 包含坐标数据和坐标产生的时间戳数据。 判定依据：最新的点 作为当前，然后从距离当前点10s～一小时 范围内选出最早点
	 * 
	 * 格式: x1,y1,unix_ts;x2,y2,unix_ts
	 * 
	 * 必填。至少包含设备的一个坐标以及时间戳。当有多个坐标以及时间戳，可判断与围栏的进/出状态。
	 */
	private String locations;

	public String getDiu() {
		return diu;
	}

	public void setDiu(String diu) {
		this.diu = diu;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MonitorFenceParam [diu=");
		builder.append(diu);
		builder.append(", uid=");
		builder.append(uid);
		builder.append(", locations=");
		builder.append(locations);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(locations)) {
			builder.append("&locations=" + URLEncoder.encode(locations, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(uid)) {
			builder.append("&uid=" + uid);
		}
		if (StringUtils.isNotEmpty(diu)) {
			builder.append("&diu=" + diu);
		}
		return builder.toString();
	}
}
