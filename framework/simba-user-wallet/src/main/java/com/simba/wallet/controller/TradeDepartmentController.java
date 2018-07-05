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
import com.simba.wallet.model.TradeDepartment;
import com.simba.wallet.model.vo.TradeDepartmentVO;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeDepartmentService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.TradeUserType;

/**
 * 收款部门控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeDepartment")
public class TradeDepartmentController {

    @Autowired
    private TradeDepartmentService tradeDepartmentService;

    @Autowired
    private TradeAccountService tradeAccountService;

    @RequestMapping("/list")
    public String list() {
        return "tradeDepartment/list";
    }

    @RequestMapping("/getList")
    public String getList(Pager pager, ModelMap model) {
        List<TradeDepartment> list = tradeDepartmentService.page(pager);
        List<TradeDepartmentVO> tradeDepartmentVOList = new ArrayList<>();
        for (TradeDepartment dept : list) {
            String accountStatus = "";
            try {
                accountStatus = CommonUtil.getAccountStatus(
                        tradeAccountService.get(dept.getDeptNO(), TradeUserType.DEPARTMENT));
            } catch (Exception e) {

            }
            TradeDepartmentVO vo = new TradeDepartmentVO();
            vo.setId(dept.getId());
            vo.setDeptName(dept.getDeptName());
            vo.setDeptNO(dept.getDeptNO());
            vo.setCreateTime(DateUtil.date2String(dept.getCreateTime()));
            vo.setLastUpdateTime(DateUtil.date2String(dept.getLastUpdateTime()));
            vo.setAccountStatus(accountStatus);
            tradeDepartmentVOList.add(vo);
        }
        model.put("list", tradeDepartmentVOList);
        return "tradeDepartment/table";
    }

    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count() {
        Long count = tradeDepartmentService.count();
        return new JsonResult(count, "", 200);
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "tradeDepartment/add";
    }

    @RequestMapping("/add")
    public String add(TradeDepartment tradeDepartment) throws Exception {
        tradeDepartmentService.add(tradeDepartment);
        return "redirect:/tradeDepartment/list";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Long id, ModelMap model) {
        TradeDepartment tradeDepartment = tradeDepartmentService.get(id);
        model.put("tradeDepartment", tradeDepartment);
        return "tradeDepartment/update";
    }

    @RequestMapping("/update")
    public String update(TradeDepartment tradeDepartment) {
        tradeDepartmentService.update(tradeDepartment);
        return "redirect:/tradeDepartment/list";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(String deptNO, ModelMap model) {
        tradeDepartmentService.delete(deptNO);
        return new JsonResult();
    }
}
