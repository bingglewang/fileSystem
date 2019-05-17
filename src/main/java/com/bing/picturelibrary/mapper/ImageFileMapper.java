package com.bing.picturelibrary.mapper;

import com.bing.picturelibrary.dto.in.ImageFileQuery;
import com.bing.picturelibrary.model.ImageFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageFileMapper {
    /**
     * 根据图片主键删除图片（逻辑删除）
     * @param ids
     * @return
     */
    int deleteByPrimaryKey(@Param("Ids") List<String> ids);

    /**
     * 根据图片主键恢复
     * @param ids
     * @return
     */
    int recovery(@Param("Ids") List<String> ids);

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
     * @return
     */
     List<ImageFile> getImageFileByPage(@Param("query") ImageFileQuery query);

    /**
     * 获取所有的图片文件
     * @return
     */
    List<ImageFile> getImageFileAll();
}