package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Device;
import com.simba.model.form.DeviceSearchForm;

/**
 * 设备 Dao
 * 
 * @author caozj
 * 
 */
public interface DeviceDao {

	void add(Device device);

	void update(Device device);

	void delete(Long id);

	List<Device> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<Device> page(Pager page);

	Device get(Long id);

	Device getBy(String field, Object value);

	Device getByAnd(String field1, Object value1, String field2, Object value2);

	Device getByOr(String field1, Object value1, String field2, Object value2);

	List<Device> listBy(String field, Object value);

	List<Device> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Device> listByOr(String field1, Object value1, String field2, Object value2);

	List<Device> pageBy(String field, Object value, Pager page);

	List<Device> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Device> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	int count(DeviceSearchForm searchForm);

	List<Device> page(Pager pager, DeviceSearchForm searchForm);

	void updateStatus(long id, int status);

	Device getFreeDevice(String wxProductId);

}
