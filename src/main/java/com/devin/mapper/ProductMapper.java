package com.devin.mapper;

import com.devin.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author devin
 * @since 2020-12-23
 */
public interface ProductMapper extends BaseMapper<Product> {

    // 查询库存
    int queryCount(@Param("id") Long id);

    // 修改库存
    int updateCount(@Param("id") Long id, @Param("count") Long count);

    // 获取价格
    double queryPrice(@Param("price") Long price);

}
