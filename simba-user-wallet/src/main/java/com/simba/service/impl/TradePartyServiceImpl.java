package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.TradePartyDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TradeParty;
import com.simba.service.TradePartyService;
/**
 * 交易主体 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradePartyServiceImpl implements TradePartyService {

	@Autowired
	private TradePartyDao tradePartyDao;

	@Override
	public void add(TradeParty tradeParty) {
		tradePartyDao.add(tradeParty);
	}

	@Override
	public void delete(Long id) {
		tradePartyDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeParty get(Long id) {
		return tradePartyDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> page(Pager page) {
		return tradePartyDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradePartyDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return tradePartyDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		tradePartyDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> listAll() {
		return tradePartyDao.listAll();
	}

	@Override
	public void update(TradeParty tradeParty) {
		tradePartyDao.update(tradeParty);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TradeParty getBy(String field, Object value) {
		return tradePartyDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeParty getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradePartyDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeParty getByOr(String field1, Object value1, String field2, Object value2) {
		return tradePartyDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> listBy(String field, Object value) {
		return tradePartyDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradePartyDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradePartyDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> pageBy(String field, Object value, Pager page) {
		return tradePartyDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradePartyDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeParty> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradePartyDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		tradePartyDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		tradePartyDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return tradePartyDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return tradePartyDao.countByOr(field1,value1,field2,value2);
	}
}
