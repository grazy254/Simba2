package com.simba.thrift;

import com.simba.exception.SimbaException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.*;

import java.io.IOException;

/**
 * thrift 客户端抽象类(具体调用逻辑放在request方法中，自己实现)
 * 
 * @author caozhejun
 *
 */
public abstract class ThriftClient {

	private static final Log logger = LogFactory.getLog(ThriftClient.class);

	/**
	 * thrift服务器的ip地址(必须)
	 */
	private String ip;

	/**
	 * thrift服务器的端口号(必须)
	 */
	private int port;

	/**
	 * 调用接口要使用的参数，多个参数，可以自定义对象或者直接使用Map
	 */
	private Object data;

	/**
	 * 调用thrift服务返回的结果
	 */
	private Object result;

	/**
	 * thrift回调方法，只有客户端类型为 异步非阻塞时才有效
	 */
	private AsyncMethodCallback<?> callback;

	/**
	 * thrift客户端的类型(必须)
	 */
	private ThriftClientType type;

	/**
	 * 
	 * 以下属性是预留给实现类使用的，可用在request方法中，构造thrift工具生成的代码客户端
	 * 
	 */
	/**
	 * 同步阻塞和同步非阻塞时使用
	 */
	protected TProtocol protocol;

	/**
	 * 以下三个字段是异步非阻塞时使用
	 */
	protected TAsyncClientManager clientManager;

	protected TNonblockingTransport asyncTransport;

	protected TProtocolFactory protocolFactory;

	/**
	 * 具体的业务逻辑实现
	 */
	protected abstract Object request();

	/**
	 * 发送thrift请求
	 */
	public void send() {
		try {
			sendRequst();
		} catch (Exception e) {
			logger.error("发送thrift请求异常", e);
			throw new SimbaException("发送thrift请求异常");
		}
	}

	private void sendRequst() throws TTransportException, IOException {
		if (type == ThriftClientType.SyncBlock || type == ThriftClientType.SyncUnblock) {
			sendSyncRequest();
		} else {
			sendAsynRequest();
		}
	}

	/**
	 * 发送同步请求
	 * 
	 * @throws TTransportException
	 */
	private void sendSyncRequest() throws TTransportException {
		TTransport syncTransport = null;
		if (type == ThriftClientType.SyncBlock) {
			syncTransport = new TSocket(ip, port);
		} else {
			syncTransport = new TFramedTransport(new TSocket(ip, port));
		}
		syncTransport.open();
		// 使用高密度二进制协议
		protocol = new TCompactProtocol(syncTransport);
		result = request();
		syncTransport.close();
	}

	/**
	 * 发送异步请求
	 * 
	 * @throws IOException
	 */
	private void sendAsynRequest() throws IOException {
		clientManager = new TAsyncClientManager();
		asyncTransport = new TNonblockingSocket(ip, port);
		// 使用高密度二进制协议
		protocolFactory = new TCompactProtocol.Factory();
		result = request();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public AsyncMethodCallback<?> getCallback() {
		return callback;
	}

	public void setCallback(AsyncMethodCallback<?> callback) {
		this.callback = callback;
	}

	public ThriftClientType getType() {
		return type;
	}

	public void setType(ThriftClientType type) {
		this.type = type;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
