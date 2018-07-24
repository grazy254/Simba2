package com.simba.controller.api;

import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.controller.enums.RedPackBillStatus;
import com.simba.controller.enums.RedPackType;
import com.simba.controller.form.GroupRedPackForm;
import com.simba.controller.form.NormalRedPackForm;
import com.simba.controller.form.SearchRedPackForm;
import com.simba.framework.util.common.ServerUtil;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.RedPackBill;
import com.simba.redpack.model.group.GroupRedPackReq;
import com.simba.redpack.model.group.GroupRedPackRes;
import com.simba.redpack.model.normal.NormalRedPackReq;
import com.simba.redpack.model.normal.NormalRedPackRes;
import com.simba.redpack.model.search.SearchReq;
import com.simba.redpack.util.send.WxRedPackUtil;
import com.simba.service.RedPackBillService;

/**
 * 微信红包api接口Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/api/wechatRedPack")
public class WechatRedPackApiController {

	private WxRedPackUtil wxRedPackUtil;

	@Value("${wx.pay.mchid}")
	private String mchid;

	@Value("${appID}")
	private String appID;

	@Autowired
	private RedPackBillService redPackBillService;

	@PostConstruct
	private void init() {
		wxRedPackUtil = WxRedPackUtil.getInstance();
	}

	/**
	 * 发送普通红包
	 * 
	 * @param normalRedPackForm
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/sendNormalRedPack")
	public JsonResult sendNormalRedPack(NormalRedPackForm normalRedPackForm, HttpServletRequest request) throws ParseException, IOException {
		normalRedPackForm.setMch_billno(RandomUtil.random32Chars());
		NormalRedPackReq normalRedPackReq = new NormalRedPackReq();
		normalRedPackReq.setAct_name(normalRedPackForm.getAct_name());
		normalRedPackReq.setClient_ip(ServerUtil.getProxyIp(request));
		normalRedPackReq.setConsume_mch_id(normalRedPackForm.getConsume_mch_id());
		normalRedPackReq.setMch_billno(normalRedPackForm.getMch_billno());
		normalRedPackReq.setRe_openid(normalRedPackForm.getRe_openid());
		normalRedPackReq.setRemark(normalRedPackForm.getRemark());
		normalRedPackReq.setRisk_info(normalRedPackForm.getRisk_info());
		normalRedPackReq.setScene_id(normalRedPackForm.getScene_id());
		normalRedPackReq.setSend_name(normalRedPackForm.getSend_name());
		normalRedPackReq.setTotal_amount(normalRedPackForm.getTotal_amount());
		normalRedPackReq.setTotal_num(normalRedPackForm.getTotal_num());
		normalRedPackReq.setWishing(normalRedPackForm.getWishing());
		NormalRedPackRes res = wxRedPackUtil.sendNormalRedPack(normalRedPackReq);
		RedPackBill bill = new RedPackBill();
		bill.setType(RedPackType.NORMAL.getName());
		bill.setBillNo(normalRedPackForm.getMch_billno());
		bill.setMchId(mchid);
		bill.setAppid(appID);
		bill.setSendName(normalRedPackReq.getSend_name());
		bill.setOpenid(normalRedPackReq.getRe_openid());
		bill.setAmount(normalRedPackReq.getTotal_amount());
		bill.setNum(normalRedPackReq.getTotal_num());
		bill.setWishing(normalRedPackReq.getWishing());
		bill.setClientIp(normalRedPackReq.getClient_ip());
		bill.setActName(normalRedPackReq.getAct_name());
		bill.setRemark(normalRedPackReq.getRemark());
		bill.setSceneId(normalRedPackReq.getScene_id());
		bill.setRiskInfo(normalRedPackReq.getRisk_info());
		bill.setConsumeMchId(normalRedPackReq.getConsume_mch_id());
		bill.setStatus(RedPackBillStatus.SENDING.getName());
		bill.setErrMsg(res.getErr_code_des());
		bill.setSendListId(res.getSend_listid());
		bill.setCreateTime(new Date());
		bill.setCreateUser(StringUtils.EMPTY);
		redPackBillService.add(bill);
		return new JsonResult(res);
	}

	/**
	 * 发送裂变红包
	 * 
	 * @param groupRedPackForm
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/sendGroupRedPack")
	public JsonResult sendGroupRedPack(GroupRedPackForm groupRedPackForm) throws ParseException, IOException {
		groupRedPackForm.setMch_billno(RandomUtil.random32Chars());
		GroupRedPackReq groupRedPackReq = new GroupRedPackReq();
		groupRedPackReq.setAct_name(groupRedPackForm.getAct_name());
		groupRedPackReq.setAmt_type(groupRedPackForm.getAmt_type());
		groupRedPackReq.setConsume_mch_id(groupRedPackForm.getConsume_mch_id());
		groupRedPackReq.setMch_billno(groupRedPackForm.getMch_billno());
		groupRedPackReq.setRe_openid(groupRedPackForm.getRe_openid());
		groupRedPackReq.setRemark(groupRedPackForm.getRemark());
		groupRedPackReq.setRisk_info(groupRedPackForm.getRisk_info());
		groupRedPackReq.setScene_id(groupRedPackForm.getScene_id());
		groupRedPackReq.setSend_name(groupRedPackForm.getSend_name());
		groupRedPackReq.setTotal_amount(groupRedPackForm.getTotal_amount());
		groupRedPackReq.setTotal_num(groupRedPackForm.getTotal_num());
		groupRedPackReq.setWishing(groupRedPackForm.getWishing());
		GroupRedPackRes res = wxRedPackUtil.sendGroupRedPack(groupRedPackReq);
		RedPackBill bill = new RedPackBill();
		bill.setType(RedPackType.GROUP.getName());
		bill.setBillNo(groupRedPackForm.getMch_billno());
		bill.setMchId(mchid);
		bill.setAppid(appID);
		bill.setSendName(groupRedPackForm.getSend_name());
		bill.setOpenid(groupRedPackForm.getRe_openid());
		bill.setAmount(groupRedPackReq.getTotal_amount());
		bill.setNum(groupRedPackReq.getTotal_num());
		bill.setWishing(groupRedPackForm.getWishing());
		bill.setClientIp(StringUtils.EMPTY);
		bill.setActName(groupRedPackForm.getAct_name());
		bill.setRemark(groupRedPackForm.getRemark());
		bill.setSceneId(groupRedPackForm.getScene_id());
		bill.setRiskInfo(groupRedPackForm.getRisk_info());
		bill.setConsumeMchId(groupRedPackForm.getConsume_mch_id());
		bill.setStatus(RedPackBillStatus.SENDING.getName());
		bill.setErrMsg(res.getErr_code_des());
		bill.setSendListId(res.getSend_listid());
		bill.setCreateTime(new Date());
		bill.setCreateUser(StringUtils.EMPTY);
		redPackBillService.add(bill);
		return new JsonResult(res);
	}

	/**
	 * 查询红包记录
	 * 
	 * @param SearchRedPackForm
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/searchRedPack")
	public JsonResult searchRedPack(SearchRedPackForm searchRedPackForm) throws ParseException, IOException {
		SearchReq searchReq = new SearchReq();
		searchReq.setBill_type(searchRedPackForm.getBill_type());
		searchReq.setMch_billno(searchRedPackForm.getMch_billno());
		return new JsonResult(wxRedPackUtil.searchRedPack(searchReq));
	}
}
