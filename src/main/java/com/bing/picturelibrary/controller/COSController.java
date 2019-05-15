package com.bing.picturelibrary.controller;

import com.bing.picturelibrary.dto.COSResult;
import com.bing.picturelibrary.service.COSServcie;
import com.bing.picturelibrary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/file")
public class COSController {
    @Autowired
    private COSServcie cosServcie;

    /**
     * 上传到腾讯云服务器(上传)
     * @return
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public CommonResult<COSResult> upload(@RequestParam(value = "file") MultipartFile file, HttpSession session){
        if(file == null){
            return CommonResult.failed("文件不能为空");
        }
        return cosServcie.upload(file);
    }

    /**
     * 从腾讯云服务器(下载)
     * @return
     */
    @GetMapping(value = "/download")
    @ResponseBody
    public void download(String fileKey, HttpServletResponse response){
        cosServcie.download(fileKey,response);
    }

    /**
     * 从腾讯云服务器(删除)
     * @return
     */
    @DeleteMapping(value = "/delete")
    @ResponseBody
    public CommonResult delete(String fileKey){
        cosServcie.delete(fileKey);
        return CommonResult.success(null,"删除成功");
    }
}
