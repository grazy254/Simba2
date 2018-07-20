package com.simba.okhttp.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.simba.exception.BussException;
import com.simba.model.constant.ConstantData;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
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
		Request request = buildGetRequest(url);
		return execute(request);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param callback
	 */
	public void get(String url, Callback callback) {
		Request request = buildGetRequest(url);
		asyncExecute(request, callback);
	}

	private Request buildGetRequest(String url) {
		Request request = new Request.Builder().url(url).build();
		return request;
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

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public String post(String url) throws IOException {
		Request request = buildPostRequest(url);
		return execute(request);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param callback
	 */
	public void post(String url, Callback callback) {
		Request request = buildPostRequest(url);
		asyncExecute(request, callback);
	}

	private Request buildPostRequest(String url) {
		FormBody.Builder builder = new FormBody.Builder();
		Request request = new Request.Builder().url(url).post(builder.build()).build();
		return request;
	}

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public String post(String url, Map<String, String> param) throws IOException {
		Request request = buildPostRequest(url, param);
		return execute(request);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param param
	 * @param callback
	 */
	public void post(String url, Map<String, String> param, Callback callback) {
		Request request = buildPostRequest(url, param);
		asyncExecute(request, callback);
	}

	private Request buildPostRequest(String url, Map<String, String> param) {
		FormBody.Builder builder = new FormBody.Builder();
		param.forEach((key, value) -> {
			builder.add(key, value);
		});
		Request request = new Request.Builder().url(url).post(builder.build()).build();
		return request;
	}

	/**
	 * 以http body方式同步提交json数据
	 * 
	 * @param url
	 * @param json
	 * @return
	 * @throws IOException
	 */
	public String postJson(String url, String json) throws IOException {
		Request request = buildJsonRequest(url, json);
		return execute(request);
	}

	/**
	 * 以http body方式异步提交json数据
	 * 
	 * @param url
	 * @param json
	 * @param callback
	 */
	public void postJson(String url, String json, Callback callback) {
		Request request = buildJsonRequest(url, json);
		asyncExecute(request, callback);
	}

	private Request buildJsonRequest(String url, String json) {
		MediaType type = MediaType.parse("application/json;charset=" + ConstantData.DEFAULT_CHARSET);
		RequestBody body = RequestBody.create(type, json);
		Request request = new Request.Builder().url(url).post(body).build();
		return request;
	}

	private Request buildXmlRequest(String url, String json) {
		MediaType type = MediaType.parse("application/xml;charset=" + ConstantData.DEFAULT_CHARSET);
		RequestBody body = RequestBody.create(type, json);
		Request request = new Request.Builder().url(url).post(body).build();
		return request;
	}

	/**
	 * 以http body方式同步提交xml数据
	 * 
	 * @param url
	 * @param xml
	 * @return
	 * @throws IOException
	 */
	public String postXml(String url, String xml) throws IOException {
		Request request = buildXmlRequest(url, xml);
		return execute(request);
	}

	/**
	 * 以http body方式异步提交xml数据
	 * 
	 * @param url
	 * @param xml
	 * @param callback
	 */
	public void postXml(String url, String xml, Callback callback) {
		Request request = buildXmlRequest(url, xml);
		asyncExecute(request, callback);
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(File file, String url) throws IOException {
		Request request = buildFileRequest(file, url);
		return execute(request);
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param url
	 * @param callback
	 */
	public void fileUpload(File file, String url, Callback callback) {
		Request request = buildFileRequest(file, url);
		asyncExecute(request, callback);
	}

	private Request buildFileRequest(File file, String url) {
		MediaType type = MediaType.parse("File/*");
		RequestBody body = RequestBody.create(type, file);
		Request request = new Request.Builder().url(url).post(body).build();
		return request;
	}

	/**
	 * 上传文件
	 * 
	 * @param url
	 * @param param
	 * @param fileName
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(String url, Map<String, String> param, String fileName, File file) throws IOException {
		Request request = buildFileRequest(url, param, fileName, file);
		return execute(request);
	}

	/**
	 * 批量上传文件
	 * 
	 * @param url
	 * @param param
	 * @param fileNames
	 * @param files
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(String url, Map<String, String> param, List<String> fileNames, List<File> files) throws IOException {
		Request request = buildFileRequest(url, param, fileNames, files);
		return execute(request);
	}

	/**
	 * 批量上传文件
	 * 
	 * @param url
	 * @param param
	 * @param fileNames
	 * @param files
	 * @return
	 */
	public void fileUpload(String url, Map<String, String> param, List<String> fileNames, List<File> files, Callback callback) {
		Request request = buildFileRequest(url, param, fileNames, files);
		asyncExecute(request, callback);
	}

	private Request buildFileRequest(String url, Map<String, String> param, List<String> fileNames, List<File> files) {
		Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
		param.forEach((key, value) -> {
			builder.addFormDataPart(key, value);
		});
		int length = fileNames.size();
		for (int i = 0; i < length; i++) {
			String fileName = fileNames.get(i);
			File file = files.get(i);
			builder.addFormDataPart(fileName, file.getName(), RequestBody.create(MediaType.parse("File/*"), file));
		}
		MultipartBody body = builder.build();
		Request request = new Request.Builder().url(url).post(body).build();
		return request;
	}

	/**
	 * 上传文件
	 * 
	 * @param url
	 * @param param
	 * @param fileName
	 * @param file
	 */
	public void fileUpload(String url, Map<String, String> param, String fileName, File file, Callback callback) {
		Request request = buildFileRequest(url, param, fileName, file);
		asyncExecute(request, callback);
	}

	private Request buildFileRequest(String url, Map<String, String> param, String fileName, File file) {
		Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
		param.forEach((key, value) -> {
			builder.addFormDataPart(key, value);
		});
		builder.addFormDataPart(fileName, file.getName(), RequestBody.create(MediaType.parse("File/*"), file));
		MultipartBody body = builder.build();
		Request request = new Request.Builder().url(url).post(body).build();
		return request;
	}

}
