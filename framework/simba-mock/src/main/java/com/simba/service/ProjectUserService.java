package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ProjectUser;
import com.simba.permission.model.User;

/**
 * Service
 * 
 * @author caozj
 * 
 */
public interface ProjectUserService {

	void add(ProjectUser projectUser);

	void update(ProjectUser projectUser);

	void delete(Integer id);

	List<ProjectUser> listAll();

	int count();
	
	int countBy(String field, Object value);
	
	List<ProjectUser> page(Pager page);

	ProjectUser get(Integer id);
	
	void batchDelete(List<Integer> idList);

	ProjectUser getBy(String field, Object value);

	ProjectUser getByAnd(String field1, Object value1, String field2, Object value2);

	ProjectUser getByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectUser> listBy(String field, Object value);

	List<ProjectUser> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ProjectUser> listByOr(String field1, Object value1, String field2, Object value2);

	List<ProjectUser> pageBy(String field, Object value, Pager page);

	List<ProjectUser> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ProjectUser> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);
	
	List<User> pageByProjectId(String field, Object value, Pager page);

    int countUser(int projectId);

    void deleteUser(String account, Integer projectId);

    void batchDeleteUser(List<String> accountList, Integer projectId);

    Integer getUserType(String account, Integer projectId);

    List<User> listByProjectId(Integer projectId);

    void assignUsers(Integer projectId, List<String> accountsChecked, String currentAccount);

}
