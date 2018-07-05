package com.simba.model.enums;

/**
 * 群发发消息类型
 * 
 * @author caozhejun
 *
 */
public enum GroupMessageType {

	TEXT("text", "文本"),

	IMAGE("image", "图片"),

	VOICE("voice", "语音"),

	VIDEO("video", "视频"),

	NEWS("news", "图文 ");

	private String name;

	private String description;

	private GroupMessageType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
