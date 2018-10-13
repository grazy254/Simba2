package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradeDetailDao;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.service.TradeDetailService;

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
	public Long countBy(String field, Object value) {
		return tradeDetailDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		tradeDetailDao.deleteBy(field, value);
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
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		tradeDetailDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		tradeDetailDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeDetailDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return tradeDetailDao.countByOr(field1, value1, field2, value2);
	}

}
