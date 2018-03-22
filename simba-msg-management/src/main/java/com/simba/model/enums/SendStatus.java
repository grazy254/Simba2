package com.simba.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linshuo on 2017/12/6.
 * <p>
 * 短信的发送状态
 */
public enum SendStatus {
	FAIL(0, "发送失败"), SUCCESS(1, "发送成功"), UNKNOWN(2, "发送中");

	private int id;
	private String description;

	private static Map<Integer, String> map = new HashMap<>();
	/**
	 * 发送状态返回码 4001 发送成功 4002 被叫手机号码为运营商黑名单，需联系运营商处理 4003
	 * 手机终端问题，手机关机、停机等，请确认手机状态是否正常 4004 被叫手机号码为空号，请核实手机号码是否合规 4005 可发送短信余量不足
	 * 4006 发送超频 4100 其他错误
	 */
	public static Map<Integer, String> JPUSH_STATUS = new HashMap<>();

	static {
		for (SendStatus status : SendStatus.values()) {
			map.put(status.getId(), status.getDescription());
		}
		JPUSH_STATUS.put(4001, "发送成功");
		JPUSH_STATUS.put(4002, "被叫手机号码为运营商黑名单，需联系运营商处理");
		JPUSH_STATUS.put(4003, "手机终端问题，手机关机、停机等，请确认手机状态是否正常");
		JPUSH_STATUS.put(4004, "被叫手机号码为空号");
		JPUSH_STATUS.put(4005, "可发送短信余量不足");
		JPUSH_STATUS.put(4006, "发送超频");
		JPUSH_STATUS.put(4010, "其他错误");
	}

	SendStatus(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static String getDescById(int id) {
		return map.get(id);
	}
}
