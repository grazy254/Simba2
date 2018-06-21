package com.simba.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.controller.form.LooseMoneyBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.LooseMoneyBill;

/**
 * 零钱账单 Service
 * 
 * @author caozj
 * 
 */
public interface LooseMoneyBillService {

	void add(LooseMoneyBill looseMoneyBill);

	void update(LooseMoneyBill looseMoneyBill);

	void delete(Long id);

	List<LooseMoneyBill> listAll();

	Long count();

	Long countBy(String field, Object value);

	Long countByAnd(String field1, Object value1, String field2, Object value2);

	Long countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> page(Pager page);

	LooseMoneyBill get(Long id);

	void batchDelete(List<Long> idList);

	LooseMoneyBill getBy(String field, Object value);

	LooseMoneyBill getByAnd(String field1, Object value1, String field2, Object value2);

	LooseMoneyBill getByOr(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> listBy(String field, Object value);

	List<LooseMoneyBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> pageBy(String field, Object value, Pager page);

	List<LooseMoneyBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<LooseMoneyBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<LooseMoneyBill> page(LooseMoneyBillSearchForm searchForm, Pager pager);

	Long count(LooseMoneyBillSearchForm searchForm);

	
	/**
	 * 查询未完成的订单，更新其状态
	 */
	void checkUnfinishOrder()throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException ;

}
