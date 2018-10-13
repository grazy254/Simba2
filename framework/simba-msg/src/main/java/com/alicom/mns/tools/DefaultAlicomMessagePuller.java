package com.alicom.mns.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.model.Message;

/**
 * 阿里通信官方消息默认拉取工具类
 */
public class DefaultAlicomMessagePuller {
	private String mnsAccountEndpoint = "https://1943695596114318.mns.cn-hangzhou.aliyuncs.com/";// 阿里通信消息的endpoint,固定。
	private String endpointNameForPop = "cn-hangzhou";
	private String regionIdForPop = "cn-hangzhou";
	private String domainForPop = "dybaseapi.aliyuncs.com";

	private TokenGetterForAlicom tokenGetter;
	private MessageListener messageListener;
	private Log logger = LogFactory.getLog(DefaultAlicomMessagePuller.class);
	private boolean isRunning = false;
	private Integer sleepMillsWhenNoData = 3000;
	private Integer consumeMinThreadSize = 6;
	private Integer consumeMaxThreadSize = 16;
	private Integer pullMsgThreadSize = 1;
	private Integer threadQueueSize = 200;
	private boolean debugLogOpen = false;

	public void openDebugLog(boolean debugLogOpen) {
		this.debugLogOpen = debugLogOpen;
	}

	public Integer getSleepMillsWhenNoData() {
		return sleepMillsWhenNoData;
	}

	public void setSleepMillsWhenNoData(Integer sleepMillsWhenNoData) {
		this.sleepMillsWhenNoData = sleepMillsWhenNoData;
	}

	public Integer getConsumeMinThreadSize() {
		return consumeMinThreadSize;
	}

	public void setConsumeMinThreadSize(Integer consumeMinThreadSize) {
		if (consumeMinThreadSize != null && consumeMinThreadSize > 0) {
			this.consumeMinThreadSize = consumeMinThreadSize;
		}
	}

	public Integer getConsumeMaxThreadSize() {
		return consumeMaxThreadSize;
	}

	public void setConsumeMaxThreadSize(Integer consumeMaxThreadSize) {
		if (consumeMaxThreadSize != null && consumeMaxThreadSize > 0) {
			this.consumeMaxThreadSize = consumeMaxThreadSize;
		}
	}

	public Integer getPullMsgThreadSize() {
		return pullMsgThreadSize;
	}

	public void setPullMsgThreadSize(Integer pullMsgThreadSize) {
		if (pullMsgThreadSize != null && pullMsgThreadSize > 1) {
			this.pullMsgThreadSize = pullMsgThreadSize;
		}
	}

	public Integer getThreadQueueSize() {
		return threadQueueSize;
	}

	public void setThreadQueueSize(Integer threadQueueSize) {
		if (threadQueueSize != null && threadQueueSize > 0 && threadQueueSize < 20) {
			this.threadQueueSize = threadQueueSize;
		}
	}

	private class PullMessageTask implements Runnable {
		private String messageType;
		private String queueName;

		private ExecutorService cachedThreadPool = null;

		@Override
		public void run() {

			cachedThreadPool = new ThreadPoolExecutor(consumeMinThreadSize, consumeMaxThreadSize, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(threadQueueSize));

			while (isRunning) {

				try {
					TokenForAlicom tokenObject = tokenGetter.getTokenByMessageType(messageType, queueName, mnsAccountEndpoint);
					final CloudQueue queue = tokenObject.getQueue();

					if (debugLogOpen) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						logger.warn(Thread.currentThread().getName() + "-popStart at " + "," + format.format(new Date()));
					}

					final List<Message> popMsg = queue.batchPopMessage(16);

					if (debugLogOpen) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						logger.warn(Thread.currentThread().getName() + "-popDone at " + "," + format.format(new Date()) + " msgSize=" + (popMsg == null ? 0 : popMsg.size()));
					}

					if (popMsg != null && popMsg.size() > 0) {
						for (final Message message : popMsg) {
							cachedThreadPool.execute(new Thread() {
								@Override
								public void run() {

									if (debugLogOpen) {
										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										logger.warn(message.getMessageId() + "," + "receive" + "," + format.format(new Date()));
									}

									boolean dealResult = messageListener.dealMessage(message);

									if (debugLogOpen) {
										SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										logger.warn(message.getMessageId() + "," + "consumeResult" + dealResult + "," + format.format(new Date()));
									}

									if (dealResult) {
										// remember to delete message when
										// consume message successfully.
										queue.deleteMessage(message.getReceiptHandle());
									}
								}
							});
						}
					}
				} catch (Exception e) {
					logger.error("PullMessageTask_execute_error,messageType:" + messageType + ",queueName:" + queueName, e);
					try {
						Thread.sleep(sleepMillsWhenNoData);
					} catch (InterruptedException e1) {
						logger.error("PullMessageTask_execute_error,messageType:" + messageType + ",queueName:" + queueName, e);
					}
				}
			}

		}

	}

	/**
	 * @param accessKeyId
	 *            accessKeyId
	 * @param accessKeySecret
	 *            accessKeySecret
	 * @param messageType
	 *            消息类型
	 * @param queueName
	 *            队列名称
	 * @param messageListener
	 *            回调的listener,用户自己实现
	 * @throws com.aliyuncs.exceptions.ClientException
	 * @throws ParseException
	 */
	public void startReceiveMsg(String accessKeyId, String accessKeySecret, String messageType, String queueName, MessageListener messageListener)
			throws com.aliyuncs.exceptions.ClientException, ParseException {

		tokenGetter = new TokenGetterForAlicom(accessKeyId, accessKeySecret, endpointNameForPop, regionIdForPop, domainForPop, null);

		this.messageListener = messageListener;
		isRunning = true;
		PullMessageTask task = new PullMessageTask();
		task.messageType = messageType;
		task.queueName = queueName;

		for (int i = 0; i < pullMsgThreadSize; i++) {
			Thread thread = new Thread(task, "PullMessageTask-thread-" + i);
			thread.start();
		}
	}

	/**
	 * 虚商用户定制接收消息方法
	 * 
	 * @param accessKeyId
	 *            accessKeyId
	 * @param accessKeySecret
	 *            accessKeySecret
	 * @param ownerId
	 *            实际的ownerId
	 * @param messageType
	 *            消息类型
	 * @param queueName
	 *            队列名称
	 * @param messageListener
	 *            回调listener
	 * @throws com.aliyuncs.exceptions.ClientException
	 * @throws ParseException
	 */
	public void startReceiveMsgForPartnerUser(String accessKeyId, String accessKeySecret, Long ownerId, String messageType, String queueName, MessageListener messageListener)
			throws com.aliyuncs.exceptions.ClientException, ParseException {

		tokenGetter = new TokenGetterForAlicom(accessKeyId, accessKeySecret, endpointNameForPop, regionIdForPop, domainForPop, ownerId);

		this.messageListener = messageListener;
		isRunning = true;
		PullMessageTask task = new PullMessageTask();
		task.messageType = messageType;
		task.queueName = queueName;

		for (int i = 0; i < pullMsgThreadSize; i++) {
			Thread thread = new Thread(task, "PullMessageTask-thread-" + i);
			thread.start();
		}
	}

	public void stop() {
		isRunning = false;
	}

}
