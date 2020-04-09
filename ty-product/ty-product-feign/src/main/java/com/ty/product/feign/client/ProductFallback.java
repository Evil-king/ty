package com.ty.product.feign.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductFallback implements FallbackFactory<IProductFeign> {
    @Override
    public IProductFeign create(Throwable throwable) {
        log.info("进入Product服务降级");
        return null;
    }
}
