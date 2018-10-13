package com.simba.thrift;

/**
 * thrift客户端类型
 * 
 * @author caozhejun
 *
 */
public enum ThriftClientType {

	/**
	 * 同步阻塞
	 */
	SyncBlock,

	/**
	 * 同步非阻塞
	 */
	SyncUnblock,

	/**
	 * 异步非阻塞
	 */
	AsyncUnblock;
}
