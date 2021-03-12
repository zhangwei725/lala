package com.lala.common.vo;

import lombok.Getter;

/**
 * 业务错误错误的状态码
 */
@Getter
public enum ResponseCode {
    /**
     * 返回成功
     */
    SUCCESS(200, "success", "成功"),

    ERROR(404, "error", "错误"),
    //    用户相关的状态信息
    USER_NOT_NAME(400010, "error", "用户名不存在"),
    /**
     * 用户被锁定
     */
    USER_IS_LOCKED(400012, "user is  locked", "用户被锁定,请于管理员联系"),
    /**
     *
     */
    USER_PASSWORD_NAME(400011, "password is error", "密码错误"),

    /**
     * 订单相关的 错误信息
     */
    ORDER_PRODUCT_OUT(400031, "product out", "部分商品已经下架,请重新下单"),
    ORDER_CREATE_ERROR(400033, "create  order  fail ", "创建订单失败,请重新下单"),
    PRODUCT_STOCK_OUT(400032, "product stock out", "商品库存不够,请重新下单");

    /**
     * 返回码
     */
    protected int status;
    /**
     * 返回说明
     */
    protected String msg;
    /**
     * 提示消息
     */
    protected String tips;

    ResponseCode(int retCode, String retMsg, String tips) {
        this.status = retCode;
        this.msg = retMsg;
        this.tips = tips;
    }

}
