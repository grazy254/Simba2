package com.simba.jsonp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 使@ResponseBody和@RestController默认支持jsonp的数据格式返回
 * 
 * @author caozhejun
 *
 */
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

	private static final String[] jsonpCallback = new String[] { "callback", "jsonp" };

	public JsonpAdvice() {
		super(jsonpCallback);
	}

}
