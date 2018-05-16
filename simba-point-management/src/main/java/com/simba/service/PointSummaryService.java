package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PointSummary;

/**
 *null Service
 * 
 * @author caozj
 * 
 */
public interface PointSummaryService {

	void add(PointSummary pointSummary);

	void update(PointSummary pointSummary);

	void delete(Long id);

	List<PointSummary> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<PointSummary> page(Pager page);

	PointSummary get(Long id);
	
	void batchDelete(List<Long> idList);

	PointSummary getBy(String field, Object value);

	PointSummary getByAnd(String field1, Object value1, String field2, Object value2);

	PointSummary getByOr(String field1, Object value1, String field2, Object value2);

	List<PointSummary> listBy(String field, Object value);

	List<PointSummary> listByAnd(String field1, Object value1, String field2, Object value2);

	List<PointSummary> listByOr(String field1, Object value1, String field2, Object value2);

	List<PointSummary> pageBy(String field, Object value, Pager page);

	List<PointSummary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<PointSummary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
