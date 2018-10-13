package  com.simba.wallet.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.model.TradeBalanceDetail;
/**
 * Service
 * 
 * @author caozj
 * 
 */
public interface TradeBalanceDetailService {

	void add(TradeBalanceDetail tradeBalanceDetail);

	void update(TradeBalanceDetail tradeBalanceDetail);

	void delete(Long id);

	List<TradeBalanceDetail> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeBalanceDetail> page(Pager page);
	
	TradeBalanceDetail get(Long id);
	
	void batchDelete(List<Long> idList);

	TradeBalanceDetail getBy(String field, Object value);

	TradeBalanceDetail getByAnd(String field1, Object value1, String field2, Object value2);

	TradeBalanceDetail getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeBalanceDetail> listBy(String field, Object value);

	List<TradeBalanceDetail> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeBalanceDetail> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeBalanceDetail> pageBy(String field, Object value, Pager page);

	List<TradeBalanceDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeBalanceDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
