package com.bing.picturelibrary.service;

import com.bing.picturelibrary.dto.in.ImageFileQuery;
import com.bing.picturelibrary.dto.in.PageParams;
import com.bing.picturelibrary.model.ImageFile;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ImageFileService {
    /**
     * 根据图片主键删除图片（逻辑删除）
     * @param Ids
     * @return
     */
    int deleteByPrimaryKey(List<String> Ids);

    /**
     * 根据图片主键批量恢复
     * @param Ids
     * @return
     */
    int recovery(List<String> Ids);

    /**
     * 新增图片（全部）
     * @param record
     * @return
     */
    int insert(ImageFile record);

    /**
     * 根据主键查询图片
     * @param imgId
     * @return
     */
    ImageFile selectByPrimaryKey(String imgId);

    /**
     * 根据主键更新图片(全部)
     * @param record
     * @return
     */
    int updateByPrimaryKey(ImageFile record);

    /**
     * 按条件分页查询图片文件
     * @param query
     * @param pageParams
     * @return
     */
    PageInfo getImageFileByPage(ImageFileQuery query, PageParams pageParams);

    /**
     * 获取所有的图片文件
     * @return
     */
    List<ImageFile> getImageFileAll();
}
