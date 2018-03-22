package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.controller.form.LooseMoneyBillSearchForm;
import com.simba.dao.LooseMoneyBillDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.LooseMoneyBill;

/**
 * 零钱账单 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class LooseMoneyBillDaoImpl implements LooseMoneyBillDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "looseMoneyBill";

	@Override
	public void add(LooseMoneyBill looseMoneyBill) {
		String sql = "insert into " + table
				+ "( appid, mchid, deviceInfo, partnerTradeNo, openid, reUserName, amount, description, clientIp, status, errMsg, paymentNo, paymentTime, createTime, createUser) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, looseMoneyBill.getAppid(), looseMoneyBill.getMchid(), looseMoneyBill.getDeviceInfo(), looseMoneyBill.getPartnerTradeNo(), looseMoneyBill.getOpenid(),
				looseMoneyBill.getReUserName(), looseMoneyBill.getAmount(), looseMoneyBill.getDescription(), looseMoneyBill.getClientIp(), looseMoneyBill.getStatus(), looseMoneyBill.getErrMsg(),
				looseMoneyBill.getPaymentNo(), looseMoneyBill.getPaymentTime(), looseMoneyBill.getCreateTime(), looseMoneyBill.getCreateUser());
	}

	@Override
	public void update(LooseMoneyBill looseMoneyBill) {
		String sql = "update " + table
				+ " set  appid = ? , mchid = ? , deviceInfo = ? , partnerTradeNo = ? , openid = ? , reUserName = ? , amount = ? , description = ? , clientIp = ? , status = ? , errMsg = ? , paymentNo = ? , paymentTime = ? , createTime = ? , createUser = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, looseMoneyBill.getAppid(), looseMoneyBill.getMchid(), looseMoneyBill.getDeviceInfo(), looseMoneyBill.getPartnerTradeNo(), looseMoneyBill.getOpenid(),
				looseMoneyBill.getReUserName(), looseMoneyBill.getAmount(), looseMoneyBill.getDescription(), looseMoneyBill.getClientIp(), looseMoneyBill.getStatus(), looseMoneyBill.getErrMsg(),
				looseMoneyBill.getPaymentNo(), looseMoneyBill.getPaymentTime(), looseMoneyBill.getCreateTime(), looseMoneyBill.getCreateUser(), looseMoneyBill.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<LooseMoneyBill> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, LooseMoneyBill.class, page);
	}

	@Override
	public List<LooseMoneyBill> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, LooseMoneyBill.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public LooseMoneyBill get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, LooseMoneyBill.class, id);
	}

	@Override
	public LooseMoneyBill getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, LooseMoneyBill.class, value);
	}

	@Override
	public LooseMoneyBill getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, LooseMoneyBill.class, value1, value2);
	}

	@Override
	public LooseMoneyBill getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, LooseMoneyBill.class, value1, value2);
	}

	@Override
	public List<LooseMoneyBill> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, LooseMoneyBill.class, value);
	}

	@Override
	public List<LooseMoneyBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, LooseMoneyBill.class, value1, value2);
	}

	@Override
	public List<LooseMoneyBill> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, LooseMoneyBill.class, value1, value2);
	}

	@Override
	public List<LooseMoneyBill> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, LooseMoneyBill.class, page, param);
	}

	@Override
	public List<LooseMoneyBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, LooseMoneyBill.class, page, param);
	}

	@Override
	public List<LooseMoneyBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, LooseMoneyBill.class, page, param);
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
	public List<LooseMoneyBill> page(LooseMoneyBillSearchForm searchForm, Pager pager) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, LooseMoneyBill.class, pager, param);
	}

	@Override
	public Long count(LooseMoneyBillSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, LooseMoneyBillSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getOpenid())) {
			sql += " and openid = ? ";
			param.setString(searchForm.getOpenid());
		}
		if (StringUtils.isNotEmpty(searchForm.getPartnerTradeNo())) {
			sql += " and partnerTradeNo = ? ";
			param.setString(searchForm.getPartnerTradeNo());
		}
		if (StringUtils.isNotEmpty(searchForm.getReUserName())) {
			sql += " and reUserName = ? ";
			param.setString(searchForm.getReUserName());
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
