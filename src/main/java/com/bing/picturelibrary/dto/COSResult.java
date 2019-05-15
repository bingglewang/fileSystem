package com.bing.picturelibrary.dto;

public class COSResult {
    private String url;  //图片地址
    private String fileKey; //文件对象COS上的对象key

    public COSResult(String url, String fileKey) {
        this.url = url;
        this.fileKey = fileKey;
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
}
