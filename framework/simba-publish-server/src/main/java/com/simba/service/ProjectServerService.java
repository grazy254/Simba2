package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectServer;

/**
 *服务器 Service
 * 
 * @author caozj
 * 
 */
public interface ProjectServerService {

	void add(ProjectServer projectServer);

	void update(ProjectServer projectServer);

	void delete(Integer id);

	List<ProjectServer> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	Integer countByAnd(String field1, Object value1, String field2, Object value2);
	
	Integer countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<ProjectServer> page(Pager page);

	ProjectServer get(Integer id);
	
	void batchDelete(List<Integer> idList);

	ProjectServer getBy(String field, Object value);

	ProjectServer getByAnd(String field1, Object value1, String field2, Object value2);

	ProjectServer getByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServer> listBy(String field, Object value);

	List<ProjectServer> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ProjectServer> listByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectServer> pageBy(String field, Object value, Pager page);

	List<ProjectServer> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ProjectServer> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
