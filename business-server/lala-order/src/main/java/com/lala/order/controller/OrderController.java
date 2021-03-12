package com.lala.order.controller;

import com.lala.common.vo.ResponseResult;
import com.lala.order.common.dto.OrderRequestParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    /**
     * 创建订单
     *
     * @param orderRequestParams
     * @return
     */

    public ResponseResult<String> create(OrderRequestParams orderRequestParams) {
        return null;
    }

}
