package com.lala.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "product_statics")
public class ProductStatics implements Serializable {
    @TableId(value = "ps_id", type = IdType.INPUT)
    private Integer psId;

    @TableField(value = "sell_count")
    private Integer sellCount;

    @TableField(value = "product_id")
    private Integer productId;

    private static final long serialVersionUID = 1L;

    public static final String COL_PS_ID = "ps_id";

    public static final String COL_SELL_COUNT = "sell_count";

    public static final String COL_PRODUCT_ID = "product_id";
}