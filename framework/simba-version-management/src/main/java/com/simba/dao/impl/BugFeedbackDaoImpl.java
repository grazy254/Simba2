package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.BugFeedbackDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.BugFeedback;
import com.simba.model.form.BugFeedbackSearchForm;

/**
 * bug反馈管理 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class BugFeedbackDaoImpl implements BugFeedbackDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "bugFeedback";

	@Override
	public void add(BugFeedback bugFeedback) {
		String sql = "insert into " + table + "( userId, title, text, img, createTime) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, bugFeedback.getUserId(), bugFeedback.getTitle(), bugFeedback.getText(), bugFeedback.getImg(), bugFeedback.getCreateTime());
	}

	@Override
	public void update(BugFeedback bugFeedback) {
		String sql = "update " + table + " set  userId = ? , title = ? , text = ? , img = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, bugFeedback.getUserId(), bugFeedback.getTitle(), bugFeedback.getText(), bugFeedback.getImg(), bugFeedback.getCreateTime(), bugFeedback.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<BugFeedback> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, BugFeedback.class, page);
	}

	@Override
	public List<BugFeedback> page(Pager page, BugFeedbackSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, BugFeedback.class, page, param);
	}

	@Override
	public List<BugFeedback> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, BugFeedback.class);
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public BugFeedback get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, BugFeedback.class, id);
	}

	@Override
	public BugFeedback getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, BugFeedback.class, value);
	}

	@Override
	public BugFeedback getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, BugFeedback.class, value1, value2);
	}

	@Override
	public BugFeedback getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, BugFeedback.class, value1, value2);
	}

	@Override
	public List<BugFeedback> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, BugFeedback.class, value);
	}

	@Override
	public List<BugFeedback> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, BugFeedback.class, value1, value2);
	}

	@Override
	public List<BugFeedback> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, BugFeedback.class, value1, value2);
	}

	@Override
	public List<BugFeedback> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, BugFeedback.class, page, param);
	}

	@Override
	public List<BugFeedback> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, BugFeedback.class, page, param);
	}

	@Override
	public List<BugFeedback> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, BugFeedback.class, page, param);
	}

	@Override
	public Integer countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

	private String buildCondition(String sql, BugFeedbackSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (searchForm.getUserId() != null && searchForm.getUserId() > 0) {
			sql += " and userId = ? ";
			param.setInt(searchForm.getUserId());
		}
		if (StringUtils.isNotEmpty(searchForm.getTitle())) {
			sql += " and title like '%" + searchForm.getTitle() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getText())) {
			sql += " and text like '%" + searchForm.getText() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		return sql;
	}

	@Override
	public Integer count(BugFeedbackSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

}
