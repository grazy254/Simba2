package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.date.DateTime;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.vo.TradePartyVO;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.service.TradePartyDetailService;
import com.simba.wallet.util.FmtUtil;
import com.simba.wallet.util.SessionUtil;

/**
 * 交易主体控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradePartyDetail")
public class TradePartyDetailController {

	@Autowired
	private TradePartyDetailService tradePartyDetailService;

	@Autowired
	private TradeDetailService tradeDetailService;

	@Autowired
	private SessionUtil sessionUtil;



	@ResponseBody
	@RequestMapping("/list")
	public List<TradePartyVO> list(Integer pageStart,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date tradeDate,
			HttpSession session) {

		List<TradePartyDetail> tradePartyDetailList = null;
		if (tradeDate != null) {
			tradePartyDetailList = tradePartyDetailService.pageByAnd("tradeUserID",
					sessionUtil.getTradeUser(sessionUtil.getSmartUser(session).getAccount()).getId(), "createDate",
					tradeDate,
					new Pager((pageStart - 1) * 10, 10));
		} else {
			tradePartyDetailList = tradePartyDetailService.pageBy("tradeUserID",
					sessionUtil.getTradeUser(sessionUtil.getSmartUser(session).getAccount()).getId(),
					new Pager((pageStart - 1) * 10, 10));
		}

		List<TradePartyVO> result = new ArrayList<>();
		for (TradePartyDetail detail : tradePartyDetailList) {
			TradeDetail tradeDetail = tradeDetailService.getBy("tradePartyID", detail.getId());
			if (tradeDetail != null) {
				TradePartyVO vo = new TradePartyVO();
				vo.setTradeAmount(FmtUtil.transToCNYType(tradeDetail.getPaymentAmount()));
				vo.setTradeStatus("充值" + FmtUtil.fmtTradeStatus(tradeDetail.getTradeStatus()));
				vo.setTradeTime(DateTime.getTime(tradeDetail.getTradePaymentTime()));
				vo.setTradeType(FmtUtil.fmtTradeType(tradeDetail.getTradeType()));
				result.add(vo);
			}
		}
		return result;
	}

	/**
	 * 新增交易主体
	 * 
	 * @param tradePartyDetail
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradePartyDetail tradePartyDetail) {
		tradePartyDetailService.add(tradePartyDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradePartyDetail tradePartyDetail) {
		tradePartyDetailService.update(tradePartyDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradePartyDetailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradePartyDetailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
