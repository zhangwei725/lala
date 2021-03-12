package com.lala.order.common.vo;

import com.lala.order.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderVo extends Order {
    private List<OrderItemVo> orderItemVos;
}
