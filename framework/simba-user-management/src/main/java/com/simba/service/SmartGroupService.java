package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.SmartGroup;

/**
 *分组表 Service
 * 
 * @author caozj
 * 
 */
public interface SmartGroupService {

	void add(SmartGroup smartGroup);

	void update(SmartGroup smartGroup);

	void delete(Long id);

	List<SmartGroup> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<SmartGroup> page(Pager page);

	SmartGroup get(Long id);
	
	void batchDelete(List<Long> idList);

	SmartGroup getBy(String field, Object value);

	SmartGroup getByAnd(String field1, Object value1, String field2, Object value2);

	SmartGroup getByOr(String field1, Object value1, String field2, Object value2);

	List<SmartGroup> listBy(String field, Object value);

	List<SmartGroup> listByAnd(String field1, Object value1, String field2, Object value2);

	List<SmartGroup> listByOr(String field1, Object value1, String field2, Object value2);

	List<SmartGroup> pageBy(String field, Object value, Pager page);

	List<SmartGroup> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<SmartGroup> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
