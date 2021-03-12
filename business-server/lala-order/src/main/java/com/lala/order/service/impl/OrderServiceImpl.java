package com.lala.order.service.impl;

import com.lala.common.vo.ResponseCode;
import com.lala.common.vo.ResponseResult;
import com.lala.order.common.dto.OrderRequestParams;
import com.lala.order.common.dto.ProductRequestParams;
import com.lala.order.common.utils.OrderUtils;
import com.lala.order.entity.Order;
import com.lala.order.entity.Product;
import com.lala.order.entity.ProductStatics;
import com.lala.order.exception.OrderException;
import com.lala.order.mapper.OrderMapper;
import com.lala.order.mapper.ProductMapper;
import com.lala.order.mapper.ProductStaticsMapper;
import com.lala.order.service.OrderService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 事务
 * 锁  乐观锁
 * <p>
 * 订单表
 * 订单item表
 * 商品表
 * 库存表
 * 购物车
 * 销量表
 * <p>
 * <p>
 * <p>
 * <p>
 * pojo
 * dto      服务跟服务之间做数据传递, 控制层入口参数  服务层的入口参数
 * vo  ---> 服务器--展示层交互对象   显示商品价格   原始价格   优惠价格
 * entity   作为持久化层的入口参数 返回类型
 * 确认订单-->创建订单
 * 1> 生成订单号 (必须是唯一  项目名+年月日日分秒+随机的六位数字)
 * 2> 购物车表
 * 3> 库存表(锁库存)  判断库存
 * 4> 计算总价
 * 多表操作 (增删改查) 事务
 * 数据安全  锁
 * 业务逻辑  if else
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Resource
    ProductMapper productMapper;
    @Resource
    ProductStaticsMapper productStaticsMapper;

    /**
     * java 锁机制 性能差
     * 乐观锁  在数据库表中加一个字段  version
     * 查询两个字段
     * select  stock    from  product  where product_id=1
     *
     * @param orderRequestParams
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 3000)
    public ResponseResult<String> create(OrderRequestParams orderRequestParams) {
        Order order = new Order();
        /**
         * 生成订单号
         */
        order.setOrderCode(OrderUtils.getOrderCode());
        order.setAddress(orderRequestParams.getAddress().getDetail());
        order.setMobile(orderRequestParams.getAddress().getMobile());
        order.setReceiver(orderRequestParams.getAddress().getUsername());
        /**
         * 保存
         */
        int count = orderMapper.insert(order);

        /*
         * 通过商品的ID查询商品的信息
         */
        List<ProductRequestParams> productRequestParams = orderRequestParams.getProducts();
        /**
         * 从数据库中查询商品的相关信息
         * 判断库存
         * 计算总价
         */
        /**
         * 熟读业务
         */
        List<Integer> ids = productRequestParams.stream()
                .map(ProductRequestParams::getProductId)
                .collect(Collectors.toList());

        List<Product> products = productMapper.selectBatchIds(ids);
        /**
         * 所有的商品的全部都没有下架
         */
        if (products.size() != productRequestParams.size()) {
            //部分商品已经下架 请重新下单
            throw new OrderException(ResponseCode.ORDER_PRODUCT_OUT);
        }
        /**
         * 商品永不下架  一件商品永远卖不完  下单不发货
         *
         */
        if (!isStock(products, productRequestParams)) {
            throw new OrderException(ResponseCode.PRODUCT_STOCK_OUT);
        }
        /**
         * 减库存的操作
         */
        BigDecimal total = null;
        for (Product product : products) {
            for (ProductRequestParams prp : productRequestParams) {
                if (product.getShopId().equals(prp.getProductId())) {
                    /**
                     * 减少库存
                     */
                    product.setStock(product.getStock() - prp.getQuantity());
                    /*
                     * 更新到数据库
                     */
                    int i = productMapper.updateByIdAndVersion(product);
                    if (i != 1) {
                        throw new OrderException(ResponseCode.ORDER_CREATE_ERROR);
                    }
                    total.add(product.getPromotePrice());
                    /**
                     * 增加商品销量
                     */
                    ProductStatics productStatics = new ProductStatics();
                    productStatics.setProductId(product.getShopId());
                    productStatics.setSellCount(prp.getQuantity());
                    productStaticsMapper.insert(productStatics);
                }
            }
        }


        return null;
    }


    /**
     * 判断库存的数量
     * 购买商品  num
     * 查询库存
     */

    private boolean isStock(List<Product> products, List<ProductRequestParams> productRequestList) {
        for (Product product : products) {
            for (ProductRequestParams productRequestParams : productRequestList) {
                if (product.getShopId().equals(productRequestParams.getProductId())) {
                    if (product.getStock() < productRequestParams.getQuantity()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
