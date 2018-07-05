package com.simba.model.enums;

/**
 * 发送消息类型
 * 
 * @author caozhejun
 *
 */
public enum SendMessageType {

	TEXT("text", "文本"),

	IMAGE("image", "图片"),

	VOICE("voice", "语音"),

	VIDEO("video", "视频"),

	MUSIC("music", "音乐"),

	NEWS("news", "图文（点击跳转到外链） "),

	MPNEWS("mpnews", "图文（点击跳转到图文消息页面）");

	private String name;

	private String description;

	private SendMessageType(String name, String description) {
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
