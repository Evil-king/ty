package com.ty.april.order.service;
import com.ty.april.core.mybatis.Service;
import com.ty.april.tool.page.MyPageInfo;
import com.ty.april.order.common.dto.ProductDto;
import com.ty.april.order.model.Product;


/**
* @author: wenqing
* @date: 2020/04/03 11:53:56
* @description: Product服务接口
*/
public interface IProductService extends Service<Product> {

    MyPageInfo<Product> queryById(ProductDto productDto);
}
