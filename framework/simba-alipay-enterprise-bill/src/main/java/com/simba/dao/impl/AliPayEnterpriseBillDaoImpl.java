package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.AliPayEnterpriseBillDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.AliPayEnterpriseBill;

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
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, AliPayEnterpriseBill.class, page);
	}

	@Override
	public List<AliPayEnterpriseBill> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class);
	}

	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
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
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class, value);
	}

	@Override
	public List<AliPayEnterpriseBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class, value1, value2);
	}

	@Override
	public List<AliPayEnterpriseBill> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, AliPayEnterpriseBill.class, value1, value2);
	}

	@Override
	public List<AliPayEnterpriseBill> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, AliPayEnterpriseBill.class, page, param);
	}

	@Override
	public List<AliPayEnterpriseBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, AliPayEnterpriseBill.class, page, param);
	}

	@Override
	public List<AliPayEnterpriseBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
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
}
