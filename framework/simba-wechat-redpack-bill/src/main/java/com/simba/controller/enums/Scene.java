package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 场景(发放红包使用场景，红包金额大于200或者小于1元时必传)
 * 
 * @author caozhejun
 *
 */
public enum Scene {

	PRODUCT_1("PRODUCT_1", "商品促销"),

	PRODUCT_2("PRODUCT_2", "抽奖"),

	PRODUCT_3("PRODUCT_3", "虚拟物品兑奖"),

	PRODUCT_4("PRODUCT_4", "企业内部福利"),

	PRODUCT_5("PRODUCT_5", "渠道分润"),

	PRODUCT_6("PRODUCT_6", "保险回馈"),

	PRODUCT_7("PRODUCT_7", "彩票派奖"),

	PRODUCT_8("PRODUCT_8", "税务刮奖");

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	private Scene(String name, String description) {
		this.name = name;
		this.description = description;
	}

	private static Map<String, Scene> types = new HashMap<>();

	static {
		for (Scene scene : Scene.values()) {
			types.put(scene.getName(), scene);
		}
	}

	public static Scene get(String name) {
		return types.get(name);
	}

}
