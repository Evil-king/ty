package com.ty.product.feign.client;

import com.ty.april.common.tool.api.ApiResult;
import com.ty.product.feign.base.ProductDto;
import com.ty.product.feign.base.ProductVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Slf4j
@Component
public class ProductFallback implements IProductFeign {

    @Override
    public ApiResult<ProductVo> paymentSQL(@Valid ProductDto productDto) {
        return ApiResult.error("进入Product服务降级");
    }
}
