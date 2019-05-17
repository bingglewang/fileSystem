package com.bing.picturelibrary.dto;

import java.util.Date;

public class ImageFileResult {
    // 图片id
    private String imgId;

    // 存储服务器
    private String imgLocationServer;

    // 图片存放位置
    private String imgLocation;

    // 图片访问地址
    private String imgUrl;

    // 系统id
    private String imgSystemId;

    // 图片标签
    private String imgFlag;

    // 图片属性
    private String imgAttribute;

    // 特定唯一表示值
    private String imgSpecificUniqueValue;

    // 图片参数
    private String imgParam;

    // 备注
    private String imgRemark;

    // 类型
    private String imgType;

    // "图片创建时间")
    private Date imgCreateTime;

    // 图片更新时间
    private Date imgUpdateTime;

    // 开放标识
    private String imgOpenFlag;

    // 图片状态
    private Integer imgStatus;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgLocationServer() {
        return imgLocationServer;
    }

    public void setImgLocationServer(String imgLocationServer) {
        this.imgLocationServer = imgLocationServer;
    }

    public String getImgLocation() {
        return imgLocation;
    }

    public void setImgLocation(String imgLocation) {
        this.imgLocation = imgLocation;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgSystemId() {
        return imgSystemId;
    }

    public void setImgSystemId(String imgSystemId) {
        this.imgSystemId = imgSystemId;
    }

    public String getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(String imgFlag) {
        this.imgFlag = imgFlag;
    }

    public String getImgAttribute() {
        return imgAttribute;
    }

    public void setImgAttribute(String imgAttribute) {
        this.imgAttribute = imgAttribute;
    }

    public String getImgSpecificUniqueValue() {
        return imgSpecificUniqueValue;
    }

    public void setImgSpecificUniqueValue(String imgSpecificUniqueValue) {
        this.imgSpecificUniqueValue = imgSpecificUniqueValue;
    }

    public String getImgParam() {
        return imgParam;
    }

    public void setImgParam(String imgParam) {
        this.imgParam = imgParam;
    }

    public String getImgRemark() {
        return imgRemark;
    }

    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public Date getImgCreateTime() {
        return imgCreateTime;
    }

    public void setImgCreateTime(Date imgCreateTime) {
        this.imgCreateTime = imgCreateTime;
    }

    public Date getImgUpdateTime() {
        return imgUpdateTime;
    }

    public void setImgUpdateTime(Date imgUpdateTime) {
        this.imgUpdateTime = imgUpdateTime;
    }

    public String getImgOpenFlag() {
        return imgOpenFlag;
    }

    public void setImgOpenFlag(String imgOpenFlag) {
        this.imgOpenFlag = imgOpenFlag;
    }

    public Integer getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(Integer imgStatus) {
        this.imgStatus = imgStatus;
    }
}
