package com.bing.picturelibrary.dto.in;


import javax.validation.constraints.Min;

/**
 * 分页查询参数
 */
public class PageParams {
    /**
     * 当前页码
     */
    @Min(-1)
    private Integer pageNum;

    /**
     * 每页条数
     */
    @Min(-1)
    private Integer pageSize;

    /**
     * 排序
     */
    private String orderBy;

    public PageParams() {
    }

    public PageParams(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public PageParams(int pageSize, int pageNum, String orderBy) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.orderBy = orderBy;
    }

    public Integer getPageNum() {
        return pageNum == null ? 0 : pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 0 : pageSize;
    }

    public String getOrderBy() {
        return orderBy == null ? "" : orderBy;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
