package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AutoId;

/**
 *自增id Service
 * 
 * @author caozj
 * 
 */
public interface AutoIdService {

	void add(AutoId autoId);

	void update(AutoId autoId);

	void delete(String id);

	List<AutoId> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	Integer countByAnd(String field1, Object value1, String field2, Object value2);
	
	Integer countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<AutoId> page(Pager page);

	AutoId get(String id);
	
	void batchDelete(List<String> idList);

	AutoId getBy(String field, Object value);

	AutoId getByAnd(String field1, Object value1, String field2, Object value2);

	AutoId getByOr(String field1, Object value1, String field2, Object value2);

	List<AutoId> listBy(String field, Object value);

	List<AutoId> listByAnd(String field1, Object value1, String field2, Object value2);

	List<AutoId> listByOr(String field1, Object value1, String field2, Object value2);

	List<AutoId> pageBy(String field, Object value, Pager page);

	List<AutoId> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<AutoId> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
