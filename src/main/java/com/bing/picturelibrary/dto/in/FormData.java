package com.bing.picturelibrary.dto.in;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class FormData {
    MultipartFile file;
    @NotEmpty(message = "系统id不能为空")
    // 系统id
    private String imgSystemId;

    // 图片标签
    private String imgFlag;

    // 图片属性
    private String imgAttribute;

    @NotEmpty(message = "特定唯一表示值不能为空")
    // 特定唯一表示值
    private String imgSpecificUniqueValue;

    // 图片参数
    private String imgParam;

    // 备注
    private String imgRemark;

    // 类型
    private String imgType;

    @Pattern(regexp = "^((Y)|(N))?$", message="开放标识格式错误")
    // 开放标识
    private String imgOpenFlag;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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
}
