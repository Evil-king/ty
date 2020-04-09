package com.ty.product.feign.client;

import com.ty.april.common.tool.api.ApiResult;
import com.ty.product.feign.base.ProductVo;
import com.ty.product.feign.base.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@FeignClient(value = "product",fallback = ProductFallback.class)
public interface IProductFeign {

    @RequestMapping("/product/test")
    ApiResult<ProductVo> paymentSQL(@Valid ProductDto productDto);
}
