package com.simba.eureka.client;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * spring cloud eureka客户端工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class EurekaClientUtil {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            请求地址
	 * @return
	 */
	public String get(String url) {
		return restTemplate.getForEntity(url, String.class).getBody();
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param values
	 *            值对象
	 * @return
	 */
	public String post(String url, Map<String, String> values) {
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>(values.size());
		values.forEach((key, value) -> {
			map.add(key, value);
		});
		return restTemplate.postForObject(url, map, String.class);
	}
}
