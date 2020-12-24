package com.devin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.devin.entity.Product;
import com.devin.entity.request.ProductRequest;
import com.devin.enums.ApiEnum;
import com.devin.exception.GlobalException;
import com.devin.mapper.ProductMapper;
import com.devin.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product addOneProduct(ProductRequest request) {
        // 首先判重
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", request.getCategoryId());
        queryWrapper.eq("name", request.getName());
        List<Product> list = productMapper.selectList(queryWrapper);
        if (list.size() > 0) throw new GlobalException(ApiEnum.PRODUCT_ALREADY_EXIST);
        // 构造product实体
        Product product = new Product(request);
        productMapper.insert(product);
        return product;
    }
}
