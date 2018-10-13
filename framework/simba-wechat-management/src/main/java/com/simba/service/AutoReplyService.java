package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AutoReply;

/**
 *自动回复设置 Service
 * 
 * @author caozj
 * 
 */
public interface AutoReplyService {

	void add(AutoReply autoReply);

	void update(AutoReply autoReply);

	void delete(Integer id);

	List<AutoReply> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	List<AutoReply> page(Pager page);

	AutoReply get(Integer id);
	
	void batchDelete(List<Integer> idList);

	AutoReply getBy(String field, Object value);

	AutoReply getByAnd(String field1, Object value1, String field2, Object value2);

	AutoReply getByOr(String field1, Object value1, String field2, Object value2);

	List<AutoReply> listBy(String field, Object value);

	List<AutoReply> listByAnd(String field1, Object value1, String field2, Object value2);

	List<AutoReply> listByOr(String field1, Object value1, String field2, Object value2);

	List<AutoReply> pageBy(String field, Object value, Pager page);

	List<AutoReply> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<AutoReply> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
