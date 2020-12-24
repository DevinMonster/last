package com.devin.service;

import com.devin.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.devin.entity.request.ProductRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
public interface IProductService extends IService<Product> {

    /**
     * 添加一份产品
     * @param request 请求对象
     */
    Product addOneProduct(ProductRequest request);

    // 查询库存
    Long queryCount(Long id);

    // 修改库存
    int updateCount(Long id, Long count);

    // 获取价格
    double queryPrice(Long id);

}
