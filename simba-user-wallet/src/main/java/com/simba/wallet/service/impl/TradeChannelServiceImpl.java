package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.exception.BussException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.dao.TradeChannelDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.service.TradeChannelService;
import com.simba.wallet.util.ErrConfig;
/**
 * 渠道信息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeChannelServiceImpl implements TradeChannelService {

	@Autowired
	private TradeChannelDao tradeChannelDao;

	@Autowired
	private TradeAccountDao tradeAccountDao;

	@Override
	public void add(TradeChannel tradeChannel) throws Exception {
		tradeChannelDao.add(tradeChannel);
	}

	@Override
	public void delete(Long id) {
		tradeChannelDao.delete(id);
	}

	@Override
	@Transactional
	public void delete(String type) {
		TradeAccount tradeAccount = null;
		try {
			tradeAccount = tradeAccountDao.get(type, TradeUserType.CHANNEL);
			if (tradeAccount.getAccountBalance() == 0) {
				tradeAccount.setIsActive(-1);
				tradeAccountDao.update(tradeAccount);
			} else {
				throw new BussException("删除失败：账户余额不为0");
			}
		} catch (Exception e) {
			if (e == ErrConfig.USER_NOT_EXIST_ERR || e == ErrConfig.ACCOUNT_NOT_EXIST_ERR) {
				// TODO: logger
				System.out.println(e);
			} else {
				throw new BussException(e.getMessage());
			}
		}
		
		tradeChannelDao.deleteBy("type", type);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeChannel get(Long id) {
		return tradeChannelDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> page(Pager page) {
		return tradeChannelDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradeChannelDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return tradeChannelDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		tradeChannelDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> listAll() {
		return tradeChannelDao.listAll();
	}

	@Override
	public void update(TradeChannel tradeChannel) {
		tradeChannelDao.update(tradeChannel);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TradeChannel getBy(String field, Object value) {
		return tradeChannelDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeChannel getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeChannel getByOr(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> listBy(String field, Object value) {
		return tradeChannelDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> pageBy(String field, Object value, Pager page) {
		return tradeChannelDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeChannelDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannel> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeChannelDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		tradeChannelDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		tradeChannelDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return tradeChannelDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return tradeChannelDao.countByOr(field1,value1,field2,value2);
	}
}
