package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradeChannelDao;
import com.simba.wallet.model.TradeChannel;
import com.simba.wallet.service.TradeChannelService;
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

	@Override
	public void add(TradeChannel tradeChannel) {
		tradeChannelDao.add(tradeChannel);
	}

	@Override
	public void delete(Long id) {
		tradeChannelDao.delete(id);
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
