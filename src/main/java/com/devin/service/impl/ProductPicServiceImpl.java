package com.devin.service.impl;

import com.devin.entity.Product;
import com.devin.entity.ProductPic;
import com.devin.entity.request.ProductPicRequest;
import com.devin.enums.ApiEnum;
import com.devin.exception.GlobalException;
import com.devin.mapper.ProductMapper;
import com.devin.mapper.ProductPicMapper;
import com.devin.service.IProductPicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
@Service
public class ProductPicServiceImpl extends ServiceImpl<ProductPicMapper, ProductPic> implements IProductPicService {

    @Resource
    private ProductPicMapper mapper;

    @Resource
    private ProductMapper productMapper;

    @Override
    public ProductPic insertOnePic(ProductPicRequest picRequest) {
        // 检查产品是否存在
        checkProductExist(picRequest);
        ProductPic productPic = new ProductPic(picRequest);
        mapper.insert(productPic);
        return productPic;
    }

    private void checkProductExist(ProductPicRequest picRequest) {
        Integer id = picRequest.getProductId();
        Product product = productMapper.selectById(id);
        if (product == null) throw new GlobalException(ApiEnum.PRODUCT_NOT_EXIST);
    }
}
