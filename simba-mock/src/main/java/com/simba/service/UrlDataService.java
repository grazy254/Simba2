package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UrlData;

/**
 * Service
 * 
 * @author caozj
 * 
 */
public interface UrlDataService {

	void add(UrlData urlData);

	void update(UrlData urlData);

	void delete(Integer id);

	List<UrlData> listAll();

	int countBy(String field, Object value);
	
	List<UrlData> page(Pager page);

	UrlData get(Integer id);
	
	void batchDelete(List<Integer> idList);

	UrlData getBy(String field, Object value);

	UrlData getByAnd(String field1, Object value1, String field2, Object value2);

	UrlData getByOr(String field1, Object value1, String field2, Object value2);

	List<UrlData> listBy(String field, Object value);

	List<UrlData> listByAnd(String field1, Object value1, String field2, Object value2);

	List<UrlData> listByOr(String field1, Object value1, String field2, Object value2);

	List<UrlData> pageBy(String field, Object value, Pager page);

	List<UrlData> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<UrlData> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

    int count(Integer projectId);

}
