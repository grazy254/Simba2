package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MockProject;

/**
 * Service
 * 
 * @author caozj
 * 
 */
public interface ProjectService {

	void add(MockProject project);

	void update(MockProject project);

	void delete(Integer id);

	List<MockProject> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	List<MockProject> page(Pager page);

	MockProject get(Integer id);
	
	void batchDelete(List<Integer> idList);

	MockProject getBy(String field, Object value);

	MockProject getByAnd(String field1, Object value1, String field2, Object value2);

	MockProject getByOr(String field1, Object value1, String field2, Object value2);

	List<MockProject> listBy(String field, Object value);

	List<MockProject> listByAnd(String field1, Object value1, String field2, Object value2);

	List<MockProject> listByOr(String field1, Object value1, String field2, Object value2);

	List<MockProject> pageBy(String field, Object value, Pager page);

	List<MockProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<MockProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

    void add(String sessAccount, MockProject project);

}
