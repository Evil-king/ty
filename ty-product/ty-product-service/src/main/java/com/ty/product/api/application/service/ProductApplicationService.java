package com.ty.product.api.application.service;

import com.ty.product.api.domain.productPb.service.IProductService;
import com.ty.product.feign.base.ProductDto;
import com.ty.product.feign.base.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductApplicationService {

    @Autowired
    private IProductService productService;

    public ProductVo queryById(ProductDto productDto) {
        return productService.queryById(productDto);
    }
}
