package com.bing.picturelibrary.controller;

import com.bing.picturelibrary.dto.COSResult;
import com.bing.picturelibrary.service.COSServcie;
import com.bing.picturelibrary.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        COSResult result = cosServcie.upload(file);
        if(result != null){
           return  CommonResult.success(result,"上传成功");
        }else{
            return CommonResult.failed("上传失败");
        }
    }

    /**
     * 批量上传
     * @param files
     * @param session
     * @return
     */
    @PostMapping(value = "/batch")
    @ResponseBody
    public CommonResult<List<COSResult>> batch(@RequestParam(value = "files") MultipartFile[] files, HttpSession session){
        if(files.length == 0){
            return CommonResult.failed("至少选择一个文件");
        }
        List<COSResult> result = cosServcie.batch(files);
        if(!CollectionUtils.isEmpty(result)){
            return  CommonResult.success(result,"上传成功");
        }else{
            return CommonResult.failed("上传失败");
        }
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
