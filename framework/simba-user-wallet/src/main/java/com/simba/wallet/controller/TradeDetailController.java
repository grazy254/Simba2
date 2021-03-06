package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.simba.framework.util.date.DateTime;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.model.vo.TradeDetailVO;
import com.simba.wallet.service.TradeChannelDetailService;
import com.simba.wallet.service.TradeChannelService;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.service.TradePartyDetailService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;

/**
 * 交易详情信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeDetail")
public class TradeDetailController {

	@Autowired
	private TradeDetailService tradeDetailService;

	@Autowired
	private TradeUserService tradeUserService;

	@Autowired
	private TradePartyDetailService tradePartyDetailService;

	@Autowired
	private TradeChannelDetailService tradeChannelDetailService;

	@Autowired
	private TradeChannelService tradeChannelService;

	@RequestMapping("/list")
	public String list(ModelMap model) {
		model.put("tradeUserTypeList", TradeUserType.values());
		model.put("tradeTypeList", TradeType.values());
		model.put("tradeStatusList", TradeStatus.values());
		return "tradeDetail/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		model.put("list", getTradeDetailVOList(tradeDetailService.page(pager)));
		return "tradeDetail/table";
	}

	@RequestMapping("/doSearch")
	public String getList(Pager pager, TradeDetailSearchForm tradeDetailSearchForm, ModelMap model) {
		model.put("list", getTradeDetailVOList(tradeDetailService.page(pager, fillTradeUserID(tradeDetailSearchForm))));
		return "tradeDetail/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(TradeDetailSearchForm tradeDetailSearchForm) {
		Long count = tradeDetailService.count(fillTradeUserID(tradeDetailSearchForm));
		return new JsonResult(count, "", 200);
	}

	private List<TradeDetailVO> getTradeDetailVOList(List<TradeDetail> tradeDetailList) {
		List<TradeDetailVO> result = new ArrayList<>();
		for (TradeDetail tradeDetail : tradeDetailList) {
			TradeDetailVO vo = buildDetailVO(tradeDetail);
			result.add(vo);
		}
		return result;
	}

	private TradeDetailVO buildDetailVO(TradeDetail tradeDetail) {
		TradeDetailVO vo = new TradeDetailVO();
		vo.setPaymentAmount(CommonUtil.transToCNYType(tradeDetail.getPaymentAmount()));
		vo.setTradeStatus(TradeStatus.getValue(tradeDetail.getTradeStatus()));
		vo.setTradePaymentTime(DateTime.getTime(tradeDetail.getTradePaymentTime()));
		vo.setTradeType(TradeType.getValue(tradeDetail.getTradeType()));
		if (tradeDetail.getTradeChannelID() >= 0) {
			vo.setChannelName(tradeChannelService.get(tradeChannelDetailService.get(tradeDetail.getTradeChannelID()).getChannelID()).getName());
		}
		vo.setCreateTime(DateUtil.date2String(tradeDetail.getCreateTime()));
		vo.setFeeType(tradeDetail.getFeeType());
		vo.setLastUpdateTime(DateUtil.date2String(tradeDetail.getLastUpdateTime()));
		vo.setOrderNO(tradeDetail.getOrderNO());
		vo.setOriginalAmount(CommonUtil.transToCNYType(tradeDetail.getOriginalAmount()));
		vo.setPaymentAmount(CommonUtil.transToCNYType(tradeDetail.getPaymentAmount()));
		vo.setTradeCounterpartyName(tradePartyDetailService.get(tradeDetail.getTradeCounterpartyID()).getPartyName());
		vo.setTradeCreateTime(DateUtil.date2String(tradeDetail.getTradeCreateTime()));
		vo.setTradeNO(Long.toString(tradeDetail.getTradeNO()));
		vo.setTradePartyName(tradePartyDetailService.get(tradeDetail.getTradePartyID()).getPartyName());
		vo.setTradePaymentTime(DateUtil.date2String(tradeDetail.getTradePaymentTime()));
		return vo;
	}

	private TradeDetailSearchForm fillTradeUserID(TradeDetailSearchForm tradeDetailSearchForm) {
		if (!Strings.isNullOrEmpty(tradeDetailSearchForm.getUserID())) {
			if (!Strings.isNullOrEmpty(tradeDetailSearchForm.getTradeUserType())) {
				TradeUser tradeUser = tradeUserService.get(tradeDetailSearchForm.getUserID(), TradeUserType.getTradeUserType(tradeDetailSearchForm.getTradeUserType()));
				tradeDetailSearchForm.setTradeUserID(tradeUser.getId());
			} else {
				throw ErrConfig.INVALID_PARAMETER;
			}
		}
		return tradeDetailSearchForm;
	}
}
