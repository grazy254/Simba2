package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectVersion;

/**
 *项目版本 Service
 * 
 * @author caozj
 * 
 */
public interface ProjectVersionService {

	void add(ProjectVersion projectVersion);

	void update(ProjectVersion projectVersion);

	void delete(Integer id);

	List<ProjectVersion> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<ProjectVersion> page(Pager page);

	ProjectVersion get(Integer id);
	
	void batchDelete(List<Integer> idList);

	ProjectVersion getBy(String field, Object value);

	ProjectVersion getByAnd(String field1, Object value1, String field2, Object value2);

	ProjectVersion getByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectVersion> listBy(String field, Object value);

	List<ProjectVersion> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ProjectVersion> listByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectVersion> pageBy(String field, Object value, Pager page);

	List<ProjectVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ProjectVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
