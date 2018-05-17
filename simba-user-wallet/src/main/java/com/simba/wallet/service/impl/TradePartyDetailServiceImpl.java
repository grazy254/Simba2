package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradePartyDetailDao;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.service.TradePartyDetailService;
/**
 * 交易主体 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradePartyDetailServiceImpl implements TradePartyDetailService {

	@Autowired
	private TradePartyDetailDao tradePartyDetailDao;

	@Override
	public void add(TradePartyDetail tradePartyDetail) {
		tradePartyDetailDao.add(tradePartyDetail);
	}

	@Override
	public void delete(Long id) {
		tradePartyDetailDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradePartyDetail get(Long id) {
		return tradePartyDetailDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> page(Pager page) {
		return tradePartyDetailDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradePartyDetailDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return tradePartyDetailDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		tradePartyDetailDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> listAll() {
		return tradePartyDetailDao.listAll();
	}

	@Override
	public void update(TradePartyDetail tradePartyDetail) {
		tradePartyDetailDao.update(tradePartyDetail);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TradePartyDetail getBy(String field, Object value) {
		return tradePartyDetailDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradePartyDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradePartyDetailDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradePartyDetail getByOr(String field1, Object value1, String field2, Object value2) {
		return tradePartyDetailDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> listBy(String field, Object value) {
		return tradePartyDetailDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradePartyDetailDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradePartyDetailDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> pageBy(String field, Object value, Pager page) {
		return tradePartyDetailDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradePartyDetailDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradePartyDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradePartyDetailDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		tradePartyDetailDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		tradePartyDetailDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return tradePartyDetailDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return tradePartyDetailDao.countByOr(field1,value1,field2,value2);
	}
}
