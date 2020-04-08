package com.ty.april.order.controller;

import com.ty.april.common.tool.api.ApiResult;
import com.ty.april.common.tool.page.MyPageInfo;
import com.ty.april.order.model.Product;
import com.ty.april.order.common.dto.ProductDto;
import com.ty.april.order.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RefreshScope
//@Import(MyWebMvcConfigurer.class)
public class OrderController {

    @Autowired
    private IProductService productService;

    @PostMapping("/getTest")
    public ApiResult<?> getTest(@RequestBody @Valid ProductDto productDto){
        MyPageInfo<Product> productMyPageInfo = productService.queryById(productDto);
        return ApiResult.success(productMyPageInfo);
    }

}
