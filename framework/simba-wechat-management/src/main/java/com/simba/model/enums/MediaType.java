package com.simba.model.enums;

/**
 * 素材类型
 * 
 * @author caozhejun
 *
 */
public enum MediaType {

	IMAGE("image", "图片"),

	VOICE("voice", "语音"),

	VIDEO("video", "视频"),

	THUMB("thumb", "缩略图");

	private String name;

	private String description;

	private MediaType(String name, String description) {
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
