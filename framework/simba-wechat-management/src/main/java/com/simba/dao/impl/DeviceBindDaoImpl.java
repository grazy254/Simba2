package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.DeviceBindDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.DeviceBind;
import com.simba.model.form.DeviceBindSearchForm;

/**
 * 设备绑定 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class DeviceBindDaoImpl implements DeviceBindDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "deviceBind";

	@Override
	public void add(DeviceBind deviceBind) {
		String sql = "insert into " + table + "( openid, wxDeviceId, createTime) values(?,?,?)";
		jdbc.updateForBoolean(sql, deviceBind.getOpenid(), deviceBind.getWxDeviceId(), deviceBind.getCreateTime());
	}

	@Override
	public void update(DeviceBind deviceBind) {
		String sql = "update " + table + " set  openid = ? , wxDeviceId = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, deviceBind.getOpenid(), deviceBind.getWxDeviceId(), deviceBind.getCreateTime(), deviceBind.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<DeviceBind> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, DeviceBind.class, page);
	}

	@Override
	public List<DeviceBind> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, DeviceBind.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public DeviceBind get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, DeviceBind.class, id);
	}

	@Override
	public DeviceBind getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, DeviceBind.class, value);
	}

	@Override
	public DeviceBind getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, DeviceBind.class, value1, value2);
	}

	@Override
	public DeviceBind getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, DeviceBind.class, value1, value2);
	}

	@Override
	public List<DeviceBind> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, DeviceBind.class, value);
	}

	@Override
	public List<DeviceBind> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, DeviceBind.class, value1, value2);
	}

	@Override
	public List<DeviceBind> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, DeviceBind.class, value1, value2);
	}

	@Override
	public List<DeviceBind> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, DeviceBind.class, page, param);
	}

	@Override
	public List<DeviceBind> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DeviceBind.class, page, param);
	}

	@Override
	public List<DeviceBind> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, DeviceBind.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

	@Override
	public int count(DeviceBindSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	@Override
	public List<DeviceBind> page(Pager pager, DeviceBindSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, DeviceBind.class, pager, param);
	}

	private String buildCondition(String sql, DeviceBindSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getOpenid())) {
			sql += " and openid = ? ";
			param.setString(searchForm.getOpenid());
		}
		if (StringUtils.isNoneEmpty(searchForm.getWxDeviceId())) {
			sql += " and wxDeviceId = ? ";
			param.setString(searchForm.getWxDeviceId());
		}
		return sql;
	}

	@Override
	public void unbind(String openid, String wxDeviceId) {
		String sql = "delete from " + table + " where openid = ? and wxDeviceId = ? ";
		jdbc.updateForBoolean(sql, openid, wxDeviceId);
	}

}
