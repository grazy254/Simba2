package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Device;
import com.simba.model.DeviceBind;
import com.simba.model.form.DeviceBindSearchForm;

/**
 * 设备绑定 Service
 * 
 * @author caozj
 * 
 */
public interface DeviceBindService {

	void add(DeviceBind deviceBind);

	void update(DeviceBind deviceBind);

	void delete(Long id);

	List<DeviceBind> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<DeviceBind> page(Pager page);

	DeviceBind get(Long id);

	void batchDelete(List<Long> idList);

	DeviceBind getBy(String field, Object value);

	DeviceBind getByAnd(String field1, Object value1, String field2, Object value2);

	DeviceBind getByOr(String field1, Object value1, String field2, Object value2);

	List<DeviceBind> listBy(String field, Object value);

	List<DeviceBind> listByAnd(String field1, Object value1, String field2, Object value2);

	List<DeviceBind> listByOr(String field1, Object value1, String field2, Object value2);

	List<DeviceBind> pageBy(String field, Object value, Pager page);

	List<DeviceBind> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<DeviceBind> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	int count(DeviceBindSearchForm searchForm);

	List<DeviceBind> page(Pager pager, DeviceBindSearchForm searchForm);

	void unbind(String openid, String wxDeviceId);

	boolean bind(Device device, String openid);

}
