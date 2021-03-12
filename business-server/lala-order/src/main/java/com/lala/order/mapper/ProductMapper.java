package com.lala.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lala.order.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper extends BaseMapper<Product> {
    int updateByIdAndVersion(@Param("product") Product product);
}