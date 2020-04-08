package com.ty.april.order.service.impl;

import com.ty.april.core.mybatis.AbstractService;
import com.ty.april.tool.page.MyPageInfo;
import com.ty.april.tool.page.PageParam;
import com.ty.april.order.common.dto.ProductDto;
import com.ty.april.order.dao.ProductMapper;
import com.ty.april.order.model.Product;
import com.ty.april.order.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;


/**
* @author: wenqing
* @date: 2020/04/03 11:53:56
* @description: Product服务实现
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl extends AbstractService<Product> implements IProductService {

    @Autowired
    private ProductMapper tblProductMapper;

    @Override
    public MyPageInfo<Product> queryById(ProductDto productDto) {
        Condition condition = new Condition(Product.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("id",productDto.getId());
        MyPageInfo<Product> myPageInfo = pageList(condition, PageParam.buildWithDefaultSort(productDto.getCurrentPage(), productDto.getPageSize()));
        return myPageInfo;
    }
}
