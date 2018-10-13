package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Dictionary;
/**
 *字典 Service
 * 
 * @author caozj
 * 
 */
public interface DictionaryService {

	void add(Dictionary dictionary);

	void update(Dictionary dictionary);

	void delete(Long id);

	List<Dictionary> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<Dictionary> page(Pager page);
	
	Dictionary get(Long id);
	
	void batchDelete(List<Long> idList);

	Dictionary getBy(String field, Object value);

	Dictionary getByAnd(String field1, Object value1, String field2, Object value2);

	Dictionary getByOr(String field1, Object value1, String field2, Object value2);

	List<Dictionary> listBy(String field, Object value);

	List<Dictionary> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Dictionary> listByOr(String field1, Object value1, String field2, Object value2);

	List<Dictionary> pageBy(String field, Object value, Pager page);

	List<Dictionary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Dictionary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
