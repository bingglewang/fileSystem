package com.bing.picturelibrary.controller;

import com.bing.picturelibrary.config.COSConfig;
import com.bing.picturelibrary.dto.COSResult;
import com.bing.picturelibrary.dto.ImageFileResult;
import com.bing.picturelibrary.dto.in.*;
import com.bing.picturelibrary.model.ImageFile;
import com.bing.picturelibrary.service.COSServcie;
import com.bing.picturelibrary.service.ImageFileService;
import com.bing.picturelibrary.util.CommonResult;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageFileController {

    @Autowired
    private ImageFileService imageFileService;

    @Autowired
    private COSServcie cosServcie;

    @Autowired
    private COSConfig cosConfig;

    /**
     * 根据图片id获取图片
     * @param imgId
     * @return
     */
    @GetMapping("/{imgId}")
    public CommonResult<ImageFileResult> getImageById(@PathVariable String imgId){
        ImageFile source =  imageFileService.selectByPrimaryKey(imgId);
        if(source != null){
            ImageFileResult target = new ImageFileResult();
            BeanUtils.copyProperties(source,target);
            return CommonResult.success(target);
        }else{
            return CommonResult.success(null);
        }
    }

    /**
     * 获取全部图片文件
     * @return
     */
    @GetMapping("/getAll")
    public CommonResult<List<ImageFile>> getImageAll(){
        List<ImageFile> allImages = imageFileService.getImageFileAll();
        if(!CollectionUtils.isEmpty(allImages)){
            return CommonResult.success(allImages);
        }else{
            return CommonResult.success(null);
        }
    }

    /**
     * 根据图片id逻辑删除图片(批量删除)
     * @param intIdsQuery
     * @return
     */
    @DeleteMapping
    public CommonResult<ImageFileResult> deleteImageById(@RequestBody @Valid IntIdsQuery intIdsQuery,BindingResult result){
        int i = imageFileService.deleteByPrimaryKey(intIdsQuery.getIds());
        if(i > 0){
            return CommonResult.success(null,"删除成功");
        }else{
            return CommonResult.failed("删除失败");
        }
    }

    /**
     * 添加图片
     * @param formData
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public CommonResult<ImageFileResult> add(@ModelAttribute @Valid FormData formData,BindingResult result1){
        if(formData.getFile() == null){
            return CommonResult.failed("文件不能为空");
        }
        COSResult result = cosServcie.upload(formData.getFile());
        if(result == null){
            return CommonResult.failed("添加失败(上传失败)");
        }
        //向数据库添加图片相关信息
        ImageFile imageFile = new ImageFile();
        if(StringUtils.isBlank(formData.getImgOpenFlag())){
            formData.setImgOpenFlag("Y");//默认开放
        }
        BeanUtils.copyProperties(formData,imageFile);
        String img_id = UUID.randomUUID()+""+System.currentTimeMillis(); //生成图片id
        imageFile.setImgId(img_id);
        imageFile.setImgLocationServer(cosConfig.getLocationServer()); //存放服务器
        imageFile.setImgLocation(result.getFileKey()); //存放位置
        imageFile.setImgUrl(result.getUrl()); //访问地址
        int i = imageFileService.insert(imageFile);
        if(i > 0){
            ImageFile imageDetail= imageFileService.selectByPrimaryKey(imageFile.getImgId());
            ImageFileResult resultData = new ImageFileResult();
            BeanUtils.copyProperties(imageDetail,resultData);
            return CommonResult.success(resultData,"添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    /**
     * 批量添加图片
     * @param batchFormData
     * @return
     */
    @PostMapping("/addBatch")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public CommonResult<List<ImageFileResult>> addBatch(@ModelAttribute @Valid BatchFormData batchFormData,BindingResult result1){
        List<ImageFileResult> resultImageList = new ArrayList<>();
        if(batchFormData.getFiles() == null || batchFormData.getFiles().length == 0){
            return CommonResult.failed("至少选择一个文件");
        }
        List<COSResult> resultList = cosServcie.batch(batchFormData.getFiles());
        if(CollectionUtils.isEmpty(resultList)) {
            return CommonResult.failed("添加失败(上传失败)");
        }
        for(COSResult result : resultList) {
            //向数据库添加图片相关信息
            ImageFile imageFile = new ImageFile();
            if (StringUtils.isBlank(batchFormData.getImgOpenFlag())) {
                batchFormData.setImgOpenFlag("Y");//默认开放
            }
            BeanUtils.copyProperties(batchFormData, imageFile);
            String img_id = UUID.randomUUID() + "" + System.currentTimeMillis(); //生成图片id
            imageFile.setImgId(img_id);
            imageFile.setImgLocationServer(cosConfig.getLocationServer()); //存放服务器
            imageFile.setImgLocation(result.getFileKey()); //存放位置
            imageFile.setImgUrl(result.getUrl()); //访问地址
            int i = imageFileService.insert(imageFile);
            if (i <= 0) {
                throw new RuntimeException("添加失败");
            }else{
                ImageFile imageDetail= imageFileService.selectByPrimaryKey(imageFile.getImgId());
                ImageFileResult resultData = new ImageFileResult();
                BeanUtils.copyProperties(imageDetail,resultData);
                resultImageList.add(resultData);
            }
        }
        return CommonResult.success(resultImageList, "添加成功");
    }

    /**
     * 批量恢复删除的文件
     * @param intIdsQuery
     * @return
     */
    @PutMapping("/recovery")
    public CommonResult<ImageFileResult> recovery(@RequestBody @Valid IntIdsQuery intIdsQuery,BindingResult result){
        int i = imageFileService.recovery(intIdsQuery.getIds());
        if(i > 0){
            return CommonResult.success(null,"恢复成功");
        }else{
            return CommonResult.failed("恢复失败");
        }
    }

    /**
     * 更新图片
     * @param imageFileIn
     * @return
     */
    @PostMapping("/update")
    public CommonResult<ImageFileResult> update(@RequestBody @Valid ImageFileIn imageFileIn,BindingResult result){
        ImageFile imageFile = new ImageFile();
        BeanUtils.copyProperties(imageFileIn,imageFile);
        int i = imageFileService.updateByPrimaryKey(imageFile);
        if(i > 0){
            return CommonResult.success(null,"更新成功");
        }else{
            return CommonResult.failed("更新失败");
        }
    }

    @GetMapping("/getByPage")
    @ResponseBody
    public CommonResult<PageInfo<ImageFile>> getImageFileByPage(@Valid ImageFileQuery query, @Valid PageParams pageParams,BindingResult result){
        PageInfo<ImageFile> pageInfo = imageFileService.getImageFileByPage(query,pageParams);
        if(pageInfo != null){
            return CommonResult.success(pageInfo,"查询成功");
        }else{
            return CommonResult.failed("查询失败");
        }
    }
}
