package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.simba.dao.DeviceDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Device;
import com.simba.model.form.DeviceSearchForm;

/**
 * 设备 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class DeviceDaoImpl implements DeviceDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "device";

	@Override
	public void add(Device device) {
		String sql = "insert into " + table + "( wxDeviceId, qrcode, wxProductId, status) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, device.getWxDeviceId(), device.getQrcode(), device.getWxProductId(), device.getStatus());
	}

	@Override
	@CacheEvict(allEntries = true, cacheNames = { "device", "deviceListBy" })
	public void update(Device device) {
		String sql = "update " + table + " set  wxDeviceId = ? , qrcode = ? , wxProductId = ? , status = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, device.getWxDeviceId(), device.getQrcode(), device.getWxProductId(), device.getStatus(), device.getId());
	}

	@Override
	@CacheEvict(allEntries = true, cacheNames = { "device", "deviceListBy" })
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Device> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Device.class, page);
	}

	@Override
	public List<Device> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Device.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	@Cacheable(cacheNames = "device", key = "#id")
	public Device get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Device.class, id);
	}

	@Override
	public Device getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Device.class, value);
	}

	@Override
	public Device getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Device.class, value1, value2);
	}

	@Override
	public Device getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Device.class, value1, value2);
	}

	@Override
	@Cacheable(cacheNames = "deviceListBy", key = "#field.concat(#value.toString())")
	public List<Device> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Device.class, value);
	}

	@Override
	public List<Device> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Device.class, value1, value2);
	}

	@Override
	public List<Device> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Device.class, value1, value2);
	}

	@Override
	public List<Device> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Device.class, page, param);
	}

	@Override
	public List<Device> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Device.class, page, param);
	}

	@Override
	public List<Device> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Device.class, page, param);
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
	public int count(DeviceSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	@Override
	public List<Device> page(Pager pager, DeviceSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForPage(sql, Device.class, pager, param);
	}

	private String buildCondition(String sql, DeviceSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getQrcode())) {
			sql += " and qrcode like '%" + searchForm.getQrcode() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getWxDeviceId())) {
			sql += " and wxDeviceId like '%" + searchForm.getWxDeviceId() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getWxProductId())) {
			sql += " and wxProductId like '%" + searchForm.getWxProductId() + "%'";
		}
		if (searchForm.getStatus() != null) {
			sql += " and status =  ? ";
			param.setInt(searchForm.getStatus());
		}
		return sql;
	}

	@Override
	public void updateStatus(long id, int status) {
		String sql = "update " + table + " set status = ? where id = ? ";
		jdbc.updateForBoolean(sql, status, id);
	}

	@Override
	public Device getFreeDevice(String wxProductId) {
		String sql = "select * from " + table + " where status = 0 and wxProductId  = ? limit 1 ";
		return jdbc.query(sql, Device.class, wxProductId);
	}

}
