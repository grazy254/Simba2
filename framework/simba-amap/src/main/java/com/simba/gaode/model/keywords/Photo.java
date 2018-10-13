package com.simba.gaode.model.keywords;

/**
 * 照片相关信息
 * 
 * @author caozhejun
 *
 */
public class Photo {

	/**
	 * 图片介绍
	 */
	private String titile;

	/**
	 * 具体链接
	 */
	private String url;

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Photo [titile=");
		builder.append(titile);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}

}
