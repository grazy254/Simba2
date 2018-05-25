package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradeChannelDetailDao;
import com.simba.wallet.model.TradeChannelDetail;
import com.simba.wallet.service.TradeChannelDetailService;
/**
 * 交易的渠道信息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeChannelDetailServiceImpl implements TradeChannelDetailService {

	@Autowired
	private TradeChannelDetailDao tradeChannelDetailDao;

	@Override
	public Long add(TradeChannelDetail tradeChannelDetail) {
		return tradeChannelDetailDao.add(tradeChannelDetail);
	}

	@Override
	public void delete(Long id) {
		tradeChannelDetailDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeChannelDetail get(Long id) {
		return tradeChannelDetailDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> page(Pager page) {
		return tradeChannelDetailDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradeChannelDetailDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return tradeChannelDetailDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		tradeChannelDetailDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> listAll() {
		return tradeChannelDetailDao.listAll();
	}

	@Override
	public void update(TradeChannelDetail tradeChannelDetail) {
		tradeChannelDetailDao.update(tradeChannelDetail);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TradeChannelDetail getBy(String field, Object value) {
		return tradeChannelDetailDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeChannelDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDetailDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeChannelDetail getByOr(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDetailDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> listBy(String field, Object value) {
		return tradeChannelDetailDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDetailDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradeChannelDetailDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> pageBy(String field, Object value, Pager page) {
		return tradeChannelDetailDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeChannelDetailDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeChannelDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeChannelDetailDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		tradeChannelDetailDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		tradeChannelDetailDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return tradeChannelDetailDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return tradeChannelDetailDao.countByOr(field1,value1,field2,value2);
	}
}
