package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.domain.IntelligentPromo;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: koubei.marketing.campaign.intelligent.promo.create response.
 * 
 * @author auto create
 * @since 1.0, 2018-01-18 16:52:15
 */
public class KoubeiMarketingCampaignIntelligentPromoCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 8583377428181673833L;

	/** 
	 * 智能营销活动信息
	 */
	@ApiField("promo")
	private IntelligentPromo promo;

	public void setPromo(IntelligentPromo promo) {
		this.promo = promo;
	}
	public IntelligentPromo getPromo( ) {
		return this.promo;
	}

}
