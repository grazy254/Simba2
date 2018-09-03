package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradeBalanceDetailDao;
import com.simba.wallet.model.TradeBalanceDetail;
import com.simba.wallet.service.TradeBalanceDetailService;
/**
 *  Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeBalanceDetailServiceImpl implements TradeBalanceDetailService {

	@Autowired
	private TradeBalanceDetailDao tradeBalanceDetailDao;

	@Override
	public void add(TradeBalanceDetail tradeBalanceDetail) {
		tradeBalanceDetailDao.add(tradeBalanceDetail);
	}

	@Override
	public void delete(Long id) {
		tradeBalanceDetailDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeBalanceDetail get(Long id) {
		return tradeBalanceDetailDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> page(Pager page) {
		return tradeBalanceDetailDao.page(page);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradeBalanceDetailDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value){
		return tradeBalanceDetailDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		tradeBalanceDetailDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> listAll() {
		return tradeBalanceDetailDao.listAll();
	}

	@Override
	public void update(TradeBalanceDetail tradeBalanceDetail) {
		tradeBalanceDetailDao.update(tradeBalanceDetail);
	}
	
	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public TradeBalanceDetail getBy(String field, Object value) {
		return tradeBalanceDetailDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeBalanceDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeBalanceDetailDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeBalanceDetail getByOr(String field1, Object value1, String field2, Object value2) {
		return tradeBalanceDetailDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> listBy(String field, Object value) {
		return tradeBalanceDetailDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeBalanceDetailDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradeBalanceDetailDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> pageBy(String field, Object value, Pager page) {
		return tradeBalanceDetailDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeBalanceDetailDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeBalanceDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeBalanceDetailDao.pageByOr(field1, value1, field2, value2, page);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		tradeBalanceDetailDao.deleteByAnd(field1,value1,field2,value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		tradeBalanceDetailDao.deleteByOr(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		return tradeBalanceDetailDao.countByAnd(field1,value1,field2,value2);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		return tradeBalanceDetailDao.countByOr(field1,value1,field2,value2);
	}
}
