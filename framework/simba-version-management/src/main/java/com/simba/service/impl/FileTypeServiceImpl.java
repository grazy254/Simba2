package com.simba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.simba.dao.FileTypeDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FileType;
import com.simba.service.FileTypeService;

/**
 * 文件类型管理 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class FileTypeServiceImpl implements FileTypeService {

	@Autowired
	private FileTypeDao fileTypeDao;

	@Override
	public void add(FileType fileType) {
		fileTypeDao.add(fileType);
	}

	@Override
	public void delete(Integer id) {
		fileTypeDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public FileType get(Integer id) {
		return fileTypeDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> page(Pager page) {
		return fileTypeDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return fileTypeDao.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value){
		return fileTypeDao.countBy(field,value);
	}
	
	@Override
	public void deleteBy(String field, Object value){
		fileTypeDao.deleteBy(field,value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> listAll() {
		return fileTypeDao.listAll();
	}

	@Override
	public void update(FileType fileType) {
		fileTypeDao.update(fileType);
	}
	
	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public FileType getBy(String field, Object value) {
		return fileTypeDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public FileType getByAnd(String field1, Object value1, String field2, Object value2) {
		return fileTypeDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public FileType getByOr(String field1, Object value1, String field2, Object value2) {
		return fileTypeDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> listBy(String field, Object value) {
		return fileTypeDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> listByAnd(String field1, Object value1, String field2, Object value2) {
		return fileTypeDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> listByOr(String field1, Object value1, String field2, Object value2) {
		return fileTypeDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> pageBy(String field, Object value, Pager page) {
		return fileTypeDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return fileTypeDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return fileTypeDao.pageByOr(field1, value1, field2, value2, page);
	}
	
}
