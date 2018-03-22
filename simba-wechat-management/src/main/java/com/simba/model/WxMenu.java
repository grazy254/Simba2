package com.simba.model;

import com.simba.annotation.DescAnnotation;

/**
 * 微信菜单
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "微信菜单")
public class WxMenu {

	/**
	 * 主键自增ID
	 */
	private int id;

	/**
	 * 菜单名
	 */
	@DescAnnotation(desc = "菜单名")
	private String text;

	/**
	 * 父菜单ID
	 */
	private int parentID;

	/**
	 * 排序号，小的放在前面
	 */
	@DescAnnotation(desc = "排序号")
	private int orderNo;

	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节,click等点击类型必须
	 */
	@DescAnnotation(desc = "菜单KEY值")
	private String menuKey;

	/**
	 * 网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。view、miniprogram类型必须
	 */
	@DescAnnotation(desc = "菜单URL地址")
	private String url;

	/**
	 * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型,对应MenuType枚举类型
	 */
	@DescAnnotation(desc = "类型")
	private String type;

	/**
	 * 调用新增永久素材接口返回的合法media_id,media_id类型和view_limited类型必须
	 */
	@DescAnnotation(desc = "素材ID")
	private String mediaId;

	/**
	 * 小程序的appid（仅认证公众号可配置）,miniprogram类型必须
	 */
	@DescAnnotation(desc = "小程序的appid")
	private String appid;

	/**
	 * 小程序的页面路径,miniprogram类型必须
	 */
	@DescAnnotation(desc = "小程序的页面路径")
	private String pagepath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WxMenu [id=");
		builder.append(id);
		builder.append(", text=");
		builder.append(text);
		builder.append(", parentID=");
		builder.append(parentID);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", menuKey=");
		builder.append(menuKey);
		builder.append(", url=");
		builder.append(url);
		builder.append(", type=");
		builder.append(type);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", appid=");
		builder.append(appid);
		builder.append(", pagepath=");
		builder.append(pagepath);
		builder.append("]");
		return builder.toString();
	}

}
