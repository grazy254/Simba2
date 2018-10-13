package com.alicom.mns.tools;

import com.aliyun.mns.model.Message;

public interface MessageListener {

	public boolean dealMessage(Message message);

}
