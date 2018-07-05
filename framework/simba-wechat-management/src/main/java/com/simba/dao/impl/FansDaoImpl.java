package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.simba.dao.FansDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Fans;
import com.simba.model.form.FansSearchForm;

/**
 * 粉丝 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class FansDaoImpl implements FansDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "fans";

	@Override
	public int add(Fans fans) {
		String sql = "insert into " + table + "( openid, remark, nickname, sex, city, province, country, headimgurl, subscribeTime) values(?,?,?,?,?,?,?,?,?)";
		Number id = jdbc.updateForGeneratedKey(sql, fans.getOpenid(), fans.getRemark(), fans.getNickname(), fans.getSex(), fans.getCity(), fans.getProvince(), fans.getCountry(), fans.getHeadimgurl(),
				fans.getSubscribeTime());
		fans.setId(id.intValue());
		return fans.getId();
	}

	@Override
	@CacheEvict(cacheNames = "fans", key = "#p0.getId()")
	public void update(Fans fans) {
		String sql = "update " + table + " set  openid = ? , remark = ? , nickname = ? , sex = ? , city = ? , province = ? , country = ? , headimgurl = ? , subscribeTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, fans.getOpenid(), fans.getRemark(), fans.getNickname(), fans.getSex(), fans.getCity(), fans.getProvince(), fans.getCountry(), fans.getHeadimgurl(),
				fans.getSubscribeTime(), fans.getId());
	}

	@Override
	@CacheEvict(cacheNames = "fans", key = "#p0")
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Fans> page(Pager page) {
		String sql = "select * from " + table + " order by subscribeTime desc";
		return jdbc.queryForPage(sql, Fans.class, page);
	}

	@Override
	public List<Fans> listAll() {
		String sql = "select * from " + table + " order by subscribeTime desc";
		return jdbc.queryForList(sql, Fans.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	@Cacheable(cacheNames = "fans", key = "#p0")
	public Fans get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Fans.class, id);
	}

	@Override
	public Fans getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Fans.class, value);
	}

	@Override
	public Fans getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Fans.class, value1, value2);
	}

	@Override
	public Fans getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Fans.class, value1, value2);
	}

	@Override
	public List<Fans> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by subscribeTime desc";
		return jdbc.queryForList(sql, Fans.class, value);
	}

	@Override
	public List<Fans> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by subscribeTime desc";
		return jdbc.queryForList(sql, Fans.class, value1, value2);
	}

	@Override
	public List<Fans> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by subscribeTime desc";
		return jdbc.queryForList(sql, Fans.class, value1, value2);
	}

	@Override
	public List<Fans> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by subscribeTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Fans.class, page, param);
	}

	@Override
	public List<Fans> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by subscribeTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Fans.class, page, param);
	}

	@Override
	public List<Fans> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by subscribeTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Fans.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteByOpenid(String openid) {
		String sql = "delete from " + table + "  where openid = ? ";
		jdbc.updateForBoolean(sql, openid);
	}

	@Override
	public List<String> listAllOpenids() {
		String sql = "select openid from " + table;
		return jdbc.queryForStrings(sql);
	}

	@Override
	public List<Fans> page(Pager pager, FansSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by subscribeTime desc";
		return jdbc.queryForPage(sql, Fans.class, pager, param);
	}

	private String buildCondition(String sql, FansSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getOpenid())) {
			sql += " and openid like '%" + searchForm.getOpenid() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getNickname())) {
			sql += " and nickname like '%" + searchForm.getNickname() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getRemark())) {
			sql += " and remark like '%" + searchForm.getRemark() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and subscribeTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and subscribeTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		return sql;
	}

	@Override
	public int count(FansSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	@Override
	public void updateRemark(int id, String remark) {
		String sql = "update " + table + " set remark = ? where id = ? ";
		jdbc.updateForBoolean(sql, remark, id);
	}

}
