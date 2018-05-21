package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 云凤蝶站点页面预览数据模型
 *
 * @author auto create
 * @since 1.0, 2018-02-02 11:00:03
 */
public class FengdiePreviewPagesModel extends AlipayObject {

	private static final long serialVersionUID = 6399273516338872981L;

	/**
	 * 站点页面别名
	 */
	@ApiField("alias")
	private String alias;

	/**
	 * 页面预览地址
	 */
	@ApiField("url")
	private String url;

	public String getAlias() {
		return this.alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
