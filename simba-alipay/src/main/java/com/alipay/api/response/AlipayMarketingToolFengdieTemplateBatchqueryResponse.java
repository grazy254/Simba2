package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.domain.FengdieTemplateListRespModel;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.template.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2018-02-02 10:57:47
 */
public class AlipayMarketingToolFengdieTemplateBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2618789332141314517L;

	/** 
	 * 模板详情列表
	 */
	@ApiField("data")
	private FengdieTemplateListRespModel data;

	public void setData(FengdieTemplateListRespModel data) {
		this.data = data;
	}
	public FengdieTemplateListRespModel getData( ) {
		return this.data;
	}

}
