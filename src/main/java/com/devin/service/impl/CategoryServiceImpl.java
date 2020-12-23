package com.devin.service.impl;

import com.devin.entity.Category;
import com.devin.mapper.CategoryMapper;
import com.devin.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
