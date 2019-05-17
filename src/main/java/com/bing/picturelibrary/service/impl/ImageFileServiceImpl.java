package com.bing.picturelibrary.service.impl;

import com.bing.picturelibrary.dto.in.ImageFileQuery;
import com.bing.picturelibrary.dto.in.PageParams;
import com.bing.picturelibrary.mapper.ImageFileMapper;
import com.bing.picturelibrary.model.ImageFile;
import com.bing.picturelibrary.service.ImageFileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageFileServiceImpl implements ImageFileService {

    @Autowired
    private ImageFileMapper imageFileMapper;

    @Override
    public int deleteByPrimaryKey(List<String> Ids) {
        return imageFileMapper.deleteByPrimaryKey(Ids);
    }

    @Override
    public int recovery(List<String> Ids) {
        return imageFileMapper.recovery(Ids);
    }

    @Override
    public int insert(ImageFile record) {
        return imageFileMapper.insert(record);
    }

    @Override
    public ImageFile selectByPrimaryKey(String imgId) {
        return imageFileMapper.selectByPrimaryKey(imgId);
    }

    @Override
    public int updateByPrimaryKey(ImageFile record) {
        return imageFileMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo getImageFileByPage(ImageFileQuery query, PageParams pageParams) {
        //设置排序，大小，页数
        if (pageParams.getPageSize() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize(), pageParams.getOrderBy());
        }

        //获取数据
        List<ImageFile> imageFiles = imageFileMapper.getImageFileByPage(query);

        //返回数据
        PageInfo<ImageFile> imageFilePage = new PageInfo<>(imageFiles);
        return imageFilePage;
    }

    @Override
    public List<ImageFile> getImageFileAll() {
        return imageFileMapper.getImageFileAll();
    }
}
