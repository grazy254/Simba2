package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PropertyTemplate;

/**
 *配置模板表 Service
 * 
 * @author caozj
 * 
 */
public interface TemplateService {

	void add(PropertyTemplate template);

	void update(PropertyTemplate template);

	void delete(Long id);

	List<PropertyTemplate> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<PropertyTemplate> page(Pager page);

	PropertyTemplate get(Long id);
	
	void batchDelete(List<Long> idList);

	PropertyTemplate getBy(String field, Object value);

	PropertyTemplate getByAnd(String field1, Object value1, String field2, Object value2);

	PropertyTemplate getByOr(String field1, Object value1, String field2, Object value2);

	List<PropertyTemplate> listBy(String field, Object value);

	List<PropertyTemplate> listByAnd(String field1, Object value1, String field2, Object value2);

	List<PropertyTemplate> listByOr(String field1, Object value1, String field2, Object value2);

	List<PropertyTemplate> pageBy(String field, Object value, Pager page);

	List<PropertyTemplate> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<PropertyTemplate> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
