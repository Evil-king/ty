package com.ty.product.api.controller;

import com.ty.april.common.tool.api.ApiResult;
import com.ty.product.api.service.IProductService;
import com.ty.product.feign.base.ProductVo;
import com.ty.product.feign.base.ProductDto;
import com.ty.product.feign.client.IProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements IProductFeign {

    @Autowired
    private IProductService productService;

    @Override
    public ApiResult<ProductVo> paymentSQL(@RequestBody ProductDto productDto) {
        return ApiResult.success(productService.queryById(productDto));
    }


}
