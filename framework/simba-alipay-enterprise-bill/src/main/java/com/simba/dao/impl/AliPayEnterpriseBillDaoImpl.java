package com.simba.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.AliPayEnterpriseBillDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.AliPayEnterpriseBill;
import com.simba.model.form.AliPayEnterpriseBillSearchForm;

/**
 * 支付宝企业支付账单 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class AliPayEnterpriseBillDaoImpl implements AliPayEnterpriseBillDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "aliPayEnterpriseBill";

	@Override
	public void add(AliPayEnterpriseBill aliPayEnterpriseBill) {
		String sql = "insert into " + table
				+ "( outBizNo, payType, account, amount, payerName, peyeeName, remark, orderId, payDate, createTime, createUser, status, reason, orderFee) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, aliPayEnterpriseBill.getOutBizNo(), aliPayEnterpriseBill.getPayType(), aliPayEnterpriseBill.getAccount(), aliPayEnterpriseBill.getAmount(),
				aliPayEnterpriseBill.getPayerName(), aliPayEnterpriseBill.getPeyeeName(), aliPayEnterpriseBill.getRemark(), aliPayEnterpriseBill.getOrderId(), aliPayEnterpriseBill.getPayDate(),
				aliPayEnterpriseBill.getCreateTime(), aliPayEnterpriseBill.getCreateUser(), aliPayEnterpriseBill.getStatus(), aliPayEnterpriseBill.getReason(), aliPayEnterpriseBill.getOrderFee());
	}

	@Override
	public void update(AliPayEnterpriseBill aliPayEnterpriseBill) {
		String sql = "update " + table
				+ " set  outBizNo = ? , payType = ? , account = ? , amount = ? , payerName = ? , peyeeName = ? , remark = ? , orderId = ? , payDate = ? , createTime = ? , createUser = ? , status = ? , reason = ? , orderFee = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, aliPayEnterpriseBill.getOutBizNo(), aliPayEnterpriseBill.getPayType(), aliPayEnterpriseBill.getAccount(), aliPayEnterpriseBill.getAmount(),
				aliPayEnterpriseBill.getPayerName(), aliPayEnterpriseBill.getPeyeeName(), aliPayEnterpriseBill.getRemark(), aliPayEnterpriseBill.getOrderId(), aliPayEnterpriseBill.getPayDate(),
				aliPayEnterpriseBill.getCreateTime(), aliPayEnterpriseBill.getCreateUser(), aliPayEnterpriseBill.getStatus(), aliPayEnterpriseBill.getReason(), aliPayEnterpriseBill.getOrderFee(),
				aliPayEnterpriseBill.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<AliPayEnterpriseBill> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, AliPayEnterpriseBill.class, page);
	}

	@Override
	public List<AliPayEnterpriseBill> page(Pager page, AliPayEnterpriseBillSearchForm aliPayEnterpriseBillSearchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForPage(buildCondition(sql, aliPayEnterpriseBillSearchForm, param) + " order by createTime desc", AliPayEnterpriseBill.class, page, param);
	}

	@Override
	public List<AliPayEnterpriseBill> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class);
	}

	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public Long count(AliPayEnterpriseBillSearchForm aliPayEnterpriseBillSearchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		return jdbc.queryForLong(buildCondition(sql, aliPayEnterpriseBillSearchForm, param), param);
	}

	@Override
	public AliPayEnterpriseBill get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, AliPayEnterpriseBill.class, id);
	}

	@Override
	public AliPayEnterpriseBill getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, AliPayEnterpriseBill.class, value);
	}

	@Override
	public AliPayEnterpriseBill getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, AliPayEnterpriseBill.class, value1, value2);
	}

	@Override
	public AliPayEnterpriseBill getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, AliPayEnterpriseBill.class, value1, value2);
	}

	@Override
	public List<AliPayEnterpriseBill> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class, value);
	}

	@Override
	public List<AliPayEnterpriseBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class, value1, value2);
	}

	@Override
	public List<AliPayEnterpriseBill> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class, value1, value2);
	}

	@Override
	public List<AliPayEnterpriseBill> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, AliPayEnterpriseBill.class, page, param);
	}

	@Override
	public List<AliPayEnterpriseBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, AliPayEnterpriseBill.class, page, param);
	}

	@Override
	public List<AliPayEnterpriseBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, AliPayEnterpriseBill.class, page, param);
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

	private String buildCondition(String sql, AliPayEnterpriseBillSearchForm aliPayEnterpriseBillSearchForm, StatementParameter param) {
		sql += " where 1 = 1";
		if (aliPayEnterpriseBillSearchForm.getStatus() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getStatus() + "")) {
			sql += " and status  = ?";
			param.set(aliPayEnterpriseBillSearchForm.getStatus());
		}
		if (aliPayEnterpriseBillSearchForm.getOutBizNo() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getOutBizNo() + "")) {
			sql += " and outBizNo  = ?";
			param.set(aliPayEnterpriseBillSearchForm.getOutBizNo());
		}
		if (aliPayEnterpriseBillSearchForm.getPayType() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getPayType() + "")) {
			sql += " and payType  = ?";
			param.set(aliPayEnterpriseBillSearchForm.getPayType());
		}
		if (aliPayEnterpriseBillSearchForm.getAccount() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getAccount() + "")) {
			sql += " and account  = ?";
			param.set(aliPayEnterpriseBillSearchForm.getAccount());
		}
		if (aliPayEnterpriseBillSearchForm.getPeyeeName() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getPeyeeName() + "")) {
			sql += " and peyeeName  = ?";
			param.set(aliPayEnterpriseBillSearchForm.getPeyeeName());
		}
		if (aliPayEnterpriseBillSearchForm.getOrderId() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getOrderId() + "")) {
			sql += " and orderId  = ?";
			param.set(aliPayEnterpriseBillSearchForm.getOrderId());
		}
		if (aliPayEnterpriseBillSearchForm.getCreateUser() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getCreateUser() + "")) {
			sql += " and createUser  = ?";
			param.set(aliPayEnterpriseBillSearchForm.getCreateUser());
		}
		if (aliPayEnterpriseBillSearchForm.getStartCreateTime() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getStartCreateTime() + "")) {
			sql += " and createTime  >= ?";
			param.set(aliPayEnterpriseBillSearchForm.getStartCreateTime());
		}
		if (aliPayEnterpriseBillSearchForm.getEndCreateTime() != null && StringUtils.isNotEmpty(aliPayEnterpriseBillSearchForm.getEndCreateTime() + "")) {
			sql += " and createTime  <= ?";
			param.set(aliPayEnterpriseBillSearchForm.getEndCreateTime());
		}
		return sql;
	}

	@Override
	public List<AliPayEnterpriseBill> listAllUnfinish() {
		String sql = "select * from " + table + " where status in (?,?,?) and createTime > ? and createTime < ?";
		StatementParameter params = new StatementParameter();
		params.setString("INIT");
		params.setString("DEALING");
		params.setString("UNKNOWN");
		Date now = new Date();
		params.setDate(DateUtils.addDays(now, -3));
		params.setDate(now);
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class, params);
	}
}
