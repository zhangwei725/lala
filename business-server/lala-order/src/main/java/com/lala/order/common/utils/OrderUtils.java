package com.lala.order.common.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Date;


public class OrderUtils {
    public static final String DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String ORDER_PREFIX = "ll";

    /**
     * @return
     */
    public static String getOrderCode() {
        return String.format("%s%s%s", ORDER_PREFIX, DateUtil.format(new Date(), DATE_FORMAT));
    }
}
