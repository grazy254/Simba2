package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.model.vo.TradeChannelVO;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeChannelService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.TradeUserType;

/**
 * 渠道信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeChannel")
public class TradeChannelController {

	private static final Log logger = LogFactory.getLog(TradeChannelController.class);

	@Autowired
	private TradeChannelService tradeChannelService;

	@Autowired
	private TradeAccountService tradeAccountService;

	@RequestMapping("/list")
	public String list() {
		return "tradeChannel/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<TradeChannel> list = tradeChannelService.page(pager);
		List<TradeChannelVO> tradeChannelVOList = new ArrayList<>(list.size());
		for (TradeChannel channel : list) {
			String accountStatus = StringUtils.EMPTY;
			try {
				accountStatus = CommonUtil.getAccountStatus(tradeAccountService.get(channel.getType(), TradeUserType.CHANNEL));
			} catch (Exception e) {
				logger.error("获取钱包账号状态发生异常", e);
			}
			TradeChannelVO vo = new TradeChannelVO();
			vo.setId(channel.getId());
			vo.setName(channel.getName());
			vo.setType(channel.getType());
			vo.setCreateTime(DateUtil.date2String(channel.getCreateTime()));
			vo.setLastUpdateTime(DateUtil.date2String(channel.getLastUpdateTime()));
			vo.setAccountStatus(accountStatus);
			tradeChannelVOList.add(vo);
		}
		model.put("list", tradeChannelVOList);
		return "tradeChannel/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = tradeChannelService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "tradeChannel/add";
	}

	@RequestMapping("/add")
	public String add(TradeChannel tradeChannel) throws Exception {
		tradeChannelService.add(tradeChannel);
		return "redirect:/tradeChannel/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		TradeChannel tradeChannel = tradeChannelService.get(id);
		model.put("tradeChannel", tradeChannel);
		return "tradeChannel/update";
	}

	@RequestMapping("/update")
	public String update(TradeChannel tradeChannel) {
		tradeChannelService.update(tradeChannel);
		return "redirect:/tradeChannel/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(String type, ModelMap model) {
		tradeChannelService.delete(type);
		return new JsonResult();
	}
}
