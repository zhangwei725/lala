package com.lala.order.service;

import com.lala.common.vo.ResponseResult;
import com.lala.order.common.dto.OrderRequestParams;

/**

 *
 */
public interface OrderService {
    ResponseResult<String> create(OrderRequestParams orderRequestParams);
}
