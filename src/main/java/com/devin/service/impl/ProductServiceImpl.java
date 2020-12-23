package com.devin.service.impl;

import com.devin.entity.Product;
import com.devin.mapper.ProductMapper;
import com.devin.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
