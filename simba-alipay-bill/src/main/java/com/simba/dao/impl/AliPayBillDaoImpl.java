package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.alipay.enums.TradeStatus;
import com.simba.dao.AliPayBillDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.AliPayBill;
import com.simba.model.form.AliPayBillSearchForm;

/**
 * 阿里支付账单 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class AliPayBillDaoImpl implements AliPayBillDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "aliPayBill";

	@Override
	public void add(AliPayBill aliPayBill) {
		String sql = "insert into " + table
				+ "( appid, body, totalAmount, subject, outTradeNo, tradeNo, productCode, goodType, storeId, sellId, timeoutExpress, createTime,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, aliPayBill.getAppid(), aliPayBill.getBody(), aliPayBill.getTotalAmount(), aliPayBill.getSubject(), aliPayBill.getOutTradeNo(), aliPayBill.getTradeNo(),
				aliPayBill.getProductCode(), aliPayBill.getGoodType(), aliPayBill.getStoreId(), aliPayBill.getSellId(), aliPayBill.getTimeoutExpress(), aliPayBill.getCreateTime(),
				aliPayBill.getStatus());
	}

	@Override
	public void update(AliPayBill aliPayBill) {
		String sql = "update " + table
				+ " set  appid = ? , body = ? , totalAmount = ? , subject = ? , outTradeNo = ? , tradeNo = ? , productCode = ? , goodType = ? , storeId = ? , sellId = ? , timeoutExpress = ? , createTime = ? , status =? where id = ?  ";
		jdbc.updateForBoolean(sql, aliPayBill.getAppid(), aliPayBill.getBody(), aliPayBill.getTotalAmount(), aliPayBill.getSubject(), aliPayBill.getOutTradeNo(), aliPayBill.getTradeNo(),
				aliPayBill.getProductCode(), aliPayBill.getGoodType(), aliPayBill.getStoreId(), aliPayBill.getSellId(), aliPayBill.getTimeoutExpress(), aliPayBill.getCreateTime(),
				aliPayBill.getStatus(), aliPayBill.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<AliPayBill> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, AliPayBill.class, page);
	}

	@Override
	public List<AliPayBill> page(Pager page, AliPayBillSearchForm aliPayBillSearchForm) {
		String sql = "select * from " + table+" order by createTime desc";
		StatementParameter param = new StatementParameter();
		return jdbc.queryForPage(buildCondition(sql, aliPayBillSearchForm, param), AliPayBill.class, page, param);
	}

	@Override
	public List<AliPayBill> listAll() {
		String sql = "select * from " + table+" order by createTime desc";
		return jdbc.queryForList(sql, AliPayBill.class);
	}

	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public Long count(AliPayBillSearchForm aliPayBillSearchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForLong(buildCondition(sql, aliPayBillSearchForm, param), param);
	}

	@Override
	public AliPayBill get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, AliPayBill.class, id);
	}

	@Override
	public AliPayBill getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, AliPayBill.class, value);
	}

	@Override
	public AliPayBill getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, AliPayBill.class, value1, value2);
	}

	@Override
	public AliPayBill getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, AliPayBill.class, value1, value2);
	}

	@Override
	public List<AliPayBill> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, AliPayBill.class, value);
	}

	@Override
	public List<AliPayBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, AliPayBill.class, value1, value2);
	}

	@Override
	public List<AliPayBill> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, AliPayBill.class, value1, value2);
	}

	@Override
	public List<AliPayBill> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, AliPayBill.class, page, param);
	}

	@Override
	public List<AliPayBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, AliPayBill.class, page, param);
	}

	@Override
	public List<AliPayBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, AliPayBill.class, page, param);
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

	private String buildCondition(String sql, AliPayBillSearchForm aliPayBillSearchForm, StatementParameter param) {
		sql += " where 1 = 1";
		if (aliPayBillSearchForm.getProductCode() != null && StringUtils.isNotEmpty(aliPayBillSearchForm.getProductCode() + "")) {
			sql += " and productCode  = ?";
			param.set(aliPayBillSearchForm.getProductCode());
		}
		if (aliPayBillSearchForm.getOurTradeNo() != null && StringUtils.isNotEmpty(aliPayBillSearchForm.getOurTradeNo() + "")) {
			sql += " and ourTradeNo  = ?";
			param.set(aliPayBillSearchForm.getOurTradeNo());
		}
		if (aliPayBillSearchForm.getStatus() != null && StringUtils.isNotEmpty(aliPayBillSearchForm.getStatus() + "")) {
			sql += " and status  = ?";
			param.set(aliPayBillSearchForm.getStatus());
		}
		if (aliPayBillSearchForm.getTradeNo() != null && StringUtils.isNotEmpty(aliPayBillSearchForm.getTradeNo() + "")) {
			sql += " and tradeNo  = ?";
			param.set(aliPayBillSearchForm.getTradeNo());
		}
		if (aliPayBillSearchForm.getStartCreateTime() != null && StringUtils.isNotEmpty(aliPayBillSearchForm.getStartCreateTime() + "")) {
			sql += " and createTime  >= ?";
			param.set(aliPayBillSearchForm.getStartCreateTime());
		}
		if (aliPayBillSearchForm.getEndCreateTime() != null && StringUtils.isNotEmpty(aliPayBillSearchForm.getEndCreateTime() + "")) {
			sql += " and createTime  <= ?";
			param.set(aliPayBillSearchForm.getEndCreateTime());
		}
		sql += " order by createTime desc";
		return sql;
	}

	@Override
	public List<AliPayBill> listUnfinish() {
		String sql = "select * from " + table + " where status in (?,?) ";
		StatementParameter params = new StatementParameter();
		params.setString(TradeStatus.PAY.getName());
		params.setString(TradeStatus.REFUND.getName());
		return jdbc.queryForList(sql, AliPayBill.class, params);
	}
}
