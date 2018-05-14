package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TradeUser;
/**
 *钱包用户信息 Service
 * 
 * @author caozj
 * 
 */
public interface TradeUserService {

	void add(TradeUser tradeUser);

	void update(TradeUser tradeUser);

	void delete(Long id);

	List<TradeUser> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeUser> page(Pager page);
	
	TradeUser get(Long id);
	
	void batchDelete(List<Long> idList);

	TradeUser getBy(String field, Object value);

	TradeUser getByAnd(String field1, Object value1, String field2, Object value2);

	TradeUser getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeUser> listBy(String field, Object value);

	List<TradeUser> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeUser> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeUser> pageBy(String field, Object value, Pager page);

	List<TradeUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}