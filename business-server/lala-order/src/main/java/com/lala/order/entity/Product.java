package com.lala.order.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "product")
public class Product implements Serializable {
    @TableId(value = "shop_id", type = IdType.INPUT)
    private Integer shopId;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "sub_title")
    private String subTitle;

    @TableField(value = "original_price")
    private BigDecimal originalPrice;

    @TableField(value = "promote_price")
    private BigDecimal promotePrice;

    @TableField(value = "stock")
    private Integer stock;

    @TableField(value = "cate_id")
    private Integer cateId;

    @TableField(value = "create_date")
    private Date createDate;
    @TableField(value = "`version`")
    private Integer version;

    private static final long serialVersionUID = 1L;

    public static final String COL_SHOP_ID = "shop_id";

    public static final String COL_NAME = "name";

    public static final String COL_SUB_TITLE = "sub_title";

    public static final String COL_ORIGINAL_PRICE = "original_price";

    public static final String COL_PROMOTE_PRICE = "promote_price";

    public static final String COL_STOCK = "stock";

    public static final String COL_CATE_ID = "cate_id";

    public static final String COL_CREATE_DATE = "create_date";
}