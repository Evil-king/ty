package com.ty.product.api.interfaces;

import com.ty.april.common.tool.api.ApiResult;
import com.ty.product.api.application.service.ProductApplicationService;
import com.ty.product.api.domain.productPb.service.IProductService;
import com.ty.product.feign.base.ProductVo;
import com.ty.product.feign.base.ProductDto;
import com.ty.product.feign.client.IProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements IProductFeign {

    @Autowired
    private ProductApplicationService productApplicationService;

    @Override
    public ApiResult<ProductVo> paymentSQL(@RequestBody ProductDto productDto) {
        return ApiResult.success(productApplicationService.queryById(productDto));
    }


}
