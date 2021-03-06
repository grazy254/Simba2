package com.simba.wallet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.exception.BussException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.dao.TradeDetailDao;
import com.simba.wallet.dao.TradeUserDao;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.AccountActiveStatus;
import com.simba.wallet.util.Constants.TradePayment;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.Constants.TradeUserType;

/**
 * 钱包用户信息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeUserServiceImpl implements TradeUserService {

	@Autowired
	private TradeUserDao tradeUserDao;

	@Autowired
	private TradeDetailDao tradeDetailDao;

	@Override
	public long add(TradeUser tradeUser) {
		return tradeUserDao.add(tradeUser);
	}

	@Override
	public void delete(Long id) {
		tradeUserDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeUser get(Long id) {
		return tradeUserDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> page(Pager page) {
		return tradeUserDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradeUserDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return tradeUserDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		tradeUserDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> listAll() {
		return tradeUserDao.listAll();
	}

	@Override
	public void update(TradeUser tradeUser) {
		tradeUserDao.update(tradeUser);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TradeUser getBy(String field, Object value) {
		return tradeUserDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeUser getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeUserDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeUser getByAnd(String field1, Object value1, String field2, Object value2, String field3, Object value3) {
		return tradeUserDao.getByAnd(field1, value1, field2, value2, field3, value3);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeUser getByOr(String field1, Object value1, String field2, Object value2) {
		return tradeUserDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> listBy(String field, Object value) {
		return tradeUserDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeUserDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradeUserDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> pageBy(String field, Object value, Pager page) {
		return tradeUserDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeUserDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeUserDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		tradeUserDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		tradeUserDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeUserDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2, String field3, Object value3) {
		return tradeUserDao.countByAnd(field1, value1, field2, value2, field3, value3);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return tradeUserDao.countByOr(field1, value1, field2, value2);
	}

	@Override
	public TradeUser get(String userID, TradeUserType userType) {
		return tradeUserDao.get(userID, userType);
	}

	@Override
	public JsonResult activatePayment(String userID, TradeUserType userType) {
		TradeUser tradeUser = tradeUserDao.get(userID, userType);
		if (CommonUtil.checkTradeUserActive(tradeUser) == AccountActiveStatus.ACTIVE) {
			if (CommonUtil.checkTradeUserPayment(tradeUser) == TradePayment.NOTALLOWPAY) {
				tradeUser.setIsAllowPay(TradePayment.ALLOWPAY.getValue());
				tradeUserDao.update(tradeUser);
			}
		}
		return new JsonResult();
	}

	@Override
	public JsonResult frozePayment(String userID, TradeUserType userType) {
		TradeUser tradeUser = tradeUserDao.get(userID, userType);
		if (CommonUtil.checkTradeUserActive(tradeUser) == AccountActiveStatus.ACTIVE) {
			if (CommonUtil.checkTradeUserPayment(tradeUser) == TradePayment.ALLOWPAY) {
				tradeUser.setIsAllowPay(TradePayment.NOTALLOWPAY.getValue());
				tradeUserDao.update(tradeUser);
			}
		}
		return new JsonResult();
	}

	@Override
	public TradeUser getByOrderNO(String orderNO, TradeType tradeType) {
		TradeDetail tradeDetail = tradeDetailDao.getByAnd("orderNO", orderNO, "tradeType", tradeType.getName());
		TradeUser tradeUser = get(tradeDetail.getPartyTradeUserID());
		if (tradeUser == null) {
			throw new BussException("未找到订单详情信息");
		}
		return tradeUser;
	}
}
