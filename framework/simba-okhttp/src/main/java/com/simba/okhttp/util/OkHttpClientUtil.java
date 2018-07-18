package com.simba.okhttp.util;

import java.io.IOException;
import java.util.Map;

import com.simba.exception.BussException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp client的工具类
 * 
 * @author caozhejun
 *
 */
public class OkHttpClientUtil {

	private OkHttpClient client;

	private OkHttpClientUtil() {
		init();
	}

	private void init() {
		client = new OkHttpClient();
	}

	private static final class OkHttpClientUtilHolder {
		private static final OkHttpClientUtil instance = new OkHttpClientUtil();
	}

	public static OkHttpClientUtil getInstance() {
		return OkHttpClientUtilHolder.instance;
	}

	/**
	 * 同步执行http请求
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String execute(Request request) throws IOException {
		Response res = client.newCall(request).execute();
		if (res.isSuccessful()) {
			return res.body().string();
		}
		throw new BussException("发送http请求发生异常:" + request.url().toString() + "," + res.body().string());
	}

	/**
	 * 异步执行http请求
	 * 
	 * @param request
	 * @param callback
	 */
	public void asyncExecute(Request request, Callback callback) {
		client.newCall(request).enqueue(callback);
	}

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public String get(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
		return execute(request);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param callback
	 */
	public void get(String url, Callback callback) {
		Request request = new Request.Builder().url(url).build();
		asyncExecute(request, callback);
	}

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public String get(String url, Map<String, String> params) throws IOException {
		url = buildUrl(url, params);
		return get(url);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param params
	 * @param callback
	 */
	public void get(String url, Map<String, String> params, Callback callback) {
		url = buildUrl(url, params);
		get(url, callback);
	}

	/**
	 * 将参数拼接到url后
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private String buildUrl(String url, Map<String, String> params) {
		StringBuilder queryString = new StringBuilder(url);
		if (url.indexOf("?") > -1) {
			queryString.append("&");
		} else {
			queryString.append("?");
		}
		int index = 0;
		int size = params.size();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			queryString.append(entry.getKey() + "=" + entry.getValue());
			if (index != size - 1) {
				queryString.append("&");
			}
			index++;
		}
		return queryString.toString();
	}

	public String post(String url) {
		return null;
	}
}
