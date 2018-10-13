package com.simba.baidu.ai.model.audit;

/**
 * 文本审核结果对象
 * 
 * @author caozhejun
 *
 */
public class TextAuditResponse {

	/**
	 * 服务内部计算返回标识，无异常时都为0，-1表示command_no为空，-2表示content为空
	 */
	private int errno;

	/**
	 * 错误信息，仅在报错时会出现
	 */
	private String message;

	private TextAuditResult result;

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TextAuditResult getResult() {
		return result;
	}

	public void setResult(TextAuditResult result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextAuditResponse [errno=");
		builder.append(errno);
		builder.append(", message=");
		builder.append(message);
		builder.append(", result=");
		builder.append(result);
		builder.append("]");
		return builder.toString();
	}

}
