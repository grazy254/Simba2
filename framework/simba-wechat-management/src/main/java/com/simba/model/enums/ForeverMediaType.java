package com.simba.model.enums;

/**
 * 永久素材类型
 * 
 * @author caozhejun
 *
 */
public enum ForeverMediaType {

	IMAGE("image", "图片"),

	VOICE("voice", "语音"),

	VIDEO("video", "视频"),

	THUMB("thumb", "缩略图"),

	NEWS("news", "图文");

	private String name;

	private String description;

	private ForeverMediaType(String name, String description) {
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
