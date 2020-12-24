package com.devin.service;

import com.devin.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author devin
 * @since 2020-12-24
 */
public interface IOrdersService extends IService<Orders> {


    // 增加订单
    Orders insertOrder(Orders orders);

    // 查询订单
    List<Orders> queryOrders();

    // 根据商品名称查询订单
    Orders queryOrderByName(String products);


    // 修改订单
    int updateOrder(Orders orders);

}
