package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DeployLog;

/**
 *部署日志 Service
 * 
 * @author caozj
 * 
 */
public interface DeployLogService {

	void add(DeployLog deployLog);

	void update(DeployLog deployLog);

	void delete(Long id);

	List<DeployLog> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<DeployLog> page(Pager page);

	DeployLog get(Long id);
	
	void batchDelete(List<Long> idList);

	DeployLog getBy(String field, Object value);

	DeployLog getByAnd(String field1, Object value1, String field2, Object value2);

	DeployLog getByOr(String field1, Object value1, String field2, Object value2);

	List<DeployLog> listBy(String field, Object value);

	List<DeployLog> listByAnd(String field1, Object value1, String field2, Object value2);

	List<DeployLog> listByOr(String field1, Object value1, String field2, Object value2);

	List<DeployLog> pageBy(String field, Object value, Pager page);

	List<DeployLog> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<DeployLog> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
