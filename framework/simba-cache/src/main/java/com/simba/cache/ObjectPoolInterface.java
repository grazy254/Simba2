package com.simba.cache;

/**
 * 对象池接口类
 * 
 * @author caozhejun
 *
 */
public interface ObjectPoolInterface {

	/**
	 * 保存对象
	 * 
	 * @param key
	 * @param value
	 */
	public void save(String key, Object value);

	/**
	 * 获取对象
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key);

	/**
	 * 删除对象
	 * 
	 * @param key
	 */
	public void remove(String key);
}
