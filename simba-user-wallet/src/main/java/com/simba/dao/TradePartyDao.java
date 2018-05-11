package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.TradeParty;
/**
 * 交易主体 Dao
 * 
 * @author caozj
 * 
 */
public interface TradePartyDao {

	void add(TradeParty tradeParty);

	void update(TradeParty tradeParty);

	void delete(Long id);

	List<TradeParty> listAll();
	
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeParty> page(Pager page);
	
	TradeParty get(Long id);
	
	TradeParty getBy(String field, Object value);

	TradeParty getByAnd(String field1, Object value1, String field2, Object value2);

	TradeParty getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeParty> listBy(String field, Object value);

	List<TradeParty> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeParty> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeParty> pageBy(String field, Object value, Pager page);

	List<TradeParty> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeParty> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	

}
