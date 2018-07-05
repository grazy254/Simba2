package com.simba.model;

import com.simba.annotation.DescAnnotation;

import java.util.Date;
/**
 *
 * 用户分组关联表
 * @author lilei
 *
 */
@DescAnnotation(desc = "用户分组关联表")
public class UserGroup  {

    private long id;

    private long userId;

    private long groupId;

    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserGroup [id= "+ id+ " ,userId= "+ userId+ " ,groupId= "+ groupId+ " ,createTime= "+ createTime+ " ]";
    }
}
