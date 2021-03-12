package com.lala.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@TableName(value = "`order`")
public class Order implements Serializable {
    @TableId(value = "oid", type = IdType.INPUT)
    private Integer oid;

    @TableField(value = "order_code")
    private String orderCode;

    @TableField(value = "address")
    private String address;

    @TableField(value = "post")
    private String post;

    @TableField(value = "receiver")
    private String receiver;

    @TableField(value = "mobile")
    private String mobile;

    @TableField(value = "user_message")
    private String userMessage;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "pay_date")
    private Date payDate;

    @TableField(value = "delivery_date")
    private Date deliveryDate;

    @TableField(value = "confirm_date")
    private Date confirmDate;

    @TableField(value = "`status`")
    private Integer status;

    @TableField(value = "`uid`")
    private Integer uid;


    private static final long serialVersionUID = 1L;

    public static final String COL_OID = "oid";

    public static final String COL_ORDER_CODE = "order_code";

    public static final String COL_ADDRESS = "address";

    public static final String COL_POST = "post";

    public static final String COL_RECEIVER = "receiver";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_USER_MESSAGE = "user_message";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_PAY_DATE = "pay_date";

    public static final String COL_DELIVERY_DATE = "delivery_date";

    public static final String COL_CONFIRM_DATE = "confirm_date";

    public static final String COL_STATUS = "status";

    public static final String COL_UID = "uid";
}