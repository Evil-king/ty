package com.ty.product.feign.base;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductDto{
    @NotBlank(message = "id不能为空")
    private String id;
}
