package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PointDetail;

/**
 *null Service
 * 
 * @author caozj
 * 
 */
public interface PointDetailService {

	void add(PointDetail pointDetail);

	void update(PointDetail pointDetail);

	void delete(Long id);

	List<PointDetail> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<PointDetail> page(Pager page);

	PointDetail get(Long id);
	
	void batchDelete(List<Long> idList);

	PointDetail getBy(String field, Object value);

	PointDetail getByAnd(String field1, Object value1, String field2, Object value2);

	PointDetail getByOr(String field1, Object value1, String field2, Object value2);

	List<PointDetail> listBy(String field, Object value);

	List<PointDetail> listByAnd(String field1, Object value1, String field2, Object value2);

	List<PointDetail> listByOr(String field1, Object value1, String field2, Object value2);

	List<PointDetail> pageBy(String field, Object value, Pager page);

	List<PointDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<PointDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
