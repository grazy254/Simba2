package com.simba.model.form;

/**
 * 字典类型查询Form
 * 
 * @author caozhejun
 *
 */
public class SearchDirectionaryTypeForm {

	/**
	 * 编码
	 */
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
		builder.append("SearchDirectionaryTypeForm [code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}

}
