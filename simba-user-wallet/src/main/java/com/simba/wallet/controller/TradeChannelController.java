package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.model.enums.AccountStatus;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.model.vo.TradeChannelVO;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeChannelService;
import com.simba.wallet.util.CommonUtil;

/**
 * 渠道信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeChannel")
public class TradeChannelController {

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
        List<TradeChannelVO> tradeChannelVOList = new ArrayList<>();
        for (TradeChannel channel : list) {
            String accountStatus = AccountStatus.NOTEXIST.getName();
            TradeAccount tradeAccount =
                    tradeAccountService.get(channel.getType(), TradeUserType.CHANNEL);
            accountStatus = CommonUtil.getAccountStatus(tradeAccount).getName();

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
