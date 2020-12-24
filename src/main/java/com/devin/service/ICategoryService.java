package com.devin.service;

import com.devin.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.devin.entity.request.CategoryRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
public interface ICategoryService extends IService<Category> {

    Category add(CategoryRequest category);
}
