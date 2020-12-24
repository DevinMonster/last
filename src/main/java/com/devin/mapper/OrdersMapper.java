package com.devin.mapper;

import com.devin.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Chika
 * @since 2020/12/24
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    // 增加订单
    Orders insertOrder(@Param("Orders") Orders orders);

    // 查询订单
    List<Orders> queryOrders();

    // 根据商品名称查询订单
    Orders queryOrderByName(@Param("String") String products);


    // 修改订单
    int updateOrder(@Param("Orders") Orders orders);

}
