package com.simba.wallet.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.simba.framework.util.date.DateTime;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.model.vo.SimpleTradeDetailVO;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;
import com.simba.wallet.util.SessionUtil;

/**
 * 交易详情信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/api/tradeDetail")
public class TradeDetailApi {

	@Autowired
	private TradeDetailService tradeDetailService;

	@Autowired
	private TradeUserService tradeUserService;

	@Autowired
	private SessionUtil sessionUtil;

	@ResponseBody
	@RequestMapping("/search")
	public JsonResult search(Integer pageStart, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date tradeDate, HttpSession session) {
		TradeDetailSearchForm tradeDetailSearchForm = new TradeDetailSearchForm();
		tradeDetailSearchForm.setUserID(sessionUtil.getSmartUser(session).getAccount());
		tradeDetailSearchForm.setTradeUserType(TradeUserType.PERSION.getName());
		if (tradeDate != null) {
			tradeDetailSearchForm.setStartTime(DateUtil.getTime(tradeDate));
			tradeDetailSearchForm.setEndTime(DateUtil.getTime(tradeDate));
		}
		return getSimpleTradeDetailVOList(tradeDetailService.page(new Pager((pageStart - 1) * 10, 10), fillTradeUserID(tradeDetailSearchForm)));
	}

	private JsonResult getSimpleTradeDetailVOList(List<TradeDetail> tradeDetailList) {
		List<SimpleTradeDetailVO> result = new ArrayList<>();
		for (TradeDetail tradeDetail : tradeDetailList) {
			SimpleTradeDetailVO vo = new SimpleTradeDetailVO();
			TradeType tradeType = TradeType.getTradeType(tradeDetail.getTradeType());
			boolean addMinus = false;
			if (tradeType == TradeType.CONSUME || tradeType == TradeType.REFUND) {
				addMinus = true;
			}
			vo.setTradeAmount(CommonUtil.transToCNYType(tradeDetail.getPaymentAmount(), addMinus));
			vo.setTradeStatus(TradeStatus.getValue(tradeDetail.getTradeStatus()));
			vo.setTradeTime(DateTime.getTime(tradeDetail.getTradePaymentTime()));
			vo.setTradeType(TradeType.getValue(tradeDetail.getTradeType()));
			result.add(vo);
		}
		return new JsonResult(result);
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
