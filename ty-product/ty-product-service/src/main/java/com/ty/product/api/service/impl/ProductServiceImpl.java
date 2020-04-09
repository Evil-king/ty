package com.ty.product.api.service.impl;

import com.ty.april.core.mybatis.AbstractService;
import com.ty.product.api.dao.ProductMapper;
import com.ty.product.api.model.Product;
import com.ty.product.api.service.IProductService;
import com.ty.product.feign.base.ProductVo;
import com.ty.product.feign.base.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;



/**
* @author: wenqing
* @date: 2020/04/09 16:57:50
* @description: Product服务实现
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl extends AbstractService<Product> implements IProductService {

    @Autowired
    private ProductMapper tblProductMapper;

    @Override
    public ProductVo queryById(ProductDto productDto) {
        Condition condition = new Condition(Product.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("id",productDto.getId());
        Product products = tblProductMapper.selectByCondition(condition).get(0);
//        MyPageInfo<Product> myPageInfo = pageList(condition, PageParam.buildWithDefaultSort(productDto.getCurrentPage(), productDto.getPageSize()));
        ProductVo productVo = ProductVo.builder().goodsName(products.getGoodsName()).goodsNo(products.getGoodsNo()).id(products.getId()).build();
        return productVo;
    }
}
