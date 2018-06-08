package com.simba.wallet.dao;

import java.util.List;
import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.model.TradeChannelDetail;
/**
 * 交易的渠道信息 Dao
 * 
 * @author caozj
 * 
 */
public interface TradeChannelDetailDao {

	Long add(TradeChannelDetail tradeChannelDetail);

	void update(TradeChannelDetail tradeChannelDetail);

	void delete(Long id);

	List<TradeChannelDetail> listAll();
	
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeChannelDetail> page(Pager page);
	
	TradeChannelDetail get(Long id);
	
	TradeChannelDetail getBy(String field, Object value);

	TradeChannelDetail getByAnd(String field1, Object value1, String field2, Object value2);

	TradeChannelDetail getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeChannelDetail> listBy(String field, Object value);

	List<TradeChannelDetail> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeChannelDetail> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeChannelDetail> pageBy(String field, Object value, Pager page);

	List<TradeChannelDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeChannelDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	

}
