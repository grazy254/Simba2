package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AliPayEnterpriseBill;
/**
 *支付宝企业支付账单 Service
 * 
 * @author caozj
 * 
 */
public interface AliPayEnterpriseBillService {

	void add(AliPayEnterpriseBill aliPayEnterpriseBill);

	void update(AliPayEnterpriseBill aliPayEnterpriseBill);

	void delete(Long id);

	List<AliPayEnterpriseBill> listAll();
		
	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<AliPayEnterpriseBill> page(Pager page);
	
	AliPayEnterpriseBill get(Long id);
	
	void batchDelete(List<Long> idList);

	AliPayEnterpriseBill getBy(String field, Object value);

	AliPayEnterpriseBill getByAnd(String field1, Object value1, String field2, Object value2);

	AliPayEnterpriseBill getByOr(String field1, Object value1, String field2, Object value2);

	List<AliPayEnterpriseBill> listBy(String field, Object value);

	List<AliPayEnterpriseBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<AliPayEnterpriseBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<AliPayEnterpriseBill> pageBy(String field, Object value, Pager page);

	List<AliPayEnterpriseBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<AliPayEnterpriseBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
