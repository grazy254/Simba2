package  com.simba.wallet.service;

import java.util.List;
import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.model.TradeChannel;
/**
 *渠道信息 Service
 * 
 * @author caozj
 * 
 */
public interface TradeChannelService {

	void add(TradeChannel tradeChannel) throws Exception;

	void update(TradeChannel tradeChannel);

	void delete(Long id);

	List<TradeChannel> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeChannel> page(Pager page);
	
	TradeChannel get(Long id);
	
	void batchDelete(List<Long> idList);

	TradeChannel getBy(String field, Object value);

	TradeChannel getByAnd(String field1, Object value1, String field2, Object value2);

	TradeChannel getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeChannel> listBy(String field, Object value);

	List<TradeChannel> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeChannel> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeChannel> pageBy(String field, Object value, Pager page);

	List<TradeChannel> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeChannel> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	void delete(String channelType);

}
