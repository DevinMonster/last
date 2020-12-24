package com.devin.service.impl;

import com.devin.entity.Orders;
import com.devin.mapper.OrdersMapper;
import com.devin.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chika
 * @since 2020/12/24
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    private OrdersMapper ordersMapper;

    @Override
    public int insertOrder(Orders orders) {
        return ordersMapper.insertOrder(orders);
    }

    @Override
    public List<Orders> queryOrders() {
        return ordersMapper.queryOrders();
    }

    @Override
    public Orders queryOrderByName(String products) {
        return ordersMapper.queryOrderByName(products);
    }

    @Override
    public int deleteOrder(Long id) {
        return ordersMapper.deleteOrder(id);
    }

    @Override
    public int updateOrder(Orders orders) {
        return ordersMapper.updateOrder(orders);
    }
}
