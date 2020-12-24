package com.devin.service;

import com.devin.entity.ProductPic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.devin.entity.request.ProductPicRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
public interface IProductPicService extends IService<ProductPic> {

    ProductPic insertOnePic(ProductPicRequest picRequest);
}
