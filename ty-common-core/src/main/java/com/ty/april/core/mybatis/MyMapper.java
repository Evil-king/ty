package com.ty.april.core.mybatis;

import com.ty.april.core.mybatis.plugin.MyInsertListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author: wenqing
 * @date: 2017/7/6 19:18
 * @description: 通用Mapper插件接口，如需其他接口参考官方文档自行添加。
 */
public interface MyMapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T>, MyInsertListMapper {
}
