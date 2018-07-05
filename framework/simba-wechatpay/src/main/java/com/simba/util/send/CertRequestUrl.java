package com.simba.util.send;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;

/**
 * 带微信支付证书的http/https请求工具类
 * 
 * @author caozhejun
 *
 */
public class CertRequestUrl {

	private static final Log logger = LogFactory.getLog(CertRequestUrl.class);

	private String certFile = null;

	private String mchId = null;

	private CertRequestUrl() {
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		certFile = environmentUtil.get("wx.pay.cert");
		mchId = environmentUtil.get("wx.pay.mchid");
	}

	private static final class CertRequestUrlHolder {
		private static final CertRequestUrl instance = new CertRequestUrl();
	}

	public static CertRequestUrl getInstance() {
		return CertRequestUrlHolder.instance;
	}

	public String executeWithKey(String url, String xml) throws ParseException, IOException {
		logger.info("微信支付带证书提交请求到:" + url + ",内容为:" + xml);
		SSLContext sslContext = buildSSLContext();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, null, new DefaultHostnameVerifier());
		HttpPost httpPost = new HttpPost(url);
		try (CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build()) {
			httpPost.setEntity(new StringEntity(new String(xml.getBytes("UTF-8"), "ISO-8859-1")));
			try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
				String result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
				logger.info("微信支付带证书提交请求到:" + url + ",返回结果:" + result);
				return result;
			}
		} finally {
			httpPost.releaseConnection();
		}
	}

	private SSLContext buildSSLContext() {
		File file = new File(certFile);
		if (!file.exists()) {
			throw new RuntimeException("证书文件：【" + file.getPath() + "】不存在！");
		}
		try {
			FileInputStream inputStream = new FileInputStream(file);
			KeyStore keystore = KeyStore.getInstance("PKCS12");
			char[] partnerId2charArray = mchId.toCharArray();
			keystore.load(inputStream, partnerId2charArray);
			return SSLContexts.custom().loadKeyMaterial(keystore, partnerId2charArray).build();
		} catch (Exception e) {
			throw new RuntimeException("证书文件有问题，请核实！", e);
		}
	}
}
