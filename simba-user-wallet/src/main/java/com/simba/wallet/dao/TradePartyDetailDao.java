package com.simba.wallet.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.vo.TradePartyVO;
/**
 * 交易主体 Dao
 * 
 * @author caozj
 * 
 */
public interface TradePartyDetailDao {

	Long add(TradePartyDetail tradePartyDetail);

	void update(TradePartyDetail tradePartyDetail);

	void delete(Long id);

	List<TradePartyDetail> listAll();
	
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradePartyDetail> page(Pager page);
	
	TradePartyDetail get(Long id);
	
	TradePartyDetail getBy(String field, Object value);

	TradePartyDetail getByAnd(String field1, Object value1, String field2, Object value2);

	TradePartyDetail getByOr(String field1, Object value1, String field2, Object value2);

	List<TradePartyDetail> listBy(String field, Object value);

	List<TradePartyDetail> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradePartyDetail> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradePartyVO> pageBy(String field, Object value, Pager page);

	List<TradePartyDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradePartyDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	

}
