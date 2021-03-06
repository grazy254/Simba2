package com.alicom.mns.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dybaseapi.model.v20170525.QueryTokenForMnsQueueRequest;
import com.aliyuncs.dybaseapi.model.v20170525.QueryTokenForMnsQueueResponse;
import com.aliyuncs.dybaseapi.model.v20170525.QueryTokenForMnsQueueResponse.MessageTokenDTO;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 获取接收云通信消息的临时token
 *
 */
public class TokenGetterForAlicom {
	private Log logger=LogFactory.getLog(TokenGetterForAlicom.class);
	private String accessKeyId;
	private String accessKeySecret;
	private String endpointNameForPop;
	private String regionIdForPop;
	private String domainForPop;
	private IAcsClient iAcsClient;
	private Long ownerId;
	private final static String productName="Dybaseapi";
	private long bufferTime=1000*60*2;//过期时间小于2分钟则重新获取，防止服务器时间误差
	private final Object lock=new Object();
	private ConcurrentMap<String, TokenForAlicom> tokenMap=new ConcurrentHashMap<String, TokenForAlicom>();
	public TokenGetterForAlicom(String accessKeyId,String accessKeySecret,
			String endpointNameForPop,String regionIdForPop, String domainForPop, Long ownerId) throws ClientException{
		this.accessKeyId=accessKeyId;
		this.accessKeySecret=accessKeySecret;
		this.endpointNameForPop=endpointNameForPop;
		this.regionIdForPop=regionIdForPop;
		this.domainForPop=domainForPop;
		this.ownerId = ownerId;
		init();
	}
	
	private void init() throws ClientException{
		DefaultProfile.addEndpoint(endpointNameForPop, regionIdForPop, productName, domainForPop);
		IClientProfile profile = DefaultProfile.getProfile(regionIdForPop, accessKeyId, accessKeySecret);
		iAcsClient = new DefaultAcsClient(profile);
	}
	private TokenForAlicom getTokenFromRemote(String messageType) throws ServerException, ClientException, ParseException{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		QueryTokenForMnsQueueRequest request=new QueryTokenForMnsQueueRequest();
		request.setAcceptFormat(FormatType.JSON);
		request.setMessageType(messageType);
		request.setOwnerId(ownerId);
		request.setProtocol(ProtocolType.HTTPS);
		QueryTokenForMnsQueueResponse response = iAcsClient.getAcsResponse(request);
		String resultCode=response.getCode();
		if(resultCode!=null&&"OK".equals(resultCode)){
			MessageTokenDTO dto=response.getMessageTokenDTO();
			TokenForAlicom token=new TokenForAlicom();
			String timeStr=dto.getExpireTime();
			token.setMessageType(messageType);
			token.setExpireTime(df.parse(timeStr).getTime());
			token.setToken(dto.getSecurityToken());
			token.setTempAccessKeyId(dto.getAccessKeyId());
			token.setTempAccessKeySecret(dto.getAccessKeySecret());
			return token;
		}else{
			logger.error("getTokenFromRemote_error,messageType:"+messageType+",code:"+response.getCode()+",message:"+response.getMessage());
			throw new ServerException(response.getCode(),response.getMessage());
		}
	}
	
	public TokenForAlicom getTokenByMessageType(String messageType,String queueName,String mnsAccountEndpoint) throws ServerException, ClientException, ParseException{
		TokenForAlicom token=tokenMap.get(messageType);
		Long now=System.currentTimeMillis();		
		if(token==null||(token.getExpireTime()-now)<bufferTime){//过期时间小于2分钟则重新获取，防止服务器时间误差	
			synchronized (lock) {
				token=tokenMap.get(messageType);
				if(token==null||(token.getExpireTime()-now)<bufferTime){
					TokenForAlicom oldToken=null;
					if(token!=null){
						oldToken=token;
					}
					token=getTokenFromRemote(messageType);
					//因为换token时需要重建client和关闭老的client，所以创建client的代码和创建token放在一起
					CloudAccount account = new CloudAccount(
							token.getTempAccessKeyId(),token.getTempAccessKeySecret(),mnsAccountEndpoint,token.getToken()
							);
//					logger.warn("ak:"+token.getTempAccessKey());
//					logger.warn("token:"+token.getToken());
					MNSClient client = account.getMNSClient();
					CloudQueue queue=client.getQueueRef(queueName);
					token.setClient(client);
					token.setQueue(queue);
					tokenMap.put(messageType, token);
					if(oldToken!=null){
						oldToken.closeClient();
					}
				}	
			}
		}
		return token;
	}
}
