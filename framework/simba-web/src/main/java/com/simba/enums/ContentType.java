package com.simba.enums;

/**
 * http头的ContentType
 * 
 * @author caozhejun
 *
 */
public enum ContentType {

	XML("text/xml; charset=UTF-8"),

	JSON("application/json; charset=UTF-8"),

	HTML("text/html; charset=UTF-8"),

	STREAM("application/octet-stream"),

	TEXT("text/plain; charset=UTF-8"),

	MULTIPART("multipart/form-data; charset=UTF-8");

	private String type;

	private ContentType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
