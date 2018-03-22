package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Device;
import com.simba.model.form.DeviceSearchForm;

/**
 * 设备 Service
 * 
 * @author caozj
 * 
 */
public interface DeviceService {

	void add(Device device);

	void update(Device device);

	void delete(Long id);

	List<Device> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<Device> page(Pager page);

	Device get(Long id);

	void batchDelete(List<Long> idList);

	Device getBy(String field, Object value);

	Device getByAnd(String field1, Object value1, String field2, Object value2);

	Device getByOr(String field1, Object value1, String field2, Object value2);

	List<Device> listBy(String field, Object value);

	List<Device> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Device> listByOr(String field1, Object value1, String field2, Object value2);

	List<Device> pageBy(String field, Object value, Pager page);

	List<Device> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Device> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	/**
	 * 请求微信二维码
	 * 
	 * @param wxProductId
	 *            微信产品ID
	 * @param num
	 *            个数
	 */
	void requestQrCode(String wxProductId, int num);

	List<Device> page(Pager pager, DeviceSearchForm searchForm);

	int count(DeviceSearchForm searchForm);

	/**
	 * 更新设备状态为已用
	 * 
	 * @param id
	 */
	void usedDevice(long id);

	/**
	 * 得到一个可用的设备
	 * 
	 * @param wxProductId
	 * @return
	 */
	Device getFreeDevice(String wxProductId);

	/**
	 * 获取设备运行状态
	 * 
	 * @param wxDeviceId
	 * @return
	 */
	String getDeviceStatus(String wxDeviceId);

}
