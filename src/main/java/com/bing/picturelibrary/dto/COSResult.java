package com.bing.picturelibrary.dto;

public class COSResult {
    private String url;  //图片地址
    private String fileKey; //文件对象COS上的对象key
    private String type;//文件类型
    private String size;//文件大小
    private String originalFilename; //原始文件名称

    public COSResult(String url, String fileKey, String type, String size, String originalFilename) {
        this.url = url;
        this.fileKey = fileKey;
        this.type = type;
        this.size = size;
        this.originalFilename = originalFilename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }
}
