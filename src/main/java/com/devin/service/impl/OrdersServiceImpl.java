package com.devin.service.impl;

import com.devin.entity.Orders;
import com.devin.mapper.OrdersMapper;
import com.devin.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author devin
 * @since 2020-12-24
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
