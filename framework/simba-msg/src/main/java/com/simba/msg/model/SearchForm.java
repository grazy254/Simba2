package com.simba.msg.model;

/**
 * 短信查询接口参数对象
 * 
 * @author caozhejun
 *
 */
public class SearchForm {

	/**
	 * 短信接收号码,如果需要查询国际短信,号码前需要带上对应国家的区号,区号的获取详见国际短信支持国家信息查询API接口(必须)
	 */
	private String phoneNumber;

	/**
	 * 发送流水号,从调用发送接口返回值中获取(可选)
	 */
	private String bizId;

	/**
	 * 短信发送日期格式yyyyMMdd,支持最近30天记录查询(必须)
	 */
	private String sendDate;

	/**
	 * 页大小Max=50(必须)
	 */
	private long pageSize = 10L;

	/**
	 * 当前页码(必须)
	 */
	private long currentPage = 1L;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchForm [phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", bizId=");
		builder.append(bizId);
		builder.append(", sendDate=");
		builder.append(sendDate);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", currentPage=");
		builder.append(currentPage);
		builder.append("]");
		return builder.toString();
	}

}
