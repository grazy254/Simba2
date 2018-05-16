package  com.simba.service;

import java.text.ParseException;
import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Activity;

/**
 *活动 Service
 * 
 * @author lilei
 * 
 */
public interface ActivityService {

	void add(Activity activity) throws ParseException;
	
	boolean isExistedActivityID(String activityID); 

	void update(Activity activity)throws ParseException;

	void delete(Long id);

	List<Activity> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<Activity> page(Pager page);

	Activity get(Long id);
	
	void batchDelete(List<Long> idList);

	Activity getBy(String field, Object value);

	Activity getByAnd(String field1, Object value1, String field2, Object value2);

	Activity getByOr(String field1, Object value1, String field2, Object value2);

	List<Activity> listBy(String field, Object value);

	List<Activity> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Activity> listByOr(String field1, Object value1, String field2, Object value2);

	List<Activity> pageBy(String field, Object value, Pager page);

	List<Activity> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Activity> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
