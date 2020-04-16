package com.ty.product.feign.base;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductDto{
    private String goodsNo;
    private String goodsName;
}
