package com.simba.gaode.model.fence;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 查询围栏请求参数对象
 * 
 * @author caozhejun
 *
 */
public class QueryFenceParam {

	/**
	 * 围栏id
	 */
	private String id;

	/**
	 * 围栏全局id
	 */
	private String gid;

	/**
	 * 围栏名称
	 */
	private String name;

	/**
	 * 当前页码
	 */
	private String page_no;

	/**
	 * 每页数量
	 */
	private String page_size;

	/**
	 * 围栏激活状态
	 */
	private String enable;

	/**
	 * 按创建时间查询的起始时间
	 */
	private String start_time;

	/**
	 * 按创建时间查询的结束时间
	 */
	private String end_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPage_no() {
		return page_no;
	}

	public void setPage_no(String page_no) {
		this.page_no = page_no;
	}

	public String getPage_size() {
		return page_size;
	}

	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryFenceParam [id=");
		builder.append(id);
		builder.append(", gid=");
		builder.append(gid);
		builder.append(", name=");
		builder.append(name);
		builder.append(", page_no=");
		builder.append(page_no);
		builder.append(", page_size=");
		builder.append(page_size);
		builder.append(", enable=");
		builder.append(enable);
		builder.append(", start_time=");
		builder.append(start_time);
		builder.append(", end_time=");
		builder.append(end_time);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(id)) {
			builder.append("&id=" + id);
		}
		if (StringUtils.isNotEmpty(gid)) {
			builder.append("&gid=" + gid);
		}
		if (StringUtils.isNotEmpty(name)) {
			builder.append("&name=" + URLEncoder.encode(name, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(page_no)) {
			builder.append("&page_no=" + page_no);
		}
		if (StringUtils.isNotEmpty(page_size)) {
			builder.append("&page_size=" + page_size);
		}
		if (StringUtils.isNotEmpty(enable)) {
			builder.append("&enable=" + enable);
		}
		if (StringUtils.isNotEmpty(start_time)) {
			builder.append("&start_time=" + URLEncoder.encode(start_time, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(end_time)) {
			builder.append("&end_time=" + URLEncoder.encode(end_time, ConstantData.DEFAULT_CHARSET));
		}
		return builder.toString();
	}

}
