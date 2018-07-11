package com.simba.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.controller.form.PayBillSearchForm;
import com.simba.dao.PayBillDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.PayBill;

/**
 * 支付账单 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class PayBillDaoImpl implements PayBillDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "payBill";

	@Override
	public void add(PayBill payBill) {
		String sql = "insert into " + table
				+ "( appid, mchId, deviceInfo, productDesc, detail, attach, outTradeNo, fee, clientIp, startTime, endTime, goodsTag, notifyUrl, tradeType, productId, openid, status, errMsg, prepayId, codeUrl, mwebUrl, createTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, payBill.getAppid(), payBill.getMchId(), payBill.getDeviceInfo(), payBill.getProductDesc(), payBill.getDetail(), payBill.getAttach(), payBill.getOutTradeNo(),
				payBill.getFee(), payBill.getClientIp(), payBill.getStartTime(), payBill.getEndTime(), payBill.getGoodsTag(), payBill.getNotifyUrl(), payBill.getTradeType(), payBill.getProductId(),
				payBill.getOpenid(), payBill.getStatus(), payBill.getErrMsg(), payBill.getPrepayId(), payBill.getCodeUrl(), payBill.getMwebUrl(), payBill.getCreateTime());
	}

	@Override
	public void update(PayBill payBill) {
		String sql = "update " + table
				+ " set  appid = ? , mchId = ? , deviceInfo = ? , productDesc = ? , detail = ? , attach = ? , outTradeNo = ? , fee = ? , clientIp = ? , startTime = ? , endTime = ? , goodsTag = ? , notifyUrl = ? , tradeType = ? , productId = ? , openid = ? , status = ? , errMsg = ? , prepayId = ? , codeUrl = ? , mwebUrl = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, payBill.getAppid(), payBill.getMchId(), payBill.getDeviceInfo(), payBill.getProductDesc(), payBill.getDetail(), payBill.getAttach(), payBill.getOutTradeNo(),
				payBill.getFee(), payBill.getClientIp(), payBill.getStartTime(), payBill.getEndTime(), payBill.getGoodsTag(), payBill.getNotifyUrl(), payBill.getTradeType(), payBill.getProductId(),
				payBill.getOpenid(), payBill.getStatus(), payBill.getErrMsg(), payBill.getPrepayId(), payBill.getCodeUrl(), payBill.getMwebUrl(), payBill.getCreateTime(), payBill.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<PayBill> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, PayBill.class, page);
	}

	@Override
	public List<PayBill> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, PayBill.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public PayBill get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, PayBill.class, id);
	}

	@Override
	public PayBill getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, PayBill.class, value);
	}

	@Override
	public PayBill getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, PayBill.class, value1, value2);
	}

	@Override
	public PayBill getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, PayBill.class, value1, value2);
	}

	@Override
	public List<PayBill> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, PayBill.class, value);
	}

	@Override
	public List<PayBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, PayBill.class, value1, value2);
	}

	@Override
	public List<PayBill> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, PayBill.class, value1, value2);
	}

	@Override
	public List<PayBill> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, PayBill.class, page, param);
	}

	@Override
	public List<PayBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PayBill.class, page, param);
	}

	@Override
	public List<PayBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PayBill.class, page, param);
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
	public List<PayBill> page(PayBillSearchForm searchForm, Pager pager) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, PayBill.class, pager, param);
	}

	@Override
	public Long count(PayBillSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, PayBillSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getStatus())) {
			sql += " and status = ? ";
			param.setString(searchForm.getStatus());
		}
		if (StringUtils.isNotEmpty(searchForm.getOutTradeNo())) {
			sql += " and outTradeNo = ? ";
			param.setString(searchForm.getOutTradeNo());
		}
		if (StringUtils.isNotEmpty(searchForm.getGoodsTag())) {
			sql += " and goodsTag = ? ";
			param.setString(searchForm.getGoodsTag());
		}
		if (StringUtils.isNotEmpty(searchForm.getTradeType())) {
			sql += " and tradeType = ? ";
			param.setString(searchForm.getTradeType());
		}
		if (StringUtils.isNotEmpty(searchForm.getProductId())) {
			sql += " and productId = ? ";
			param.setString(searchForm.getProductId());
		}
		if (StringUtils.isNotEmpty(searchForm.getOpenid())) {
			sql += " and openid = ? ";
			param.setString(searchForm.getOpenid());
		}
		if (StringUtils.isNotEmpty(searchForm.getPrepayId())) {
			sql += " and prepayId = ? ";
			param.setString(searchForm.getPrepayId());
		}
		return sql;
	}

	@Override
	public List<PayBill> listUnfinish() {
		String sql = "select * from " + table + " where status in (?,?,?) and createTime > ? and createTime < ? ";
		StatementParameter params = new StatementParameter();
		params.setString("NOTPAY");
		params.setString("USERPAYING");
		params.setString("REFUND");
		Date now = new Date();
		params.setDate(DateUtils.addDays(now, -3));
		params.setDate(now);
		return jdbc.queryForList(sql, PayBill.class, params);
	}
}
