package com.simba.model;

import com.simba.annotation.DescAnnotation;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shuoGG on 2018/8/8
 */
@DescAnnotation(desc = "apk管理")
public class ApkVersion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 675998610879314964L;

	private int id;

    /**
     * 版本号
     */
    @DescAnnotation(desc = "版本号")
    private String version;

    @DescAnnotation(desc = "版本名")
    private String versionName;

    /**
     * 类型ID
     */
    @DescAnnotation(desc = "类型ID")
    private int typeId;

    /**
     * 文件大小
     */
    @DescAnnotation(desc = "文件大小")
    private double fileSize;
    /**
     * 文件路径
     */
    @DescAnnotation(desc = "文件路径")
    private String fileUrl;
    /**
     * 文件描述
     */
    @DescAnnotation(desc = "文件描述")
    private String description;

    /**
     * 时间
     */
    @DescAnnotation(desc = "时间")
    private Date createTime;

    /////////////// 扩展///////////////////
    /**
     * 类型名称
     */
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ApkVersion{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", versionName='" + versionName + '\'' +
                ", typeId=" + typeId +
                ", fileSize=" + fileSize +
                ", fileUrl='" + fileUrl + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", type='" + type + '\'' +
                '}';
    }
}
