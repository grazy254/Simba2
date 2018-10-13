package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.DeviceBindDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Device;
import com.simba.model.DeviceBind;
import com.simba.model.form.DeviceBindSearchForm;
import com.simba.service.DeviceBindService;

/**
 * 设备绑定 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DeviceBindServiceImpl implements DeviceBindService {

	@Autowired
	private DeviceBindDao deviceBindDao;

	@Override
	public void add(DeviceBind deviceBind) {
		deviceBindDao.add(deviceBind);
	}

	@Override
	public void delete(Long id) {
		deviceBindDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DeviceBind get(Long id) {
		return deviceBindDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> page(Pager page) {
		return deviceBindDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return deviceBindDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return deviceBindDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		deviceBindDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> listAll() {
		return deviceBindDao.listAll();
	}

	@Override
	public void update(DeviceBind deviceBind) {
		deviceBindDao.update(deviceBind);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DeviceBind getBy(String field, Object value) {
		return deviceBindDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public DeviceBind getByAnd(String field1, Object value1, String field2, Object value2) {
		return deviceBindDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public DeviceBind getByOr(String field1, Object value1, String field2, Object value2) {
		return deviceBindDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> listBy(String field, Object value) {
		return deviceBindDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> listByAnd(String field1, Object value1, String field2, Object value2) {
		return deviceBindDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> listByOr(String field1, Object value1, String field2, Object value2) {
		return deviceBindDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> pageBy(String field, Object value, Pager page) {
		return deviceBindDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return deviceBindDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeviceBind> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return deviceBindDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public int count(DeviceBindSearchForm searchForm) {
		return deviceBindDao.count(searchForm);
	}

	@Override
	public List<DeviceBind> page(Pager pager, DeviceBindSearchForm searchForm) {
		return deviceBindDao.page(pager, searchForm);
	}

	@Override
	public void unbind(String openid, String wxDeviceId) {
		List<DeviceBind> list = this.listByAnd("openid", openid, "wxDeviceId", wxDeviceId);
		if (list.size() > 0) {
			deviceBindDao.unbind(openid, wxDeviceId);
		}
	}

	@Override
	public boolean bind(Device device, String openid) {
		List<DeviceBind> list = deviceBindDao.listByAnd("openid", openid, "wxDeviceId", device.getWxDeviceId());
		if (list.size() == 0) {
			DeviceBind deviceBind = new DeviceBind();
			deviceBind.setCreateTime(new Date());
			deviceBind.setOpenid(openid);
			deviceBind.setWxDeviceId(device.getWxDeviceId());
			deviceBindDao.add(deviceBind);
		}
		return true;
	}

}
