package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.enums.ChannelType;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.util.SessionUtil;

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
	private SessionUtil sessionUtil;

	@RequestMapping("/list")
	public String list() {
		return "tradeDetail/list";
	}
	
	@RequestMapping("/getList")
	public String getList(Pager pager,ModelMap model){
		List<TradeDetail> list = tradeDetailService.page(pager);
		model.put("list", list);
		return "tradeDetail/table";
	}
	
	@RequestMapping("/doSearch")
	public String getList(Pager pager, TradeDetailSearchForm tradeDetailSearchForm, ModelMap model) {
		List<TradeDetail> list = tradeDetailService.page(pager, tradeDetailSearchForm);
		model.put("list", list);
		return "tradeDetail/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(TradeDetailSearchForm tradeDetailSearchForm) {
		Long count = tradeDetailService.count(tradeDetailSearchForm);
		return new JsonResult(count, "", 200);
	}
	
	@ResponseBody
	@RequestMapping("/recharge")
	public JsonResult recharge(TradePartyDetail tradePartyDetail, String orderNO, String orderName, String orderDesc, Long originalAmount,
			Long paymentAmount, @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") Date tradeCreateTime,
			HttpSession session) {
		SmartUser smartUser = sessionUtil.getSmartUser(session);
		JsonResult rs = tradeDetailService.recharge(smartUser, "SK001", ChannelType.WXPAY,
		 tradePartyDetail, orderNO, orderName, orderDesc, originalAmount,
		 paymentAmount, tradeCreateTime);
		return rs;
	}
	
	@ResponseBody
	@RequestMapping("getTradeList")
	public JsonResult getTradeList(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
		return null;
	}

	/**
	 * 新增交易详情信息
	 * 
	 * @param tradeDetail
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeDetail tradeDetail) {
		tradeDetailService.add(tradeDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeDetail tradeDetail) {
		tradeDetailService.update(tradeDetail);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeDetailService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeDetailService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
