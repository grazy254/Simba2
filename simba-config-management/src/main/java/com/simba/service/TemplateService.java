package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Template;

/**
 *配置模板表 Service
 * 
 * @author caozj
 * 
 */
public interface TemplateService {

	void add(Template template);

	void update(Template template);

	void delete(Long id);

	List<Template> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<Template> page(Pager page);

	Template get(Long id);
	
	void batchDelete(List<Long> idList);

	Template getBy(String field, Object value);

	Template getByAnd(String field1, Object value1, String field2, Object value2);

	Template getByOr(String field1, Object value1, String field2, Object value2);

	List<Template> listBy(String field, Object value);

	List<Template> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Template> listByOr(String field1, Object value1, String field2, Object value2);

	List<Template> pageBy(String field, Object value, Pager page);

	List<Template> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Template> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
