package com.simba.framework.util.collection;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map工具类
 * 
 * @author caozj
 * 
 */
public class MapUtil {
	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Object convertMap(Class<?> type, Map<?, ?> map) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				Object value = map.get(propertyName);

				Object[] args = new Object[1];
				args[0] = value;

				descriptor.getWriteMethod().invoke(obj, args);
			}
		}
		return obj;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean(Object bean) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		Class<?> type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	/**
	 * 移除map中空key或者value空值
	 * 
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	public static void removeNullEntry(Map map) {
		removeNullKey(map);
		removeNullValue(map);
	}

	/**
	 * 移除map的空key
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static void removeNullKey(Map map) {
		Set set = map.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object obj = (Object) iterator.next();
			remove(obj, iterator);
		}
	}

	/**
	 * 移除map中的value空值
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static void removeNullValue(Map map) {
		Set set = map.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object obj = (Object) iterator.next();
			Object value = (Object) map.get(obj);
			remove(value, iterator);
		}
	}

	/**
	 * 移除map中的空值
	 * 
	 * Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。 Iterator
	 * 被创建之后会建立一个指向原来对象的单链索引表，当原来的对象数量发生变化时，这个索引表的内容不会同步改变，
	 * 所以当索引指针往后移动的时候就找不到要迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出
	 * java.util.ConcurrentModificationException 异常。 所以 Iterator
	 * 在工作的时候是不允许被迭代的对象被改变的。 但你可以使用 Iterator 本身的方法 remove() 来删除对象， Iterator.remove()
	 * 方法会在删除当前迭代对象的同时维护索引的一致性。
	 * 
	 * @param obj
	 * @param iterator
	 */
	@SuppressWarnings("rawtypes")
	private static void remove(Object obj, Iterator iterator) {
		if (obj instanceof String) {
			String str = (String) obj;
			if (isEmpty(str)) { // 过滤掉为null和""的值 主函数输出结果map：{2=BB, 1=AA, 5=CC, 8= }
				// if("".equals(str.trim())){ //过滤掉为null、""和" "的值 主函数输出结果map：{2=BB, 1=AA, 5=CC}
				iterator.remove();
			}

		} else if (obj instanceof Collection) {
			Collection col = (Collection) obj;
			if (col == null || col.isEmpty()) {
				iterator.remove();
			}

		} else if (obj instanceof Map) {
			Map temp = (Map) obj;
			if (temp == null || temp.isEmpty()) {
				iterator.remove();
			}

		} else if (obj instanceof Object[]) {
			Object[] array = (Object[]) obj;
			if (array == null || array.length <= 0) {
				iterator.remove();
			}
		} else {
			if (obj == null) {
				iterator.remove();
			}
		}
	}

	public static boolean isEmpty(Object obj) {
		return obj == null || obj.toString().length() == 0;
	}
}
