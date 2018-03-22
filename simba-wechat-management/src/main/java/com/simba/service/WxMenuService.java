package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.WxMenu;

/**
 *微信菜单 Service
 * 
 * @author caozj
 * 
 */
public interface WxMenuService {

	void add(WxMenu wxMenu);

	void update(WxMenu wxMenu);

	void delete(Integer id);

	List<WxMenu> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	List<WxMenu> page(Pager page);

	WxMenu get(Integer id);
	
	void batchDelete(List<Integer> idList);

	WxMenu getBy(String field, Object value);

	WxMenu getByAnd(String field1, Object value1, String field2, Object value2);

	WxMenu getByOr(String field1, Object value1, String field2, Object value2);

	List<WxMenu> listBy(String field, Object value);

	List<WxMenu> listByAnd(String field1, Object value1, String field2, Object value2);

	List<WxMenu> listByOr(String field1, Object value1, String field2, Object value2);

	List<WxMenu> pageBy(String field, Object value, Pager page);

	List<WxMenu> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<WxMenu> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
