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
	 * 同步执行http请求返回字节数组
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public byte[] executeBackBytes(Request request) throws IOException {
		Response res = client.newCall(request).execute();
		if (res.isSuccessful()) {
			return res.body().bytes();
		}
		throw new BussException("发送http请求发生异常:" + request.url().toString());
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
		Request request = buildGetRequestWithHeaders(url, null);
		return execute(request);
	}

	/**
	 * 同步发送http请求(一般用于下载文件)
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public byte[] getBytes(String url) throws IOException {
		Request request = buildGetRequestWithHeaders(url, null);
		return executeBackBytes(request);
	}

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public String getWithHeaders(String url, Map<String, String> headers) throws IOException {
		Request request = buildGetRequestWithHeaders(url, headers);
		return execute(request);
	}

	/**
	 * 同步发送http请求(一般用于下载文件)
	 * 
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public byte[] getBytesWithHeaders(String url, Map<String, String> headers) throws IOException {
		Request request = buildGetRequestWithHeaders(url, headers);
		return executeBackBytes(request);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param callback
	 */
	public void get(String url, Callback callback) {
		Request request = buildGetRequestWithHeaders(url, null);
		asyncExecute(request, callback);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param headers
	 * @param callback
	 */
	public void getWithHeaders(String url, Map<String, String> headers, Callback callback) {
		Request request = buildGetRequestWithHeaders(url, headers);
		asyncExecute(request, callback);
	}

	private Request buildGetRequestWithHeaders(String url, Map<String, String> headers) {
		okhttp3.Request.Builder builder = new Request.Builder().url(url);
		setHeaders(headers, builder);
		return builder.build();
	}

	private void setHeaders(Map<String, String> headers, okhttp3.Request.Builder builder) {
		if (headers != null && headers.size() > 0) {
			headers.forEach((key, value) -> {
				builder.addHeader(key, value);
			});
		}
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
	 * 同步发送http请求(一般用于下载文件)
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public byte[] getBytes(String url, Map<String, String> params) throws IOException {
		url = buildUrl(url, params);
		return getBytes(url);
	}

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public String getWithHeaders(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
		url = buildUrl(url, params);
		return getWithHeaders(url, headers);
	}

	/**
	 * 同步发送http请求(一般用于下载文件)
	 * 
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public byte[] getBytesWithHeaders(String url, Map<String, String> params, Map<String, String> headers) throws IOException {
		url = buildUrl(url, params);
		return getBytesWithHeaders(url, headers);
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
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param params
	 * @param headers
	 * @param callback
	 */
	public void getWithHeaders(String url, Map<String, String> params, Map<String, String> headers, Callback callback) {
		url = buildUrl(url, params);
		getWithHeaders(url, headers, callback);
	}

	/**
	 * 将参数拼接到url后
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private String buildUrl(String url, Map<String, String> params) {
		if (params == null || params.size() == 0) {
			return url;
		}
		return joinUrl(url, params);
	}

	private String joinUrl(String url, Map<String, String> params) {
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
		Request request = buildPostRequestWithHeaders(url, null);
		return execute(request);
	}

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public String postWithHeaders(String url, Map<String, String> headers) throws IOException {
		Request request = buildPostRequestWithHeaders(url, headers);
		return execute(request);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param callback
	 */
	public void post(String url, Callback callback) {
		Request request = buildPostRequestWithHeaders(url, null);
		asyncExecute(request, callback);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param headers
	 * @param callback
	 */
	public void postWithHeaders(String url, Map<String, String> headers, Callback callback) {
		Request request = buildPostRequestWithHeaders(url, headers);
		asyncExecute(request, callback);
	}

	private Request buildPostRequestWithHeaders(String url, Map<String, String> headers) {
		FormBody.Builder builder = new FormBody.Builder();
		okhttp3.Request.Builder requestBuilder = new Request.Builder().url(url);
		setHeaders(headers, requestBuilder);
		return requestBuilder.post(builder.build()).build();
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
		Request request = buildPostRequestWithHeaders(url, param, null);
		return execute(request);
	}

	/**
	 * 同步发送http请求
	 * 
	 * @param url
	 * @param param
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public String post(String url, Map<String, String> param, Map<String, String> headers) throws IOException {
		Request request = buildPostRequestWithHeaders(url, param, headers);
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
		Request request = buildPostRequestWithHeaders(url, param, null);
		asyncExecute(request, callback);
	}

	/**
	 * 异步发送http请求
	 * 
	 * @param url
	 * @param param
	 * @param headers
	 * @param callback
	 */
	public void post(String url, Map<String, String> param, Map<String, String> headers, Callback callback) {
		Request request = buildPostRequestWithHeaders(url, param, headers);
		asyncExecute(request, callback);
	}

	private Request buildPostRequestWithHeaders(String url, Map<String, String> param, Map<String, String> headers) {
		FormBody.Builder builder = new FormBody.Builder();
		setParam(param, builder);
		okhttp3.Request.Builder requestBuilder = new Request.Builder().url(url);
		setHeaders(headers, requestBuilder);
		return requestBuilder.post(builder.build()).build();
	}

	private void setParam(Map<String, String> param, FormBody.Builder builder) {
		if (param != null && param.size() > 0) {
			param.forEach((key, value) -> {
				builder.add(key, value);
			});
		}
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
		Request request = buildJsonRequestWithHeaders(url, json, null);
		return execute(request);
	}

	/**
	 * 以http body方式同步提交json数据
	 * 
	 * @param url
	 * @param json
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public String postJsonWithHeaders(String url, String json, Map<String, String> headers) throws IOException {
		Request request = buildJsonRequestWithHeaders(url, json, headers);
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
		Request request = buildJsonRequestWithHeaders(url, json, null);
		asyncExecute(request, callback);
	}

	/**
	 * 以http body方式异步提交json数据
	 * 
	 * @param url
	 * @param json
	 * @param headers
	 * @param callback
	 */
	public void postJson(String url, String json, Map<String, String> headers, Callback callback) {
		Request request = buildJsonRequestWithHeaders(url, json, headers);
		asyncExecute(request, callback);
	}

	private Request buildJsonRequestWithHeaders(String url, String json, Map<String, String> headers) {
		MediaType type = MediaType.parse("application/json;charset=" + ConstantData.DEFAULT_CHARSET);
		RequestBody body = RequestBody.create(type, json);
		okhttp3.Request.Builder requestBuilder = new Request.Builder().url(url);
		setHeaders(headers, requestBuilder);
		return requestBuilder.post(body).build();
	}

	private Request buildXmlRequestWithHeaders(String url, String json, Map<String, String> headers) {
		MediaType type = MediaType.parse("application/xml;charset=" + ConstantData.DEFAULT_CHARSET);
		RequestBody body = RequestBody.create(type, json);
		okhttp3.Request.Builder requestBuilder = new Request.Builder().url(url);
		setHeaders(headers, requestBuilder);
		return requestBuilder.post(body).build();
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
		Request request = buildXmlRequestWithHeaders(url, xml, null);
		return execute(request);
	}

	/**
	 * 以http body方式同步提交xml数据
	 * 
	 * @param url
	 * @param xml
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public String postXml(String url, String xml, Map<String, String> headers) throws IOException {
		Request request = buildXmlRequestWithHeaders(url, xml, headers);
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
		Request request = buildXmlRequestWithHeaders(url, xml, null);
		asyncExecute(request, callback);
	}

	/**
	 * 以http body方式异步提交xml数据
	 * 
	 * @param url
	 * @param xml
	 * @param headers
	 * @param callback
	 */
	public void postXml(String url, String xml, Map<String, String> headers, Callback callback) {
		Request request = buildXmlRequestWithHeaders(url, xml, headers);
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
		Request request = buildFileRequestWithHeaders(url, null, null, "file", file);
		return execute(request);
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param url
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(File file, String url, Map<String, String> headers) throws IOException {
		Request request = buildFileRequestWithHeaders(url, null, headers, "file", file);
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
		Request request = buildFileRequestWithHeaders(url, null, null, "file", file);
		asyncExecute(request, callback);
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param url
	 * @param headers
	 * @param callback
	 */
	public void fileUpload(File file, String url, Map<String, String> headers, Callback callback) {
		Request request = buildFileRequestWithHeaders(url, null, null, "file", file);
		asyncExecute(request, callback);
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
		Request request = buildFileRequestWithHeaders(url, param, null, fileName, file);
		return execute(request);
	}

	/**
	 * 上传文件
	 * 
	 * @param url
	 * @param param
	 * @param headers
	 * @param fileName
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(String url, Map<String, String> param, Map<String, String> headers, String fileName, File file) throws IOException {
		Request request = buildFileRequestWithHeaders(url, param, headers, fileName, file);
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
		Request request = buildFileRequestWithHeaders(url, param, null, fileNames, files);
		return execute(request);
	}

	/**
	 * 批量上传文件
	 * 
	 * @param url
	 * @param param
	 * @param headers
	 * @param fileNames
	 * @param files
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(String url, Map<String, String> param, Map<String, String> headers, List<String> fileNames, List<File> files) throws IOException {
		Request request = buildFileRequestWithHeaders(url, param, headers, fileNames, files);
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
		Request request = buildFileRequestWithHeaders(url, param, null, fileNames, files);
		asyncExecute(request, callback);
	}

	/**
	 * 批量上传文件
	 * 
	 * @param url
	 * @param param
	 * @param headers
	 * @param fileNames
	 * @param files
	 * @param callback
	 */
	public void fileUpload(String url, Map<String, String> param, Map<String, String> headers, List<String> fileNames, List<File> files, Callback callback) {
		Request request = buildFileRequestWithHeaders(url, param, headers, fileNames, files);
		asyncExecute(request, callback);
	}

	private Request buildFileRequestWithHeaders(String url, Map<String, String> param, Map<String, String> headers, List<String> fileNames, List<File> files) {
		Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
		setParam(param, builder);
		addFiles(fileNames, files, builder);
		MultipartBody body = builder.build();
		okhttp3.Request.Builder requestBuilders = new Request.Builder().url(url);
		setHeaders(headers, requestBuilders);
		return requestBuilders.post(body).build();
	}

	private void addFiles(List<String> fileNames, List<File> files, Builder builder) {
		int length = fileNames.size();
		for (int i = 0; i < length; i++) {
			String fileName = fileNames.get(i);
			File file = files.get(i);
			builder.addFormDataPart(fileName, file.getName(), RequestBody.create(MediaType.parse("File/*"), file));
		}
	}

	private void setParam(Map<String, String> param, Builder builder) {
		if (param != null && param.size() > 0) {
			param.forEach((key, value) -> {
				builder.addFormDataPart(key, value);
			});
		}
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
		Request request = buildFileRequestWithHeaders(url, param, null, fileName, file);
		asyncExecute(request, callback);
	}

	/**
	 * 上传文件
	 * 
	 * @param url
	 * @param param
	 * @param headers
	 * @param fileName
	 * @param file
	 * @param callback
	 */
	public void fileUpload(String url, Map<String, String> param, Map<String, String> headers, String fileName, File file, Callback callback) {
		Request request = buildFileRequestWithHeaders(url, param, headers, fileName, file);
		asyncExecute(request, callback);
	}

	private Request buildFileRequestWithHeaders(String url, Map<String, String> param, Map<String, String> headers, String fileName, File file) {
		Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
		setParam(param, builder);
		builder.addFormDataPart(fileName, file.getName(), RequestBody.create(MediaType.parse("File/*"), file));
		MultipartBody body = builder.build();
		okhttp3.Request.Builder requestBuilders = new Request.Builder().url(url);
		setHeaders(headers, requestBuilders);
		return requestBuilders.post(body).build();
	}

}
