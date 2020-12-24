package com.devin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.devin.entity.Orders;
import com.devin.entity.Product;
import com.devin.enums.ApiEnum;
import com.devin.exception.GlobalException;
import com.devin.mapper.OrdersMapper;
import com.devin.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Chika
 * @since 2020/12/24
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    private OrdersMapper ordersMapper;

    @Override
    public Orders insertOrder(Orders orders) {
        Orders orders1 = new Orders();
        BeanUtils.copyProperties(orders,orders1);
        orders1.setCreateTime(new Date());
        orders1.setUpdateTime(new Date());
        ordersMapper.insertOrder(orders);
        return orders;
    }

    @Override
    public List<Orders> queryOrders() {
        return ordersMapper.queryOrders();
    }

    @Override
    public Orders queryOrderByName(String products) {
        return ordersMapper.queryOrderByName(products);
    }

    public int deleteOrder(Long id) {
        return ordersMapper.deleteById(id);
    }

    @Override
    public int updateOrder(Orders orders) {
        return ordersMapper.updateOrder(orders);
    }
}
