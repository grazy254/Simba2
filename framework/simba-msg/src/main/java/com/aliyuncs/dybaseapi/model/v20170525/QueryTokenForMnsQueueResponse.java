package com.aliyuncs.dybaseapi.model.v20170525;

import com.aliyuncs.AcsResponse;
import com.aliyuncs.dybaseapi.transform.v20170525.QueryTokenForMnsQueueResponseUnmarshaller;
import com.aliyuncs.transform.UnmarshallerContext;

public class QueryTokenForMnsQueueResponse extends AcsResponse {
	private String requestId;
	private String code;
	private String message;
	private MessageTokenDTO messageTokenDTO;

	public String getRequestId() {
		return this.requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageTokenDTO getMessageTokenDTO() {
		return this.messageTokenDTO;
	}

	public void setMessageTokenDTO(MessageTokenDTO messageTokenDTO) {
		this.messageTokenDTO = messageTokenDTO;
	}

	public QueryTokenForMnsQueueResponse getInstance(UnmarshallerContext context) {
		return QueryTokenForMnsQueueResponseUnmarshaller.unmarshall(this, context);
	}

	public static class MessageTokenDTO {
		private String accessKeyId;
		private String accessKeySecret;
		private String securityToken;
		private String createTime;
		private String expireTime;

		public String getAccessKeyId() {
			return this.accessKeyId;
		}

		public void setAccessKeyId(String accessKeyId) {
			this.accessKeyId = accessKeyId;
		}

		public String getAccessKeySecret() {
			return this.accessKeySecret;
		}

		public void setAccessKeySecret(String accessKeySecret) {
			this.accessKeySecret = accessKeySecret;
		}

		public String getSecurityToken() {
			return this.securityToken;
		}

		public void setSecurityToken(String securityToken) {
			this.securityToken = securityToken;
		}

		public String getCreateTime() {
			return this.createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public String getExpireTime() {
			return this.expireTime;
		}

		public void setExpireTime(String expireTime) {
			this.expireTime = expireTime;
		}
	}
}