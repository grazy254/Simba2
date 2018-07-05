package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.NotifyUser;
/**
 *通知表和用户表的关联 Service
 * 
 * @author caozj
 * 
 */
public interface NotifyUserService {

	void add(NotifyUser notifyUser);

	void update(NotifyUser notifyUser);

	void delete(Long id);

	List<NotifyUser> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<NotifyUser> page(Pager page);
	
	NotifyUser get(Long id);
	
	void batchDelete(List<Long> idList);

	NotifyUser getBy(String field, Object value);

	NotifyUser getByAnd(String field1, Object value1, String field2, Object value2);

	NotifyUser getByOr(String field1, Object value1, String field2, Object value2);

	List<NotifyUser> listBy(String field, Object value);

	List<NotifyUser> listByAnd(String field1, Object value1, String field2, Object value2);

	List<NotifyUser> listByOr(String field1, Object value1, String field2, Object value2);

	List<NotifyUser> pageBy(String field, Object value, Pager page);

	List<NotifyUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<NotifyUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
