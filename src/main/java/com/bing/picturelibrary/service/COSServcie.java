package com.bing.picturelibrary.service;

import com.bing.picturelibrary.dto.COSResult;
import com.bing.picturelibrary.util.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * COS服务类
 * Created by bingglewang on 2019/6=5/15.
 */
public interface COSServcie {
    /**
     * 上传
     * @param file
     * @return
     */
    CommonResult<COSResult> upload(MultipartFile file);

    /**
     * 下载
     * @param fileKey
     * @param response
     * @return
     */
    void download(String fileKey, HttpServletResponse response);

    /**
     * 删除
     * @param fileKey
     * @return
     */
    void delete(String fileKey);
}
