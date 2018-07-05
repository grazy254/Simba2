package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.DeviceDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Device;
import com.simba.model.form.DeviceSearchForm;
import com.simba.model.wxHardware.send.GetDeviceQrcodeResult;
import com.simba.service.DeviceService;
import com.simba.util.send.NewAuthWxUtil;

/**
 * 设备 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDao deviceDao;

	@Autowired
	private NewAuthWxUtil newAuthWxUtil;

	@Override
	public void add(Device device) {
		deviceDao.add(device);
	}

	@Override
	public void delete(Long id) {
		deviceDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Device get(Long id) {
		return deviceDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> page(Pager page) {
		return deviceDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return deviceDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return deviceDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		deviceDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> listAll() {
		return deviceDao.listAll();
	}

	@Override
	public void update(Device device) {
		deviceDao.update(device);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Device getBy(String field, Object value) {
		return deviceDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Device getByAnd(String field1, Object value1, String field2, Object value2) {
		return deviceDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Device getByOr(String field1, Object value1, String field2, Object value2) {
		return deviceDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> listBy(String field, Object value) {
		return deviceDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> listByAnd(String field1, Object value1, String field2, Object value2) {
		return deviceDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> listByOr(String field1, Object value1, String field2, Object value2) {
		return deviceDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> pageBy(String field, Object value, Pager page) {
		return deviceDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return deviceDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return deviceDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Async
	@Override
	public void requestQrCode(String wxProductId, int num) {
		for (int i = 0; i < num; i++) {
			GetDeviceQrcodeResult result = newAuthWxUtil.getDeviceQrcode(wxProductId);
			String deviceId = result.getDeviceid();
			String qrcode = result.getQrticket();
			Device device = new Device();
			device.setQrcode(qrcode);
			device.setStatus(0);
			device.setWxDeviceId(deviceId);
			device.setWxProductId(wxProductId);
			this.add(device);
		}
	}

	@Override
	public List<Device> page(Pager pager, DeviceSearchForm searchForm) {
		return deviceDao.page(pager, searchForm);
	}

	@Override
	public int count(DeviceSearchForm searchForm) {
		return deviceDao.count(searchForm);
	}

	@Override
	public void usedDevice(long id) {
		deviceDao.updateStatus(id, 1);
	}

	@Override
	public Device getFreeDevice(String wxProductId) {
		return deviceDao.getFreeDevice(wxProductId);
	}

	@Override
	public String getDeviceStatus(String wxDeviceId) {
		return null;
	}

}
