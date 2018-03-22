package com.simba.dao;

import java.util.Date;
import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DayAmount;
import com.simba.model.TotalDayAmountBean;

/**
 *  Dao
 * 
 * @author caozj
 * 
 */
public interface DayAmountDao {

	void add(DayAmount dayAmount);

	void update(DayAmount dayAmount);

	void delete(Long id);

	List<DayAmount> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<DayAmount> page(Pager page);

	DayAmount get(Long id);
	
	DayAmount getBy(String field, Object value);

	DayAmount getByAnd(String field1, Object value1, String field2, Object value2);

	DayAmount getByOr(String field1, Object value1, String field2, Object value2);

	List<DayAmount> listBy(String field, Object value);

	List<DayAmount> listByAnd(String field1, Object value1, String field2, Object value2);

	List<DayAmount> listByOr(String field1, Object value1, String field2, Object value2);

	List<DayAmount> pageBy(String field, Object value, Pager page);

	List<DayAmount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<DayAmount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	DayAmount getLatest();

	List<TotalDayAmountBean> getTotalAmountList(Date startTime, Date endTime);

	List<DayAmount> getProjectAmountList(Date startTime, Date endTime, int projectId);

}
