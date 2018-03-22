package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.FileType;

/**
 *文件类型管理 Service
 * 
 * @author caozj
 * 
 */
public interface FileTypeService {

	void add(FileType fileType);

	void update(FileType fileType);

	void delete(Integer id);

	List<FileType> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<FileType> page(Pager page);

	FileType get(Integer id);
	
	void batchDelete(List<Integer> idList);

	FileType getBy(String field, Object value);

	FileType getByAnd(String field1, Object value1, String field2, Object value2);

	FileType getByOr(String field1, Object value1, String field2, Object value2);

	List<FileType> listBy(String field, Object value);

	List<FileType> listByAnd(String field1, Object value1, String field2, Object value2);

	List<FileType> listByOr(String field1, Object value1, String field2, Object value2);

	List<FileType> pageBy(String field, Object value, Pager page);

	List<FileType> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<FileType> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
