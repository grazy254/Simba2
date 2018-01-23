package com.simba.baidu.ai.model.audit;

import java.util.List;

/**
 * 文本审核结果内容对象
 * 
 * @author caozhejun
 *
 */
public class TextAuditResult {

	/**
	 * 请求中是否包含违禁，0表示非违禁，1表示违禁，2表示建议人工复审
	 */
	private int spam;

	/**
	 * 表示请求中的违禁类型，0表示非违禁，1-5为违禁的5种细分类型 1 文本色情 2 文本含号码推广 3 文本含url推广 4 文本推广 5
	 * 文本命中政治、辱骂、暴恐
	 */
	private int type;

	/**
	 * 请求中的违禁类型集合，一个或多个，审核通过则为空
	 */
	private List<Integer> types;

	/**
	 * 请求中的违禁类型集合，一个或多个，审核通过则为空 1 暴恐违禁 2 文本色情 3 政治敏感 4 恶意推广 5 低俗辱骂
	 */
	private List<Integer> labels;

	private List<String> hit;

	/**
	 * 正确调用生成的唯一标识码，用于问题定位
	 */
	private long logid;

	public int getSpam() {
		return spam;
	}

	public void setSpam(int spam) {
		this.spam = spam;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Integer> getTypes() {
		return types;
	}

	public void setTypes(List<Integer> types) {
		this.types = types;
	}

	public List<Integer> getLabels() {
		return labels;
	}

	public void setLabels(List<Integer> labels) {
		this.labels = labels;
	}

	public List<String> getHit() {
		return hit;
	}

	public void setHit(List<String> hit) {
		this.hit = hit;
	}

	public long getLogid() {
		return logid;
	}

	public void setLogid(long logid) {
		this.logid = logid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextAuditResult [spam=");
		builder.append(spam);
		builder.append(", type=");
		builder.append(type);
		builder.append(", types=");
		builder.append(types);
		builder.append(", labels=");
		builder.append(labels);
		builder.append(", hit=");
		builder.append(hit);
		builder.append(", logid=");
		builder.append(logid);
		builder.append("]");
		return builder.toString();
	}

}
