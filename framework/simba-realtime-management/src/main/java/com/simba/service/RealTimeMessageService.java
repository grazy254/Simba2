package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.RealTimeMessage;
import com.simba.model.form.RealTimeMessageSearchForm;

/**
 *设备功能表 Service
 * 
 * @author caozj
 * 
 */
public interface RealTimeMessageService {

	void add(RealTimeMessage realTimeMessage);

	void update(RealTimeMessage realTimeMessage);

	void delete(Long id);

	List<RealTimeMessage> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<RealTimeMessage> page(Pager page);
	
	List<RealTimeMessage> page(Pager page,RealTimeMessageSearchForm searchForm);

	RealTimeMessage get(Long id);
	
	void batchDelete(List<Long> idList);

	RealTimeMessage getBy(String field, Object value);

	RealTimeMessage getByAnd(String field1, Object value1, String field2, Object value2);

	RealTimeMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<RealTimeMessage> listBy(String field, Object value);

	List<RealTimeMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<RealTimeMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<RealTimeMessage> pageBy(String field, Object value, Pager page);

	List<RealTimeMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<RealTimeMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
