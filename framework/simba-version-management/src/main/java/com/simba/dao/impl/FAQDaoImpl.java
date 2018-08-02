package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.FAQDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.FAQ;
import com.simba.model.form.FAQSearchForm;

/**
 * 常见问题管理 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class FAQDaoImpl implements FAQDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "fAQ";

	@Override
	public void add(FAQ fAQ) {
		String sql = "insert into " + table + "( title, text, type, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, fAQ.getTitle(), fAQ.getText(), fAQ.getType(), fAQ.getCreateTime());
	}

	@Override
	public void update(FAQ fAQ) {
		String sql = "update " + table + " set  title = ? , text = ? , type = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, fAQ.getTitle(), fAQ.getText(), fAQ.getType(), fAQ.getCreateTime(), fAQ.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<FAQ> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, FAQ.class, page);
	}

	@Override
	public List<FAQ> page(Pager page, FAQSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, FAQ.class, page, param);
	}

	@Override
	public List<FAQ> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, FAQ.class);
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public FAQ get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, FAQ.class, id);
	}

	@Override
	public FAQ getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, FAQ.class, value);
	}

	@Override
	public FAQ getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, FAQ.class, value1, value2);
	}

	@Override
	public FAQ getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, FAQ.class, value1, value2);
	}

	@Override
	public List<FAQ> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, FAQ.class, value);
	}

	@Override
	public List<FAQ> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, FAQ.class, value1, value2);
	}

	@Override
	public List<FAQ> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, FAQ.class, value1, value2);
	}

	@Override
	public List<FAQ> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, FAQ.class, page, param);
	}

	@Override
	public List<FAQ> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FAQ.class, page, param);
	}

	@Override
	public List<FAQ> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, FAQ.class, page, param);
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

	private String buildCondition(String sql, FAQSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (searchForm.getType() != null && searchForm.getType() > 0) {
			sql += " and type = ? ";
			param.setInt(searchForm.getType());
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
	public Integer count(FAQSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

}
