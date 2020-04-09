package com.ty.user.api.controller;

import com.ty.april.common.tool.api.ApiResult;
import com.ty.product.feign.base.ProductDto;
import com.ty.product.feign.base.ProductVo;
import com.ty.product.feign.client.IProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IProductFeign productFeign;


    @GetMapping("/user/test")
    public ApiResult test(){
        ProductDto productDto = new ProductDto();
        productDto.setId("2");
        ApiResult<ProductVo> productVoApiResult = productFeign.paymentSQL(productDto);
        return  productVoApiResult;
    }
}
