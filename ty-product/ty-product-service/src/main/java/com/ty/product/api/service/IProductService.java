package com.ty.product.api.service;
import com.ty.april.core.mybatis.Service;
import com.ty.product.api.model.Product;
import com.ty.product.feign.base.ProductVo;
import com.ty.product.feign.base.ProductDto;


/**
* @author: wenqing
* @date: 2020/04/09 16:57:50
* @description: Product服务接口
*/
public interface IProductService extends Service<Product> {

    ProductVo queryById(ProductDto productDto);
}