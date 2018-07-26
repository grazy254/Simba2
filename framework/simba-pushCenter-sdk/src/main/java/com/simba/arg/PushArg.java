package com.simba.arg;

/**
 * Created by shuoGG on 2018/7/24
 */
public class PushArg {
    private String pushType;
    private String fromUserId;
    private String toUserId;
    private String content;

    public PushArg(String pushType, String fromUserId, String toUserId, String content) {
        this.pushType = pushType;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.content = content;
    }

    public PushArg() {
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PushArg{" +
                "pushType='" + pushType + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                ", toUserId='" + toUserId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
