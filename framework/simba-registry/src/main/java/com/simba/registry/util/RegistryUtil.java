package com.simba.registry.util;

import org.apache.commons.lang.StringUtils;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.registry.model.RegistryTableData;

/**
 * 注册表数据工具类(如果有在注册表中配置，则读取系统注册表中的配置，如果没有配置，则读取配置文件的配置)
 * 
 * @author caozhejun
 *
 */
public class RegistryUtil {

	/**
	 * 获取配置值(如果有在注册表中配置，则读取系统注册表中的配置，如果没有配置，则读取配置文件的配置)
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		String value = RegistryTableData.getInstance().get(key);
		if (StringUtils.isEmpty(value)) {
			EnvironmentUtil util = ApplicationContextUtil.getBean(EnvironmentUtil.class);
			value = util.get(key);
		}
		return value;
	}

}
