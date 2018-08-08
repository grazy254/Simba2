package com.simba.service;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ApkVersion;
import org.csource.common.FastdfsException;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 *apk管理 Service
 * 
 * @author caozj
 * 
 */
public interface ApkVersionService {

	void add(ApkVersion apkVersion);

	void update(ApkVersion apkVersion);

    void add(ApkVersion apkVersion, MultipartFile file) throws Exception;

    void delete(Integer id) throws IOException, FastdfsException;

	List<ApkVersion> listAll();
		
	Integer count();
	
	Integer countBy(String field, Object value);
	
	Integer countByAnd(String field1, Object value1, String field2, Object value2);
	
	Integer countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<ApkVersion> page(Pager page);
	
	ApkVersion get(Integer id);
	
	void batchDelete(List<Integer> idList) throws IOException, FastdfsException;

	void update(ApkVersion apkVersion, MultipartFile file) throws Exception;

	ApkVersion getBy(String field, Object value);

	ApkVersion getByAnd(String field1, Object value1, String field2, Object value2);

	ApkVersion getByOr(String field1, Object value1, String field2, Object value2);

	List<ApkVersion> listBy(String field, Object value);

	List<ApkVersion> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ApkVersion> listByOr(String field1, Object value1, String field2, Object value2);

	List<ApkVersion> pageBy(String field, Object value, Pager page);

	List<ApkVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ApkVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

    ApkVersion getNewest(int typeId);
}
