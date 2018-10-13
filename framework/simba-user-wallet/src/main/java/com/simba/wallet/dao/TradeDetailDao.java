package com.simba.wallet.dao;

import java.util.List;
import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.form.TradeDetailSearchForm;
/**
 * 交易详情信息 Dao
 * 
 * @author caozj
 * 
 */
public interface TradeDetailDao {

	Long add(TradeDetail tradeDetail);

	void update(TradeDetail tradeDetail);

	void delete(Long id);

	List<TradeDetail> listAll();
	
	Long count();
	
	Long count(TradeDetailSearchForm tradeDetailSearchForm);
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeDetail> page(Pager page);
	
	List<TradeDetail> page(Pager page, TradeDetailSearchForm tradeDetailSearchForm);
	TradeDetail get(Long id);
	
	TradeDetail getBy(String field, Object value);

	TradeDetail getByAnd(String field1, Object value1, String field2, Object value2);

	TradeDetail getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeDetail> listBy(String field, Object value);

	List<TradeDetail> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeDetail> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeDetail> pageBy(String field, Object value, Pager page);

	List<TradeDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	

}
