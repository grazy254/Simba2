package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.service.TradeAccountService;
/**
 * 支付账号 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeAccountServiceImpl implements TradeAccountService {

	@Autowired
	private TradeAccountDao tradeAccountDao;

	@Override
	public Long add(TradeAccount tradeAccount) {
		return tradeAccountDao.add(tradeAccount);
	}

	@Override
	public void delete(Long id) {
		tradeAccountDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeAccount get(Long id) {
		return tradeAccountDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> page(Pager page) {
		return tradeAccountDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradeAccountDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return tradeAccountDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		tradeAccountDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listAll() {
		return tradeAccountDao.listAll();
	}

	@Override
	public void update(TradeAccount tradeAccount) {
		tradeAccountDao.update(tradeAccount);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TradeAccount getBy(String field, Object value) {
		return tradeAccountDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeAccount getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeAccount getByOr(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listBy(String field, Object value) {
		return tradeAccountDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> pageBy(String field, Object value, Pager page) {
		return tradeAccountDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeAccountDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeAccountDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		tradeAccountDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		tradeAccountDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return tradeAccountDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return tradeAccountDao.countByOr(field1,value1,field2,value2);
	}
}
