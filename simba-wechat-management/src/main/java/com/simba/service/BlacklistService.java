package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Blacklist;

/**
 *黑名单 Service
 * 
 * @author caozj
 * 
 */
public interface BlacklistService {

	void add(Blacklist blacklist);

	void update(Blacklist blacklist);

	void delete(Integer id);

	List<Blacklist> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	List<Blacklist> page(Pager page);

	Blacklist get(Integer id);
	
	void batchDelete(List<Integer> idList);

	Blacklist getBy(String field, Object value);

	Blacklist getByAnd(String field1, Object value1, String field2, Object value2);

	Blacklist getByOr(String field1, Object value1, String field2, Object value2);

	List<Blacklist> listBy(String field, Object value);

	List<Blacklist> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Blacklist> listByOr(String field1, Object value1, String field2, Object value2);

	List<Blacklist> pageBy(String field, Object value, Pager page);

	List<Blacklist> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Blacklist> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
