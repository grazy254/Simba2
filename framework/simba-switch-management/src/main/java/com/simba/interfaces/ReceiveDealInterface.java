package com.simba.interfaces;

import com.simba.model.ReceiveDealType;
import com.simba.model.ReceiveMsg;

/**
 * 接收消息处理接口类
 * 
 * @author caozhejun
 *
 */
public interface ReceiveDealInterface {

	/**
	 * 处理接收消息的方法
	 * 
	 * @param msg
	 *            消息对象
	 * @param type
	 *            类型对象
	 */
	Object deal(ReceiveMsg msg, ReceiveDealType type);

}
