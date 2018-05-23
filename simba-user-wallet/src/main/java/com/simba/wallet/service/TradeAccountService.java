package  com.simba.wallet.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.enums.TradeUserType;
/**
 *支付账号 Service
 * 
 * @author caozj
 * 
 */
public interface TradeAccountService {

	Long add(TradeAccount tradeAccount);

	void update(TradeAccount tradeAccount);

	void delete(Long id);
	
	List<TradeAccount> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<TradeAccount> page(Pager page);
	
	TradeAccount get(Long id);
	
	void batchDelete(List<Long> idList);

	TradeAccount getBy(String field, Object value);

	TradeAccount getByAnd(String field1, Object value1, String field2, Object value2);

	TradeAccount getByOr(String field1, Object value1, String field2, Object value2);

	List<TradeAccount> listBy(String field, Object value);

	List<TradeAccount> listByAnd(String field1, Object value1, String field2, Object value2);

	List<TradeAccount> listByOr(String field1, Object value1, String field2, Object value2);

	List<TradeAccount> pageBy(String field, Object value, Pager page);

	List<TradeAccount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<TradeAccount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	JsonResult openAccount(String userID, String name, String password, String payPhone, String payEmail,
			TradeUserType tradeUserType, int isAllowPay, int isAllowRecharge, int isActive)
			throws Exception;

	JsonResult frozeAccount(String userID, TradeUserType tradeUserType);
}
