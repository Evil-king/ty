package com.ty.april.common.tool.page;

import com.ty.april.common.tool.constants.DbConstant;
import lombok.Data;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author: wenqing
 * @date: 2019/3/25 11:07 PM
 * @description: 分页参数
 */
@Data
public class PageParam implements Serializable {


    // 当前页
    @NotNull(message = "当前页不能为空")
    @Min(value = 1, message = "当前页不能小于1")
    private Integer currentPage;

    // 每页记录数
    @NotNull(message = "每页记录数不能为空")
    @Max(value = 100, message = "每页记录数不能超过100")
    private Integer pageSize;

    // 排序字段
    private String sort;

    // 排序规则,asc/desc
    private String order;

    public PageParam() {
    }

    /**
     * 构建不带排序规则的分页参数
     *
     * @param currentPage
     * @param pageSize
     */
    public static PageParam build(Integer currentPage, Integer pageSize) {
        PageParam pageParam = new PageParam();
        pageParam.setCurrentPage(currentPage);
        pageParam.setPageSize(pageSize);
        return pageParam;
    }

    /**
     * 构建带排序规则的分页参数
     *
     * @param currentPage
     * @param pageSize
     * @param sort
     * @param order
     */
    public static PageParam build(Integer currentPage, Integer pageSize, String sort, String order) {
        PageParam pageParam = new PageParam();
        pageParam.setCurrentPage(currentPage);
        pageParam.setPageSize(pageSize);
        pageParam.setSort(sort);
        pageParam.setOrder(order);
        return pageParam;
    }

    /**
     * 构建默认按照创建时间倒序排序的分页参数(前提:数据库表必须有create_time字段)
     *
     * @return
     */
    public static PageParam buildWithDefaultSort(Integer currentPage, Integer pageSize) {
        PageParam pageParam = new PageParam();
        pageParam.setCurrentPage(currentPage);
        pageParam.setPageSize(pageSize);
        pageParam.setSort(DbConstant.CREATE_TIME);
        pageParam.setOrder(DbConstant.DESC);
        return pageParam;
    }
}
