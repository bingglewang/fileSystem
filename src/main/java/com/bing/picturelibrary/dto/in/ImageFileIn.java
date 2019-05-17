package com.bing.picturelibrary.dto.in;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ImageFileIn {
    // 图片id
    @NotEmpty(message = "图片id不能为空")
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

    // 开放标识
    @Pattern(regexp = "^((Y)|(N))$", message="开放标识格式错误")
    private String imgOpenFlag;


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

    public String getImgOpenFlag() {
        return imgOpenFlag;
    }

    public void setImgOpenFlag(String imgOpenFlag) {
        this.imgOpenFlag = imgOpenFlag;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
}
