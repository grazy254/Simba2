package com.simba.model.form;

import com.simba.annotation.DBFieldAnnotation;

public class SearchDictionaryTypeForm {

	/**
	 * 编码
	 */
	@DBFieldAnnotation(desc = "编码")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchDictionaryTypeForm [code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}

}
