package com.simba.ios.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

/**
 * ios app推送通知实现工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class IosPushUtil {

	private static final Log logger = LogFactory.getLog(IosPushUtil.class);

	@Value("${ios.cert.path}")
	private String certPath;

	@Value("${ios.cert.password}")
	private String certPwd;

	@Value("${ios.cert.test}")
	private String certTest;

	/**
	 * 推送ios通知
	 * 
	 * @param token
	 *            设备token
	 * @param message
	 *            推送通知的内容
	 * @throws JSONException
	 * @throws CommunicationException
	 * @throws KeystoreException
	 */
	public void send(String token, String message) throws JSONException, CommunicationException, KeystoreException {
		PushNotificationPayload payLoad = new PushNotificationPayload();
		payLoad.addAlert(message); // 消息内容
		PushNotificationManager pushManager = new PushNotificationManager();
		// true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
		pushManager.initializeConnection(new AppleNotificationServerBasicImpl(certPath, certPwd, !"true".equals(certTest)));
		List<PushedNotification> notifications = new ArrayList<PushedNotification>();
		Device device = new BasicDevice();
		device.setToken(token);
		PushedNotification notification = pushManager.sendNotification(device, payLoad, true);
		notifications.add(notification);
		List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
		List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);
		int failed = failedNotifications.size();
		int successful = successfulNotifications.size();
		pushManager.stopConnection();
		logger.info("成功推送[" + successful + "]条，失败[" + failed + "]条");
	}

	/**
	 * 推送ios通知
	 * 
	 * @param tokens
	 *            设备token列表
	 * @param message
	 *            推送通知的内容
	 * @throws JSONException
	 * @throws CommunicationException
	 * @throws KeystoreException
	 */
	public void send(List<String> tokens, String message) throws JSONException, CommunicationException, KeystoreException {
		PushNotificationPayload payLoad = new PushNotificationPayload();
		payLoad.addAlert(message); // 消息内容
		PushNotificationManager pushManager = new PushNotificationManager();
		// true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
		pushManager.initializeConnection(new AppleNotificationServerBasicImpl(certPath, certPwd, !"true".equals(certTest)));
		List<Device> devices = new ArrayList<Device>();
		for (String token : tokens) {
			Device device = new BasicDevice();
			device.setToken(token);
			devices.add(device);
		}
		List<PushedNotification> notifications = pushManager.sendNotifications(payLoad, devices);
		List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
		List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);
		int failed = failedNotifications.size();
		int successful = successfulNotifications.size();
		pushManager.stopConnection();
		logger.info("成功推送[" + successful + "]条，失败[" + failed + "]条");
	}
}
