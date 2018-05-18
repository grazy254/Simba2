package com.simba.wallet.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.exception.BussException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.dao.TradeDetailDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.model.TradeChannelDetail;
import com.simba.wallet.model.TradeDepartment;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.enums.ChannelType;
import com.simba.wallet.model.enums.FeeType;
import com.simba.wallet.model.enums.TradeStatus;
import com.simba.wallet.model.enums.TradeType;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeChannelDetailService;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.service.TradePartyDetailService;
import com.simba.wallet.util.SessionUtil;
/**
 * 交易详情信息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeDetailServiceImpl implements TradeDetailService {

	@Autowired
	private TradeDetailDao tradeDetailDao;
	
	@Autowired
	private TradeDetailService tradeDetailService;
	
	@Autowired
	private TradeAccountService tradeAccountService;
	
	@Autowired
	private TradePartyDetailService tradePartyDetailService;

	@Autowired
	private TradeChannelDetailService tradeChannelDetailService;

	@Autowired
	private SessionUtil sessionUtil;

	@Override
	public Long add(TradeDetail tradeDetail) {
		return tradeDetailDao.add(tradeDetail);
	}

	@Override
	public void delete(Long id) {
		tradeDetailDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeDetail get(Long id) {
		return tradeDetailDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> page(Pager page) {
		return tradeDetailDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> page(Pager page, TradeDetailSearchForm tradeDetailSearchForm) {
		return tradeDetailDao.page(page, tradeDetailSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradeDetailDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long count(TradeDetailSearchForm tradeDetailSearchForm) {
		return tradeDetailDao.count(tradeDetailSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return tradeDetailDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		tradeDetailDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> listAll() {
		return tradeDetailDao.listAll();
	}

	@Override
	public void update(TradeDetail tradeDetail) {
		tradeDetailDao.update(tradeDetail);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TradeDetail getBy(String field, Object value) {
		return tradeDetailDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeDetailDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeDetail getByOr(String field1, Object value1, String field2, Object value2) {
		return tradeDetailDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> listBy(String field, Object value) {
		return tradeDetailDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeDetailDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradeDetailDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> pageBy(String field, Object value, Pager page) {
		return tradeDetailDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeDetailDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeDetailDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		tradeDetailDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		tradeDetailDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return tradeDetailDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return tradeDetailDao.countByOr(field1,value1,field2,value2);
	}

	private String generateTradeNO() {
		return UUID.randomUUID().toString();
	}

	@Override
	@Transactional(readOnly = false)
	public JsonResult recharge(SmartUser smartUser, String tradeDeptNO, ChannelType channelType, 
			TradePartyDetail tradePartyDetail, String orderNO, String orderName, String orderDesc, long originalAmount,
			long paymentAmount, Date tradeCreateTime) {
		
		tradePartyDetail.setCreateTime(new Date());
		tradePartyDetail.setPartyName(smartUser.getName());
		tradePartyDetail.setPartyType(TradeUserType.PERSION.getName());
		tradePartyDetail.setNoticeMail(smartUser.getEmail());
		tradePartyDetail.setIp("");
		tradePartyDetail.setLocation("");
		tradePartyDetail.setMobileNumber(smartUser.getTelNo());
		tradePartyDetail.setTradeAccountID(sessionUtil.getTradeAccount(smartUser.getAccount()).getAccountID());
		tradePartyDetail.setTradeUserID(sessionUtil.getTradeUser(smartUser.getAccount()).getId());
		Long tradePartyID = tradePartyDetailService.add(tradePartyDetail);
		tradePartyDetail.setId(tradePartyID);

		TradeDepartment tradeDepartment = sessionUtil.getTradeDepartment(tradeDeptNO);

		TradePartyDetail counterPartyDetail = new TradePartyDetail();
		counterPartyDetail.setCreateTime(new Date());
		counterPartyDetail.setPartyName(tradeDepartment.getDeptName());
		counterPartyDetail.setPartyType(TradeUserType.DEPARTMENT.getName());
		counterPartyDetail.setTradeAccountID(sessionUtil.getTradeAccount(tradeDepartment.getDeptNO()).getAccountID());
		counterPartyDetail.setTradeUserID(sessionUtil.getTradeUser(tradeDepartment.getDeptNO()).getId());
		counterPartyDetail.setIp("");
		counterPartyDetail.setLocation("");
		counterPartyDetail.setMobileNumber("");
		counterPartyDetail.setNoticeMail("");
		Long counterPartyID = tradePartyDetailService.add(counterPartyDetail);
		counterPartyDetail.setId(counterPartyID);

		TradeChannel tradeChannel = sessionUtil.getTradeChannel(channelType);

		TradeChannelDetail tradeChannelDetail = new TradeChannelDetail();
		tradeChannelDetail.setChannelID(tradeChannel.getId());
		tradeChannelDetail.setCreateTime(new Date());
		tradeChannelDetail.setErrorCode("");
		tradeChannelDetail.setErrorMsg("");
		tradeChannelDetail.setOpenID("");
		tradeChannelDetail.setOrderCreateTime(new Date());
		tradeChannelDetail.setOrderNO("000");
		tradeChannelDetail.setPaymentTime(new Date());
		tradeChannelDetail.setLastUpdateTime(new Date());
		tradeChannelDetail.setTradeAccountID(sessionUtil.getTradeAccount(tradeChannel.getType()).getAccountID());
		Long tradeChannelDetailID = tradeChannelDetailService.add(tradeChannelDetail);
		tradeChannelDetail.setId(tradeChannelDetailID);

		return dealOrder(tradePartyDetail, counterPartyDetail, tradeChannelDetail, orderNO, 
				orderName, orderDesc, "", originalAmount, paymentAmount, 
				tradeCreateTime, TradeType.RECHARGE);
	}
	
	public JsonResult dealOrder(TradePartyDetail tradePartyDetail, 
			TradePartyDetail counterPartyDetail, 
			TradeChannelDetail tradeChannelDetail,
			String orderNO, String orderName, String orderDesc, 
			String orderAddress, long originalAmount, long paymentAmount, 
			Date tradeCreateTime, TradeType tradeType){
//		String tradeAccountID =  sessionUtil.getTradeAccount(session).getAccountID();
//		SmartUser smartUser = sessionUtil.getSmartUser(session);
//		TradeUser tradeUser = sessionUtil.getTradeUser(session);
		
		//======插入的数据======
		//TradePartyDetail信息 
			//需要普通用户的ID， name，类型等
			//用户的TradeAccountID信息
		// --可以通过userID信息获取到(userID +accountType -> TradeAccount)
			
		//CounterPartyDetail信息 
			//需要收费部门的的ID， name
			//部门的AccountID信息
				//--可以通过部门ID获取到(deptNO  + accoutType -> TradeAccount)
	
		//渠道详情TradeChannelDetail
			//需要渠道的ID - 微信渠道的可以通过缓存整张渠道表获取
			//渠道的AccountID信息
				//--可以通过渠道ID获取(ChannelID + accountType -> TradeAccount)
		
		//充值操作，在提交请求的时候不需要修改TradeAccount表的信息
		//如果是消费操作，则在每次操作的时候需要先把变动的金额冻结，然后在"商品出库"后再解冻金额
		
		TradeDetail tradeDetail = new TradeDetail();
		tradeDetail.setCreateTime(new Date());
		tradeDetail.setFeeType(FeeType.CNY.getName());
		tradeDetail.setLastUpdateTime(new Date());
		tradeDetail.setOrderAddress(orderAddress);
		tradeDetail.setOrderDesc(orderDesc);
		tradeDetail.setOrderName(orderName);
		tradeDetail.setOrderNO(orderNO);
		tradeDetail.setOriginalAmount(originalAmount);
		tradeDetail.setPaymentAmount(paymentAmount);
		tradeDetail.setTradeChannelID(tradeChannelDetail.getId());
		tradeDetail.setTradeCounterpartyID(counterPartyDetail.getId());
		tradeDetail.setTradeCreateTime(tradeCreateTime);
		tradeDetail.setTradeNO(generateTradeNO());
		tradeDetail.setTradePartyID(tradePartyDetail.getId());
		tradeDetail.setTradePaymentTime(new Date());
		tradeDetail.setTradeStatus(TradeStatus.INPROCESS.getName());
		tradeDetail.setTradeType(tradeType.getName());
		Long tradeDetailID = tradeDetailService.add(tradeDetail);

		if (tradeDetailID <= 0 ) {
			throw new BussException("创建支付订单失败");
		}
		if (tradeType == TradeType.CONSUME) {
			//交易的操作需要先冻结PERSON用户的支付金额			
			TradeAccount tradeAccount = tradeAccountService.getBy("accountID", tradePartyDetail.getTradeAccountID());
			tradeAccount.setFrozenBalance(paymentAmount);
			tradeAccountService.update(tradeAccount);
		}
		return new JsonResult("创建支付订单成功");
	}
	
}
