package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.vo.TradePartyVO;
import com.simba.wallet.service.TradePartyDetailService;
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
	private SessionUtil sessionUtil;
	@ResponseBody
	@RequestMapping("/list")
	public List<TradePartyVO> list(Integer pageStart, HttpSession session) {

		List<TradePartyVO> list = tradePartyDetailService.pageBy("tradeUserID",
				sessionUtil.getTradeUser(session).getId(), new Pager(pageStart, 10));
		return list;
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
