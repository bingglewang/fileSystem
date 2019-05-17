package com.bing.picturelibrary.dto.in;

import java.util.Date;

public class ImageFileQuery {
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

    // 类型
    private String imgType;

    // "图片创建时间")
    private Date imgCreateTime;

    // 图片更新时间
    private Date imgUpdateTime;

    // 开放标识
    private String imgOpenFlag;

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
}
