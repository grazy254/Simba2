package com.alipay.api.response;

import java.util.List;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: koubei.marketing.campaign.intelligent.template.consult response.
 * 
 * @author auto create
 * @since 1.0, 2018-01-29 11:02:45
 */
public class KoubeiMarketingCampaignIntelligentTemplateConsultResponse extends AlipayResponse {

	private static final long serialVersionUID = 3145451598162748565L;

	/** 
	 * 营销模板的编号
GENERAL_NORMAL：全场普通；
ITEM_NORMAL：单品普通;
CROWD_NORMAL: 千人千券普通；
	 */
	@ApiListField("template_codes")
	@ApiField("string")
	private List<String> templateCodes;

	public void setTemplateCodes(List<String> templateCodes) {
		this.templateCodes = templateCodes;
	}
	public List<String> getTemplateCodes( ) {
		return this.templateCodes;
	}

}
