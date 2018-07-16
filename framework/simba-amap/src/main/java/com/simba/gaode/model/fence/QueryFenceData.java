package com.simba.gaode.model.fence;

import java.util.List;

/**
 * 返回内容消息体
 * 
 * @author caozhejun
 *
 */
public class QueryFenceData {

	/**
	 * 当前页码
	 */
	private String page_no;

	/**
	 * 每页记录数
	 */
	private String page_size;

	/**
	 * 围栏列表
	 */
	private List<Fence> rs_list;

	/**
	 * 总记录数
	 */
	private String total_record;

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

	public List<Fence> getRs_list() {
		return rs_list;
	}

	public void setRs_list(List<Fence> rs_list) {
		this.rs_list = rs_list;
	}

	public String getTotal_record() {
		return total_record;
	}

	public void setTotal_record(String total_record) {
		this.total_record = total_record;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryFenceData [page_no=");
		builder.append(page_no);
		builder.append(", page_size=");
		builder.append(page_size);
		builder.append(", rs_list=");
		builder.append(rs_list);
		builder.append(", total_record=");
		builder.append(total_record);
		builder.append("]");
		return builder.toString();
	}

}
