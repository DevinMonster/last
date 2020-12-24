package com.devin.service.impl;

import com.devin.entity.Category;
import com.devin.entity.request.CategoryRequest;
import com.devin.mapper.CategoryMapper;
import com.devin.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public Category add(CategoryRequest category) {
        Category category1 = new Category();
        BeanUtils.copyProperties(category,category1);
        category1.setCreateTime(new Date());
        category1.setUpdateTime(new Date());
        categoryMapper.insert(category1);
        return category1;
    }
}
