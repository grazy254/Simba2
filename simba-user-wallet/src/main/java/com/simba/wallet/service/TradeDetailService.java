package  com.simba.wallet.service;

import java.util.Date;
import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.enums.ChannelType;
/**
 *交易详情信息 Service
 * 
 * @author caozj
 * 
 */
public interface TradeDetailService {
	
	Long add(TradeDetail tradeDetail);

	void update(TradeDetail tradeDetail);

	void delete(Long id);

	List<TradeDetail> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeDetail> page(Pager page);
	
	TradeDetail get(Long id);
	
	void batchDelete(List<Long> idList);

	TradeDetail getBy(String field, Object value);

	TradeDetail getByAnd(String field1, Object value1, String field2, Object value2);

	TradeDetail getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeDetail> listBy(String field, Object value);

	List<TradeDetail> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeDetail> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeDetail> pageBy(String field, Object value, Pager page);

	List<TradeDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	JsonResult recharge(SmartUser smartUser, String tradeDeptNO, ChannelType channelType,
			TradePartyDetail tradePartyDetail, String orderNO, String orderName, String orderDesc, long originalAmount, long paymentAmount, 
			Date tradeCreateTime);

}
