package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.OpinionFeedbackDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.OpinionFeedback;
import com.simba.model.form.OpinionFeedbackSearchForm;

/**
 * 意见反馈管理 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class OpinionFeedbackDaoImpl implements OpinionFeedbackDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "opinionFeedback";

	@Override
	public void add(OpinionFeedback opinionFeedback) {
		String sql = "insert into " + table + "( userId, title, text, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, opinionFeedback.getUserId(), opinionFeedback.getTitle(), opinionFeedback.getText(), opinionFeedback.getCreateTime());
	}

	@Override
	public void update(OpinionFeedback opinionFeedback) {
		String sql = "update " + table + " set  userId = ? , title = ? , text = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, opinionFeedback.getUserId(), opinionFeedback.getTitle(), opinionFeedback.getText(), opinionFeedback.getCreateTime(), opinionFeedback.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<OpinionFeedback> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, OpinionFeedback.class, page);
	}

	// new add
	@Override
	public List<OpinionFeedback> page(Pager page, OpinionFeedbackSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, OpinionFeedback.class, page, param);
	}
	// new add!!

	@Override
	public List<OpinionFeedback> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, OpinionFeedback.class);
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public OpinionFeedback get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, OpinionFeedback.class, id);
	}

	@Override
	public OpinionFeedback getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, OpinionFeedback.class, value);
	}

	@Override
	public OpinionFeedback getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, OpinionFeedback.class, value1, value2);
	}

	@Override
	public OpinionFeedback getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, OpinionFeedback.class, value1, value2);
	}

	@Override
	public List<OpinionFeedback> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, OpinionFeedback.class, value);
	}

	@Override
	public List<OpinionFeedback> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, OpinionFeedback.class, value1, value2);
	}

	@Override
	public List<OpinionFeedback> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, OpinionFeedback.class, value1, value2);
	}

	@Override
	public List<OpinionFeedback> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, OpinionFeedback.class, page, param);
	}

	@Override
	public List<OpinionFeedback> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, OpinionFeedback.class, page, param);
	}

	@Override
	public List<OpinionFeedback> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, OpinionFeedback.class, page, param);
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

	// new add
	private String buildCondition(String sql, OpinionFeedbackSearchForm searchForm, StatementParameter param) {
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
	// new add end !!!

}
