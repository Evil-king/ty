package com.ty.user.api.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ty.april.common.tool.api.ApiResult;
import com.ty.april.common.tool.exception.ServiceException;
import com.ty.product.feign.base.ProductDto;
import com.ty.product.feign.base.ProductVo;
import com.ty.product.feign.client.IProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.BadLocationException;

@RestController
public class UserController {

    @Autowired
    private IProductFeign productFeign;


    @GetMapping("/user/test")
    public ApiResult test() {
        ProductDto productDto = new ProductDto();
        productDto.setId("2");
        ApiResult<ProductVo> productVoApiResult = productFeign.paymentSQL(productDto);
        return productVoApiResult;
    }

    @GetMapping("/user/fallback/{id}")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback") //fallback只负责业务异常，但是我们已经有全局异常处理机制了，这块可以不用
    @SentinelResource(value = "fallback", blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
    public ApiResult testSentinel(@PathVariable Long id){
        if(id == 4){
            throw new ServiceException("IllegalArgumentException,非法参数异常");
        } else {
            return ApiResult.success();
        }
    }

//    public ApiResult handlerFallback(Throwable e) {
//        return ApiResult.badParam("兜底异常handlerFallback,exception内容" + e.getMessage());
//    }

    public ApiResult blockHandler(BadLocationException b) {
        return ApiResult.badParam("兜底异常blockHandler-sentinel限流，无此流水" + b.getMessage());
    }

}
