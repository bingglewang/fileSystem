package com.bing.picturelibrary.service.impl;

import com.bing.picturelibrary.config.COSConfig;
import com.bing.picturelibrary.dto.COSResult;
import com.bing.picturelibrary.service.COSServcie;
import com.bing.picturelibrary.util.COSClientUtil;
import com.bing.picturelibrary.util.CommonResult;
import com.bing.picturelibrary.util.FileType;
import com.bing.picturelibrary.util.FileTypeJudge;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class COSServiceImpl implements COSServcie {
    @Autowired
    private COSConfig cosConfig;


    @Override
    public List<COSResult> batch(MultipartFile[] files) {
        List<COSResult> cosResults = new ArrayList<>();
        // 获取COSClient操作对象
        COSClient cosclient= COSClientUtil.getCOSClient();
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = cosConfig.getBucketName();

        for(MultipartFile file : files){
            String size = file.getSize()*1.0/(1024*1024) + "M";//文件大小
            String oldFileName = file.getOriginalFilename(); //原始文件名称
            String eName = "";
            if(oldFileName.lastIndexOf(".") > 0) {
                eName = oldFileName.substring(oldFileName.lastIndexOf("."));  //文件类型
            }else{
                try {
                    eName =  ((FileType.toMap()).get(FileTypeJudge.getFileType(file.getInputStream()))).toString();
                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }
            String newFileName = UUID.randomUUID()+eName;
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month=cal.get(Calendar.MONTH) + 1;
            int day=cal.get(Calendar.DATE);
            // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
            // 大文件上传请参照 API 文档高级 API 上传
            File localFile = null;
            try {
                localFile = File.createTempFile("temp",null);
                file.transferTo(localFile);
                // 指定要上传到 COS 上的路径
                String key = "/"+cosConfig.getQianzui()+"/"+year+"/"+month+"/"+day+"/"+newFileName;
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
                PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
                cosResults.add(new COSResult(cosConfig.getPath() + putObjectRequest.getKey(),key,eName.substring(1),size,oldFileName));
            } catch (Exception e) {
                return null;
            }
        }
        // 关闭客户端(关闭后台线程)
        cosclient.shutdown();
        return cosResults;
    }

    @Override
    public COSResult upload(MultipartFile file) {
        String size = file.getSize()*1.0/(1024*1024) + "M";//文件大小
        String oldFileName = file.getOriginalFilename(); //原始文件名称
        String eName = "";
        if(oldFileName.lastIndexOf(".") > 0) {
            eName = oldFileName.substring(oldFileName.lastIndexOf("."));  //文件类型
        }else{
            try {
                eName =  ((FileType.toMap()).get(FileTypeJudge.getFileType(file.getInputStream()))).toString();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        String newFileName = UUID.randomUUID()+eName;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH) + 1;
        int day=cal.get(Calendar.DATE);
        // 获取COSClient操作对象
        COSClient cosclient= COSClientUtil.getCOSClient();
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = cosConfig.getBucketName();

        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = null;
        try {
            localFile = File.createTempFile("temp",null);
            file.transferTo(localFile);
            // 指定要上传到 COS 上的路径
            String key = "/"+cosConfig.getQianzui()+"/"+year+"/"+month+"/"+day+"/"+newFileName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            return new COSResult(cosConfig.getPath() + putObjectRequest.getKey(),key,eName.substring(1),size,oldFileName);
        } catch (Exception e) {
            return null;
        }finally {
            // 关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
    }

    @Override
    public void download(String fileKey, HttpServletResponse response) {
        // 获取COSClient操作对象
        COSClient cosclient= COSClientUtil.getCOSClient();
        File localFile = null;
        try{
            localFile = File.createTempFile("temp",null);
            // 指定文件所在的存储桶
            String bucketName = cosConfig.getBucketName();
            // 指定文件在 COS 上的对象键
            String key = fileKey;
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
            ObjectMetadata downObjectMeta = cosclient.getObject(getObjectRequest, localFile);
            response.setContentType("application/force-download");// 设置强制下载不打开
            //response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            response.setContentType("multipart/form-data;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName="+ new String(fileKey.getBytes("GB2312"),"ISO-8859-1"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            fis = new FileInputStream(localFile);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
    }

    @Override
    public void delete(String fileKey) {
        // 获取COSClient操作对象
        COSClient cosclient= COSClientUtil.getCOSClient();
        // 指定文件所在的存储桶
        String bucketName = cosConfig.getBucketName();
        // 指定文件在 COS 上的对象键
        String key = fileKey;
        cosclient.deleteObject(bucketName, key);
        // 关闭客户端(关闭后台线程)
        cosclient.shutdown();
    }
}
