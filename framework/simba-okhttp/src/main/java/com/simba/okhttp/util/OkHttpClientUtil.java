package com.simba.okhttp.util;

import java.io.IOException;

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

}
