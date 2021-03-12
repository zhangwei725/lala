package com.lala.order.common.dto;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class OrderRequestParams {
    /**
     * 收货地址的相关信息
     */
    private AddressRequestParams address;
    /**
     * 购买商品的信息
     */
    private List<ProductRequestParams> products;
    /**
     *
     */
    private Integer couponId;

}
