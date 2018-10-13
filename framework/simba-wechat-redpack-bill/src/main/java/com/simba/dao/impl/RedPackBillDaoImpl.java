package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.controller.enums.RedPackBillStatus;
import com.simba.controller.form.RedPackBillSearchForm;
import com.simba.dao.RedPackBillDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.RedPackBill;

/**
 * 红包账单 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class RedPackBillDaoImpl implements RedPackBillDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "redPackBill";

	@Override
	public void add(RedPackBill redPackBill) {
		String sql = "insert into " + table
				+ "( type, billNo, mchId, appid, sendName, openid, amount, num, wishing, clientIp, actName, remark, sceneId, riskInfo, consumeMchId, status, errMsg, sendListId, createTime, createUser) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, redPackBill.getType(), redPackBill.getBillNo(), redPackBill.getMchId(), redPackBill.getAppid(), redPackBill.getSendName(), redPackBill.getOpenid(),
				redPackBill.getAmount(), redPackBill.getNum(), redPackBill.getWishing(), redPackBill.getClientIp(), redPackBill.getActName(), redPackBill.getRemark(), redPackBill.getSceneId(),
				redPackBill.getRiskInfo(), redPackBill.getConsumeMchId(), redPackBill.getStatus(), redPackBill.getErrMsg(), redPackBill.getSendListId(), redPackBill.getCreateTime(),
				redPackBill.getCreateUser());
	}

	@Override
	public void update(RedPackBill redPackBill) {
		String sql = "update " + table
				+ " set  type = ? , billNo = ? , mchId = ? , appid = ? , sendName = ? , openid = ? , amount = ? , num = ? , wishing = ? , clientIp = ? , actName = ? , remark = ? , sceneId = ? , riskInfo = ? , consumeMchId = ? , status = ? , errMsg = ? , sendListId = ? , createTime = ? , createUser = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, redPackBill.getType(), redPackBill.getBillNo(), redPackBill.getMchId(), redPackBill.getAppid(), redPackBill.getSendName(), redPackBill.getOpenid(),
				redPackBill.getAmount(), redPackBill.getNum(), redPackBill.getWishing(), redPackBill.getClientIp(), redPackBill.getActName(), redPackBill.getRemark(), redPackBill.getSceneId(),
				redPackBill.getRiskInfo(), redPackBill.getConsumeMchId(), redPackBill.getStatus(), redPackBill.getErrMsg(), redPackBill.getSendListId(), redPackBill.getCreateTime(),
				redPackBill.getCreateUser(), redPackBill.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<RedPackBill> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, RedPackBill.class, page);
	}

	@Override
	public List<RedPackBill> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, RedPackBill.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public RedPackBill get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, RedPackBill.class, id);
	}

	@Override
	public RedPackBill getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, RedPackBill.class, value);
	}

	@Override
	public RedPackBill getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, RedPackBill.class, value1, value2);
	}

	@Override
	public RedPackBill getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, RedPackBill.class, value1, value2);
	}

	@Override
	public List<RedPackBill> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, RedPackBill.class, value);
	}

	@Override
	public List<RedPackBill> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, RedPackBill.class, value1, value2);
	}

	@Override
	public List<RedPackBill> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, RedPackBill.class, value1, value2);
	}

	@Override
	public List<RedPackBill> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, RedPackBill.class, page, param);
	}

	@Override
	public List<RedPackBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, RedPackBill.class, page, param);
	}

	@Override
	public List<RedPackBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, RedPackBill.class, page, param);
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
	public List<RedPackBill> page(RedPackBillSearchForm searchForm, Pager pager) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, RedPackBill.class, pager, param);
	}

	@Override
	public Long count(RedPackBillSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForLong(sql, param);
	}

	private String buildCondition(String sql, RedPackBillSearchForm searchForm, StatementParameter param) {
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
		if (StringUtils.isNotEmpty(searchForm.getType())) {
			sql += " and type = ? ";
			param.setString(searchForm.getType());
		}
		if (StringUtils.isNotEmpty(searchForm.getBillNo())) {
			sql += " and billNo = ? ";
			param.setString(searchForm.getBillNo());
		}
		if (StringUtils.isNotEmpty(searchForm.getActName())) {
			sql += " and actName = ? ";
			param.setString(searchForm.getActName());
		}
		if (StringUtils.isNotEmpty(searchForm.getSceneId())) {
			sql += " and sceneId = ? ";
			param.setString(searchForm.getSceneId());
		}
		if (StringUtils.isNotEmpty(searchForm.getStatus())) {
			sql += " and status = ? ";
			param.setString(searchForm.getStatus());
		}
		if (StringUtils.isNotEmpty(searchForm.getSendListId())) {
			sql += " and sendListId = ? ";
			param.setString(searchForm.getSendListId());
		}
		return sql;
	}

	@Override
	public List<RedPackBill> listAllUnfinish() {
		String sql = "select * from " + table + " where status in (?,?,?)";
		StatementParameter params = new StatementParameter();
		params.setString(RedPackBillStatus.SENDING.getName());
		params.setString(RedPackBillStatus.SENT.getName());
		params.setString(RedPackBillStatus.RFUND_ING.getName());
		return jdbc.queryForList(sql, RedPackBill.class, params);
	}
}
