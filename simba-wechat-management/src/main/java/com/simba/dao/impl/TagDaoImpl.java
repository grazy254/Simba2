package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TagDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Tag;

/**
 * 标签 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class TagDaoImpl implements TagDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tag";

	@Override
	public void add(Tag tag) {
		String sql = "insert into " + table + "( name, wxTagId) values(?,?)";
		jdbc.updateForBoolean(sql, tag.getName(), tag.getWxTagId());
	}

	@Override
	public void update(Tag tag) {
		String sql = "update " + table + " set  name = ? , wxTagId = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, tag.getName(), tag.getWxTagId(), tag.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Tag> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Tag.class, page);
	}

	@Override
	public List<Tag> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Tag.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public Tag get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Tag.class, id);
	}

	@Override
	public Tag getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Tag.class, value);
	}

	@Override
	public Tag getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Tag.class, value1, value2);
	}

	@Override
	public Tag getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Tag.class, value1, value2);
	}

	@Override
	public List<Tag> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Tag.class, value);
	}

	@Override
	public List<Tag> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Tag.class, value1, value2);
	}

	@Override
	public List<Tag> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Tag.class, value1, value2);
	}

	@Override
	public List<Tag> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Tag.class, page, param);
	}

	@Override
	public List<Tag> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Tag.class, page, param);
	}

	@Override
	public List<Tag> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Tag.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteByWxTagId(int wxTagId) {
		String sql = "delete from " + table + " where wxTagId = ? ";
		jdbc.updateForBoolean(sql, wxTagId);
	}

	@Override
	public List<Integer> listAllWxTagIds() {
		String sql = "select wxTagId from " + table;
		return jdbc.queryForInts(sql);
	}

	@Override
	public void updateName(Tag tag) {
		String sql = "update " + table + " set  name = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, tag.getName(), tag.getId());
	}

}
