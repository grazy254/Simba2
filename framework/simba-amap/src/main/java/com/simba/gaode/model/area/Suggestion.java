package com.simba.gaode.model.area;

import java.util.List;

/**
 * 建议结果
 * 
 * @author caozhejun
 *
 */
public class Suggestion {

	private List<String> keywords;

	private List<String> cites;

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getCites() {
		return cites;
	}

	public void setCites(List<String> cites) {
		this.cites = cites;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Suggestion []");
		return builder.toString();
	}

}
