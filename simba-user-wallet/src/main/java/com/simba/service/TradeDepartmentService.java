package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TradeDepartment;
/**
 *收款部门 Service
 * 
 * @author caozj
 * 
 */
public interface TradeDepartmentService {

	void add(TradeDepartment tradeDepartment);

	void update(TradeDepartment tradeDepartment);

	void delete(Long id);

	List<TradeDepartment> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeDepartment> page(Pager page);
	
	TradeDepartment get(Long id);
	
	void batchDelete(List<Long> idList);

	TradeDepartment getBy(String field, Object value);

	TradeDepartment getByAnd(String field1, Object value1, String field2, Object value2);

	TradeDepartment getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeDepartment> listBy(String field, Object value);

	List<TradeDepartment> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeDepartment> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeDepartment> pageBy(String field, Object value, Pager page);

	List<TradeDepartment> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeDepartment> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
