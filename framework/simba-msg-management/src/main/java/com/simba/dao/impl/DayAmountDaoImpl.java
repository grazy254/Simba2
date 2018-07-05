package com.simba.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.DayAmountDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.DayAmount;
import com.simba.model.TotalDayAmountBean;

/**
 * Dao实现类
 *
 * @author caozj
 */
@Repository
public class DayAmountDaoImpl implements DayAmountDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "dayAmount";

	@Override
	public void add(DayAmount dayAmount) {
		String sql = "insert into " + table + "( dayDate, amount, projectId) values(?,?,?)";
		jdbc.updateForBoolean(sql, dayAmount.getDayDate(), dayAmount.getAmount(), dayAmount.getProjectId());
	}

	@Override
	public void update(DayAmount dayAmount) {
		String sql = "update " + table + " set  dayDate = ? , amount = ? , projectId = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, dayAmount.getDayDate(), dayAmount.getAmount(), dayAmount.getProjectId(), dayAmount.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<DayAmount> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, DayAmount.class, page);
	}

	@Override
	public List<DayAmount> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, DayAmount.class);
	}

	@Override
	public Long count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql);
	}

	@Override
	public DayAmount get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, DayAmount.class, id);
	}

	@Override
	public DayAmount getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, DayAmount.class, value);
	}

	@Override
	public DayAmount getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, DayAmount.class, value1, value2);
	}

	@Override
	public DayAmount getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, DayAmount.class, value1, value2);
	}

	@Override
	public List<DayAmount> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, DayAmount.class, value);
	}

	@Override
	public List<DayAmount> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, DayAmount.class, value1, value2);
	}

	@Override
	public List<DayAmount> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, DayAmount.class, value1, value2);
	}

	@Override
	public List<DayAmount> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, DayAmount.class, page, param);
	}

	@Override
	public List<DayAmount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DayAmount.class, page, param);
	}

	@Override
	public List<DayAmount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DayAmount.class, page, param);
	}

	@Override
	public DayAmount getLatest() {
		String sql = "SELECT * FROM " + table + "ORDER BY dayDate DESC LIMIT 1";
		return jdbc.query(sql, DayAmount.class);
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
	public List<TotalDayAmountBean> getTotalAmountList(Date startTime, Date endTime) {
		String sql = "SELECT SUM(amount) AS total,dayDate FROM " + table + " WHERE dayDate >= ? AND dayDate <= ? GROUP BY dayDate ORDER BY dayDate ASC";
		StatementParameter param = new StatementParameter();
		param.set(startTime);
		param.set(endTime);
		return jdbc.queryForList(sql, TotalDayAmountBean.class, param);
	}

	@Override
	public List<DayAmount> getProjectAmountList(Date startTime, Date endTime, int projectId) {
		String sql = "SELECT * FROM " + table + " WHERE dayDate >= ? AND dayDate <= ? AND projectId= ? ORDER BY dayDate ASC";
		StatementParameter param = new StatementParameter();
		param.set(startTime);
		param.set(endTime);
		param.set(projectId);
		return jdbc.queryForList(sql, DayAmount.class, param);
	}

}
