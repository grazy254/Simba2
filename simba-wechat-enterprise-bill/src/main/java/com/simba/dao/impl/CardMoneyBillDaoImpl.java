package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.controller.form.CardMoneyBillSearchForm;
import com.simba.dao.CardMoneyBillDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.CardMoneyBill;

/**
 * 银行卡账单 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class CardMoneyBillDaoImpl implements CardMoneyBillDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "cardMoneyBill";

	@Override
	public void add(CardMoneyBill cardMoneyBill) {
		String sql = "insert into " + table
				+ "( mchId, partnerTradeNo, bankNo, trueName, bankCode, amount, description, status, errMsg, paymentNo, cmmsAmt, createTime, createUser) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, cardMoneyBill.getMchId(), cardMoneyBill.getPartnerTradeNo(), cardMoneyBill.getBankNo(), cardMoneyBill.getTrueName(), cardMoneyBill.getBankCode(),
				cardMoneyBill.getAmount(), cardMoneyBill.getDescription(), cardMoneyBill.getStatus(), cardMoneyBill.getErrMsg(), cardMoneyBill.getPaymentNo(), cardMoneyBill.getCmmsAmt(),
				cardMoneyBill.getCreateTime(), cardMoneyBill.getCreateUser());
	}

	@Override
	public void update(CardMoneyBill cardMoneyBill) {
		String sql = "update " + table
				+ " set  mchId = ? , partnerTradeNo = ? , bankNo = ? , trueName = ? , bankCode = ? , amount = ? , description = ? , status = ? , errMsg = ? , paymentNo = ? , cmmsAmt = ? , createTime = ? , createUser = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, cardMoneyBill.getMchId(), cardMoneyBill.getPartnerTradeNo(), cardMoneyBill.getBankNo(), cardMoneyBill.getTrueName(), cardMoneyBill.getBankCode(),
				cardMoneyBill.getAmount(), cardMoneyBill.getDescription(), cardMoneyBill.getStatus(), cardMoneyBill.getErrMsg(), cardMoneyBill.getPaymentNo(), cardMoneyBill.getCmmsAmt(),
				cardMoneyBill.getCreateTime(), cardMoneyBill.getCreateUser(), cardMoneyBill.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<CardMoneyBill> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, CardMoneyBill.class, page);
	}

	@Override
	public List<CardMoneyBill> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, CardMoneyBill.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public CardMoneyBill get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, CardMoneyBill.class, id);
	}

	@Override
	public CardMoneyBill getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, CardMoneyBill.class, value);
	}

	@Override
	public CardMoneyBill getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, CardMoneyBill.class, value1, value2);
	}

	@Override
	public CardMoneyBill getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, CardMoneyBill.class, value1, value2);
	}

	@Override
	public List<CardMoneyBill> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, CardMoneyBill.class, value);
	}

	@Override
	public List<CardMoneyBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, CardMoneyBill.class, value1, value2);
	}

	@Override
	public List<CardMoneyBill> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, CardMoneyBill.class, value1, value2);
	}

	@Override
	public List<CardMoneyBill> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, CardMoneyBill.class, page, param);
	}

	@Override
	public List<CardMoneyBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, CardMoneyBill.class, page, param);
	}

	@Override
	public List<CardMoneyBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, CardMoneyBill.class, page, param);
	}

	@Override
	public Long countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForLong(sql, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

	@Override
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}

	@Override
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "delete from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "delete from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}

	@Override
	public List<CardMoneyBill> page(CardMoneyBillSearchForm searchForm, Pager pager) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, CardMoneyBill.class, pager, param);
	}

	@Override
	public Long count(CardMoneyBillSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, CardMoneyBillSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getBankNo())) {
			sql += " and bankNo = ? ";
			param.setString(searchForm.getBankNo());
		}
		if (StringUtils.isNotEmpty(searchForm.getPartnerTradeNo())) {
			sql += " and partnerTradeNo = ? ";
			param.setString(searchForm.getPartnerTradeNo());
		}
		if (StringUtils.isNotEmpty(searchForm.getTrueName())) {
			sql += " and trueName = ? ";
			param.setString(searchForm.getTrueName());
		}
		if (StringUtils.isNotEmpty(searchForm.getStatus())) {
			sql += " and status = ? ";
			param.setString(searchForm.getStatus());
		}
		if (StringUtils.isNotEmpty(searchForm.getPaymentNo())) {
			sql += " and paymentNo = ? ";
			param.setString(searchForm.getPaymentNo());
		}
		return sql;
	}
}
