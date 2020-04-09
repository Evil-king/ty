package com.ty.product.feign.base;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductVo {
    private int id;
    private String goodsNo;
    private String goodsName;
}