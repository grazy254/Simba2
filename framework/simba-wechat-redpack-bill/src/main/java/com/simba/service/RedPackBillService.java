package  com.simba.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.controller.form.RedPackBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.RedPackBill;

/**
 *红包账单 Service
 * 
 * @author caozj
 * 
 */
public interface RedPackBillService {

	void add(RedPackBill redPackBill);

	void update(RedPackBill redPackBill);

	void delete(Long id);

	List<RedPackBill> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<RedPackBill> page(Pager page);

	RedPackBill get(Long id);
	
	void batchDelete(List<Long> idList);

	RedPackBill getBy(String field, Object value);

	RedPackBill getByAnd(String field1, Object value1, String field2, Object value2);

	RedPackBill getByOr(String field1, Object value1, String field2, Object value2);

	List<RedPackBill> listBy(String field, Object value);

	List<RedPackBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<RedPackBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<RedPackBill> pageBy(String field, Object value, Pager page);
	
	List<RedPackBill> listAllUnfinish();

	List<RedPackBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<RedPackBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<RedPackBill> page(RedPackBillSearchForm searchForm, Pager pager);

	Long count(RedPackBillSearchForm searchForm);
	
	/**
	 * 查询未完成的订单，更新其状态
	 */
	void checkUnfinishOrder()throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException ;


}
