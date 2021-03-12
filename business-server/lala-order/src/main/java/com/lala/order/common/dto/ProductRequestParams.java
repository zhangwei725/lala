package com.lala.order.common.dto;

import lombok.Data;

@Data
public class ProductRequestParams {
    /**
     * 商品ID
     */
    private Integer productId;
    /**
     * 购买商品的数量
     */
    private Integer quantity;
}
