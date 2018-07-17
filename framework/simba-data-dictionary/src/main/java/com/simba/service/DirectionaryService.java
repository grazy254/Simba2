package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Directionary;
/**
 *字典 Service
 * 
 * @author caozj
 * 
 */
public interface DirectionaryService {

	void add(Directionary directionary);

	void update(Directionary directionary);

	void delete(Long id);

	List<Directionary> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<Directionary> page(Pager page);
	
	Directionary get(Long id);
	
	void batchDelete(List<Long> idList);

	Directionary getBy(String field, Object value);

	Directionary getByAnd(String field1, Object value1, String field2, Object value2);

	Directionary getByOr(String field1, Object value1, String field2, Object value2);

	List<Directionary> listBy(String field, Object value);

	List<Directionary> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Directionary> listByOr(String field1, Object value1, String field2, Object value2);

	List<Directionary> pageBy(String field, Object value, Pager page);

	List<Directionary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Directionary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
