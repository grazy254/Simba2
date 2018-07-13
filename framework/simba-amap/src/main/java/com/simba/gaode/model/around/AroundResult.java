package com.simba.gaode.model.around;

import java.util.List;

import com.simba.gaode.model.area.Suggestion;
import com.simba.gaode.model.keywords.POI;

/**
 * 周边搜索响应对象
 * 
 * @author caozhejun
 *
 */
public class AroundResult {

	/**
	 * 返回状态 值为0或1
	 * 
	 * 1：成功；0：失败
	 */
	private String status;

	/**
	 * 返回的状态信息 status为0时，info返回错误原因；否则返回ok
	 */
	private String info;

	/**
	 * 返回结果总数目
	 */
	private String count;

	private String infocode;

	/**
	 * 建议结果列表
	 */
	private Suggestion suggestion;

	private List<POI> pois;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public List<POI> getPois() {
		return pois;
	}

	public void setPois(List<POI> pois) {
		this.pois = pois;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AroundResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", count=");
		builder.append(count);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", suggestion=");
		builder.append(suggestion);
		builder.append(", pois=");
		builder.append(pois);
		builder.append("]");
		return builder.toString();
	}

}
