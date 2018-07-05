package com.simba.service.message.impls;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simba.buss.model.Buss;
import com.simba.buss.service.BussService;
import com.simba.framework.util.groovy.GroovyUtil;
import com.simba.interfaces.ReceiveDealInterface;
import com.simba.model.ReceiveDealType;
import com.simba.model.ReceiveMsg;

/**
 * 通过执行groovy脚本来接收消息
 * 
 * @author caozhejun
 *
 */
@Service
public class ReceiveByGroovy implements ReceiveDealInterface {

	@Autowired
	private BussService bussService;

	@Override
	public Object deal(ReceiveMsg msg, ReceiveDealType type) {
		String ext = type.getExt();
		Buss buss = bussService.get(ext);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("msg", msg);
		param.put("type", type);
		String script = buss.getScript();
		return GroovyUtil.executeScript(script, param);
	}

}
