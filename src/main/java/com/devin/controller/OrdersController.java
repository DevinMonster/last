package com.devin.controller;


import com.devin.dto.APIResult;
import com.devin.dto.ResultGenerator;
import com.devin.entity.Orders;
import com.devin.entity.Product;
import com.devin.enums.ApiEnum;
import com.devin.exception.GlobalException;
import com.devin.service.impl.OrdersServiceImpl;
import com.devin.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author devin
 * @since 2020-12-24
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    private OrdersServiceImpl ordersService;

    @Resource
    private ProductServiceImpl productService;

    private Model model;
    private Product product;
    private Orders orders;

    // 结算增加订单
    @RequestMapping("/balance")
    public APIResult balanceOrder(@RequestBody @Validated Orders orders, @RequestBody Long id, @RequestBody Long stock) {
        Long count = productService.queryCount(id);
        if (stock > count) {
            throw new GlobalException(ApiEnum.BALANCE_COUNT_ERROR);
        } else {
            // 修改库存
            count = count - stock;
            // 创建订单\修改库存
            productService.updateCount(id, count);
            ordersService.insertOrder(orders);

            // 订单创建时间\库存修改时间
            orders.setCreateTime(new Date());
            product.setUpdateTime(new Date());

            // 输出总价
            double price = productService.queryPrice(id);
            price = price * count;

            // 总价添加到model
            model.addAttribute("price", price);
            return ResultGenerator.genSuccess();
        }
    }

    // 查询订单
    @RequestMapping("/query")
    public APIResult queryOrders() {
        ordersService.queryOrders();
        return ResultGenerator.genSuccess();
    }

    // 根据商品名称查询订单
    @RequestMapping("/queryByName")
    public APIResult queryByName(@RequestBody String products) {
        ordersService.queryOrderByName(products);
        return ResultGenerator.genSuccess();
    }

    // 删除订单
    @RequestMapping("/delete")
    public APIResult deleteOrder(@RequestBody Long id) {
        ordersService.deleteOrder(id);
        return ResultGenerator.genSuccess();
    }

    // 修改订单
    @RequestMapping("/update")
    public APIResult updateOrder(@RequestBody @Validated Orders orders) {
        ordersService.updateOrder(orders);
        return ResultGenerator.genSuccess();
    }

}
