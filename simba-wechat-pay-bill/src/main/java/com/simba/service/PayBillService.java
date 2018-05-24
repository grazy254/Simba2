package com.simba.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.controller.form.PayBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PayBill;

/**
 * 支付账单 Service
 * 
 * @author caozj
 * 
 */
public interface PayBillService {

	void add(PayBill payBill);

	void update(PayBill payBill);

	void delete(Long id);

	List<PayBill> listAll();

	Long count();

	Long countBy(String field, Object value);

	Long countByAnd(String field1, Object value1, String field2, Object value2);

	Long countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<PayBill> page(Pager page);

	PayBill get(Long id);

	void batchDelete(List<Long> idList);

	PayBill getBy(String field, Object value);

	PayBill getByAnd(String field1, Object value1, String field2, Object value2);

	PayBill getByOr(String field1, Object value1, String field2, Object value2);

	List<PayBill> listBy(String field, Object value);

	List<PayBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<PayBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<PayBill> pageBy(String field, Object value, Pager page);

	List<PayBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<PayBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<PayBill> page(PayBillSearchForm searchForm, Pager pager);

	Long count(PayBillSearchForm searchForm);

	/**
	 * 查询未完成的订单，更新其状态
	 */
	void checkUnfinishOrder()throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException ;

	/**
	 * 查询所有没有结束的订单信息
	 * 
	 * @return
	 */
	List<PayBill> listUnfinish();
}
